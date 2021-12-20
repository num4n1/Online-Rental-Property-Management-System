package renter;
import java.util.ArrayList;
import java.sql.*;
/**
 * requires a arraylsit of 5 elements
 * 
 * could have different better searches 
 */
public class KeyWordSearch implements SearchStratagy {


    /**
     * preforms the search amd returns an array lsit of Strings
     * that contain the appropriate properties
     */
    @Override
    public ArrayList<String> performSearch (Connection dbConnect, ArrayList<String> ctr) {
  
        String f = "0";
        if(ctr.get(3).equals("true")){
            f = "1";
        }

        String query = "SELECT property_id FROM properties Where "+ 
        "type = \'"+ ctr.get(0) +
        "\' and bed = \'"+ ctr.get(1) +
        "\' and bath = \'"+ ctr.get(2) +
        "\' and furnished = \'"+ f + // replace with f if this doens't work
        "\' and quadrant = \'"+ ctr.get(4) + "\'";
        

        ArrayList<String> a = new ArrayList<>();

        try{
        
            Statement myStmt = dbConnect.createStatement();
            ResultSet results = myStmt.executeQuery(query); // do the command
            while (results.next()){
          
             a.add(results.getString("property_id")); // add the property ids thatmatch to the a array 
            }//end while

        
            myStmt.close(); // close the thing
        } catch (SQLException ex) {
            ex.printStackTrace();
        
        }
            // a.add("end");
            // a.add("b");
            // a.add("c");


        return a;
    }
 





}
