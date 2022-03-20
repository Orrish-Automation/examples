package web.playwright.tests;

import com.orrish.automation.entrypoint.*;
import org.testng.annotations.*;
import web.playwright.WebsiteSteps;

import java.io.File;

import static org.testng.Assert.assertTrue;

public class ExampleTest {

    @BeforeMethod
    public void setUp() {
        SetUp setUp = new SetUp();
        setUp.extentReportLocation(System.getProperty("user.dir") + File.separator + "extent.html");
        setUp.setSuiteName("Sample Suite");
        setUp.playwrightHeadless(false);
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
