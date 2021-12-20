package login;
// import user.*;


// import com.mysql.cj.protocol.MessageListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.SQLException;

// import static java.lang.System.exit;

public class LoginGUI extends JFrame implements ActionListener {
    private String username;
    private String password;
    private boolean errorShowing = false;

    private JPanel mainPanel;
    private JPanel body;
    private JPanel buttonPanel;

    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JLabel errorMessage;

    private JTextField usernameInput;
    private JPasswordField passwordInput;
    
    private JButton loginButton;
    private JButton noLoginButton;

    private boolean skip = false;


    public boolean getSkip(){
        return this.skip;
    }

    /**
     * Basic constructor
     */
    public LoginGUI(){
        super("Login");
        setSize(300, 300);
        setupGUI();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Main GUI setup
     */
    public void setupGUI(){
        mainPanel = new JPanel();
        body = new JPanel();
        buttonPanel = new JPanel();

        usernameLabel = new JLabel("username: ");
        passwordLabel = new JLabel("password: ");
        errorMessage = new JLabel();

        usernameInput = new JTextField(15);
        passwordInput = new JPasswordField(15);

        body.setLayout(new FlowLayout());
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        body.add(usernameLabel);
        body.add(usernameInput);
        body.add(passwordLabel);
        body.add(passwordInput);
        body.add(errorMessage);

        loginButton = new JButton("Login");
        loginButton.addActionListener(this);
        buttonPanel.add(loginButton);

        noLoginButton = new JButton("Skip Login");
        noLoginButton.addActionListener(this);
        buttonPanel.add(noLoginButton);

        mainPanel.add(body);
        mainPanel.add(buttonPanel);
        this.add(mainPanel, BorderLayout.CENTER);
    }

    /**
     * Shows error message when user inputs an invalid credential
     */
    public void displayIncorrectCred(){
        if(!errorShowing){
            errorMessage.setText("Incorrect Credentials! Try again!");
            this.validate();
            this.repaint();
            errorShowing =  true;
        }
    }

    /**
     * Removes credential error message
     */
    public void removeIncorrectCred(){
        if(errorShowing){
            errorMessage.setText("");
            this.validate();
            this.repaint();
            errorShowing =  false;
        }
    }

    /**
     * Waits for user input
     * Must use threads to use
     * @throws InterruptedException uses notify to get out of wait
     */
    public void waitForInput() throws InterruptedException {
        synchronized (this){
            wait();
        }
    }

    @Override
    /**
     * Waits for user to click the button
     * Notifies waitForInput() when button is clicked
     */
    public void actionPerformed(ActionEvent actionEvent) {
        Object o =actionEvent.getSource();
        
        synchronized (this){
            if(o == loginButton){
                System.out.println("heere");
                username = usernameInput.getText();
                password = new String(passwordInput.getPassword());
                notify();


            }else if(o == noLoginButton){
                System.out.println("don't login");
                skip = true;
                username = "notnullstring";
                password = "new String";
                // username = usernameInput.getText();
                // password = new String(passwordInput.getPassword());
                notify();
                
                // need to end 
                // setVisible(false);
            }
        }

    }

    /** username and password getters **/
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}