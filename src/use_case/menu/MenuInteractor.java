package use_case.menu;

public class MenuInteractor implements MenuInputBoundary{
    final MenuOutputBoundary menuPresenter;

    public MenuInteractor(MenuOutputBoundary menuPresenter) {
        this.menuPresenter = menuPresenter;
    }

    @Override
    public void execute(MenuInputData menuInputData) {

    }
    @Override
    public void prepareMenuView() {

    }
}
