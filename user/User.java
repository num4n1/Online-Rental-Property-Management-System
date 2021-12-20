package user;
public class User {
    private String name;
    private String userID;
    private String username;
    private String password;
    private String accountType;

    public User(String userID, String name, String username, String password, String accountType) {
        this.userID = userID;
        this.name = name;
        this.username = username;
        this.password = password;
        this.accountType = accountType;
    }
    public User(){
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccountType() {
        return accountType;
    }

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }

    public String getUserID(){
        return userID;
    }
}

