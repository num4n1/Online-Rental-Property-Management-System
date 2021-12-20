package registeredRenter;
import java.sql.*;
import java.util.*;

// import landlord.Property;
import renter.SearchStratagy;
import user.User;

public class RegisteredRenter{
	
	private User user;
	private Connection dbConnection;
	private SearchStratagy searchStrategy;
	private ArrayList<String> notifCriteria;
	private ArrayList<String> notifications;
	

    /**
	 * Method: Connect user based on user's information from the database
	 * @param a
	 * @param dbConnect
	 */
	public RegisteredRenter(User a, Connection dbConnect) {
		this.user = a;
		this.dbConnection = dbConnect;
	}
	
    /**
	 * Method: Connect user based on user's information from the database and user's search function
	 * @param a
	 * @param search
	 * @param dbConnect
	 */
    public RegisteredRenter(User a, SearchStratagy search, Connection dbConnect) {
        this.user = a;
    	this.searchStrategy = search;
        this.dbConnection = dbConnect;
        fillNotifications();
    }
    
     /**
     * Method: Default Constructor
     */
    public RegisteredRenter() {
		// TODO Auto-generated constructor stub
	}

     /**
     * Method: get Search strategy
     * @return searchStrategy
     */
	public SearchStratagy getSearch() {
        return this.searchStrategy;
    }
	/*
	 * Method: get the connection
	 * @return Connection dbConnection
	 */    
    public Connection getDbConnect() {
        return this.dbConnection;
    }
 /**
     * Method: set the connection
     * @param dbConnect
     */
    public void setDbConnect(Connection dbConnect) {
        this.dbConnection = dbConnect;
    }
/*
     * Method: set user's search strategy
     */
    public RegisteredRenter search(SearchStratagy search) {
        setSearch(search);
        return this;
    }

    /**
     * Method: set user's connection
     * @param dbConnect
     * @return
     */
    public RegisteredRenter dbConnect(Connection dbConnect) {
        setDbConnect(dbConnect);
        return this;
    }

    /**
     * to string helper method
     */
    @Override
    public String toString() {
        return "{" +
            " search='" + getSearch() + "'" +
            ", dbConnect='" + getDbConnect() + "'" +
            "}";
    }

 /**
     * Method: set user's search strategy
     * @param search
     */
    public void setSearch(SearchStratagy search) {
        this.searchStrategy = search;
    }
    
     /**
     * Method: Perform searching all property based on user preference's
     * @param a
     * @return
     */
    public ArrayList<String> performSearch(ArrayList<String> a){ // uses the class associated withtreh current sort method
        return searchStrategy.performSearch(dbConnection, a); // i think i have to pass array of Item<E> type as reference to be sorted

     }
    
      /**
     * Method: get Property's information
     * @param id
     * @return
     */
    public String getPropertyinfo(String id){

        StringBuffer propteryInfo = new StringBuffer();
        ResultSet results;   // result
       
        try {                        
            Statement myStmt = dbConnection.createStatement();
            results = myStmt.executeQuery("SELECT * FROM properties WHERE (property_id =\'"+  id  + "\')");  // do the command
            
            while (results.next()){
               if(  results.getString("datePosted") != null  ){

                   propteryInfo.append(
                       "Property - "+  results.getString("property_id") + "<br> "+ 
                       "&nbsp&nbsp&nbsp  LandLord ID - " + results.getString("landlord_id") + "<br> " +
                       "&nbsp&nbsp&nbsp  Date Posted - " +results.getString("datePosted") + "<br> " +   
                       "&nbsp&nbsp&nbsp  Type - " +results.getString("type") + "<br> " +
                       "&nbsp&nbsp&nbsp  Number of Bedrooms - " + results.getString("bed") + "<br> " +   
                       "&nbsp&nbsp&nbsp  Number of Bathrooms - " + results.getString("bath") + "<br> " 
                       );
                    String f = "No";
                    if(results.getString("furnished").equals("1")){
                        f= "Yes";
                    }
                   
                    
                    propteryInfo.append(
                        "&nbsp&nbsp&nbsp  Funished - "+ f + "<br> " +   
                        "&nbsp&nbsp&nbsp  Location - " + results.getString("quadrant") + "<br> " + 
                        "&nbsp&nbsp&nbsp  Rent - $" +results.getString("rent") + "<br> "  +
                        "&nbsp&nbsp&nbsp  Address - " +results.getString("address") + "<br> " + 
                        "&nbsp&nbsp&nbsp  Status - " + results.getString("status") + "<br> "  
                        );
                            
                }// only get posted properties 
                    
            }//end while
     
            myStmt.close(); // close the thing
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return propteryInfo.toString();
    }
    
    /**
     * Method: Edit user's preference for notification system
     * @param newCriteria
     */
	public void editNotificationSetting(ArrayList<String> newCriteria) {
		notifCriteria = newCriteria;
        System.out.println("NEW NOTIF ADDED!!");
        fillNotifications();
	}

    /*
	 * Method: Fill in user's Notification
	 */
	public void fillNotifications() {
        if(notifCriteria != null && notifCriteria.size() != 0) {
            notifications = performSearch(notifCriteria);
            System.out.println("NOTIF FILLED!!" + notifications.size());
            for(String i : notifications){
                System.out.println(getPropertyinfo(i));
            }
        }
	}
	
	
}
