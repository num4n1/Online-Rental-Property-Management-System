

import login.LoginController;
import manager.Manager;
import manager.ManagerController;
import manager.ManagerView;
import manager.*;

import java.sql.*;

import database.DataBaseConnector;
import landlord.Landlord;
import landlord.LandlordController;
import landlord.LandlordView;

import registeredRenter.RegisteredRenter;
import registeredRenter.RegisteredRenterController;
import registeredRenter.RegisteredRenterView;
import renter.KeyWordSearch;
import renter.Renter;
import renter.RenterController;
import renter.RenterView;
import user.*;


/**
 * main class to drive the program
 */
public class Runner{    
    public static void main(String[] args) throws InterruptedException {
       
        //default string values for password and databse and username to access database
        String database = "jdbc:mysql://localhost/480_database";
        String username = "kar2fastQ";
        String password = "Klesser!!";

        // if 3 command lines arguments set databsae
        if(args.length !=3){
            System.out.println("Need 3 command line arguments");
            System.out.println("\n Using default database name, username and password ");
            // System.exit(1);
        }else{
            database = args[0]; // set username password and database name
            username = args[1];
            password = args[2];
            
        }
        
        System.out.println("database = "+ database + "\nUsername = "+ username + "\nPassword = "+ password);
        // have database username and password 
        
        // create  database connection object with the apropriate
        DataBaseConnector a = new DataBaseConnector(database, username, password); // will set up a password here for acessing teh database right now its hard coded into the databse connect class
        Connection data= a.createConnection();
        System.out.println("database = "+ database + "\nUsername = "+ username + "\nPassword = "+ password);
        System.out.println("\n" + data.toString());
       //-----------------------------------------------------------------------------------------------------------------------
       //rest of program is GUI and action listeners 
        
       // data connection object is used by all the othe classes


        //set up the singleton 
        LoginController logCtr;
        
        logCtr = new LoginController(data); 
        logCtr.displayUI();

        User curUser = new User();

        String userType = "renter"; // default unless login in server changes itr
        try {
            curUser = logCtr.getUserAccount(); // create a user from the getUser accoutn  only returns when correct info has been pushed or skip login
            userType = curUser.getAccountType();
            System.out.println(curUser.getAccountType());
            logCtr.closeUI();

        } catch (InterruptedException e) {

            e.printStackTrace();
        }

        
        //select user section
        //if cetian type of renter open page for that account

        if(userType.equals("renter") ){  // regular renter not registered
            System.out.println("-----renter");

                            //pass i nthe strategy pattern keyword searach which could be updated in the future
            Renter r = new Renter(new KeyWordSearch() , data); // the model   
            RenterView rView = new RenterView();    //the view
            RenterController rController = new RenterController(rView, r);


        }else if(userType.equals("rrenter")){ // manager landlord or rrenter
            System.out.println(userType+ " this is the user tyope end program should be rrenter");
            // System.out.println("USer info " +curUser.getName());
            // System.out.println("USer info " +curUser.getUserID());
            // System.out.println("USer info " +curUser.getUsername());
            // System.out.println("USer info " +curUser.getPassword());


            // open rrenter stuff 
            RegisteredRenterView newView = new RegisteredRenterView(); // registeredrenter view
            RegisteredRenter newRegisteredRenter = new RegisteredRenter(curUser, new KeyWordSearch(), data);// registeredrenter view
            RegisteredRenterController newController = new RegisteredRenterController(newRegisteredRenter, newView); // pass both ton controller


        }
        else if(userType.equals("landlord")){ // manager landlord or rrenter
            System.out.println(userType+ " this is the user tyope end program  should be lanlord");
        
            Landlord landlordUser = new Landlord(curUser, data); // landlord out of current user
            
    
            //set up landlord GUI and backenbd
            LandlordView landView = new LandlordView(); // landlord view
            LandlordController landControl = new LandlordController(landlordUser, landView); // controller to handle alndlord GUI and backend
    
           


        }else if(userType.equals("manager")){ // manager landlord or rrenter
            System.out.println(userType+ " this is the user tyope end program  should be manager");
       
            

            // Report rep= new Report();
            Manager man = new Manager(new DisplayReportList(),  data); // manager with display Report strategy
            ManagerView mView = new ManagerView();  // manager View
            ManagerController mctr = new ManagerController(man, mView); // controller to handle GUi and backend for manager


        }





    }//end main 
}//end class


// other classes  


// public ArrayList<String> getIDandPostedDate(String LID, Connection dbConnect){

//     ArrayList <String> arrayResults = new ArrayList<>();

//     ResultSet results;   // result
   
//     try {                        
//         Statement myStmt = dbConnect.createStatement();
//         results = myStmt.executeQuery("SELECT * FROM properties WHERE (landlord_id =\'"+  LID  + "\')");  // do the command
        
//         while (results.next()){
//             arrayResults.add("Property ID "+ results.getString("property_id")+ 
//                             " || Landlord ID "+ results.getString("landlord_id") +
//                             " || Date Posted " + results.getString("datePosted") +
//                             " || Address " + results.getString("address")
//                             );
//         }//end while
 
//         myStmt.close(); // close the thing
//     } catch (SQLException ex) {
//         ex.printStackTrace();
//     }


//     return arrayResults;

// }




// public ArrayList<Property> fillPropertyArray(String LID, Connection dbConnect) throws ParseException{
//     ArrayList <Property> arrayResults = new ArrayList<>();

//     ResultSet results;   // result
   
//     try {                        
//         Statement myStmt = dbConnect.createStatement();
//         results = myStmt.executeQuery("SELECT * FROM properties WHERE (landlord_id =\'"+  LID  + "\')");  // do the command
        
//         ///need to get landlord info for daabase as well

//         while (results.next()){
//                 //create a propety form info and add to array 
//             Property p = new Property();
//             DateCalculator d= new DateCalculator();
           
//             // finish add stuff to a property to add to array
//             p.setProperty_id(  Integer.parseInt( results.getString("property_id"))   );
//             p.setPosted(Boolean.parseBoolean( results.getString("posted")));;
//             p.setStatus(results.getString("status"));
        
//             if(results.getString("datePosted") == null){
//                 p.setDatePosted(  null  );
                
//             }else{
//                 try {
//                     p.setDatePosted(  d.stringToDate(results.getString("datePosted"))  );
//                 } catch (Exception e) { 
//                     e.printStackTrace();
//                 }
//             }
            
//             if(results.getString("postingExpiration") == null){
//                 p.setPostingExpirationDate(  null  );
                
//             }else{
//                 try {
//                     p.setPostingExpirationDate(  d.stringToDate(results.getString("postingExpiration"))  );
//                 } catch (Exception e) {
//                     e.printStackTrace();
//                 }
//             }
            
            

//             p.setPostingFee(  Double.parseDouble(results.getString("postingFee")) );

//             // p.setLandlord(new Landlord(  Integer.parseInt( results.getString("property_id"))  ));

//                 // need to change later the getter methods for final landlord class

//             p.setType(results.getString("type"));
//             p.setNumberBedrooms(Integer.parseInt( results.getString("bed") ) );
//             p.setNumberBathrooms(Integer.parseInt( results.getString("bath") ) );
//             p.setCityQuadrant(results.getString("quadrant"));
//             p.setFurnished(Boolean.parseBoolean( results.getString("furnished")));
//             p.setRent(Double.parseDouble(results.getString("rent")));
//             p.setAddress(results.getString("address"));

//                 arrayResults.add(p);


//         }//end while
 
//         myStmt.close(); // close the thing
//     } catch (SQLException ex) {
//         ex.printStackTrace();
//     }


//     return arrayResults;

// }








/*abstract

 // // logCtr = new LoginController(data);
        // // logCtr.displayUI();

        // // login = logCtr.getMainClient();

        // // User newUser = new User("new", "mainuser", "password", "rrenter");
        // // login.addUser(newUser);


        // // try {
        // //     User curUser = logCtr.getUserAccount();

        // // } catch (InterruptedException e) {

        // //     e.printStackTrace();
        // // }

        // Renter r = new Renter(new KeyWordSearch() , data); // the model 
                    
        // RenterView rView = new RenterView();
        // RenterController rController = new RenterController(rView, r);


*/