package use_case.menu;

public interface MenuOutputBoundary {
    void prepareSuccessView(); //stock symbol is valid

    void prepareFailView(); //stock symbol is invalid
}
