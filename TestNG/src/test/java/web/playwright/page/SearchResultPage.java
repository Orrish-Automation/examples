package web.playwright.page;

import web.playwright.WebsiteActions;

public class SearchResultPage {

    //By class name
    String searchResultHeader = ".js-codesearch-count";

    public String getSearchResultHeader(WebsiteActions playwrightActions) {
        return playwrightActions.executeOnWebAndReturnString("getTextFromElement", searchResultHeader);
    }
}
