package landlord;

import javax.swing.*;

public class LandlordView {
	
	/* Set Global Variables */
	private JFrame LandlordFrame;
	private JPanel homepagePanel, registerPropertyPanel, propertyListPanel, editPanel;
	private JButton registerPropertyButton, propertyListButton, emailButton, registerButton,
	                registerBackButton, editButton, listBackButton, payFeeButton, changeStatusButton, 
	                editCancelButton;
	private JTextField typeField, bedField, bathroomField, furnishedField, addressField, 
	                   quadrantField, rentField, propertyField;
	private JLabel list;
	SpringLayout layout = new SpringLayout();
	
	// initializing GUI 
	public void LandlordViewInit() {
		
		// frame
		LandlordFrame = new JFrame();
		LandlordFrame.setSize(600, 600);
		LandlordFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		LandlordFrame.setVisible(true);
		
		// panel
		homepagePanel = new JPanel();
		registerPropertyPanel = new JPanel();
		propertyListPanel = new JPanel();
		editPanel = new JPanel();
		
		// button
		registerPropertyButton = new JButton("Register Property");
		propertyListButton = new JButton("View your properties");
		emailButton = new JButton("Inbox");
		registerButton = new JButton("Register");
		registerBackButton = new JButton("Back");
		editButton = new JButton("Edit");
		listBackButton = new JButton("Back");
		payFeeButton = new JButton("Pay Fee");
		changeStatusButton = new JButton("Change Status");
		editCancelButton = new JButton("Cancel");

		// textfield
		typeField = new JTextField(20);
		bedField = new JTextField(20);
		bathroomField = new JTextField(20);
		furnishedField = new JTextField(20);
		addressField = new JTextField(20);
		rentField = new JTextField(20);
		quadrantField = new JTextField(10);
		propertyField = new JTextField(10);
		
		// label
		JLabel typeLabel = new JLabel("Type:");
		JLabel bedLabel = new JLabel("Number of beds:");
		JLabel bathroomLabel = new JLabel("Number of bathrooms:");
		JLabel furnishedLabel = new JLabel("Furnished:");
		JLabel addressLabel = new JLabel("Address:");
		JLabel rentLabel = new JLabel("Rent per month:");
		JLabel quadrantLabel = new JLabel("Quadrant:");
		
		// initialize hompage
		homepagePanel.add(registerPropertyButton);
		homepagePanel.add(propertyListButton);
		homepagePanel.add(emailButton);
		
		// initialize register property
		registerPropertyPanel.add(typeLabel);
		registerPropertyPanel.add(bedLabel);
		registerPropertyPanel.add(bathroomLabel);
		registerPropertyPanel.add(furnishedLabel);
		registerPropertyPanel.add(addressLabel);
		registerPropertyPanel.add(quadrantLabel);
		registerPropertyPanel.add(rentLabel);
		
		registerPropertyPanel.add(typeField);
		registerPropertyPanel.add(bedField);
		registerPropertyPanel.add(bathroomField);
		registerPropertyPanel.add(furnishedField);
		registerPropertyPanel.add(addressField);
		registerPropertyPanel.add(quadrantField);
		registerPropertyPanel.add(rentField);
		registerPropertyPanel.setLayout(layout);
		
		layout.putConstraint(SpringLayout.WEST, typeLabel, 6, SpringLayout.WEST, registerPropertyPanel);
		layout.putConstraint(SpringLayout.NORTH, typeLabel, 6, SpringLayout.NORTH, registerPropertyPanel);
		layout.putConstraint(SpringLayout.WEST, typeField, 136, SpringLayout.WEST, registerPropertyPanel);
		layout.putConstraint(SpringLayout.NORTH, typeField, 6, SpringLayout.NORTH, registerPropertyPanel);
		
		layout.putConstraint(SpringLayout.WEST, bedLabel, 6, SpringLayout.WEST, registerPropertyPanel);
		layout.putConstraint(SpringLayout.NORTH, bedLabel, 36, SpringLayout.NORTH, registerPropertyPanel);
		layout.putConstraint(SpringLayout.WEST, bedField, 136, SpringLayout.WEST, registerPropertyPanel);
		layout.putConstraint(SpringLayout.NORTH, bedField, 36, SpringLayout.NORTH, registerPropertyPanel);
		
		layout.putConstraint(SpringLayout.WEST, bathroomLabel, 6, SpringLayout.WEST, registerPropertyPanel);
		layout.putConstraint(SpringLayout.NORTH, bathroomLabel, 66, SpringLayout.NORTH, registerPropertyPanel);
		layout.putConstraint(SpringLayout.WEST, bathroomField, 136, SpringLayout.WEST, registerPropertyPanel);
		layout.putConstraint(SpringLayout.NORTH, bathroomField, 66, SpringLayout.NORTH, registerPropertyPanel);
		
		layout.putConstraint(SpringLayout.WEST, furnishedLabel, 6, SpringLayout.WEST, registerPropertyPanel);
		layout.putConstraint(SpringLayout.NORTH, furnishedLabel, 96, SpringLayout.NORTH, registerPropertyPanel);
		layout.putConstraint(SpringLayout.WEST, furnishedField, 136, SpringLayout.WEST, registerPropertyPanel);
		layout.putConstraint(SpringLayout.NORTH, furnishedField, 96, SpringLayout.NORTH, registerPropertyPanel);
		
		layout.putConstraint(SpringLayout.WEST, addressLabel, 6, SpringLayout.WEST, registerPropertyPanel);
		layout.putConstraint(SpringLayout.NORTH, addressLabel, 126, SpringLayout.NORTH, registerPropertyPanel);
		layout.putConstraint(SpringLayout.WEST, addressField, 136, SpringLayout.WEST, registerPropertyPanel);
		layout.putConstraint(SpringLayout.NORTH, addressField, 126, SpringLayout.NORTH, registerPropertyPanel);
		
		layout.putConstraint(SpringLayout.WEST, quadrantLabel, 340, SpringLayout.WEST, registerPropertyPanel);
		layout.putConstraint(SpringLayout.NORTH, quadrantLabel, 126, SpringLayout.NORTH, registerPropertyPanel);
		layout.putConstraint(SpringLayout.WEST, quadrantField, 396, SpringLayout.WEST, registerPropertyPanel);
		layout.putConstraint(SpringLayout.NORTH, quadrantField, 126, SpringLayout.NORTH, registerPropertyPanel);
		
		layout.putConstraint(SpringLayout.WEST, rentLabel, 6, SpringLayout.WEST, registerPropertyPanel);
		layout.putConstraint(SpringLayout.NORTH, rentLabel, 156, SpringLayout.NORTH, registerPropertyPanel);
		layout.putConstraint(SpringLayout.WEST, rentField, 136, SpringLayout.WEST, registerPropertyPanel);
		layout.putConstraint(SpringLayout.NORTH, rentField, 156, SpringLayout.NORTH, registerPropertyPanel);
		
		registerPropertyPanel.add(registerButton);
		registerPropertyPanel.add(registerBackButton);
		
		layout.putConstraint(SpringLayout.WEST, registerButton, 6, SpringLayout.WEST, registerPropertyPanel);
		layout.putConstraint(SpringLayout.NORTH, registerButton, 186, SpringLayout.NORTH, registerPropertyPanel);
		
		layout.putConstraint(SpringLayout.WEST, registerBackButton, 96, SpringLayout.WEST, registerPropertyPanel);
		layout.putConstraint(SpringLayout.NORTH, registerBackButton, 186, SpringLayout.NORTH, registerPropertyPanel);
		
		// initialzing propertyListPanel
		propertyListPanel.setLayout(layout);
		propertyListPanel.add(editButton);
		propertyListPanel.add(listBackButton);
		
		layout.putConstraint(SpringLayout.WEST, editButton,6,SpringLayout.WEST, propertyListPanel);
		layout.putConstraint(SpringLayout.NORTH, editButton,156,SpringLayout.NORTH, propertyListPanel);
		
		layout.putConstraint(SpringLayout.WEST, listBackButton, 106,SpringLayout.WEST, propertyListPanel);
		layout.putConstraint(SpringLayout.NORTH, listBackButton,156,SpringLayout.NORTH, propertyListPanel);
		
		// initializing edit panel
		JLabel propertyLabel = new JLabel("Please enter property id to edit:");
		editPanel.add(propertyLabel);
		editPanel.add(propertyField);
		editPanel.setLayout(layout);
		
		layout.putConstraint(SpringLayout.WEST, propertyLabel, 6, SpringLayout.WEST, editPanel);
		layout.putConstraint(SpringLayout.NORTH, propertyLabel, 6, SpringLayout.NORTH, editPanel);
		layout.putConstraint(SpringLayout.WEST, propertyField, 206, SpringLayout.WEST, editPanel);
		layout.putConstraint(SpringLayout.NORTH, propertyField, 6, SpringLayout.NORTH, editPanel);
		
		JLabel actionLabel = new JLabel("Choose one of the following actions:");
		editPanel.add(actionLabel);
		layout.putConstraint(SpringLayout.WEST, actionLabel, 6, SpringLayout.WEST, editPanel);
		layout.putConstraint(SpringLayout.NORTH, actionLabel, 36, SpringLayout.NORTH, editPanel);
		
		editPanel.add(payFeeButton);
		editPanel.add(changeStatusButton);
		editPanel.add(editCancelButton);
		
		layout.putConstraint(SpringLayout.WEST, payFeeButton, 6, SpringLayout.WEST, editPanel);
		layout.putConstraint(SpringLayout.NORTH, payFeeButton, 66, SpringLayout.NORTH, editPanel);
		
		layout.putConstraint(SpringLayout.WEST, changeStatusButton, 106, SpringLayout.WEST, editPanel);
		layout.putConstraint(SpringLayout.NORTH, changeStatusButton, 66, SpringLayout.NORTH, editPanel);
		
		layout.putConstraint(SpringLayout.WEST, editCancelButton, 236, SpringLayout.WEST, editPanel);
		layout.putConstraint(SpringLayout.NORTH, editCancelButton, 66, SpringLayout.NORTH, editPanel);
		
	}
	
	// add homepage panel
	public void addHomepage() {
		
		LandlordFrame.setTitle("Homepage");
		
		LandlordFrame.add(homepagePanel);
		LandlordFrame.revalidate();
		LandlordFrame.repaint();
		
	}
	
	// remove homepage panel
	public void removeHomepage() {
		
		LandlordFrame.remove(homepagePanel);
		LandlordFrame.revalidate();
		LandlordFrame.repaint();
		
	}
	
	// add register property panel
	public void addRegisterProperty() {
		
		LandlordFrame.setTitle("Register Property");
		
		LandlordFrame.add(registerPropertyPanel);
		LandlordFrame.revalidate();
		LandlordFrame.repaint();
		
	}
	
	// remove register property panel
	public void removeRegisterProperty() {
		
		LandlordFrame.remove(registerPropertyPanel);
		LandlordFrame.revalidate();
		LandlordFrame.repaint();
		
	}
	
	// add property list panel
	public void addPropertyList(String arg) {
		
		LandlordFrame.setTitle("Property List");

		if (list != null) {
			propertyListPanel.remove(list);
		}

		list = new JLabel(arg);
		propertyListPanel.add(list);
		
		layout.putConstraint(SpringLayout.WEST, list, 6,SpringLayout.WEST, propertyListPanel);
		layout.putConstraint(SpringLayout.NORTH, list, 6, SpringLayout.NORTH, propertyListPanel);
		
		LandlordFrame.add(propertyListPanel);
		LandlordFrame.revalidate();
		LandlordFrame.repaint();
		
	}
	
	// remove property list panel
	public void removePropertyList() {
		
		LandlordFrame.remove(propertyListPanel);
		LandlordFrame.revalidate();
		LandlordFrame.repaint();
		
	}
	
	// add edit panel
	public void addEdit() {
		
        LandlordFrame.setTitle("Edit Property");
		
		LandlordFrame.add(editPanel);
		LandlordFrame.revalidate();
		LandlordFrame.repaint();
		
	}
	
	// remove edit panel
	public void removeEdit() {
		
		LandlordFrame.remove(editPanel);
		LandlordFrame.revalidate();
		LandlordFrame.repaint();
		
	}
	
	/* getters for buttons and textfields */
	public JButton getRegisterPropertyButton() {
		return registerPropertyButton;
	}
	
	public JButton getPropertyListButton() {
		return propertyListButton;
	}
	
	public JButton getEmailButton() {
		return emailButton;
	}
	
	public JButton getRegisterButton() {
		return registerButton;
	}
	
	public JButton getRegisterBackButton() {
		return registerBackButton;
	}
	
	public JButton getEditButton() {
		return editButton;
	}
	
	public JButton getListBackButton() {
		return listBackButton;
	}
	
	public JButton getPayFeeButton() {
		return payFeeButton;
	}
	
	public JButton getChangeStatusButton() {
		return changeStatusButton;
	}
	
	public JButton getEditCancelButton() {
		return editCancelButton;
	}
	
	public JTextField getTypeField() {
		return typeField;
	}
	
	public JTextField getBedField() {
		return bedField;
	}
	
	public JTextField getBathroomField() {
		return bathroomField;
	}
	
	public JTextField getFurnishedField() {
		return furnishedField;
	}
	
	public JTextField getAddressField() {
		return addressField;
	}
	
	public JTextField getRentField() {
		return rentField;
	}
	
	public JTextField getQuadrantField() {
		return quadrantField;
	}
	
	public JTextField getPropertyField() {
		return propertyField;
	}
	
	
}
