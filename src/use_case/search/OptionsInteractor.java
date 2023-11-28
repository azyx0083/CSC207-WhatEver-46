package use_case.search;

public class OptionsInteractor implements OptionsInputBoundary {
    private final OptionsOutputBoundary searchPresenter;
    private final OptionsAPIDataAccessInterface searchAPIDataAccessObject;

    /**
     * constructor
     * @param searchPresenter SearchOutputBoundary that SearchPresenter implements
     * @param searchAPIDataAccessObject SearchAPIDataAccessInterface that APIDataAccess implements,
     *                                  let the interactor has access to DAO
     *
     */
    public OptionsInteractor(OptionsOutputBoundary searchPresenter,
                             OptionsAPIDataAccessInterface searchAPIDataAccessObject){
        this.searchPresenter = searchPresenter;
        this.searchAPIDataAccessObject = searchAPIDataAccessObject;
    }

    /**
     * actual execute method when call interface. If the stock symbol was invalid, prepare the fail view,
     * otherwise prepare success view.
     */
    @Override
    public void execute(OptionsInputData optionsInputData) {
        Object search = searchAPIDataAccessObject.search(optionsInputData.getSymbol());
        if (search != null){
            searchPresenter.prepareFailView((String)search);
        } else {
            OptionsOutputData optionsOutputData = new OptionsOutputData(
                    searchAPIDataAccessObject.getName(optionsInputData.getSymbol()), optionsInputData.getSymbol());
            searchPresenter.prepareSuccessView(optionsOutputData);
        }
    }
}
