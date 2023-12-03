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

    public SearchPresenter(SearchViewModel searchViewModel, MenuViewModel menuViewModel, ViewManagerModel viewManagerModel) {
        this.searchViewModel = searchViewModel;
        this.menuViewModel = menuViewModel;
        this.viewManagerModel = viewManagerModel;
    }

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

    public void prepareFailView(String error) {
        MenuState state = menuViewModel.getState();
        state.setStockError(error);
        menuViewModel.setState(state);
        menuViewModel.firePropertyChanged();
    }
}
