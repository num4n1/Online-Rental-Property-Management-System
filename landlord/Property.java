package landlord;
/*
    Property.java
    Author Chace Nielson
    Date Thursday, December 2, 2021

    


*/

import java.util.Date;

import database.DateCalculator;

import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList; // import the ArrayList class

public class Property extends DateCalculator{
    
//this class is a bnit messy withthe numebr of fields
// it was decided that creating a second class to hold this onformation wouldmbe messier and this method does work 
//13 items 
    private Connection dbConnect;  //connection object
   

    private int property_id; // if so it can be accesses in database 
    private boolean posted; // can it be posted or not, differnt from status
    private String status; // changed by landlord of manager if active it can bee seen or else it can't 
    private Date datePosted; // acts a bool for is fee is paid if null fee isn't paid , it is a bit useless other than to see when you posted it 
    private Date postingExpirationDate; //when fee is good for
    private double postingFee;
     
    private Landlord landlord; // landlord in charge of property 

    //constants only changed bny landlord   
    private String type;
    private int numberBedrooms;
    private int numberBathrooms;
    private String cityQuadrant;
    private boolean furnished;
    private double rent;
    private String address;

    /**
     * ctor
     */
    public Property() {
    }

    /**
     * ctro with following arguments 
     * @param property_id
     * @param posted
     * @param status
     * @param datePosted
     * @param postingExpirationDate
     * @param postingFee
     * @param landlord
     * @param type
     * @param numberBedrooms
     * @param numberBathrooms
     * @param cityQuadrant
     * @param furnished
     * @param rent
     * sets all members
     * 
     */
    public Property(Connection dbConnection, int property_id, boolean posted, String status, Date datePosted,
                    Date postingExpirationDate, double postingFee, Landlord landlord, 
                    String type, int numberBedrooms, int numberBathrooms, 
                    String cityQuadrant, boolean furnished, double rent, String address) {
        this.dbConnect = dbConnection;
        this.property_id = property_id;
        this.posted = posted;
        this.status = status;
        this.datePosted = datePosted;
        this.postingExpirationDate = postingExpirationDate;
        this.postingFee = postingFee;
        this.landlord = landlord;
        this.type = type;
        this.numberBedrooms = numberBedrooms;
        this.numberBathrooms = numberBathrooms;
        this.cityQuadrant = cityQuadrant;
        this.furnished = furnished;
        this.rent = rent;
        this.address= address;
    }

   

    /**
     * a ton of getters and setters
     */
    public void setAddress(String address){
        this.address = address;
    }
    public String getAddress(){
        return this.address;
    }
    public Connection getConnection(){
        return this.dbConnect;
    }
    public void setConnection(Connection dbConnection){
        this.dbConnect = dbConnection;
    }
    public int getProperty_id() {
        return this.property_id;
    }
    public void setProperty_id(int property_id) {
        this.property_id = property_id;
    }
    public boolean isPosted() {
        return this.posted;
    }
    public boolean getPosted() {
        return this.posted;
    }
    public void setPosted(boolean posted) {
        this.posted = posted;
    }
    public String getStatus() {
        return this.status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Date getDatePosted() {
        return this.datePosted;
    }
    public void setDatePosted(Date datePosted) {
        this.datePosted = datePosted;
    }
    public Date getPostingExpirationDate() {
        return this.postingExpirationDate;
    }
    public void setPostingExpirationDate(Date postingExpirationDate) {
        this.postingExpirationDate = postingExpirationDate;
    }
    public double getPostingFee() {
        return this.postingFee;
    }
    public void setPostingFee(double postingFee) {
        this.postingFee = postingFee;
    }
    public Landlord getLandlord() {
        return this.landlord;
    }
    public void setLandlord(Landlord landlord) {
        this.landlord = landlord;
    }
    public String getType() {
        return this.type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public int getNumberBedrooms() {
        return this.numberBedrooms;
    }
    public void setNumberBedrooms(int numberBedrooms) {
        this.numberBedrooms = numberBedrooms;
    }
    public int getNumberBathrooms() {
        return this.numberBathrooms;
    }
    public void setNumberBathrooms(int numberBathrooms) {
        this.numberBathrooms = numberBathrooms;
    }
    public String getCityQuadrant() {
        return this.cityQuadrant;
    }
    public void setCityQuadrant(String cityQuadrant) {
        this.cityQuadrant = cityQuadrant;
    }
    public boolean isFurnished() {
        return this.furnished;
    }
    public boolean getFurnished() {
        return this.furnished;
    }
    public void setFurnished(boolean furnished) {
        this.furnished = furnished;
    }
    public double getRent() {
        return this.rent;
    }
    public void setRent(double rent) {
        this.rent = rent;
    }
    public Property property_id(int property_id) {
        setProperty_id(property_id);
        return this;
    }
    public Property posted(boolean posted) {
        setPosted(posted);
        return this;
    }
    public Property status(String status) {
        setStatus(status);
        return this;
    }
    public Property datePosted(Date datePosted) {
        setDatePosted(datePosted);
        return this;
    }
    public Property postingExpirationDate(Date postingExpirationDate) {
        setPostingExpirationDate(postingExpirationDate);
        return this;
    }
    public Property postingFee(double postingFee) {
        setPostingFee(postingFee);
        return this;
    }
    public Property landlord(Landlord landlord) {
        setLandlord(landlord);
        return this;
    }
    public Property type(String type) {
        setType(type);
        return this;
    }
    public Property numberBedrooms(int numberBedrooms) {
        setNumberBedrooms(numberBedrooms);
        return this;
    }
    public Property numberBathrooms(int numberBathrooms) {
        setNumberBathrooms(numberBathrooms);
        return this;
    }
    public Property cityQuadrant(String cityQuadrant) {
        setCityQuadrant(cityQuadrant);
        return this;
    }
    public Property furnished(boolean furnished) {
        setFurnished(furnished);
        return this;
    }
    public Property rent(double rent) {
        setRent(rent);
        return this;
    }



    /**
     * creates a string of all the fields helper method
     */
    @Override
    public String toString() {
        return "{" +
            " property_id='" + getProperty_id() + "'" +
            ", posted='" + isPosted() + "'" +
            ", status='" + getStatus() + "'" +
            ", datePosted='" + datetoString(getDatePosted()) + "'" +
            ", postingExpirationDate='" + datetoString(getPostingExpirationDate()) + "'" +
            ", postingFee='" + getPostingFee() + "'" +
            ", landlord='" + getLandlord().getLandlordId() + "'" +
            ", type='" + getType() + "'" +
            ", numberBedrooms='" + getNumberBedrooms() + "'" +
            ", numberBathrooms='" + getNumberBathrooms() + "'" +
            ", cityQuadrant='" + getCityQuadrant() + "'" +
            ", furnished='" + isFurnished() + "'" +
            ", rent='" + getRent() + "'" +
            "}";
    }


    /**
     * 
     * @return string of the info that potenitally changes in the database
     */
    public String id_post_dates_toString() {
        return "{" +
            " property_id='" + getProperty_id() + "'" +
            ", posted='" + isPosted() + "'" +
            ", status='" + getStatus() + "'" +
            ", datePosted='" + datetoString(getDatePosted()) + "'" +
            ", postingExpirationDate='" + datetoString(getPostingExpirationDate()) + "'" +
            "}";
    }



    /////////Other fucntions
    /////////////////////////////////////////////////////////////////////  //////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////  //////////////////////////////////////////////////////////////////////


    /**
     * set this property to posted
     * and update eh database to reflect that 
     * also changes the posted day and postedExpiration date
     */
public void setPropertyToPosted(){
    // DateCalculator a= new DateCalcultor(); // could just inherit this Class 
    posted = true; // it is now set to posted
    datePosted= getTodaysDate(); // set todays date
    postingExpirationDate = addDaysToToday(60); // 60 days from now
    // can make 60 a variable to bve passed through to allow change in the future if they wanted a longer or shorter payment period  

    updateThisProperty();
    // call update to database this property 


}//end fucntion 



/**
 * cheks is posting Expiration date has passed
 * if true it unposts the property changes date info 
 * and updates database 
 */
public void checkPostingExpirationDate(){

    if(dateHasPassed(postingExpirationDate)){

        posted = false; 
        datePosted = null; // reset the date posted 
        postingExpirationDate = null;
        
        updateThisProperty();
        
        // call update to database 

    }else{
        return; // nothing to change property is still good till posting period is over 
    }

}

/**
 * acess database 
 * @return an arraylsit with each index containing a string of info for each property 
 * also gets the landlord ID
 * need Dbconnect in class for this to work 
 */
public ArrayList<String> selectAllProperties() {

    StringBuffer propteryInfo = new StringBuffer();
    ResultSet results;   // result
    ArrayList<String> a = new ArrayList<>(); // to hold results 
    
    try {                        
        Statement myStmt = dbConnect.createStatement();
        results = myStmt.executeQuery("SELECT * FROM properties"); // do the command
        while (results.next()){

            
            StringBuffer b= new StringBuffer();
            b.append(results.getString("property_id") + ", " + results.getString("landlord_id") + ", " +
            results.getString("posted") + ", " + results.getString("datePosted") + ", " +   
            results.getString("postingExpiration") + ", " + results.getString("postingFee") + ",\n" +   
            results.getString("type") + ", " + results.getString("bed") + ", " +   
            results.getString("bath") + ", " + results.getString("furnished") + ", " +   
            results.getString("quadrant") + ", " + results.getString("rent") + ", " +   
            results.getString("status")+ ", " + results.getString("address") + "\n"
            );

             a.add(b.toString());
   
        }//end while

        
        myStmt.close(); // close the thing
    } catch (SQLException ex) {
        ex.printStackTrace();
    }

    // could use results to fill and array to return 
    // System.out.println( propteryInfo.toString()); // a stering result of the stuff

    return a; // convert StringBuffer to string array containing the results getting all properties 
    

}


/**
 * takes current posted and date info and updates the database 
 */
public void updateThisProperty(){
    
    try {                        
        // Statement myStmt = dbConnect.createStatement();
        int p=0;
        if(getPosted())
            p = 1;
        
            //can't insert a boolean need to insert a string or 1 or 0

            String query;

            if(datePosted == null || postingExpirationDate ==null){
                query = "UPDATE properties SET posted =\'"+ p  +
                "\', datePosted = "+ "NULL" +
                ", postingExpiration = "+ "NULL" +
                " WHERE (property_id =\'"+  getProperty_id()  + "\')";

            }else{
                 query = "UPDATE properties SET posted =\'"+ p  +
                "\', datePosted = \'"+ datetoString( getDatePosted() ) +
                "\', postingExpiration = \'"+ datetoString( getPostingExpirationDate() ) +
                "\' WHERE (property_id =\'"+  getProperty_id()  + "\')";

            }
        
        // System.out.println("\n\n"+ query);
        
        PreparedStatement myStmt = dbConnect.prepareStatement(query);
        int rowCount = myStmt.executeUpdate();  // execute the update tpo the database
        System.out.println("Rows affected: " + rowCount);
        System.out.println("  property Updated  ");

        
        myStmt.close(); // close the thing
    } catch (SQLException ex) {
       
        System.out.println("Could not update property");
        ex.printStackTrace();
        System.out.println(ex.getMessage());
    }

} //end fucntion 


/**
 * create a property and pass all its info to this fucntions
 * @param a a good amnount of info is null 
 * @return statemtn saying property is added 
 * 
 * could make this static but need to change a bunch of stuff
 */
public String addProperty(Property a){
    // add property a to the database 
            try {             
                String query =  "INSERT INTO properties (landlord_id, posted, datePosted, postingExpiration, postingFee, bed, type, bath, furnished, quadrant, rent, status, address)" +
                        "VALUES ("+a.getLandlord().getLandlordId() +  ", "+ a.getPosted() +", "+ datetoStringwSlash(a.getDatePosted()) +", "+ 
                        datetoStringwSlash(a.getPostingExpirationDate())+
                        ", " + a.getPostingFee() + ", " + 7 + ", \'" + a.getType()  +"\', " + 
                        a.getNumberBathrooms() + ", " + a.getFurnished() +
                        ", \'" + a.getCityQuadrant() + "\', " + a.getRent()+ ", \'" 
                        +a.getStatus() +"\'"+ 
                        
                        ", \'" 
                        +a.getAddress() +"\'"+ 

                        
                        ");";

                PreparedStatement myStmt = dbConnect.prepareStatement(query);
                int rowCount = myStmt.executeUpdate();  // execute the update tpo the database
                System.out.println("Rows affected: " + rowCount);
                
                myStmt.close();  // close the statement
    
            } catch (SQLException ex) {
                System.out.println("Could not add property");
                ex.printStackTrace();
                System.out.println(ex.getMessage());
            }
        
        return "\nProperty Added to database\n";
}//end fcuntion 


/**
 * create a property and pass all its info to this fucntions
 * @param a a good amnount of info is null 
 * @return
 */
public String addThisProperty(){
    // add property a to the database 
    try {             
        String query =  "INSERT INTO properties (landlord_id, posted, datePosted, postingExpiration, postingFee, bed, type, bath, furnished, quadrant, rent, status, address)" +
                "VALUES ("+this.getLandlord().getLandlordId() +  ", "+ this.getPosted() +", "+ datetoStringwSlash(this.getDatePosted()) +", "+ 
                datetoStringwSlash(this.getPostingExpirationDate())+
                ", " + this.getPostingFee() + ", " + 7 + ", \'" + this.getType()  +"\', " + 
                this.getNumberBathrooms() + ", " + this.getFurnished() +
                ", \'" + this.getCityQuadrant() + "\', " + this.getRent()+ ", \'" 
                +this.getStatus() +"\'"+ 
                ", \'" 
                +this.getAddress() +"\'"+ 
                ");";

        PreparedStatement myStmt = dbConnect.prepareStatement(query);
        int rowCount = myStmt.executeUpdate();  // execute the update tpo the database
        System.out.println("Rows affected: " + rowCount);
        
        myStmt.close();  // close the statement

    } catch (SQLException ex) {
        System.out.println("Could not add property");
        ex.printStackTrace();
        System.out.println(ex.getMessage());
    }

    return "\n This Property Added to database\n";
}
     

/**
 * updates the current status of the proerty
 * @return a string for debugging
 */
public String updateThisStatus(){
                
    try {                        
        String query = "UPDATE properties SET status =\'"+ getStatus()  +
       
         "\' WHERE (property_id =\'"+  getProperty_id()  + "\')";
        
        System.out.println("\n\n"+ query);
        
        PreparedStatement myStmt = dbConnect.prepareStatement(query);
        int rowCount = myStmt.executeUpdate();  // execute the update tpo the database
        System.out.println("Rows affected: " + rowCount);
        System.out.println("  status Updated  ");

        
        myStmt.close(); // close the thing
    } catch (SQLException ex) {
       
        System.out.println("Could not update property");
        ex.printStackTrace();
        System.out.println(ex.getMessage());
    }     
            
    return "\n status updated\n";
}//end fuctnion


/**
 * disaply all properties into a string that can be printed 
 * @return
 */
public String displayAllProperties(){

    StringBuffer propteryInfo = new StringBuffer();
    ResultSet results;   // result
   
    
    try {                        
        Statement myStmt = dbConnect.createStatement();
        results = myStmt.executeQuery("SELECT * FROM properties"); // do the command
        
        while (results.next()){
            propteryInfo.append("\n=============\n"); // creating one long string of alll the info 
            propteryInfo.append(
                "Property - "+  results.getString("property_id") + "\n "+ 
                "  LandLord ID - " + results.getString("landlord_id") + "\n " +
                "  Date Posted - " +results.getString("datePosted") + "\n " +   
                "  Type - " +results.getString("type") + "\n " +
                "  Number of Bedrooms - " + results.getString("bed") + "\n " +   
                "  Number of Bathrooms - " + results.getString("bath") + "\n " +
                "  Address - " + results.getString("address") + "\n "
                );
            String f = "No";
            if(results.getString("furnished").equals("1")){
                f= "Yes";
            }
                
            propteryInfo.append(
                "  Funished - "+ f + "\n " +   
                "  Location - " + results.getString("quadrant") + "\n " + 
                "  Rent - $" +results.getString("rent") + "\n "   
                    
                );
            propteryInfo.append("=============\n"); // creating one long string of alll the info 
                        
        }//end while
 
        myStmt.close(); // close the thing
    } catch (SQLException ex) {
        ex.printStackTrace();
    }

    // could use results to fill and array to return 

    return propteryInfo.toString(); // convert StringBuffer to string array containing the results getting all properties 

}// end fucntion 



/**
 * only gets properties that are posted and active
 * @return a string of those properties
 */
public String displayPostedActiveProperties(){

    StringBuffer propteryInfo = new StringBuffer();
    ResultSet results;   // result
    
    try {                        
        Statement myStmt = dbConnect.createStatement();
        results = myStmt.executeQuery("SELECT * FROM properties"); // do the command
        
        while (results.next()){
            if( results.getString("posted").equals("1") && results.getString("status").equals("active") ){
                propteryInfo.append("\n=============\n"); // creating one long string of alll the info 
                propteryInfo.append(
                    "Property - "+  results.getString("property_id") + "\n "+ 
                    "  LandLord ID - " + results.getString("landlord_id") + "\n " +
                    "  Date Posted - " +results.getString("datePosted") + "\n " +   
                    "  Type - " +results.getString("type") + "\n " +
                    "  Number of Bedrooms - " + results.getString("bed") + "\n " +   
                    "  Number of Bathrooms - " + results.getString("bath") + "\n " 
                    );
                String f = "No";
                if(results.getString("furnished").equals("1")){
                    f= "Yes";
                }
                    
                propteryInfo.append(
                    "  Funished - "+ f + "\n " +   
                    "  Location - " + results.getString("quadrant") + "\n " + 
                    "  Rent - $" +results.getString("rent") + "\n "   
                        
                    );
                propteryInfo.append("=============\n"); // creating one long string of alll the info 
                        
            }//end if
        }//end while
 
        myStmt.close(); // close the thing
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    // could use results to fill and array to return 

    return propteryInfo.toString(); // convert StringBuffer to string array containing the results getting all properties 

}// end fucntion 


/**
 * acess database 
 * @return an arraylsit with each index containing a string of info for each property 
 * also gets the landlord ID
 * need Dbconnect in class for this to work 
 */
public ArrayList<String> selectPostedActiveProperties() {

    StringBuffer propteryInfo = new StringBuffer();
    ResultSet results;   // result
    ArrayList<String> a = new ArrayList<>(); // to hold results 
    
    try {                        
        Statement myStmt = dbConnect.createStatement();
        results = myStmt.executeQuery("SELECT * FROM properties"); // do the command
        while (results.next()){
           
            StringBuffer b= new StringBuffer();
            
            if( results.getString("posted").equals("1") && results.getString("status").equals("active") ){
                b.append("\n=============\n"); // creating one long string of alll the info 
                b.append(
                    "Property - "+  results.getString("property_id") + "\n "+ 
                    "  LandLord ID - " + results.getString("landlord_id") + "\n " +
                    "  Date Posted - " +results.getString("datePosted") + "\n " +   
                    "  Type - " +results.getString("type") + "\n " +
                    "  Number of Bedrooms - " + results.getString("bed") + "\n " +   
                    "  Number of Bathrooms - " + results.getString("bath") + "\n " 
                    );
                    String f = "No";
                    if(results.getString("furnished").equals("1")){
                        f= "Yes";
                    }
                    
                    b.append(
                        "  Funished - "+ f + "\n " +   
                        "  Location - " + results.getString("quadrant") + "\n " + 
                        "  Rent - $" +results.getString("rent") + "\n "   
                        
                        );
                        b.append("=============\n"); // creating one long string of alll the info 
                         
                 a.add(b.toString());
            }
        }//end while

        myStmt.close(); // close the thing
    } catch (SQLException ex) {
        ex.printStackTrace();
    }

    // could use results to fill and array to return 
    // System.out.println( propteryInfo.toString()); // a stering result of the stuff

    return a; // convert StringBuffer to string array containing the results getting all properties 
    

}








/**
 * 
 * @param LID landlord ID
 * @param dbConnect the conenction
 * @return and arraylsit of all the porperties using a property Object
 * @throws ParseException
 */
public ArrayList<Property> fillPropertyArray(String LID, Connection dbConnect) throws ParseException{
    ArrayList <Property> arrayResults = new ArrayList<>();

    ResultSet results;   // result
   
    try {                        
        Statement myStmt = dbConnect.createStatement();
        results = myStmt.executeQuery("SELECT * FROM properties WHERE (landlord_id =\'"+  LID  + "\')");  // do the command
        
        ///need to get landlord info for daabase as well

        while (results.next()){
                //create a propety form info and add to array 
            Property p = new Property();
            DateCalculator d= new DateCalculator();
           
            // finish add stuff to a property to add to array
            p.setProperty_id(  Integer.parseInt( results.getString("property_id"))   );
            p.setPosted(Boolean.parseBoolean( results.getString("posted")));;
            p.setStatus(results.getString("status"));
        
            if(results.getString("datePosted") == null){
                p.setDatePosted(  null  );
                
            }else{
                try {
                    p.setDatePosted(  d.stringToDate(results.getString("datePosted"))  );
                } catch (Exception e) { 
                    e.printStackTrace();
                }
            }
            
            if(results.getString("postingExpiration") == null){
                p.setPostingExpirationDate(  null  );
                
            }else{
                try {
                    p.setPostingExpirationDate(  d.stringToDate(results.getString("postingExpiration"))  );
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            
            

            p.setPostingFee(  Double.parseDouble(results.getString("postingFee")) );

            // p.setLandlord(new Landlord(  Integer.parseInt( results.getString("property_id"))  ));

                // need to change later the getter methods for final landlord class

            p.setType(results.getString("type"));
            p.setNumberBedrooms(Integer.parseInt( results.getString("bed") ) );
            p.setNumberBathrooms(Integer.parseInt( results.getString("bath") ) );
            p.setCityQuadrant(results.getString("quadrant"));
            p.setFurnished(Boolean.parseBoolean( results.getString("furnished")));
            p.setRent(Double.parseDouble(results.getString("rent")));
            p.setAddress(results.getString("address"));

                arrayResults.add(p);


        }//end while
 
        myStmt.close(); // close the thing
    } catch (SQLException ex) {
        ex.printStackTrace();
    }


    return arrayResults;

}



/**
 * gets info all properties for output on GUI
 * @return a string with HTmnl properties of all property info
 */
public String displayHtmlProperties(){

    StringBuffer propteryInfo = new StringBuffer();
        ResultSet results;   // result
       
        try {                        
            Statement myStmt = dbConnect.createStatement();
            results = myStmt.executeQuery("SELECT * FROM properties ");  // do the command
            
            while (results.next()){

                   propteryInfo.append(
                       "Property - "+  results.getString("property_id") + "<br> "+ 
                       "&nbsp&nbsp  LandLord ID - " + results.getString("landlord_id") + "&nbsp" +
                       "&nbsp&nbsp|  Date Posted - " +results.getString("datePosted") + "&nbsp " +   
                       "&nbsp&nbsp|  Type - " +results.getString("type") + "&nbsp " +
                       "&nbsp&nbsp|  Number of Bedrooms - " + results.getString("bed") + "&nbsp " +   
                       "&nbsp&nbsp|  Number of Bathrooms - " + results.getString("bath") + "&nbsp " 
                       );
                    String f = "No";
                    if(results.getString("furnished").equals("1")){
                        f= "Yes";
                    }
                   
                    
                    propteryInfo.append(
                        "&nbsp&nbsp|  Funished - "+ f + "<br> " +   
                        "&nbsp&nbsp|  Location - " + results.getString("quadrant") + "&nbsp " + 
                        "&nbsp&nbsp|  Rent - $" +results.getString("rent") + "&nbsp "  +
                        "&nbsp&nbsp|  Address - " +results.getString("address") + "&nbsp " + 
                        "&nbsp&nbsp|  Status - " + results.getString("status") + "<br> " 
                        );
                            
                
                    
            }//end while
     
            myStmt.close(); // close the thing
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    
        // could use results to fill and array to return 
    
        return propteryInfo.toString(); // convert StringBuffer to string array containing the results getting all properties 

}// end fucntion 



/**
 * houses rented
 * @return string of how many houses have been rented
 */
public String getHousesRented(){
    
    ResultSet results;   // result
   int counter=0;
    try {                        
        Statement myStmt = dbConnect.createStatement();
        results = myStmt.executeQuery("SELECT * FROM properties Where status = 'rented' ");  // do the command
        
        while (results.next()){
    
               counter++;

        }//end while
 
        myStmt.close(); // close the thing
    } catch (SQLException ex) {
        ex.printStackTrace();
    }

    return Integer.toString(counter);
}


/**
 * gets the properties that have status rented
 * @return a string with all the active properties
 */
public String getActiveHouses(){
    ResultSet results;   // result
    int counter=0;
     try {                        
         Statement myStmt = dbConnect.createStatement();
         results = myStmt.executeQuery("SELECT * FROM properties Where status = 'active' ");  // do the command
         
         while (results.next()){
 
               
                counter++;
         
         }//end while
  
         myStmt.close(); // close the thing
     } catch (SQLException ex) {
         ex.printStackTrace();
     }
 
     return Integer.toString(counter);
}


}//end class






































////extra 

/*abstract





public ArrayList<String> selectAllProperties() {

    StringBuffer propteryInfo = new StringBuffer();
    ResultSet results;   // result
    ArrayList<String> a = new ArrayList<>(); // to hold results 
    
    try {                        
        Statement myStmt = dbConnect.createStatement();
        results = myStmt.executeQuery("SELECT * FROM properties"); // do the command
        while (results.next()){
            // System.out.println("Print results: " + results.getString("name") + ", " + results.getString("owner"));  
            // propteryInfo.append(results.getString("property_id") + ", " + results.getString("landlord_id") + ", " +
            //                     results.getString("posted") + ", " + results.getString("datePosted") + ", " +   
            //                     results.getString("postingExpiration") + ", " + results.getString("postingFee") + ",\n" +   
            //                     results.getString("type") + ", " + results.getString("bed") + ", " +   
            //                     results.getString("bath") + ", " + results.getString("furnished") + ", " +   
            //                     results.getString("quadrant") + ", " + results.getString("rent") + ", " +   
            //                     results.getString("status") + "\n"
            //                     );
            // propteryInfo.append('\n'); // creating one long string of alll the info 
            
            StringBuffer b= new StringBuffer();
            b.append(results.getString("property_id") + ", " + results.getString("landlord_id") + ", " +
            results.getString("posted") + ", " + results.getString("datePosted") + ", " +   
            results.getString("postingExpiration") + ", " + results.getString("postingFee") + ",\n" +   
            results.getString("type") + ", " + results.getString("bed") + ", " +   
            results.getString("bath") + ", " + results.getString("furnished") + ", " +   
            results.getString("quadrant") + ", " + results.getString("rent") + ", " +   
            results.getString("status") + "\n"
            );

             a.add(b.toString());
   
        }//end while

        
        myStmt.close(); // close the thing
    } catch (SQLException ex) {
        ex.printStackTrace();
    }



    // could use results to fill and array to return 
    System.out.println( propteryInfo.toString()); // a stering result of the stuff

    return a; // convert StringBuffer to string array containing the results getting all properties 
    

}



*/