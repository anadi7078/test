package modules;

import com.relevantcodes.extentreports.LogStatus;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.CMSPageObject;
import runner.MyTestRunner;
import utilities.ExcelDataUtil;
import utilities.HTMLReportUtil;
import utilities.KeywordUtil;

import java.util.HashMap;
import java.util.List;

public class CMSPage extends KeywordUtil {
    public static HashMap<String, String> dataMap = new HashMap<String, String>();
    public static String courseName = "";

    /**
     * @Description: This method will navigate to the respective tab in CMS
     * @Parameter: String tab
     * @Created By: Diksha
     * @Date: July 13, 2023
     */
    public static void tabNavigation(String menu) {
        try {
            String mainMenu = menu.split(" > ")[0];
            String tab = menu.split(" > ")[1];
            clickwithoutlog(CMSPageObject.search(mainMenu));
            waitForVisible(CMSPageObject.searchBox);
            inputText(CMSPageObject.searchBox, tab, "searching " + tab + " in " + mainMenu);
            waitForVisible(CMSPageObject.spanText(tab));
            click(CMSPageObject.spanText(tab), "clicking on " + tab + " in side bar");
            waitForVisible(CMSPageObject.headerPage(tab));
            waitForVisible(CMSPageObject.publishedItems);
            waitTillPageIsCompletelyLoaded();
            takeScreenshotAndAttachInReport();

        } catch (Exception e) {
            catchAssertError(e);
        }

    }

    /**
     * @Description: This method will clone items based on count
     * @Parameter: int count
     * @Created By: Diksha
     * @Date: July 13, 2023
     */
    public static void cloneItems(String type, int count) {
        try {
            List<WebElement> publishedItems = getListElements(CMSPageObject.publishedItems, "getting list of published items on page");
            System.out.println("Published items present on start" + publishedItems.size());
            if (publishedItems.size() == 0) {
                MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("there is no published item present to clone"));
            } else {
                if (publishedItems.size() < count) {
                    while (publishedItems.size() < count) {
                        click(CMSPageObject.clonePublished, "clicking on clone button for a published item");
                        waitForVisible(CMSPageObject.button("Save"));
                        click(CMSPageObject.button("Save"), "clicking on save button");
                        waitForClickable(CMSPageObject.button("Publish"));
                        click(CMSPageObject.button("Publish"), "clicking on publish button");
                        takeScreenshotAndAttachInReport();
                        getDriver().navigate().back();
                        waitForInVisible(CMSPageObject.button("Save"));
                        waitForVisible(CMSPageObject.clonePublished);
                        getDriver().navigate().refresh();
                        waitForVisible(CMSPageObject.publishedItems);
                        publishedItems = getListElements(CMSPageObject.publishedItems, "getting list of published items on page");
                        System.out.println("Updated published items present" + publishedItems.size());
                    }
                    MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(count + " " + type + " are published on academy website"));

                } else {
                    MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("there is no need to clone " + type + " as already " + count + " " + type + " are published on academy website"));
                }
            }
            takeScreenshotAndAttachInReport();


        } catch (Exception e) {
            catchAssertError(e);
        }

    }

    /**
     * @Description: This method will change language in dropdown
     * @Parameter: String language
     * @Created By: Diksha
     * @Date: July 13, 2023
     */
    public static void changeLanguage(String language) {
        try {
            if (!isWebElementVisibleWithoutLog(CMSPageObject.languageSelected(language))) {
                clickWithoutLog(CMSPageObject.languageDropdown);
                waitForVisible(CMSPageObject.languageToSelect(language));
                click(CMSPageObject.languageToSelect(language), "changing language to " + language);
            }
            waitForVisible(CMSPageObject.languageSelected(language));
            Assert.assertTrue(isWebElementVisibleWithoutLog(CMSPageObject.languageSelected(language)));

        } catch (Exception e) {
            catchAssertError(e);
        }

    }

    /**
     * @Description: This method will login to CMS website
     * @Created By: Diksha
     * @Date: July 13, 2023
     */
    public static void login() {
        try {
            dataMap = ExcelDataUtil.getTestDataWithTestCaseID("LoginPage", "CMS");
            waitForVisible(CMSPageObject.email);
            inputText(CMSPageObject.email, dataMap.get("email"), "entering email as : " + dataMap.get("email"));
            inputText(CMSPageObject.password, dataMap.get("password"), "entering password");
            takeScreenshotAndAttachInReport();
            click(CMSPageObject.loginButton, "clicking on login button");
            waitForInVisible(CMSPageObject.email);
            waitForInVisible(CMSPageObject.loginButton);
            waitForVisible(CMSPageObject.hiSystem);
            waitForVisible(CMSPageObject.hiSystem);
            waitForVisible(CMSPageObject.hiSystem);
            waitTillPageIsCompletelyLoaded();
            takeScreenshotAndAttachInReport();
            MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("user is logged in successfully"));

        } catch (Exception e) {
            catchAssertError(e);
        }

    }

    /**
     * @Description: This method will select filter in settings
     * @Parameter: String text
     * @Created By: Diksha
     * @Date: July 13, 2023
     */
    public static void applyFilter(String text) {
        try {
            if (!isWebElementVisibleWithoutLog(CMSPageObject.typeFilter)) {
                clickwithoutlog(CMSPageObject.filter);
                waitForVisible(CMSPageObject.configureView);
                clickwithoutlog(CMSPageObject.typeInFilter);
            }
            waitForVisible(CMSPageObject.typeFilter);
            clickwithoutlog(CMSPageObject.filters);
            waitForVisible(CMSPageObject.filterOpen);
            Select dropdown = new Select(getDriver().findElement(CMSPageObject.dropdown));
            dropdown.selectByValue("type");
            Select dropdownValue = new Select(getDriver().findElement(CMSPageObject.dropdownType));
            dropdownValue.selectByValue(text);
            clickwithoutlog(CMSPageObject.applyFilter);

        } catch (Exception e) {
            catchAssertError(e);
        }

    }

    /**
     * @Description: This method will search in cms
     * @Parameter: String testDataName
     * @Created By: Diksha
     * @Date: July 14, 2023
     */
    public static void searchEntry(String testDataName) {
        try {
            dataMap = ExcelDataUtil.getTestDataWithTestCaseID("CMSSearch", testDataName);
            inputText(CMSPageObject.searchAnEntry, dataMap.get("Query"), "searching data : " + dataMap.get("Query"));
            waitForVisible(CMSPageObject.spanText(dataMap.get("Query")));
            takeScreenshotAndAttachInReport();

        } catch (Exception e) {
            catchAssertError(e);
        }

    }

    /**
     * @Description: This method will delete an entry in cms
     * @Created By: Diksha
     * @Date: July 14, 2023
     */
    public static void deleteEntry() {
        try {
            if (isWebElementVisibleWithoutLog(CMSPageObject.deleteEntry)) {
                waitForVisible(CMSPageObject.deleteEntry);
                clickwithoutlog(CMSPageObject.deleteEntry);
                waitForVisible(CMSPageObject.spanText("Yes, confirm"));
                takeScreenshotAndAttachInReport();
                clickwithoutlog(CMSPageObject.spanText("Yes, confirm"));
                waitForVisible(CMSPageObject.noEntryFound);
                takeScreenshotAndAttachInReport();
                MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.infoStringGreenColor("entry is deleted successfully"));
            } else {
                MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.infoStringGreenColor("there is no entry present and therefore, there delete is not required"));
            }

        } catch (Exception e) {
            catchAssertError(e);
        }

    }

    /**
     * @Description: This method will clone a course that will have very few seats
     * @Created By: Diksha
     * @Date: July 14, 2023
     */
    public static void cloneCourseHavingFewSeats() {

        try {
            Actions actions = new Actions(getDriver());
            click(CMSPageObject.clonePublishedCourse, "clicking on clone button for a published course");
            waitForVisible(CMSPageObject.button("Save"));
            courseName = "" + System.currentTimeMillis();
            inputText(CMSPageObject.courseName, courseName.replace(" ", ""), "entering course name : " + courseName);
            takeScreenshotAndAttachInReport();
            scrollingToElementofAPage(CMSPageObject.spanText("Banner Image"), "");
            clickwithoutlog(CMSPageObject.startDate);
            actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
            actions.sendKeys(Keys.BACK_SPACE).perform();
            Thread.sleep(1000);
            clickwithoutlog(CMSPageObject.startDate);
            waitForVisible(CMSPageObject.calendarNextMonth);
            clickwithoutlog(CMSPageObject.calendarNextMonth);
            clickwithoutlog(CMSPageObject.calendarSelectDateStart);
            clickwithoutlog(CMSPageObject.endDate);
            actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
            actions.sendKeys(Keys.BACK_SPACE).perform();
            Thread.sleep(1000);
            clickwithoutlog(CMSPageObject.endDate);
            waitForVisible(CMSPageObject.calendarNextMonth);
            clickwithoutlog(CMSPageObject.calendarNextMonth);
            clickwithoutlog(CMSPageObject.calendarSelectDateEnd);
            clickwithoutlog(CMSPageObject.seatsInCourse);
            actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
            actions.sendKeys(Keys.BACK_SPACE).perform();
            getDriver().findElement(CMSPageObject.seatsInCourse).clear();
            inputText(CMSPageObject.seatsInCourse, "1", "setting seats to 1");
            getDriver().findElement(CMSPageObject.price).clear();
            getDriver().findElement(CMSPageObject.price).sendKeys("1000");
            takeScreenshotAndAttachInReport();
            click(CMSPageObject.button("Save"), "clicking on save button");
            waitForClickable(CMSPageObject.button("Publish"));
            clickJS(CMSPageObject.button("Publish"), "clicking on publish button");
            waitForVisible(CMSPageObject.editingPublishedVersion);
            takeScreenshotAndAttachInReport();

        } catch (Exception e) {
            catchAssertError(e);
        }
    }

    public static void searchCourse() {
        inputText(CMSPageObject.searchAnEntry, courseName, "searching data : " + courseName);
        pressEnter();
        waitTillPageIsCompletelyLoaded();
        waitForVisible(CMSPageObject.oneEntry);
        waitForVisible(CMSPageObject.spanText(courseName));
        waitForVisible(CMSPageObject.deleteEntry);
        Assert.assertTrue(isWebElementVisibleWithoutLog(CMSPageObject.spanText(courseName)));
        waitForVisible(CMSPageObject.deleteEntry);
        Assert.assertTrue(isWebElementVisibleWithoutLog(CMSPageObject.deleteEntry));
        clickwithoutlog(CMSPageObject.deleteEntry);
        waitForVisible(CMSPageObject.spanText("Yes, confirm"));
        takeScreenshotAndAttachInReport();
        clickwithoutlog(CMSPageObject.spanText("Yes, confirm"));
        waitForVisible(CMSPageObject.noEntryFound);
        takeScreenshotAndAttachInReport();
        MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.infoStringGreenColor("course is deleted successfully"));
        takeScreenshotAndAttachInReport();
    }

    /**
     * @Description: This method will logout from application
     * @Created By: Diksha
     * @Date: July 25, 2023
     */
    public static void logout() {
        try {

            clickJS(CMSPageObject.systemAdmin, "");
            waitForVisible(CMSPageObject.logout);
            takeScreenshotAndAttachInReport();
            click(CMSPageObject.logout, "clicking on logout");
            waitForVisible(CMSPageObject.email);
            Assert.assertTrue(isWebElementVisible(CMSPageObject.email, "user is logged out successfully"));
            takeScreenshotAndAttachInReport();

        } catch (Exception e) {
            catchAssertError(e);
        }

    }

    /**
     * @Description: This method will select filter in settings
     * @Parameter: String text
     * @Created By: Diksha
     * @Date: July 13, 2023
     */
    public static void applyFilterForUser(String testDataName) {
        try {
            dataMap = ExcelDataUtil.getTestDataWithTestCaseID("CMSSearch", testDataName);
            clickwithoutlog(CMSPageObject.filters);
            waitForVisible(CMSPageObject.filterOpen);
            Select dropdown = new Select(getDriver().findElement(CMSPageObject.dropdown));
            dropdown.selectByValue("user");
            waitForVisible(CMSPageObject.valueEmail);
            getDriver().findElement(CMSPageObject.valueEmail).sendKeys(dataMap.get("Query"));
            clickwithoutlog(CMSPageObject.applyFilter);
            waitForInVisible(CMSPageObject.applyFilter);

        } catch (Exception e) {
            catchAssertError(e);
        }

    }
}
