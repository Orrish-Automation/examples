package web.selenium.tests;

import com.orrish.automation.entrypoint.GeneralSteps;
import com.orrish.automation.entrypoint.SetUp;
import com.orrish.automation.entrypoint.TearDown;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import web.selenium.WebsiteSteps;

import java.io.File;

import static org.testng.Assert.assertTrue;

public class ExampleTest {

    @BeforeMethod
    public void setUp() {
        SetUp setUp = new SetUp();
        setUp.extentReportLocation(System.getProperty("user.dir") + File.separator + "extent.html");
        setUp.setSuiteName("Sample Suite");
        setUp.seleniumGridURL("http://server_ip:4444/wd/hub");
        setUp.browser("chrome");
    }

    @Test
    public void testWeb() {
        WebsiteSteps websiteSteps = new WebsiteSteps();
        assertTrue(websiteSteps.launchBrowserAndNavigateTo("http://github.com"));
        websiteSteps.takeWebScreenshotWithText("After launching page");
        assertTrue(websiteSteps.enterTextInSearchTextBox("Orrish core"));
        assertTrue(websiteSteps.clickFirstSuggestionBox());
        websiteSteps.takeWebScreenshotWithText("After searching result.");
        String value = websiteSteps.getSearchResultHeader();
        assertTrue(new GeneralSteps().doesContain(value, "1"));
    }

    @AfterMethod
    public void tearDown() {
        new TearDown();
    }

}
