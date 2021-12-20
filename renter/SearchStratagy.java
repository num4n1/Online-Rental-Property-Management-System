package renter;





// import java.util.Calendar;
// import java.util.Date;
import java.util.ArrayList; // import the ArrayList class
import java.sql.*;


/**
 * interface for strategy pattern to work with renter and registered renter
 */
public interface SearchStratagy {

   //preform the search
   public ArrayList<String> performSearch(Connection dbConnect, ArrayList<String> a);

}
