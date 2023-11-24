package use_case.search;

public interface SearchAPIDataAccessInterface {
    String search(String symbol);

    String getName(String symbol);
}
