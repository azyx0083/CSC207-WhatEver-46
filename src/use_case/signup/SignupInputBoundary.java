package use_case.signup;

public interface SignupInputBoundary {
    /**
     * Let the SignupInteractor execute the use case using the inputData
     * @param signupInputData contains the username and password that need to save or cause an error.
     */
    void execute(SignupInputData signupInputData);
}