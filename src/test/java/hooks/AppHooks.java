package hooks;

import com.relevantcodes.extentreports.LogStatus;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import mantisutil.MantisReport;
import org.apache.commons.compress.utils.IOUtils;
import org.junit.Assume;
import runner.MyTestRunner;
import testlink.api.java.client.TestLinkAPIResults;
import utilities.*;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Base64;
import java.util.Collection;


public class AppHooks {

    String imagePath;
    String pathForLogger;
    String testCaseDescription;
    AppiumDriverLocalService service;
    public static boolean closeYoutubeVideo = true;
    public static boolean gmailTcs = false;

    public static String imagePath1;
    public static String concatt = ".";

    @Before("@Web")
    public void beforeMethodWeb(Scenario scenario) {
        if (scenario.getName().contains("_"))
            testCaseDescription = scenario.getName().split("_")[1].trim();
        else
            testCaseDescription = scenario.getName();

        MyTestRunner.logger = MyTestRunner.extent.startTest(testCaseDescription);
        try {
            Collection<String> tagsList = scenario.getSourceTagNames();
            if (tagsList.size() > 0) {
                for (String tag : tagsList
                ) {
                    MyTestRunner.logger.assignCategory(tag);
                }
            }
            if (scenario.getName().startsWith("ACAWEB001")) {
                closeYoutubeVideo = false;
            } else {
                closeYoutubeVideo = true;
            }
            if (scenario.getSourceTagNames().contains("@Gmail")) {
                gmailTcs = true;

            } else {
                gmailTcs = false;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        String browser = "";
        if (System.getProperty("browser") != null) {
            browser = System.getProperty("browser");
        } else {
            browser = GlobalUtil.getCommonSettings().getBrowser();
        }
        LogUtil.infoLog(getClass(),
                "\n+----------------------------------------------------------------------------------------------------------------------------+");
        LogUtil.infoLog(getClass(), "Test Started: " + scenario.getName());
        LogUtil.infoLog(getClass(),
                "Test is executed in Environment: " + GlobalUtil.getCommonSettings().getExecutionEnv());
        LogUtil.infoLog(getClass(), "Test is started with browser: " + browser);

        GlobalUtil.setDriver(DriverUtil.getBrowser("Window", browser));
        if (browser.equalsIgnoreCase("Firefox") && gmailTcs) {
            Assume.assumeTrue("Skipping scenario: " + scenario.getName(), false);

        }
    }

    @After("@Web")
    public void afterMethodWeb(Scenario scenario) {
        String testName;
        if (scenario.getName().contains("_"))
            testName = scenario.getName().split("_")[0].trim();
        else
            testName = scenario.getName();

        if (scenario.isFailed()) {
            try {
                String scFileName = "ScreenShot_" + System.currentTimeMillis();
                String screenshotFilePath = ConfigReader.getValue("screenshotPath") + "\\" + scFileName + ".png";
                imagePath = HTMLReportUtil.testFailTakeScreenshot(screenshotFilePath);

                InputStream is = new FileInputStream(imagePath);
                byte[] imageBytes = IOUtils.toByteArray(is);
                Thread.sleep(2000);
                String base64 = Base64.getEncoder().encodeToString(imageBytes);
                pathForLogger = MyTestRunner.logger.addBase64ScreenShot("data:image/png;base64," + base64);
                MyTestRunner.logger.log(LogStatus.FAIL,
                        HTMLReportUtil.failStringRedColor("Failed at point: " + pathForLogger) + GlobalUtil.e);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            LogUtil.infoLog(getClass(),
                    "Test has ended closing browser: " + GlobalUtil.getCommonSettings().getBrowser());
        }
        GlobalUtil.getDriver().close();
        // close the browsers
        MyTestRunner.extent.endTest(MyTestRunner.logger);
    }

    @Before("@Mobile")
    public void beforeMobileTestMethod(Scenario scenario) throws Exception {
        try {
            testCaseDescription = scenario.getName().split("_")[1];
        } catch (Exception e) {
            testCaseDescription = scenario.getName();
        }
        MyTestRunner.logger = MyTestRunner.extent.startTest(testCaseDescription);
        try {
            Collection<String> tagsList = scenario.getSourceTagNames();
            if (tagsList.size() > 0) {
                for (String tag : tagsList
                ) {
                    MyTestRunner.logger.assignCategory(tag);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        if (scenario.getName().startsWith("ACAWEB001")) {
            closeYoutubeVideo = false;
        } else {
            closeYoutubeVideo = true;
        }
        LogUtil.infoLog(getClass(),
                "\n+----------------------------------------------------------------------------------------------------------------------------+");
        LogUtil.infoLog(getClass(), "Mobile Tests Started: " + scenario.getName());

        LogUtil.infoLog("Mobile Test Environment",
                "Mobile Test is executed in OS: " + GlobalUtil.getCommonSettings().getAndroidName());
    }

    @After("@Mobile")
    public void afterMobileTestMethod(Scenario scenario) {
        String testName;
        try {
            testName = scenario.getName().split("_")[0].trim();
        } catch (Exception e) {
            e.printStackTrace();
            testName = scenario.getName();
        }
        if (scenario.isFailed()) {
            try {
                String scFileName = "ScreenShot_" + System.currentTimeMillis();
                String screenshotFilePath = ConfigReader.getValue("screenshotPath") + "\\" + scFileName + ".png";
                imagePath = HTMLReportUtil.testFailMobileTakeScreenshot(screenshotFilePath);
                InputStream is = new FileInputStream(imagePath);
                byte[] imageBytes = IOUtils.toByteArray(is);
                Thread.sleep(2000);
                String base64 = Base64.getEncoder().encodeToString(imageBytes);
                pathForLogger = MyTestRunner.logger.addBase64ScreenShot("data:image/png;base64," + base64);
                MyTestRunner.logger.log(LogStatus.FAIL,
                        HTMLReportUtil.failStringRedColor("Failed at point: " + pathForLogger) + GlobalUtil.e);
                byte[] screenshot = KeywordUtil.takeScreenshot(imagePath);
                scenario.embed(screenshot, "image/png");

                // report the bug
                String bugID = "Please check the Bug tool Configuration";
                if (GlobalUtil.getCommonSettings().getBugToolName().equalsIgnoreCase("Mantis")) {
                    bugID = MantisReport.reporIssue(scenario.getName(), GlobalUtil.errorMsg, "General",
                            "Automated on Android Device Version: " + GlobalUtil.getCommonSettings().getAndroidVersion()
                                    + " and Build Name: " + GlobalUtil.getCommonSettings().getBuildNumber(),
                            screenshotFilePath);
                }

                if (GlobalUtil.getCommonSettings().getBugToolName().equalsIgnoreCase("Jira")) {
                    bugID = GlobalUtil.jiraapi.reporIssue(scenario.getName(),
                            "Automated on Android Device Version: " + GlobalUtil.getCommonSettings().getAndroidVersion()
                                    + ",\n Build Name: " + GlobalUtil.getCommonSettings().getBuildNumber()
                                    + ". \n\n\n\n" + GlobalUtil.errorMsg,
                            screenshotFilePath);
                }

                // updating the results in Testmangement tool
                if (GlobalUtil.getCommonSettings().getManageToolName().equalsIgnoreCase("TestLink")) {
                    GlobalUtil.testlinkapi
                            .updateTestLinkResult(
                                    testName, "Please find the BUGID in "
                                            + GlobalUtil.getCommonSettings().getBugToolName() + " : " + bugID,
                                    TestLinkAPIResults.TEST_PASSED);
                }
                if (GlobalUtil.getCommonSettings().getManageToolName().equalsIgnoreCase("Jira")) {
                    GlobalUtil.jiraapi.updateJiraTestResults(testName, "Please find the BUGID in "
                            + GlobalUtil.getCommonSettings().getBugToolName() + " : " + bugID, "Fail");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {

            LogUtil.infoLog("TestEnded",
                    "Test has ended closing Application: " + GlobalUtil.getCommonSettings().getAndroidName());
            // updating the results in Testmangement tool
            if (GlobalUtil.getCommonSettings().getManageToolName().equalsIgnoreCase("TestLink")) {
                GlobalUtil.testlinkapi.updateTestLinkResult(testName, "This test is passed",
                        TestLinkAPIResults.TEST_PASSED);
            }
            if (GlobalUtil.getCommonSettings().getManageToolName().equalsIgnoreCase("Jira")) {
                GlobalUtil.jiraapi.updateJiraTestResults(testName, "This test is passed", "Pass");
            }
        }

        // close the browsers

        // We need to write the quit for local mobile device for time being we commented
        // for browser stack
        if (GlobalUtil.getDriver() != null)
            GlobalUtil.getDriver().quit();
        if (GlobalUtil.getMDriver() != null)
            GlobalUtil.getMDriver().quit();
        System.out.println(GlobalUtil.getDriver());
        System.out.println(GlobalUtil.getMDriver());
        MyTestRunner.extent.endTest(MyTestRunner.logger);
    }

}