package registeredRenter;

import renter.Renter;
import renter.SearchStratagy;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
public class RegisteredRenterController {
	
    private RegisteredRenter registeredrenter;
	private RegisteredRenterView theView;
	
	/**
	 * method: Login as one of the registered renter from the database
	 * @param rr
	 * @param view
	 */
	public RegisteredRenterController(RegisteredRenter rr, RegisteredRenterView view) {
		registeredrenter = rr;
		theView = view;
		RegisteredRenterInit();
	}
	
	/**
	 * method: show RegisteredRenter's homepage to the user
	 */
	public void RegisteredRenterInit() {
		theView.RRenterViewInit();
		theView.addHomepage();
		
		/**
		 * method: Search Property Button will call search engine
		 */
		theView.getSearchPropertyButton().addActionListener(e->{
			theView.removeHomepage();
			theView.addSearch();
		});
		
		/**
		 * method: Add Notification button will move to Add Notification panel
		 */
		theView.getAddNotificationButton().addActionListener(e->{
			theView.removeHomepage();
			theView.addAddNotification();
		});
		
		/**
		 * method: unsubscribe user from notification service
		 */
		theView.getRemoveNotificationButton().addActionListener(e->{
			// Add RegisteredRenter back-end code here
			
			JOptionPane.showMessageDialog(null, "You have unsubscribed the notification service",
					"", JOptionPane.PLAIN_MESSAGE);
		});
		
		/**
		 * method: Update user with new properties
		 */
		theView.getUpdateNotificationButton().addActionListener(e->{
			// Add RegisteredRenter back-end code here
			
			theView.addNotificationResult("");
		});
		
		/**
		 * method: Search Button will give users all properties based on their preference
		 */
		theView.getSearchButton().addActionListener(e->{
			
			/**
			 * show error message when user didn't input all information
			 */
			if (theView.getTypeSField().getText().isEmpty() || 
				theView.getBedSField().getText().isEmpty() || 
				theView.getBathroomSField().getText().isEmpty() || 
				theView.getFurnishedSField().getText().isEmpty() || 
				theView.getQuadrantSField().getText().isEmpty()) 
			{
				JOptionPane.showMessageDialog(theView.getRRenterFrame(), "Please input all the information");
			}
			else {
				/***************************************NEED TO UPDATE********************************/
				ArrayList<String> searchCrit = new ArrayList<>();
				searchCrit.add(theView.getTypeSField().getText());
				searchCrit.add(theView.getBedSField().getText());
				searchCrit.add(theView.getBathroomSField().getText());
				String a = "false";
				if(theView.getFurnishedNField().getText().equals("Yes")){
					a= "true";
				}
				//might ahve to change this to false or true instead of 0 or 1
				searchCrit.add(a);

				searchCrit.add(theView.getQuadrantSField().getText());

			    ArrayList<String> searchResults = registeredrenter.performSearch(searchCrit);
				String returnValue= "";
				for (String temp : searchResults) {
                    // append all the property info to the 
                    Renter r = new Renter();
					r.setDbConnect(registeredrenter.getDbConnect());
                    // use temp to get property info 
                    returnValue += r.getPropertyinfo(temp); // and the returnValue for this 
                    // or put this in an array to send to the view so i can make a button of reach 
                    returnValue += "<br>=========================<br>";

                }

                theView.addSearchResult("<html>"+returnValue+"<html>");

				



			}
		});
		
		/**
		 * method: Back button in Search panel will move user back to homepage
		 */
		theView.getSearchBackButton().addActionListener(e->{
			theView.removeSearch();
			theView.addHomepage();
		});
		
		/**
		 * method: Subscribe user to notification system based on their preference
		 */
		theView.getSubNotificationButton().addActionListener(e->{
			
			/**
			 * show error message when user didn't input all information
			 */
			if (theView.getTypeNField().getText().isEmpty() || 
					theView.getBedNField().getText().isEmpty() || 
					theView.getBathroomNField().getText().isEmpty() || 
					theView.getFurnishedNField().getText().isEmpty() || 
					theView.getQuadrantNField().getText().isEmpty()) {
				JOptionPane.showMessageDialog(theView.getRRenterFrame(), "Please input all the information");
			}
			else {
				/*****************ORDER OF PLACEMENT COULD BE WRONG!**********************/
				ArrayList<String> newNotif = new ArrayList<>();
				newNotif.add(theView.getTypeNField().getText());
				newNotif.add(theView.getBedNField().getText());
				newNotif.add(theView.getBathroomNField().getText());

				/**************************** NOT SURE IF NEEDS UPDATING *********************/
				String a = "false";
				if(theView.getFurnishedNField().getText().equals("Yes")){
					a= "true";
				}
				//might ahve to change this to false or true instead of 0 or 1
				newNotif.add(a);

				System.out.println(theView.getFurnishedNField().getText());
				newNotif.add(theView.getQuadrantNField().getText());
				
			    // Add add registered observer function here
				/**********************UPDATE NOTIFICATION CRITERIA! NEED TO PROPERLY PLACE THEM IN ARRAY LIST*************/
				//String [] noti = {type, bed, bathroom, furnished, quadrant};

				registeredrenter.editNotificationSetting(newNotif);
				
				
				
				theView.addNotificationResult("");
				theView.removeAddNotification();
				theView.addHomepage();
			}
		});
		
		/**
		 * Method: Back button in Add Notification panel will move user back to homepage 
		 */
		theView.getSubBackButton().addActionListener(e->{
			theView.removeAddNotification();
			theView.addHomepage();
		});
		
	}
	

}
