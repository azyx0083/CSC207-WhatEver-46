package interface_adapter.search;

import interface_adapter.ViewManagerModel;
import interface_adapter.menu.MenuState;
import interface_adapter.menu.MenuViewModel;
import use_case.search.SearchOutputBoundary;
import use_case.search.SearchOutputData;

public class SearchPresenter implements SearchOutputBoundary {
    private final SearchViewModel searchViewModel;
    private final MenuViewModel menuViewModel;
    private final ViewManagerModel viewManagerModel;

    /**
     * Constructs a SearchPresenter.
     * @param searchViewModel the view model of search use case.
     * @param menuViewModel the view model of menu use case
     * @param viewManagerModel the model that manages all views.
     */
    public SearchPresenter(SearchViewModel searchViewModel, MenuViewModel menuViewModel, ViewManagerModel viewManagerModel) {
        this.searchViewModel = searchViewModel;
        this.menuViewModel = menuViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    /**
     * Prepares the view given that the search process succeeded.
     * @param data the output data of the search use case.
     */
    public void prepareSuccessView(SearchOutputData data) {
        // Once success, switch to the search view.
        SearchState searchState = searchViewModel.getState();
        searchState.setName(data.getName());
        searchState.setSymbol(data.getSymbol());
        searchViewModel.setState(searchState);
        searchViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(searchViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    /**
     * Prepares the view given that the search process failed.
     * @param error the error that causes the failure of the process.
     */
    public void prepareFailView(String error) {
        MenuState state = menuViewModel.getState();
        state.setStockError(error);
        menuViewModel.setState(state);
        menuViewModel.firePropertyChanged();
    }
}
