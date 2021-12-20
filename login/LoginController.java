//SAMPLE USE OF THE CONTROLLER
/**
    Connection testConnect = null;
    try{
        testConnect = DriverManager.getConnection("jdbc:mysql://localhost:3306/480_database","root","()MYpr0j3cts");
    } catch (SQLException throwables) {
        throwables.printStackTrace();
        exit(-1);
    }
    LoginController login = new LoginController(testConnect);
    login.displayUI();
    User curUser = login.getUserAccount();
    System.out.println(curUser.getUsername());
 **/

package login;
import user.*;

import java.sql.Connection;

public class LoginController {
    private User currentUser;
    private LoginServer mainClient;
    private LoginGUI loginUI;

    /**
     * Basic constructor
     * @param dbConnect connection to the database
     */
    public LoginController(Connection dbConnect){
        mainClient = LoginServer.getInstance(dbConnect);
        loginUI = new LoginGUI();
    }

    /**
     * Starts the UI
     */
    public void displayUI(){
        loginUI.setVisible(true);
    }

    /**
     * Hides the UI
     */
    public void hideUI(){
        loginUI.setVisible(false);
        
    }

    /**
     * Terminates the UI
     */
    public void closeUI(){
        loginUI.dispose();
    }

    /**
     * Main method that allows the controller to output a User object based on user input
     *
     * This method would keep running until a proper User object has been retrieved
     * @return User object generated from user inputs
     * @throws InterruptedException calls in a method that uses threads
     */
    public User getUserAccount() throws InterruptedException {
        while(!validInput()){
            System.out.println(loginUI.getSkip());
            if(loginUI.getSkip()){
                return new User("0","new", "mainuser", "password", "renter");
            }
    
        }
        loginUI.removeIncorrectCred();
        return currentUser;
    }

    /**
     * Helper method that checks user input from the gui and checks if the credentials
     * are in the database
     *
     * @return true if user inputs correct credentials,
     * false otherwise
     *
     * @throws InterruptedException uses threads to wait for input
     */
    private boolean validInput() throws InterruptedException {
        Thread t1 = new Thread(new Runnable(){
            public void run(){
                try{
                    loginUI.waitForInput();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t1.join();

        currentUser = mainClient.validateUser(loginUI.getUsername(), loginUI.getPassword());
        if(currentUser != null){
            return true;
        }
        loginUI.displayIncorrectCred();
        return false;
    }

    /** GETTERS AND SETTERS FOR ALL MEMBERS **/
    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public LoginServer getMainClient() {
        return mainClient;
    }

    public LoginGUI getLoginUI() {
        return loginUI;
    }

    public void setLoginUI(LoginGUI loginUI) {
        this.loginUI = loginUI;
    }
}
