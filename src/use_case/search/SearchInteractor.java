package use_case.search;

import entity.User;
import entity.UserSetting;

public class SearchInteractor implements SearchInputBoundary {
    private final SearchOutputBoundary searchPresenter;
    private final SearchAPIDataAccessInterface searchAPIDataAccessObject;
    private final SearchFileUserDataAccessInterface searchFileUserDataAccessInterface;

    /**
     * constructor
     * @param searchPresenter SearchOutputBoundary that SearchPresenter implements
     * @param searchAPIDataAccessObject SearchAPIDataAccessInterface that APIDataAccess implements,
     *                                  let the interactor has access to DAO
     *
     */
    public SearchInteractor(SearchOutputBoundary searchPresenter,
                            SearchAPIDataAccessInterface searchAPIDataAccessObject,
                            SearchFileUserDataAccessInterface searchFileUserDataAccessInterface){
        this.searchPresenter = searchPresenter;
        this.searchAPIDataAccessObject = searchAPIDataAccessObject;
        this.searchFileUserDataAccessInterface = searchFileUserDataAccessInterface;
    }

    /**
     * actual execute method when call interface. If the stock symbol was invalid, prepare the fail view,
     * otherwise prepare success view.
     */
    @Override
    public void execute(SearchInputData searchInputData) {
        if (searchInputData.getUsername() != null){
            User user = searchFileUserDataAccessInterface.get(searchInputData.getUsername());
            UserSetting setting = new UserSetting(user.getInterval(), user.getOutputSize());
            String search = searchAPIDataAccessObject.search(searchInputData.getSymbol(), setting);
            if (search != null){
                searchPresenter.prepareFailView(search);
            } else {
                SearchOutputData searchOutputData = new SearchOutputData(
                        searchAPIDataAccessObject.getName(searchInputData.getSymbol()), searchInputData.getSymbol());
                searchPresenter.prepareSuccessView(searchOutputData);
            }
        } else {
            String search = searchAPIDataAccessObject.search(searchInputData.getSymbol());
            if (search != null){
                searchPresenter.prepareFailView(search);
            } else {
                SearchOutputData searchOutputData = new SearchOutputData(
                        searchAPIDataAccessObject.getName(searchInputData.getSymbol()), searchInputData.getSymbol());
                searchPresenter.prepareSuccessView(searchOutputData);
            }
        }
    }
}
