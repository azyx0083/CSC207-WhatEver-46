package use_case.signup;

public class SignupOutputData {

    private final String username;

    private boolean useCaseFailed;

    /**
     * initialize all the data required for presenter
     * @param username user's username
     * @param useCaseFailed False if the usecase success
     */
    public SignupOutputData(String username, boolean useCaseFailed) {
        this.username = username;
        this.useCaseFailed = useCaseFailed;
    }

    public String getUsername() {
        return username;
    }

}