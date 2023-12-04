package use_case.signup;

/**
 * The DataStructure that store the info of user who want to sign up
 */
public class SignupInputData {

    final private String username;
    final private String password;
    final private String repeatPassword;

    /**
     * initialize a SignupInputData
     * @param username user's name that user want to register
     * @param password user's password for this account
     * @param repeatPassword repeated password for ensure user's choice
     */
    public SignupInputData(String username, String password, String repeatPassword) {
        this.username = username;
        this.password = password;
        this.repeatPassword = repeatPassword;
    }

    String getUsername() {
        return username;
    }

    String getPassword() {
        return password;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }
}
