package manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import user.User;


/**
 * Manager class 
 *holdsmmanger info mation for the manager cointroller to use
 */
public class Manager {
    
    private String report;
    private  GenerateReport reportGenerator;
    public int fees;
    public int periodOfFees;
    private Connection dbConnect;

    /**ctor
     * 
     */
    public Manager(GenerateReport reportGenerator, Connection dbConnect )
    {
        
        this.reportGenerator = reportGenerator;
        this.report = "";
        this.dbConnect = dbConnect;
    }


    /**
     * getters and setters
     * 
     */
    public void setSearchStratagy(GenerateReport reportGenerator){
        this.reportGenerator = reportGenerator;
        
    }//end setSortStrategy  same a s above 

    public String getReport(){

        return this.report;
        // reportGenerator.performSearch( dbConnect);
    }
    public void setReport(String report){

        this.report =report;
        // reportGenerator.performSearch( dbConnect);

    }


    /**
     * uses generate report interfce fucntion to create a report and stopre in report String
     * @return
     */
    public String generateRport(){
        return reportGenerator.displayReport(dbConnect);

    }
    

}
