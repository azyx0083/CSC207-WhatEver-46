package interface_adapter.login;

/**
 * the DataStructure that stores actual data that LoginView need
 */
public class LoginState {
    private String username = "";
    private String usernameError = null;
    private String password = "";

    public LoginState(LoginState copy) {
        username = copy.username;
        usernameError = copy.usernameError;
        password = copy.password;
    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public LoginState() {}

    public String getUsername() {
        return username;
    }

    public String getUsernameError() {
        return usernameError;
    }

    public String getPassword() {
        return password;
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public void setUsernameError(String usernameError) {
        this.usernameError = usernameError;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
