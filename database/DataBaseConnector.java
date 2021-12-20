/*
PropertyDataBaseConnector.java
Author Chace Nielson
Date Thursday, December 2, 2021

DataBase accessing class specifically to update property inforamtion 


*/

package database;


import java.sql.*;
// import java.util.jar.Attributes.Name;

public class DataBaseConnector extends DateCalculator{
    private String databaseName;
    private String username;
    private String password;

    private Connection dbConnect;  //connection object
    private ResultSet results;      

    /**
     * default ctor
     */
    public DataBaseConnector() {
    }

    /**
     * ctor
     * @param databaseName
     * @param username
     * @param password
     */
    public DataBaseConnector(String databaseName, String username, String password) {
        this.databaseName = databaseName;
        this.username = username;
        this.password = password;

    }
    /**
     * getters and setters
     */
    public String getDatabaseName() {
        return this.databaseName;
    }
    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }
    public String getUsername() {
        return this.username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return this.password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String toString() {
        return "{" +
            " databaseName='" + getDatabaseName() + "'" +
            ", username='" + getUsername() + "'" +
            ", password='" + getPassword() + "'" +
            "}";
    }
  


    /**
     * creates a connection tothe databse based on class field inforamtion 
     * @return the connection object
     */
    public Connection createConnection(){
                
        try{
            // dbConnect = DriverManager.getConnection("jdbc:mysql://localhost/480_database", "kar2fastQ", "Klesser!!"); // surface root account
            dbConnect = DriverManager.getConnection(databaseName, username, password); // surface root account
         
            System.out.print("Corrent Information -------- Connection Created to database " +databaseName+ " \n");

        } catch (SQLException e) {
            System.out.println("database connection failed");
            
            e.printStackTrace();
            System.out.println("Exiting Program");
            System.exit(1);
        }


        return dbConnect;
    } //end fucntion 


    /**
     * closed the connection
     */
    public void close() {
        try {
            
            if(results != null){ // if no results made then 
                results.close();
            }

            dbConnect.close();
            System.out.println("\ndatabase  closed\n");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}//end class

