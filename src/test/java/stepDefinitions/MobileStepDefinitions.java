package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import modules.HomePage;
import utilities.DriverUtil;
import utilities.ExcelDataUtil;
import utilities.GlobalUtil;
import utilities.LayoutUtil;

import java.util.HashMap;


public class MobileStepDefinitions {

    @Given("^open the Chrome app on \"([^\"]*)\"$")
    public void open_the_Chrome_app(String testDataName) {
        HashMap<String, String> dataMap = new HashMap<String, String>();
        dataMap = ExcelDataUtil.getTestDataWithTestCaseID("MobileDetails", testDataName);
        String deviceDetails = dataMap.get("Device Details");

        if (GlobalUtil.getCommonSettings().getExecutionEnv().equalsIgnoreCase("Local"))
            DriverUtil.invokeLocalMobileApp(GlobalUtil.getCommonSettings().getExecutionEnv(), deviceDetails);

    }

    @Then("^verify the layout is not broken for the page for mobile browser$")
    public void verifyLayoutBrokenMobile() {
        LayoutUtil.checkLogUsingBrowserMobForMobileBrowser(GlobalUtil.getDriver().getCurrentUrl());
    }

    @Given("^launch the \"([^\"]*)\" website on chrome$")
    public void launchTheWebsiteOnChrome(String testDataName) {
        HomePage.launchWebsiteOnMobileChrome(testDataName);
    }

    @Given("^launch the \"([^\"]*)\" website on web$")
    public static void navigateToURL(String testDataName) {
        GlobalUtil.setDriver(DriverUtil.getBrowser("Window", "CHROME"));
        HomePage.launchURL(testDataName);
    }

    @And("^close the web driver$")
    public void closeTheWebDriver() {
        GlobalUtil.setDriverToNull();
    }

    @And("^close the mobile driver$")
    public void closeTheMobileDriver() {
        GlobalUtil.setMDriverToNull();
    }
}
