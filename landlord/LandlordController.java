package landlord;

import java.awt.*;
import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.*;

public class LandlordController {
	private LandlordView theView;
	private Landlord landlord;
	private Connection dbConnect;
	
	/* Once login as landlord it will show landlord homepage */
	public LandlordController(Landlord ll, LandlordView view) {
		landlord = ll;
		theView = view;
		Landlordinit();
	}
	
	public void Landlordinit() {
		theView.LandlordViewInit();
		theView.addHomepage();
		
		/**
		 * method: Register Property button will move from homepage to Register Property page
		 */
		theView.getRegisterPropertyButton().addActionListener(e->{
			theView.removeHomepage();
			theView.addRegisterProperty();
		});
		
		/**
		 * method: Property List Button will move from home to Property List with all registered property that landlord owns
		 */
		theView.getPropertyListButton().addActionListener(e->{
			theView.removeHomepage();
			// Add property list function here: property id, property address, status of all property that the landlord has
			String list = "<html>";
			ArrayList<Property> tmp = new ArrayList<>();
			tmp = landlord.getRegisteredProperties();


			for (int i = 0; i < tmp.size(); i++) {
				list = list.concat("Property id: ");
				list = list.concat(Integer.toString(tmp.get(i).getProperty_id()));
				list = list.concat("<br>");
				list = list.concat("Property Address: ");
				list = list.concat(tmp.get(i).getAddress());
				list = list.concat(" ");
				list = list.concat(tmp.get(i).getCityQuadrant());
				list = list.concat("<br>");
				list = list.concat("Status: ");
				list = list.concat(tmp.get(i).getStatus());
				list = list.concat("<br>");
				list = list.concat("=============================");
				list = list.concat("<br>");

			}
			list = list.concat("</html>");
			System.out.println("IM DONE");
			theView.addPropertyList(list);

		});
		
		/**
		 * method: Register button will register a new property to the program and database and move back to homepage
		 */
		theView.getRegisterButton().addActionListener(e->{
			
			/* if landlord didn't give enough information */
			if (theView.getTypeField().getText().isEmpty() || 
					theView.getBedField().getText().isEmpty() || 
					theView.getBathroomField().getText().isEmpty() || 
					theView.getFurnishedField().getText().isEmpty() ||
					theView.getAddressField().getText().isEmpty() ||
					theView.getQuadrantField().getText().isEmpty() ||
					theView.getRentField().getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Please input all the information",
						"Error Message", JOptionPane.PLAIN_MESSAGE);
			}
			
			/*if landlord gives enough information, it will create new property and register it*/
			else {
				
				String type = theView.getTypeField().getText();
				String bed = theView.getBedField().getText();
				String bathroom = theView.getBathroomField().getText();
				String furnished = theView.getFurnishedField().getText();
				String address = theView.getAddressField().getText();
				String quadrant = theView.getQuadrantField().getText();
				String rent = theView.getRentField().getText();
				
			    // Add register property function here
				int num_bed = Integer.parseInt(bed);
				int num_bathroom = Integer.parseInt(bathroom);
				double rent_num = Double.parseDouble(rent);
				boolean isFurnished;
		        if (furnished == "Yes") isFurnished = true;
		        else if (furnished == "No") isFurnished = false;
		        else isFurnished = false;
			
				Property tmp = new Property();
				tmp.setType(type);
				tmp.setNumberBedrooms(num_bed);
				tmp.setNumberBathrooms(num_bathroom);
				tmp.setFurnished(isFurnished);
				tmp.setAddress(address);
				tmp.setCityQuadrant(quadrant);
				tmp.setRent(rent_num);
				
				landlord.addProperty(tmp);
				
				theView.removeRegisterProperty();
				theView.addHomepage();
			}
		});
		
		/**
		 * method: Back button from Register Property page will move back homepage
		 */
		theView.getRegisterBackButton().addActionListener(e->{
			theView.removeRegisterProperty();
			theView.addHomepage();
		});
		
		/**
		 * method: Edit button will move from Property List to edit page
		 */
		theView.getEditButton().addActionListener(e->{
			theView.removePropertyList();
			theView.addEdit();
		});
		
		/**
		 * method: Back button from Property List page will move back to homepage
		 */
		theView.getListBackButton().addActionListener(e->{
			theView.removePropertyList();
			theView.addHomepage();
		});
		
		/**
		 * method: Pay Fee button will get property_id and change its state to active
		 */
		theView.getPayFeeButton().addActionListener(e->{
			String id = theView.getPropertyField().getText();
			
			/* If landlord didn't input property_id*/
			if (id == null) {
				JOptionPane.showMessageDialog(null, "Please input all the information",
						"Error Message", JOptionPane.PLAIN_MESSAGE);
			}
			
			/* If landlord input property_id */
			else {
				
				Property tmp = null;
				int p_id = Integer.parseInt(id);
				for (int i = 0; i < landlord.getRegisteredProperties().size(); i++) {
					if (p_id == landlord.getRegisteredProperties().get(i).getProperty_id()) {
						tmp = landlord.getRegisteredProperties().get(i);
					}
				}
				landlord.payFees(tmp);
			    theView.removeEdit();
			    theView.addHomepage();
				
			}		
		});
		
		/**
		 * method: Change Status button will get property_id and change its status depending on its previous status
		 */
		theView.getChangeStatusButton().addActionListener(e->{
			String id = theView.getPropertyField().getText();
			
			/*If landlord didn't input property_id*/
			if (id == null) {
				JOptionPane.showMessageDialog(null, "Please input all the information",
						"Error Message", JOptionPane.PLAIN_MESSAGE);
			}
			
			/*If landlord input property_id*/
			else {
					
				// Add change status function here
				int p_id = Integer.parseInt(id);
				for (int i = 0; i < landlord.getRegisteredProperties().size(); i++) {
					if (p_id == landlord.getRegisteredProperties().get(i).getProperty_id()) {
						try{
							landlord.changePropertyListing(landlord.getRegisteredProperties().get(i));

						}catch (Exception as){
							System.out.println("lllllllll[][][][][][][lllllllllll");
						}
					}
				}

				theView.removeEdit();
				theView.addHomepage();
			}
		});
		
		/**
		 * method: Cancel button will move back to homepage 
		 */
		theView.getEditCancelButton().addActionListener(e->{
			theView.removeEdit();
			theView.addHomepage();
		});
	
	}
	 	
}
