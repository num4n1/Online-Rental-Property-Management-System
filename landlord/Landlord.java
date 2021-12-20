package landlord;

import java.sql.*;
import java.text.ParseException;
import java.util.*;
import user.User;

public class Landlord {

    private String lanlordId;
	private User user;
	private ArrayList<Property> registeredProperties = new ArrayList<Property>();
	private ArrayList<Property> postedProperties = new ArrayList<Property>();
	//private Email email;

	/**
	 * method: this is constructor that will get all landlord's informations from the database
	 * @param user
	 * @param dbConnect
	 */
	public Landlord(User user, Connection dbConnect) {
		this.user = user;
        try {

            Statement statement = dbConnect.createStatement();
            String query = String.format("SELECT landlord_id FROM landlord WHERE user_id = '%s'", user.getUserID());
			System.out.println("Num of properties: ");
            ResultSet result = statement.executeQuery(query);
            result.next();
            lanlordId = result.getString("landlord_id");

			registeredProperties = new Property().fillPropertyArray(lanlordId, dbConnect);
			System.out.println("Num of properties: " + Integer.toString(registeredProperties.size()));
			for(Property i : registeredProperties){
				if(i.getStatus().equals("Posted")){
					postedProperties.add(i);
				}
			}

		} catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
			e.printStackTrace();
		}

	}
	/**
	 * get landlordId from the database in string form
	 * @return string
	 */
    public String getLandlordId(){
        return lanlordId;
    }

    /**
     * method: Add a new Property to list of registered property in landlord class and database
     * @param Property
     */
	public void addProperty(Property a) {
		registeredProperties.add(a);
		a.updateThisProperty();
	}

	/**
	 * method: Remove a property from landlord's posted property
	 * @param Property in posted property
	 */
	public void removeProperty(Property a) {
		postedProperties.remove(a);
	}

	/**
	 * method: Make landlord pay for a fee to get a property posted
	 * @param Property in registered property
	 */
	public void payFees(Property a) {
		a.setPropertyToPosted();
		a.setStatus("Posted");
		postProperty(a);
	}

	/**
	 * method: add a registered property to posted property
	 * @param Property in registered Property
	 */
	public void postProperty(Property a) {
		postedProperties.add(a);
	}

	/**
	 * method: change status of one property in registered property
	 * @param Property in registered property
	 */
	public void changePropertyListing(Property a) {
		System.out.println(a.getStatus());
		System.out.println(a.getProperty_id());
//		System.out.println(a.getLandlord().getLandlordId());
		if (a.getStatus().equals("active"))
			a.setStatus("inactive");
		else if (a.getStatus().equals("inactive"))
			a.setStatus("active");
		try{
			a.updateThisStatus();

		}catch (Exception as){
			System.out.println("----------54454545445----");
		}
		System.out.println(a.getStatus());
	}

	/**
	 * method: get user from landlord class
	 * @return user
	 */
	public User getUser() {
		return this.user;
	}
//
//	//public Email getEmail() {
//		return this.email;
//	}
//
//	public void sendEmail(RegisteredRenter a, String message) {
//		a.getEmail().addMessage(message);
//	}
//
	/**
	 * method: get landlord's registered property
	 * @return registeredProperties
	 */
	public ArrayList<Property> getRegisteredProperties() {
		System.out.println("!!!!Num of properties: " + Integer.toString(registeredProperties.size()));
		return this.registeredProperties;
	}

}
