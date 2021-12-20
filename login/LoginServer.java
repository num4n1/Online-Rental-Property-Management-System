package login;
import user.*;

import java.sql.*;

import java.util.ArrayList;

// import static java.lang.System.exit;

public class LoginServer {
    private static LoginServer instance = null;
    private ArrayList<User> users;
    private static Connection dbConnect;

    /**
     * Private constructor so user cannot make any new LoginServer instance
     */
    private LoginServer(){
        if(!initialize()){
            System.out.println("Error loading data from the database!");
        }
    }

    /**
     * Loads data from database. Called at the start and only used once
     * @return returns true if connection is successful, otherwise return false
     */
    private boolean initialize(){
        users = new ArrayList<User>();
        try{
            Statement statement = dbConnect.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM users");
            while(result.next()){
                users.add(new User(result.getString("user_id"),
                                result.getString("name"),
                                result.getString("username"),
                                result.getString("password"),
                                result.getString("accountType")
                        )
                );
            }
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    /**
     * For initializing a LoginServer object
     * @return the only one instance of LoginServer
     */
    public static LoginServer getInstance(Connection con){
        if(instance == null){
            dbConnect = con;
            instance = new LoginServer();
        }
        return instance;
    }

    //MUST UPDATE DB!!
    public void addUser(User newUser){
        if(!checkUser(newUser.getUsername(), newUser.getPassword())) {
            users.add(newUser);
        }
        else{
            System.out.println("Username is already being used!\nTry a different one");
            return;
        }
        String sql = "INSERT INTO users(name,username,password,accountType) "
                + "VALUES(?,?,?,?)";
        try {
            PreparedStatement pstmt = dbConnect.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            // set parameters for statement
            pstmt.setString(1, newUser.getName());
            pstmt.setString(2, newUser.getUsername());
            pstmt.setString(3, newUser.getPassword());
            pstmt.setString(4, newUser.getAccountType());

            int rowAffected = pstmt.executeUpdate();
            if(rowAffected == 1)
            {
                System.out.println("Successfully added new user!");
            }
            else{
                System.out.println("Failed to add a new user!");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }


    /**
     * Checks the account list and returns User object if a match is found
     * @param username username to check
     * @param password password to check
     * @return Returns User that matches the given username and password
     * otherwise return null
     */
    public User validateUser(String username, String password){
        for(var t : users){
            if(username.equals(t.getUsername()) && password.equals(t.getPassword())){
                return t;
            }
        }
        return null;
    }

    /**
     * Checks the account list and return true if match is found
     * @param username username to check
     * @param password password to check
     * @return Returns true if username and password has a match,
     * otherwise return false
     */
    public boolean checkUser(String username, String password){
        for(var t : users){
            if(username.equals(t.getUsername()) && password.equals(t.getPassword())){
                return true;
            }
        }
        return false;
    }
}
