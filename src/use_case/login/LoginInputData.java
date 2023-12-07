package use_case.login;

/**
 * The DataStructure that store the info of user who want to log in
 */
public class LoginInputData {

    final private String username;
    final private String password;

    /**
     * initialize a LoginInputData
     * @param username user's name that's may in the database
     * @param password user's password corresponding to the username
     */
    public LoginInputData(String username, String password) {
        this.username = username;
        this.password = password;
    }

    String getUsername() {
        return username;
    }

    String getPassword() {
        return password;
    }

}
