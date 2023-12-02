package use_case.logout;

public class LogoutInteractor implements LogoutInputBoundary{
    final LogoutOutputBoundary userPresenter;

    public LogoutInteractor(LogoutOutputBoundary userPresenter) {
        this.userPresenter = userPresenter;
    }

    @Override
    public void execute() {
        userPresenter.prepareSuccessView();
    }
}
