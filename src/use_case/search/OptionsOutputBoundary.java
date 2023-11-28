package use_case.search;


public interface OptionsOutputBoundary {
    void prepareSuccessView(OptionsOutputData data);
    void prepareFailView(String error);
}
