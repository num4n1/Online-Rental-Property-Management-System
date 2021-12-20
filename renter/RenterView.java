package renter;
// import java.awt.*;
// import java.awt.event.ActionEvent;
import javax.swing.*;

// import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// import java.util.ArrayList; // import the ArrayList class
// import java.util.ArrayList;
// import java.awt.*;
import java.awt.event.*;
// import javax.swing.*;
import javax.swing.JLabel;

public class RenterView extends JFrame {
	// GUi componets to fill content pane

	JLabel typeLabel;
    JLabel bedLabel;
    JLabel bathLabel;
    JLabel furnishedLabel;
    JLabel quadrantLabel;
	

	JTextField typefield;
    JTextField bedfield;
    JTextField bathfield;
    JTextField furnishedfield;
    JTextField quadrantfield;


   
	JFrame searchFrame;

	JPanel searchPanel;


	JButton searchButton;
	JButton backButton;

	SpringLayout spring;

	JLabel results ;

	/**
	 * ctor
	 * creates objects for memebr components
	 */
    public RenterView(){
		searchFrame = new JFrame();
		searchPanel = new JPanel();

		typeLabel = new JLabel("Type ");
		bedLabel = new JLabel("Number of Bedrooms ");
		bathLabel = new JLabel("Number of Bathrooms ");
		furnishedLabel = new JLabel("Furnished(Yes/No) ");
		quadrantLabel = new JLabel("Location");
		
		typefield = new JTextField("apartment",20);
		bedfield = new JTextField("2",20);
		bathfield = new JTextField("2",20);
		furnishedfield = new JTextField("Yes",20);
		quadrantfield = new JTextField("NW",20);

		searchButton= new JButton("Search");
		backButton= new JButton("Exit");

		spring = new SpringLayout();

		results = new JLabel("");

		setUpSpringFrame();

    } // end ctor


	/**
	 * sets up the Spring frame called in ctor to make class more modual
	 */
	public void setUpSpringFrame(){
        // Container cp = searchFrame.getContentPane();
        spring = new SpringLayout();
        searchPanel.setLayout(spring);

		searchPanel.add(typeLabel);
        searchPanel.add(typefield); // add in order
		searchPanel.add(bedLabel);
        searchPanel.add(bedfield);
		searchPanel.add(bathLabel);
        searchPanel.add(bathfield);

        searchPanel.add(furnishedLabel);
        searchPanel.add(furnishedfield);

        searchPanel.add(quadrantLabel);
        searchPanel.add(quadrantfield);

		spring.putConstraint(SpringLayout.WEST, typeLabel,6,SpringLayout.WEST, searchPanel);
		spring.putConstraint(SpringLayout.NORTH, typeLabel,6 + 0*30,SpringLayout.NORTH, searchPanel);
		spring.putConstraint(SpringLayout.WEST, typefield,136,SpringLayout.WEST, searchPanel);
		spring.putConstraint(SpringLayout.NORTH, typefield,6 + 0*30,SpringLayout.NORTH, searchPanel);


		spring.putConstraint(SpringLayout.WEST, bedLabel,6,SpringLayout.WEST, searchPanel);
		spring.putConstraint(SpringLayout.NORTH, bedLabel,6 + 1*30,SpringLayout.NORTH, searchPanel);
		spring.putConstraint(SpringLayout.WEST, bedfield,136,SpringLayout.WEST, searchPanel);
		spring.putConstraint(SpringLayout.NORTH, bedfield,6 + 1*30,SpringLayout.NORTH, searchPanel);
		
		spring.putConstraint(SpringLayout.WEST, bathLabel,6,SpringLayout.WEST, searchPanel);
		spring.putConstraint(SpringLayout.NORTH, bathLabel,6 + 2*30,SpringLayout.NORTH, searchPanel);
		spring.putConstraint(SpringLayout.WEST, bathfield,136,SpringLayout.WEST, searchPanel);
		spring.putConstraint(SpringLayout.NORTH, bathfield,6 + 2*30,SpringLayout.NORTH, searchPanel);
		
		spring.putConstraint(SpringLayout.WEST, furnishedLabel,6,SpringLayout.WEST, searchPanel);
		spring.putConstraint(SpringLayout.NORTH, furnishedLabel,6 + 3*30,SpringLayout.NORTH, searchPanel);
		spring.putConstraint(SpringLayout.WEST, furnishedfield,136,SpringLayout.WEST, searchPanel);
		spring.putConstraint(SpringLayout.NORTH, furnishedfield,6 + 3*30,SpringLayout.NORTH, searchPanel);
		
		spring.putConstraint(SpringLayout.WEST, quadrantLabel,6,SpringLayout.WEST, searchPanel);
		spring.putConstraint(SpringLayout.NORTH, quadrantLabel,6 + 4*30,SpringLayout.NORTH, searchPanel);
		spring.putConstraint(SpringLayout.WEST, quadrantfield,136,SpringLayout.WEST, searchPanel);
		spring.putConstraint(SpringLayout.NORTH, quadrantfield,6 + 4*30,SpringLayout.NORTH, searchPanel);



		searchPanel.add(searchButton);
		spring.putConstraint(SpringLayout.WEST, searchButton,30,SpringLayout.WEST, searchPanel);
		spring.putConstraint(SpringLayout.NORTH, searchButton,156,SpringLayout.NORTH, searchPanel);
	
		searchPanel.add(backButton);
		spring.putConstraint(SpringLayout.EAST, backButton,-200,SpringLayout.EAST, searchPanel);
		spring.putConstraint(SpringLayout.NORTH, backButton,156,SpringLayout.NORTH, searchPanel);
	
		searchFrame.add(searchPanel);

		spring.putConstraint(SpringLayout.WEST, results,6,SpringLayout.WEST, searchPanel);
		spring.putConstraint(SpringLayout.NORTH, results,6 + 7*30,SpringLayout.NORTH, searchPanel);
		

        
        searchFrame.setTitle("Search Property Page");
        searchFrame.setSize(600,800);
        searchFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        searchFrame.setVisible(true);


        setUpButtonListener(); // set up button action  this sets up bnoth 
       
    }


	// internal listner
		// is also found i nthe controller as a lambda expression 
		//is used to exit the program
	public void setUpButtonListener(){
		ActionListener buttonListner = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) { 
				Object o = e.getSource();

				if(o ==searchButton){
					System.out.println("search");
					// could do call to master controller here
					// but this fucntionality is taken care of elsewhere

				}else if(o == backButton){
					System.out.println("back");
					try {
							
						Thread.sleep(1000);
						System.exit(0);
					} catch (InterruptedException e1) {
						
						e1.printStackTrace();
					}
				
				}
			}
		};
		searchButton.addActionListener(buttonListner);
		backButton.addActionListener(buttonListner);
	}


	/**
	 * changes the resutls label called in actioon lsitener
	 * @param a
	 */
	public void changeResultsLabel(String a){
		
		JLabel tmp = results;
		
		if(tmp !=null){
			searchPanel.remove(tmp);
		}
		
		results = new JLabel(a);
		
		searchPanel.add(results);

		spring.putConstraint(SpringLayout.WEST, results,6,SpringLayout.WEST, searchPanel);
		spring.putConstraint(SpringLayout.NORTH, results,6 + 7*30,SpringLayout.NORTH, searchPanel);
		
		searchPanel.revalidate();
		searchPanel.repaint();


	}

	/**
	 * set up and action listner
	 * @param listenForButton
	 */
	public void addActionListener(ActionListener listenForButton){
        searchButton.addActionListener(listenForButton);

    }

	/**
	 * getter and setteers
	 * 
	 */
	public String getTypefield() {
		return this.typefield.getText();
	}
	public String getBedfield() {
		return this.bedfield.getText();
	}
	public String getBathfield() {
		return this.bathfield.getText();
	}
	public String getFurnishedfield() {
		String a = "false";
		if(this.furnishedfield.getText().equals("Yes")){
			a= "true";
		}
				//might ahve to change this to false or true instead of 0 or 1
		return a;
	}
	public String getQuadrantfield() {
		return this.quadrantfield.getText();
	}

} // en dcclass


































/*

old code before rework



package renter;
// import java.awt.*;
// import java.awt.event.ActionEvent;
import javax.swing.*;

// import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// import java.util.ArrayList; // import the ArrayList class

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RenterView extends JFrame {
    
	JTextField typefield;
    JTextField bedfield;
    JTextField bathfield;
    JTextField furnishedfield;
    JTextField quadrantfield;
   
	JFrame searchFrame;

	JButton searchButton;
	JButton backButton;

	JLabel resultsLabel;

	JPanel searchPanel;

	SpringLayout sl;

	JLabel result ;



	public String getTypefield() {
		return this.typefield.getText();
	}
	public String getBedfield() {
		return this.bedfield.getText();
	}
	public String getBathfield() {
		return this.bathfield.getText();
	}
	public String getFurnishedfield() {
		String a = "false";
		if(this.furnishedfield.getText().equals("Yes")){
			a= "true";
		}
				//might ahve to change this to false or true instead of 0 or 1
		return a;
	}
	public String getQuadrantfield() {
		return this.quadrantfield.getText();
	}



	public void changeResultsLabel(String a){
		
		JLabel tmp = result;
		
		if(tmp !=null){
			searchPanel.remove(tmp);
		}
		
		result = new JLabel(a);
		
		searchPanel.add(result);

		sl.putConstraint(SpringLayout.WEST, result,6,SpringLayout.WEST, searchPanel);
		sl.putConstraint(SpringLayout.NORTH, result,6 + 7*30,SpringLayout.NORTH, searchPanel);
		
		searchPanel.revalidate();
		searchPanel.repaint();


	}

	


	//ctor
    public RenterView(){
		
		// set frame
		searchFrame = new JFrame("search Property");
		searchFrame.setSize(600, 500);
		searchFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setUpPanel();
		
	

		searchFrame.setVisible(true); //initialy set ture
		

       
        // System.out.print(typefield.getText() + " "+ bedfield.getText()+ " " + bathfield.getText()+ " " + furnishedfield.getText()+ " " + quadrantfield.getText());

    }

	public void  setUpPanel(){
				// set panel
		searchPanel = new JPanel();
		
		// saome labels for the jlabels
		String[] labels = {"Type ", "Number of beds", "Number of Bathrooms", "Furnished (Yes, No)", "Location "};
		// String[] labels = {"Type (apartment, attached, detached, townhouse) ", "Number of beds", "Number of Bathrooms", "Furnished (Yes, No)", "Location ( NW, NE, SW, SE)"};
		
		sl = new SpringLayout();
		searchPanel.setLayout(sl); // add layout to panel


			JLabel typeLabel = new JLabel(labels[0]);
			searchPanel.add(typeLabel);
			 typefield = new JTextField("apartment", 20);
			searchPanel.add(typefield);
			sl.putConstraint(SpringLayout.WEST, typeLabel,6,SpringLayout.WEST, searchPanel);
			sl.putConstraint(SpringLayout.NORTH, typeLabel,6 + 0*30,SpringLayout.NORTH, searchPanel);
			sl.putConstraint(SpringLayout.WEST, typefield,136,SpringLayout.WEST, searchPanel);
			sl.putConstraint(SpringLayout.NORTH, typefield,6 + 0*30,SpringLayout.NORTH, searchPanel);


			JLabel bedLabel = new JLabel(labels[1]);
			searchPanel.add(bedLabel);
			 bedfield = new JTextField("2", 20);
			searchPanel.add(bedfield);
			sl.putConstraint(SpringLayout.WEST, bedLabel,6,SpringLayout.WEST, searchPanel);
			sl.putConstraint(SpringLayout.NORTH, bedLabel,6 + 1*30,SpringLayout.NORTH, searchPanel);
			sl.putConstraint(SpringLayout.WEST, bedfield,136,SpringLayout.WEST, searchPanel);
			sl.putConstraint(SpringLayout.NORTH, bedfield,6 + 1*30,SpringLayout.NORTH, searchPanel);
            
			JLabel bathLabel = new JLabel(labels[2]);
			searchPanel.add(bathLabel);
			 bathfield = new JTextField("2", 20);
			searchPanel.add(bathfield);
			sl.putConstraint(SpringLayout.WEST, bathLabel,6,SpringLayout.WEST, searchPanel);
			sl.putConstraint(SpringLayout.NORTH, bathLabel,6 + 2*30,SpringLayout.NORTH, searchPanel);
			sl.putConstraint(SpringLayout.WEST, bathfield,136,SpringLayout.WEST, searchPanel);
			sl.putConstraint(SpringLayout.NORTH, bathfield,6 + 2*30,SpringLayout.NORTH, searchPanel);
            
			JLabel furnishedLabel = new JLabel(labels[3]);
			searchPanel.add(furnishedLabel);
			 furnishedfield = new JTextField("Yes", 20);
			searchPanel.add(furnishedfield);
			sl.putConstraint(SpringLayout.WEST, furnishedLabel,6,SpringLayout.WEST, searchPanel);
			sl.putConstraint(SpringLayout.NORTH, furnishedLabel,6 + 3*30,SpringLayout.NORTH, searchPanel);
			sl.putConstraint(SpringLayout.WEST, furnishedfield,136,SpringLayout.WEST, searchPanel);
			sl.putConstraint(SpringLayout.NORTH, furnishedfield,6 + 3*30,SpringLayout.NORTH, searchPanel);

			JLabel quadrantLabel = new JLabel(labels[4]);
			searchPanel.add(quadrantLabel);
			quadrantfield = new JTextField("NW", 20);
			searchPanel.add(quadrantfield);
			sl.putConstraint(SpringLayout.WEST, quadrantLabel,6,SpringLayout.WEST, searchPanel);
			sl.putConstraint(SpringLayout.NORTH, quadrantLabel,6 + 4*30,SpringLayout.NORTH, searchPanel);
			sl.putConstraint(SpringLayout.WEST, quadrantfield,136,SpringLayout.WEST, searchPanel);
			sl.putConstraint(SpringLayout.NORTH, quadrantfield,6 + 4*30,SpringLayout.NORTH, searchPanel);
			
			
			
			 resultsLabel = new JLabel("");
			searchPanel.add(resultsLabel);
			sl.putConstraint(SpringLayout.WEST, resultsLabel,6,SpringLayout.WEST, searchPanel);
			sl.putConstraint(SpringLayout.NORTH, resultsLabel,6 + 6*30,SpringLayout.NORTH, searchPanel);
			sl.putConstraint(SpringLayout.WEST, resultsLabel,136,SpringLayout.WEST, searchPanel);
			sl.putConstraint(SpringLayout.NORTH, resultsLabel,6 + 6*30,SpringLayout.NORTH, searchPanel);



		searchButton = new JButton("Search"); // initialize search button
		backButton = new JButton("back"); // initialize search button


		// searchPanel.add(searchButton);
		// sl.putConstraint(SpringLayout.WEST, searchButton,6,SpringLayout.WEST, searchPanel);
		// sl.putConstraint(SpringLayout.NORTH, searchButton,156,SpringLayout.NORTH, searchPanel);
	
		searchPanel.add(backButton);
		sl.putConstraint(SpringLayout.EAST, backButton,20,SpringLayout.EAST, searchPanel);
		sl.putConstraint(SpringLayout.NORTH, backButton,176,SpringLayout.NORTH, searchPanel);
	

		JScrollPane scroll = new JScrollPane();
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		searchPanel.add(scroll);

	}





    public void display(){ // displays oin the console 
        System.out.print("--------"+typefield.getText() + " "+ bedfield.getText()+ " " + bathfield.getText()+ " " + furnishedfield.getText()+ " " + quadrantfield.getText());

    }

	


	public void addActionListener(ActionListener listenForButton){
        searchButton.addActionListener(listenForButton);
    }




    
   

  
  

}





 */