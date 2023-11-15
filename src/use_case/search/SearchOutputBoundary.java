package use_case.search;


public interface SearchOutputBoundary {
    void prepareSuccessView(SearchOutputData data);
    void prepareFailView(String error);
}
