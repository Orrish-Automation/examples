package web.selenium;

import com.orrish.automation.entrypoint.SeleniumAppiumSteps;
import web.selenium.page.PageStore;

public class WebsiteSteps extends SeleniumAppiumSteps {

    WebsiteActions websiteActions = new WebsiteActions();

    public boolean launchBrowserAndNavigateTo(String url) {
        boolean value = websiteActions.executeOnWebAndReturnBoolean("launchBrowserAndNavigateTo", url);
        PageStore.initializePages();
        return value;
    }

    public boolean enterTextInSearchTextBox(String textToEnter) {
        return websiteActions.executeOnWebAndReturnBoolean("enterTextInSearchTextBox", textToEnter);
    }

    public boolean clickFirstSuggestionBox() {
        return websiteActions.executeOnWebAndReturnBoolean("clickFirstSuggestionBox");
    }

    public String getSearchResultHeader() {
        return websiteActions.executeOnWebAndReturnString("getSearchResultHeader");
    }

}
