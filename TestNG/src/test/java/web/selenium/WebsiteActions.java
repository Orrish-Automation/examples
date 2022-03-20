package web.selenium;

import com.orrish.automation.appiumselenium.SeleniumAppiumActions;
import com.orrish.automation.entrypoint.SetUp;
import com.orrish.automation.utility.report.ReportUtility;
import com.orrish.automation.utility.report.UIStepReporter;
import web.selenium.page.PageStore;

import static com.orrish.automation.entrypoint.SetUp.isScreenshotAtEachStepEnabled;
import static com.orrish.automation.utility.GeneralUtility.getMethodStyleStepName;

public class WebsiteActions extends SeleniumAppiumActions {

    public Object executeOnWebAndReturnObject(Object... args) {
        try {
            switch (args[0].toString()) {
                case "enterTextInSearchTextBox":
                    return PageStore.landingPage.enterTextInSearchTextBox(this, args[1].toString());
                case "clickFirstSuggestionBox":
                    return PageStore.landingPage.clickFirstSuggestionBox(this);
                case "getSearchResultHeader":
                    return PageStore.searchResultPage.getSearchResultHeader(this);
                case "dummyStep":
                    isWebStepPassed = PageStore.landingPage.dummyStep(this);
                    break;
                default:
                    return super.executeOnWebAndReturnObject(args);
            }
        } catch (Exception ex) {
            isWebStepPassed = false;
            seleniumPageMethods.reportExecutionStatusWithScreenshotAndException(false, args, ex);
            return null;
        }
        if (isWebStepPassed && !isScreenshotAtEachStepEnabled)
            ReportUtility.reportPass(getMethodStyleStepName(args) + " performed successfully.");
        else {
            seleniumPageMethods.reportExecutionStatusWithScreenshotAndException(isWebStepPassed, args, null);
        }
        return isWebStepPassed;
    }
}
