package renter;
// import java.text.DateFormat;
// import java.text.SimpleDateFormat;



// import java.util.Calendar;
// import java.util.Date;
import java.sql.*;
import java.util.ArrayList; // import the ArrayList class



public class Renter {
    private SearchStratagy search; // a strategy pattern 
    Connection dbConnect; // connection object
   
    /**
     * default ctor
     */
    public Renter() {
    }

    /**
     * Getters and setters
     *
     */
    public Renter( Connection dbConnect) {
        this.dbConnect = dbConnect;
    }
    public Renter(SearchStratagy search, Connection dbConnect) {
        this.search = search;
        this.dbConnect = dbConnect;
    }
    public SearchStratagy getSearch() {
        return this.search;
    }
    public Connection getDbConnect() {
        return this.dbConnect;
    }
    public void setDbConnect(Connection dbConnect) {
        this.dbConnect = dbConnect;
    }

    public Renter search(SearchStratagy search) {
        setSearch(search);
        return this;
    }
    public Renter dbConnect(Connection dbConnect) {
        setDbConnect(dbConnect);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " search='" + getSearch() + "'" +
            ", dbConnect='" + getDbConnect() + "'" +
            "}";
    }

    public void setSearch(SearchStratagy search) {
        this.search = search;
    }

    public void setSearchStratagy(SearchStratagy s){
        this.search = s;
    }//end setSortStrategy  same a s above 




    /**
     * perform the search for poroperties
     * @param a
     * @return
     */
    public ArrayList<String> performSearch(ArrayList<String> a){ // uses the class associated withtreh current sort method
       return search.performSearch(dbConnect, a); // i think i have to pass array of Item<E> type as reference to be sorted

    }//end preform sort


    /**
     * 
     * @param id a property ID
     * @return a string with formated info of the property
     */
    public String getPropertyinfo(String id){

        StringBuffer propteryInfo = new StringBuffer();
        ResultSet results;   // result
       
        try {                        
            Statement myStmt = dbConnect.createStatement();
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
    
        // could use results to fill and array to return 
    
        return propteryInfo.toString(); // convert StringBuffer to string array containing the results getting all properties 

    
    } //end fucntion




}
