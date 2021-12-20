package manager;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import landlord.Property;

public class DisplayReportList implements GenerateReport {
    

    /**
	 * method: this is function used to display the Report required by the manager
	 * @param dbConnect
	 */
    public String displayReport(Connection dbConnect){
        
        
        // calls to database to generate report stuff
        Property a = new Property();
        a.setConnection(dbConnect);

        String report = "<html>";

        report+= "<br> Active houses "+a.getActiveHouses() + "<br>" ;
        
        report+= "======================";

        report += "<br> Houses rented "+a.getHousesRented() + "<br>" ;

        report+= "======================<br>";
        report += a.displayHtmlProperties(); // get all properties 
        


    



        report += "</html>";
        return report;
        // return "<html>Report Stirng <br> more reprotstuff<br> even more report stuff</html>";
    }




}





