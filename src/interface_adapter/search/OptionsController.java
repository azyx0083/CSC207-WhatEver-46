package interface_adapter.search;

import use_case.search.OptionsInputBoundary;
import use_case.search.OptionsInputData;

public class OptionsController {
    final OptionsInputBoundary userSearchCaseInteractor;
    public OptionsController(OptionsInputBoundary userSearchCaseInteractor) {
        this.userSearchCaseInteractor = userSearchCaseInteractor;
    }

    public void execute(String symbol) {
        OptionsInputData optionsInputData = new OptionsInputData(symbol); // Assume that both are needed to search.
        userSearchCaseInteractor.execute(optionsInputData);
    }
}