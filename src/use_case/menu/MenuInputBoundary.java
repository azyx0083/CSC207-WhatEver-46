package use_case.menu;

public interface MenuInputBoundary {
    void execute(MenuInputData menuInputData);

    void prepareMenuView();
}
