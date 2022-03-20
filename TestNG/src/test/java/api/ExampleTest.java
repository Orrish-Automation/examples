package api;

import com.orrish.automation.entrypoint.*;
import org.testng.annotations.*;

import java.io.File;

import static org.testng.Assert.assertTrue;

public class ExampleTest {

    @BeforeSuite
    public void suiteSetUp() {
        SuiteSetUp suiteSetUp = new SuiteSetUp();
        //If you use report portal, update the details below and
        /*
        suiteSetUp.reportPortalUrl("");
        suiteSetUp.reportPortalProject("");
        suiteSetUp.reportPortalApiToken("");
        suiteSetUp.launchReportPortalWithName("")
         */
    }

    @AfterSuite
    public void suiteTearDown() {
        new SuiteTearDown();
    }

    @BeforeMethod
    public void setUp() {
        SetUp setUp = new SetUp();
        setUp.extentReportLocation(System.getProperty("user.dir") + File.separator + "extent.html");
        setUp.setSuiteName("Sample Suite");
    }

    @AfterMethod
    public void tearDown() {
        new TearDown();
    }

    @Test
    public void testAPI1() {
        APISteps apiSteps = new APISteps();
        ReportSteps.setTestName("API Test 1");
        assertTrue(apiSteps.callGETForEndpoint("https://jsonplaceholder.typicode.com/users/1"));
        assertTrue(apiSteps.getExistenceOfNodeInResponse("name"));
        String name = apiSteps.getFromResponse("name");
        assertTrue(new GeneralSteps().doesContain(name, "Leanne Graham"));
    }

    @Test
    public void testAPI2() {
        APISteps apiSteps = new APISteps();
        ReportSteps.setTestName("API Test 2");
        assertTrue(apiSteps.callGETForEndpoint("https://jsonplaceholder.typicode.com/users/1"));
        assertTrue(apiSteps.getExistenceOfNodeInResponse("name"));
        String name = apiSteps.getFromResponse("name");
        assertTrue(new GeneralSteps().doesContain(name, "Leanne Graham"));
    }

}
