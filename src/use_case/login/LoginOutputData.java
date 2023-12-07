package use_case.login;

public class LoginOutputData {

    private final String username;
    private boolean useCaseFailed;

    /**
     * initialize all the data required for presenter
     * @param username user's username
     * @param useCaseFailed False if the usecase success
     */
    public LoginOutputData(String username, boolean useCaseFailed) {
        this.username = username;
        this.useCaseFailed = useCaseFailed;
    }

    public String getUsername() {
        return username;
    }

}
