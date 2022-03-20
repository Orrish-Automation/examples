package web.playwright;

import com.orrish.automation.entrypoint.SetUp;
import com.orrish.automation.playwright.PlaywrightActions;
import com.orrish.automation.utility.report.ReportUtility;
import com.orrish.automation.utility.report.UIStepReporter;
import web.playwright.page.PageStore;

import static com.orrish.automation.entrypoint.SetUp.isScreenshotAtEachStepEnabled;
import static com.orrish.automation.utility.GeneralUtility.getMethodStyleStepName;

public class WebsiteActions extends PlaywrightActions {

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
                    isPlaywrightStepPassed = PageStore.landingPage.dummyStep(this);
                    break;
                default:
                    return super.executeOnWebAndReturnObject(args);
            }
        } catch (Exception ex) {
            isPlaywrightStepPassed = false;
            UIStepReporter UIStepReporter = new UIStepReporter(++SetUp.stepCounter, args, ex);
            UIStepReporter.reportStepResultWithScreenshotAndException(ReportUtility.REPORT_STATUS.FAIL, null);
            return false;
        }
        if (isPlaywrightStepPassed && !isScreenshotAtEachStepEnabled)
            ReportUtility.reportPass(getMethodStyleStepName(args) + " performed successfully.");
        else {
            ReportUtility.REPORT_STATUS status = isPlaywrightStepPassed ? ReportUtility.REPORT_STATUS.PASS : ReportUtility.REPORT_STATUS.FAIL;
            UIStepReporter UIStepReporter = new UIStepReporter(++SetUp.stepCounter, args, null);
            UIStepReporter.reportStepResultWithScreenshotAndException(status, null);
        }
        return isPlaywrightStepPassed;
    }
}
