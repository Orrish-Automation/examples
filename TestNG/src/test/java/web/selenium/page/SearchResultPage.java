package web.selenium.page;

import web.selenium.WebsiteActions;

public class SearchResultPage {

    //By class name
    String searchResultHeader = ".js-codesearch-count";

    public String getSearchResultHeader(WebsiteActions seleniumAppiumActions) {
        return seleniumAppiumActions.executeOnWebAndReturnString("getTextFromElement", searchResultHeader);
    }
}
