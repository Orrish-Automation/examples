package web.selenium.page;


import web.selenium.WebsiteActions;

public class LandingPage {
    //Locator by type
    String searchTextBoxLocator = "input";
    //Locator by id
    String searchSuggestionLocator = "#jump-to-suggestion-search-global";
    //Locator by class
    String sampleLocatorByClass = ".className";
    //Locator by xpath
    String sampleXpathLocator = "//div";
    //Locator by css
    String sampleCSSLocator = "input[id='hello']";

    public boolean enterTextInSearchTextBox(WebsiteActions seleniumAppiumActions, String textToEnter) {
        //The argument text is the standard method calls defined in the orrish-core project.
        return seleniumAppiumActions.executeOnWebAndReturnBoolean("enterInTextFieldFor", textToEnter, searchTextBoxLocator, "search box in homepage");
    }

    public boolean clickFirstSuggestionBox(WebsiteActions seleniumAppiumActions) {
        boolean clickValue = seleniumAppiumActions.executeOnWebAndReturnBoolean("clickFor", searchSuggestionLocator, "suggestion box");
        boolean waitValue = seleniumAppiumActions.executeOnWebAndReturnBoolean("waitUntilIsGoneFor", searchSuggestionLocator, "suggestion box");
        PageStore.searchResultPage = new SearchResultPage();
        return clickValue && waitValue;
    }

    public boolean dummyStep(WebsiteActions seleniumAppiumActions) {
        return false;
    }
}
