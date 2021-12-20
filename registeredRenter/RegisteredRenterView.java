package registeredRenter;

import javax.swing.*;


public class RegisteredRenterView {
	
	/* Global Variables */
	private JFrame RRenterFrame, notificationFrame;
	private JPanel homepagePanel, searchPanel, addNotificationPanel, notificationPanel;
	private JButton searchPropertyButton, addNotificationButton, removeNotificationButton, updateNotificationButton,
	                 emailButton, searchButton, searchBackButton, subNotificationButton, subBackButton;
	private JTextField typeSField, bedSField, bathroomSField, furnishedSField, quadrantSField,
	                   typeNField, bedNField, bathroomNField, furnishedNField, quadrantNField;
	private JLabel result = new JLabel();
	private JLabel notification = new JLabel();
	SpringLayout layout = new SpringLayout();
	
	/* Initializing GUI */
	public void RRenterViewInit() {
		
		// frame
		RRenterFrame = new JFrame();
		RRenterFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		RRenterFrame.setSize(600, 600);
		RRenterFrame.setVisible(true);
		
		notificationFrame = new JFrame("Notification");
		notificationFrame.setSize(400, 300);
		notificationFrame.setVisible(false);
			
		// panel
		homepagePanel = new JPanel();
		searchPanel = new JPanel();
		addNotificationPanel = new JPanel();
		notificationPanel = new JPanel();
		
		// buttons
		searchPropertyButton = new JButton("Search Property");
		addNotificationButton = new JButton("Add Notification");
		removeNotificationButton = new JButton("Remove Notification");
		updateNotificationButton = new JButton("Update Notification");
		emailButton = new JButton("Inbox");
		searchButton = new JButton("Search");
		searchBackButton = new JButton("Back");
		subNotificationButton = new JButton("Subscribe");
		subBackButton = new JButton("Back");
		
		// Text Field
		typeSField = new JTextField("apartment", 20);
		bedSField = new JTextField("2", 20);
		bathroomSField = new JTextField("2", 20);
		furnishedSField = new JTextField("Yes", 20);
		quadrantSField = new JTextField("NW", 20);
		typeNField = new JTextField("apartment", 20);
		bedNField = new JTextField("2", 20);
		bathroomNField = new JTextField("2", 20);
		furnishedNField = new JTextField("Yes", 20);
		quadrantNField = new JTextField("NW", 20);
		
		// Labels
		JLabel typeSLabel = new JLabel("Type:");
		JLabel bedSLabel = new JLabel("Number of beds");
		JLabel bathroomSLabel = new JLabel("Number of bathrooms:");
		JLabel furnishedSLabel = new JLabel("Furnished?");
		JLabel quadrantSLabel = new JLabel("quadrant:");
		JLabel typeNLabel = new JLabel("Type:");
		JLabel bedNLabel = new JLabel("Number of beds");
		JLabel bathroomNLabel = new JLabel("Number of bathrooms:");
		JLabel furnishedNLabel = new JLabel("Furnished?");
		JLabel quadrantNLabel = new JLabel("quadrant:");
		
		// initializing homepage panel
		homepagePanel.add(searchPropertyButton);
		homepagePanel.add(addNotificationButton);
		homepagePanel.add(removeNotificationButton);
		homepagePanel.add(updateNotificationButton);
		homepagePanel.add(emailButton);
		
		// initializing search property panel
		searchPanel.add(typeSLabel);
		searchPanel.add(bedSLabel);
		searchPanel.add(bathroomSLabel);
		searchPanel.add(furnishedSLabel);
		searchPanel.add(quadrantSLabel);
		searchPanel.add(result);
		
		searchPanel.add(typeSField);
		searchPanel.add(bedSField);
		searchPanel.add(bathroomSField);
		searchPanel.add(furnishedSField);
		searchPanel.add(quadrantSField);
		
		searchPanel.add(searchButton);
		searchPanel.add(searchBackButton);
		
		searchPanel.setLayout(layout);
		
		layout.putConstraint(SpringLayout.WEST, typeSLabel, 6, SpringLayout.WEST, searchPanel);
		layout.putConstraint(SpringLayout.NORTH, typeSLabel, 6, SpringLayout.NORTH, searchPanel);
		layout.putConstraint(SpringLayout.WEST, typeSField, 136, SpringLayout.WEST, searchPanel);
		layout.putConstraint(SpringLayout.NORTH, typeSField, 6, SpringLayout.NORTH, searchPanel);
		
		layout.putConstraint(SpringLayout.WEST, bedSLabel, 6, SpringLayout.WEST, searchPanel);
		layout.putConstraint(SpringLayout.NORTH, bedSLabel, 36, SpringLayout.NORTH, searchPanel);
		layout.putConstraint(SpringLayout.WEST, bedSField, 136, SpringLayout.WEST, searchPanel);
		layout.putConstraint(SpringLayout.NORTH, bedSField, 36, SpringLayout.NORTH, searchPanel);
		
		layout.putConstraint(SpringLayout.WEST, bathroomSLabel, 6, SpringLayout.WEST, searchPanel);
		layout.putConstraint(SpringLayout.NORTH, bathroomSLabel, 66, SpringLayout.NORTH, searchPanel);
		layout.putConstraint(SpringLayout.WEST, bathroomSField, 136, SpringLayout.WEST, searchPanel);
		layout.putConstraint(SpringLayout.NORTH, bathroomSField, 66, SpringLayout.NORTH, searchPanel);
		
		layout.putConstraint(SpringLayout.WEST, furnishedSLabel, 6, SpringLayout.WEST, searchPanel);
		layout.putConstraint(SpringLayout.NORTH, furnishedSLabel, 96, SpringLayout.NORTH, searchPanel);
		layout.putConstraint(SpringLayout.WEST, furnishedSField, 136, SpringLayout.WEST, searchPanel);
		layout.putConstraint(SpringLayout.NORTH, furnishedSField, 96, SpringLayout.NORTH, searchPanel);
		
		layout.putConstraint(SpringLayout.WEST, quadrantSLabel, 6, SpringLayout.WEST, searchPanel);
		layout.putConstraint(SpringLayout.NORTH, quadrantSLabel, 126, SpringLayout.NORTH, searchPanel);
		layout.putConstraint(SpringLayout.WEST, quadrantSField, 136, SpringLayout.WEST, searchPanel);
		layout.putConstraint(SpringLayout.NORTH, quadrantSField, 126, SpringLayout.NORTH, searchPanel);
		
		layout.putConstraint(SpringLayout.WEST, searchButton, 6, SpringLayout.WEST, searchPanel);
		layout.putConstraint(SpringLayout.NORTH, searchButton, 156, SpringLayout.NORTH, searchPanel);
		layout.putConstraint(SpringLayout.WEST, searchBackButton, 96, SpringLayout.WEST, searchPanel);
		layout.putConstraint(SpringLayout.NORTH, searchBackButton, 156, SpringLayout.NORTH, searchPanel);
		
		layout.putConstraint(SpringLayout.WEST, result, 6, SpringLayout.WEST, searchPanel);
		layout.putConstraint(SpringLayout.NORTH, result, 186, SpringLayout.NORTH, searchPanel);
		
		// initialize add notification panel
		addNotificationPanel.add(typeNLabel);
		addNotificationPanel.add(bedNLabel);
		addNotificationPanel.add(bathroomNLabel);
		addNotificationPanel.add(furnishedNLabel);
		addNotificationPanel.add(quadrantNLabel);
		
		addNotificationPanel.add(typeNField);
		addNotificationPanel.add(bedNField);
		addNotificationPanel.add(bathroomNField);
		addNotificationPanel.add(furnishedNField);
		addNotificationPanel.add(quadrantNField);
		
		addNotificationPanel.add(subNotificationButton);
		addNotificationPanel.add(subBackButton);
		
		addNotificationPanel.setLayout(layout);
		
		layout.putConstraint(SpringLayout.WEST, typeNLabel, 6, SpringLayout.WEST, addNotificationPanel);
		layout.putConstraint(SpringLayout.NORTH, typeNLabel, 6, SpringLayout.NORTH, addNotificationPanel);
		layout.putConstraint(SpringLayout.WEST, typeNField, 136, SpringLayout.WEST, addNotificationPanel);
		layout.putConstraint(SpringLayout.NORTH, typeNField, 6, SpringLayout.NORTH, addNotificationPanel);
		
		layout.putConstraint(SpringLayout.WEST, bedNLabel, 6, SpringLayout.WEST, addNotificationPanel);
		layout.putConstraint(SpringLayout.NORTH, bedNLabel, 36, SpringLayout.NORTH, addNotificationPanel);
		layout.putConstraint(SpringLayout.WEST, bedNField, 136, SpringLayout.WEST, addNotificationPanel);
		layout.putConstraint(SpringLayout.NORTH, bedNField, 36, SpringLayout.NORTH, addNotificationPanel);
		
		layout.putConstraint(SpringLayout.WEST, bathroomNLabel, 6, SpringLayout.WEST, addNotificationPanel);
		layout.putConstraint(SpringLayout.NORTH, bathroomNLabel, 66, SpringLayout.NORTH, addNotificationPanel);
		layout.putConstraint(SpringLayout.WEST, bathroomNField, 136, SpringLayout.WEST, addNotificationPanel);
		layout.putConstraint(SpringLayout.NORTH, bathroomNField, 66, SpringLayout.NORTH, addNotificationPanel);
		
		layout.putConstraint(SpringLayout.WEST, furnishedNLabel, 6, SpringLayout.WEST, addNotificationPanel);
		layout.putConstraint(SpringLayout.NORTH, furnishedNLabel, 96, SpringLayout.NORTH, addNotificationPanel);
		layout.putConstraint(SpringLayout.WEST, furnishedNField, 136, SpringLayout.WEST, addNotificationPanel);
		layout.putConstraint(SpringLayout.NORTH, furnishedNField, 96, SpringLayout.NORTH, addNotificationPanel);
		
		layout.putConstraint(SpringLayout.WEST, quadrantNLabel, 6, SpringLayout.WEST, addNotificationPanel);
		layout.putConstraint(SpringLayout.NORTH, quadrantNLabel, 126, SpringLayout.NORTH, addNotificationPanel);
		layout.putConstraint(SpringLayout.WEST, quadrantNField, 136, SpringLayout.WEST, addNotificationPanel);
		layout.putConstraint(SpringLayout.NORTH, quadrantNField, 126, SpringLayout.NORTH, addNotificationPanel);
		
		layout.putConstraint(SpringLayout.WEST, subNotificationButton, 6, SpringLayout.WEST, addNotificationPanel);
		layout.putConstraint(SpringLayout.NORTH, subNotificationButton, 156, SpringLayout.NORTH, addNotificationPanel);
		layout.putConstraint(SpringLayout.WEST, subBackButton, 96, SpringLayout.WEST, addNotificationPanel);
		layout.putConstraint(SpringLayout.NORTH, subBackButton, 156, SpringLayout.NORTH, addNotificationPanel);
		
		// initialize notification panel + frame
		notificationPanel.add(notification);
		notificationFrame.add(notificationPanel);
		
		notificationPanel.setLayout(layout);
		
		layout.putConstraint(SpringLayout.WEST, notification, 6, SpringLayout.WEST, notificationPanel);
		layout.putConstraint(SpringLayout.NORTH, notification, 6, SpringLayout.NORTH, notificationPanel);
		
	}
	
	// add homepage panel
	public void addHomepage() {
		RRenterFrame.setTitle("Homepage");
		
		RRenterFrame.add(homepagePanel);
		RRenterFrame.revalidate();
		RRenterFrame.repaint();
	}
	
	// remove home panel
	public void removeHomepage() {
		RRenterFrame.remove(homepagePanel);
		RRenterFrame.revalidate();
		RRenterFrame.repaint();
	}
	
	// add search panel
	public void addSearch() {
		RRenterFrame.setTitle("Search Property");
		
		RRenterFrame.add(searchPanel);
		RRenterFrame.revalidate();
		RRenterFrame.repaint();
	}
	
	// remove search panel
	public void removeSearch() {
		RRenterFrame.remove(searchPanel);
		RRenterFrame.revalidate();
		RRenterFrame.repaint();
	}
	
    // add result to search panel
	public void addSearchResult(String arg) {
		/********************************** NEED TO UPDATE **************************/
		if (result != null) {
			searchPanel.remove(result);
		}
		
		result = new JLabel(arg);
		searchPanel.add(result);
		
		layout.putConstraint(SpringLayout.WEST, result, 6, SpringLayout.WEST, searchPanel);
		layout.putConstraint(SpringLayout.NORTH, result, 186, SpringLayout.NORTH, searchPanel);
		
		searchPanel.revalidate();
		searchPanel.repaint();
	}
	
	// add add notification panel
	public void addAddNotification() {
		RRenterFrame.setTitle("Add Notification");
		
		RRenterFrame.add(addNotificationPanel);
		RRenterFrame.revalidate();
		RRenterFrame.repaint();
		
	}
	
	// remove add notification panel
	public void removeAddNotification() {
		RRenterFrame.remove(addNotificationPanel);
		RRenterFrame.revalidate();
		RRenterFrame.repaint();
	}
	
	// add Notification panel + frame
	public void addNotificationResult(String arg) {
		if(notification != null) {
			notificationPanel.remove(notification);
		}
		
		notification = new JLabel(arg);
		notificationPanel.add(notification);
		
		layout.putConstraint(SpringLayout.WEST, notification, 6, SpringLayout.WEST, notificationPanel);
		layout.putConstraint(SpringLayout.NORTH, notification, 6, SpringLayout.NORTH, notificationPanel);
		
		notificationPanel.revalidate();
		notificationPanel.repaint();
		notificationFrame.setVisible(true);
		
	}
	
	/* Getter functions for button and textfield */
	public JButton getSearchPropertyButton() {
		return searchPropertyButton;
	}
	
	public JButton getAddNotificationButton() {
		return addNotificationButton;
	}
	
	public JButton getRemoveNotificationButton() {
		return removeNotificationButton;
	}
	
	public JButton getUpdateNotificationButton() {
		return updateNotificationButton;
	}
	
	public JButton getEmailButton() {
		return emailButton;
	}
	
	public JButton getSearchButton() {
		return searchButton;
	}
	
	public JButton getSearchBackButton() {
		return searchBackButton;
	}
	
	public JButton getSubNotificationButton() {
		return subNotificationButton;
	}
	
	public JButton getSubBackButton() {
		return subBackButton;
	}
	
	public JTextField getTypeSField() {
		return typeSField;
	}
	
	public JTextField getBedSField() {
		return bedSField;
	}
	
	public JTextField getBathroomSField() {
		return bathroomSField;
	}
	
	public JTextField getFurnishedSField() {
		return furnishedSField;
	}
	
	public JTextField getQuadrantSField() {
		return quadrantSField;
	}
	
	public JTextField getTypeNField() {
		return typeNField;
	}
	
	public JTextField getBedNField() {
		return bedNField;
	}
	
	public JTextField getBathroomNField() {
		return bathroomNField;
	}
	
	public JTextField getFurnishedNField() {
		return furnishedNField;
	}
	
	public JTextField getQuadrantNField() {
		return quadrantNField;
	}
	
	public JFrame getRRenterFrame() {
		return RRenterFrame;
	}
}
