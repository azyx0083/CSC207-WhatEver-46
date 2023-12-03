package use_case.search;

import entity.UserSetting;

public interface SearchAPIDataAccessInterface {
    String search(String symbol, UserSetting setting);

    String getName(String symbol);
}
