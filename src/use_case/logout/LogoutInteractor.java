package use_case.logout;

public class LogoutInteractor implements LogoutInputBoundary{
    final LogoutOutputBoundary userPresenter;

    /**
     * Assigns the LogoutOutputBoundary to the interactor.
     * @param userPresenter the presenter that implements the OutputBoundary.
     */
    public LogoutInteractor(LogoutOutputBoundary userPresenter) {
        this.userPresenter = userPresenter;
    }

    /**
     * Prepare the success view for the logout use case since logout process won't fail.
     */
    @Override
    public void execute() {
        userPresenter.prepareSuccessView();
    }
}
