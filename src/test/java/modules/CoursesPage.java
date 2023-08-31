package modules;

import com.relevantcodes.extentreports.LogStatus;
import mobileutil.MobileKeywords;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.CartPageObject;
import pages.CoursesPageObject;
import pages.NewsAndEventsPageObject;
import runner.MyTestRunner;
import utilities.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import static modules.CMSPage.courseName;

public class CoursesPage extends KeywordUtil {
    public static HashMap<String, String> dataMap = new HashMap<String, String>();

    /**
     * @Description: This method will click on more details button
     * @Created By: Diksha
     * @Date: July 06, 2023
     */
    public static void moreDetailsButton() {
        try {
            Random random = new Random();
            List<WebElement> moreDetailsBtn = getListElements(CoursesPageObject.moreDetailsButton, "getting list of more details");
            int randomNumber = random.nextInt(moreDetailsBtn.size() - 1) + 1;
            if (randomNumber > 1)
                scrollingToElementofAPage(CoursesPageObject.courses(randomNumber - 1), "");
            else
                scrollingToElementofAPage(CoursesPageObject.firstMonth, "");
            String courseName = getElementText(CoursesPageObject.coursesName(randomNumber));
            takeScreenshotAndAttachInReport();
            clickJS(CoursesPageObject.moreDetailsButton(randomNumber), "clicking on more details button for " + courseName);
            waitForVisible(CoursesPageObject.title);
            Assert.assertEquals(getElementText(CoursesPageObject.title), courseName);
            MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(courseName + " details page is opened"));
            takeScreenshotAndAttachInReport();

        } catch (Exception e) {
            catchAssertError(e);
        }

    }

    /**
     * @Description: This method will verify components for the  courses page
     * @Parameter: String verificationParameter
     * @Created By: Diksha
     * @Date: July 06, 2023
     */
    public static void verificationOfComponents(String verificationParamter) {
        try {
            switch (verificationParamter) {
                case "three filtering criteria":
                    Assert.assertTrue("course name filter not available", isWebElementVisible(CoursesPageObject.filterByCourseName, "filter by course name is visible"));
                    Assert.assertTrue("course category filter not available", isWebElementVisible(CoursesPageObject.filterByCourseCategory, "filter by course category is visible"));
                    Assert.assertTrue("course month filter not available", isWebElementVisible(CoursesPageObject.filterByMonth, "filter by course month is visible"));
                    if (mdriver == null) {
                        scrollingToElementofAPage(CoursesPageObject.filterByCourseCategory, "");
                        takeScreenshotAndAttachInReport();
                    }
                    break;
                case "header image":
                    if (mdriver == null) {
                        waitForVisible(CoursesPageObject.headerImage);
                        Assert.assertTrue("header image is not visible", isWebElementVisible(CoursesPageObject.headerImage, "header image is visible"));
                    } else {
                        waitForVisible(CoursesPageObject.headerImageMobile);
                        Assert.assertTrue("header image is not visible", isWebElementVisible(CoursesPageObject.headerImageMobile, "header image is visible"));
                    }
                    break;
                case "title":
                    waitForVisible(CoursesPageObject.titlePage);
                    Assert.assertTrue("title is not visible", isWebElementVisible(CoursesPageObject.titlePage, "title is visible"));
                    break;
                case "searching section":
                    Assert.assertTrue("searching section not available", isWebElementVisible(CoursesPageObject.searchingSection, "searching section is visible"));
                    break;
                case "courses list":
                    List<WebElement> courses = getListElements(CoursesPageObject.courses, "getting list of courses");
                    Assert.assertTrue("courses not visible", courses.size() > 0);
                    MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(courses.size() + " courses are visible"));
                    break;
                case "courses details":
                    scrollingToElementofAPage(CoursesPageObject.firstMonth, "");
                    List<WebElement> coursesList = getListElements(CoursesPageObject.courses, "getting list of courses");
                    List<WebElement> coursesCategory = getListElements(CoursesPageObject.coursesCategory, "getting list of courses Category");
                    Assert.assertTrue("category is not there", coursesList.size() == coursesCategory.size());
                    MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("category is showing for all the courses"));
                    List<WebElement> coursesTrainer = getListElements(CoursesPageObject.coursesTrainer, "getting list of courses trainer");
                    Assert.assertTrue("trainer is not there", coursesList.size() == coursesTrainer.size());
                    MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("trainer is showing for all the courses"));
                    List<WebElement> coursesImage = getListElements(CoursesPageObject.courseImage, "getting list of upcoming courses dates");
                    Assert.assertTrue("image is not there", coursesList.size() == coursesImage.size());
                    MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("image is showing for all the courses"));
                    if (mdriver == null) {
                        List<WebElement> coursesLocation = getListElements(CoursesPageObject.coursesLocation, "getting list of courses Location");
                        Assert.assertTrue("courses Location is not there", coursesList.size() == coursesLocation.size());
                        MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("location is showing for all the courses"));
                        List<WebElement> coursesDuration = getListElements(CoursesPageObject.coursesDuration, "getting list of courses duration");
                        Assert.assertTrue("courses duration is not there", coursesList.size() == coursesDuration.size());
                        MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("duration is showing for all the courses"));
                        List<WebElement> coursesHoursPerDay = getListElements(CoursesPageObject.coursesHoursPerDay, "getting list of courses HoursPerDay");
                        Assert.assertTrue("courses HoursPerDay is not there", coursesList.size() == coursesHoursPerDay.size());
                        MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("hours per day is showing for all the courses"));
                        List<WebElement> coursesDescription = getListElements(CoursesPageObject.coursesDescription, "getting list of courses description");
                        Assert.assertTrue("courses description is not there", coursesList.size() == coursesDescription.size());
                        MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("description is showing for all the courses"));
                    }
                    List<WebElement> coursesDays = getListElements(CoursesPageObject.coursesDays, "getting list of courses days");
                    Assert.assertTrue("courses days is not there", coursesList.size() == coursesDays.size());
                    MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("days or coming soon is showing for all the courses"));
                    List<WebElement> coursesPrice = getListElements(CoursesPageObject.coursesPrice, "getting list of courses price");
                    Assert.assertTrue("courses price is not there", coursesList.size() == coursesPrice.size());
                    MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("price is showing for all the courses"));
                    List<WebElement> coursesMoreDetailsBtn = getListElements(CoursesPageObject.moreDetailsButton, "getting list of courses more Details Button");
                    Assert.assertTrue("courses more Details Button is not there", coursesList.size() == coursesMoreDetailsBtn.size());
                    MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("more details button is showing for all the courses"));
                    takeScreenshotAndAttachInReport();
                    break;
                case "opened course details":
                    Thread.sleep(5000);
                    takeScreenshotAndAttachInReport();
                    Assert.assertTrue("course Details is not there", isWebElementVisible(CoursesPageObject.courseDetails, "course details are visible"));
                    Assert.assertTrue("course title is not there", isWebElementVisible(CoursesPageObject.title, "course title " + getElementText(CoursesPageObject.title) + " is visible"));
                    List<WebElement> sharingIcons = getListElements(CoursesPageObject.sharingIcons, "getting list of sharing icons");
                    Assert.assertTrue("sharing icons are not there", sharingIcons.size() > 0);
                    MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("sharing icons are there"));
                    scrollingToElementofAPage(CoursesPageObject.trainerCourse, "");
                    takeScreenshotAndAttachInReport();
                    Assert.assertTrue("course description is not there", isWebElementVisible(CoursesPageObject.courseDesc, "course description is visible"));
                    Assert.assertTrue("course location is not there", isWebElementVisible(CoursesPageObject.detailsInCourse("location"), getElementText(CoursesPageObject.detailsInCourse("location")) + " is visible"));
                    Assert.assertTrue("course hours per day is not there", isWebElementVisible(CoursesPageObject.detailsInCourse("clock"), getElementText(CoursesPageObject.detailsInCourse("clock")) + " is visible"));
                    Assert.assertTrue("course duration is not there", isWebElementVisible(CoursesPageObject.detailsInCourse("calender"), getElementText(CoursesPageObject.detailsInCourse("calender")) + " is visible"));
                    Assert.assertTrue("course days is not there", isWebElementVisible(CoursesPageObject.detailsInCourse("date"), getElementText(CoursesPageObject.detailsInCourse("date")) + " is visible"));
                    scrollingToElementofAPage(CoursesPageObject.courseMedia, "");
                    takeScreenshotAndAttachInReport();
                    Assert.assertTrue("course main media is not there", isWebElementVisible(CoursesPageObject.courseMedia, "course media is visible"));
                    if (isWebElementVisibleWithoutLog(CoursesPageObject.videoMainMedia)) {
                        Assert.assertTrue("main media video is not autoplaying", isWebElementVisible(CoursesPageObject.videoMainMediaAutoPlay, "video media is visible and is auto playing"));
                    }
                    Assert.assertTrue("course trainer is not there", isWebElementVisible(CoursesPageObject.trainerCourse, "course trainer " + getElementText(CoursesPageObject.trainerCourse) + " is visible"));
                    Assert.assertTrue("course price is not there", isWebElementVisible(CoursesPageObject.coursePrice, "course price " + getElementText(CoursesPageObject.coursePrice) + " is visible"));
                    Assert.assertTrue("register now button is not there", isWebElementVisible(CoursesPageObject.registerNowButton, "register now button is visible"));
                    break;
                case "related courses":
                    Assert.assertTrue("related courses is not there", isWebElementVisibleWithoutLog(CoursesPageObject.relatedCourses));
                    List<WebElement> relatedCourses = getListElements(CoursesPageObject.relatedCoursesList, "getting list of related courses");
                    Assert.assertTrue("related courses is not there", relatedCourses.size() > 0);
                    MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(relatedCourses.size() + " related courses are showing"));
                    scrollingToElementofAPage(CoursesPageObject.relatedCourses, "");
                    takeScreenshotAndAttachInReport();
                    break;
                case "all courses button":
                    Assert.assertTrue("all courses button is not visible", isWebElementVisible(CoursesPageObject.allCoursesButton, "all courses button is visible"));
                    if (mdriver != null) {
                        scrollingToElementofAPage(CoursesPageObject.allCoursesButton, "");
                        takeScreenshotAndAttachInReport();
                    }
                    break;
                case "more details button":
                    Assert.assertTrue("more details button is not visible", isWebElementVisible(CoursesPageObject.moreDetailsButton, "more details button is visible"));
                    break;
                case "related courses details":
                    scrollingToElementofAPage(CoursesPageObject.relatedCourses, "");
                    takeScreenshotAndAttachInReport();
                    List<WebElement> relatedCoursesList = getListElements(CoursesPageObject.relatedCoursesList, "getting list of related courses");
                    Assert.assertTrue("related courses is not there", relatedCoursesList.size() > 0);
                    List<WebElement> relatedCoursesCategory = getListElements(CoursesPageObject.coursesCategory, "getting list of related courses category");
                    Assert.assertTrue("related courses is not there", relatedCoursesList.size() == relatedCoursesCategory.size());
                    MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("category is showing for all the related courses"));
                    List<WebElement> relatedCoursesImage = getListElements(CoursesPageObject.courseImage, "getting list of related courses image");
                    Assert.assertTrue("related courses image is not there", relatedCoursesList.size() == relatedCoursesImage.size());
                    MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("image is showing for all the related courses"));
                    List<WebElement> relatedCoursesDays = getListElements(CoursesPageObject.coursesDays, "getting list of related courses days");
                    Assert.assertTrue("related courses days is not there", relatedCoursesList.size() == relatedCoursesDays.size());
                    MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("days is showing for all the related courses"));
                    List<WebElement> relatedcoursesTrainer = getListElements(CoursesPageObject.coursesTrainer, "getting list of related courses trainer");
                    Assert.assertTrue("trainer is not there", relatedCoursesList.size() == relatedcoursesTrainer.size());
                    MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("trainer is showing for all the related courses"));
                    List<WebElement> relatedcoursesLocation = getListElements(CoursesPageObject.coursesLocation, "getting list of related courses Location");
                    Assert.assertTrue("related courses Location is not there", relatedCoursesList.size() == relatedcoursesLocation.size());
                    MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("location is showing for all the related courses"));
                    List<WebElement> relatedcoursesDuration = getListElements(CoursesPageObject.coursesDuration, "getting list of related courses duration");
                    Assert.assertTrue("related courses duration is not there", relatedCoursesList.size() == relatedcoursesDuration.size());
                    MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("duration is showing for all the related courses"));
                    List<WebElement> relatedcoursesHoursPerDay = getListElements(CoursesPageObject.coursesHoursPerDay, "getting list of related courses HoursPerDay");
                    Assert.assertTrue("related courses HoursPerDay is not there", relatedCoursesList.size() == relatedcoursesHoursPerDay.size());
                    MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("hours per day is showing for all the related courses"));
                    List<WebElement> relatedcoursesPrice = getListElements(CoursesPageObject.coursesPrice, "getting list of related courses price");
                    Assert.assertTrue("related courses price is not there", relatedCoursesList.size() == relatedcoursesPrice.size());
                    MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("price is showing for all the courses"));
                    List<WebElement> relatedcoursesDescription = getListElements(CoursesPageObject.coursesDescription, "getting list of related courses description");
                    Assert.assertTrue("related courses description is not there", relatedCoursesList.size() == relatedcoursesDescription.size());
                    MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("description is showing for all the related courses"));
                    List<WebElement> relatedcoursesMoreDetailsBtn = getListElements(CoursesPageObject.moreDetailsButton, "getting list of related courses more Details Button");
                    Assert.assertTrue("related courses more Details Button is not there", relatedCoursesList.size() == relatedcoursesMoreDetailsBtn.size());
                    MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("more details button is showing for all the related courses"));
                    break;
                case "register now button":
                    if (isWebElementVisibleWithoutLog(CoursesPageObject.courseMedia))
                        scrollingToElementofAPage(CoursesPageObject.courseMedia, "");
                    takeScreenshotAndAttachInReport();
                    Assert.assertTrue("register now button is not there", isWebElementVisible(CoursesPageObject.registerNowButton, "register now button is visible in course details page"));
                    click(CoursesPageObject.registerNowButton, "clicking on register now button in course detail page");
                    Assert.assertTrue(waitForURLContains("login", "user is redirected to login page"));
                    takeScreenshotAndAttachInReport();
                    getDriver().navigate().back();
                    break;
                case "upcoming courses button":
                    scrollingToElementofAPage(CoursesPageObject.footerCoursesBtn, "upcoming courses button is visible in footer");
                    takeScreenshotAndAttachInReport();
                    break;

            }
        } catch (Exception e) {
            catchAssertError(e);
        }

    }

    /**
     * @Description: This method will click on more details button
     * @Created By: Diksha
     * @Date: July 07, 2023
     */
    public static void ClickMoreDetailsButton() {
        try {
            click(CoursesPageObject.moreDetailsButton1, "clicking on more details button");
            waitForVisible(CoursesPageObject.registerNowButton);

        } catch (Exception e) {
            catchAssertError(e);
        }
    }

    /**
     * @Description: This method will click on more details button for the last course
     * @Created By: Mehak
     * @Date: July 24, 2023
     */
    public static void clickMoreDetailsButton() {
        try {
            scrollingToElementofAPage(CoursesPageObject.moreDetailButton, "");
            click(CoursesPageObject.moreDetailButton, "clicking on more details button");
            waitForVisible(CoursesPageObject.registerNowButton);
            takeScreenshotAndAttachInReport();

        } catch (Exception e) {
            catchAssertError(e);
        }
    }

    /**
     * @Description: This method will click on the social icons displayed
     * @Parameter: String Social Icon Name
     * @Created By: Diksha
     * @Date: July 07, 2023
     */
    public static void ClickSocialIcons(String socialIconName) {
        try {
            String contentToVerify = "";
            ArrayList<String> windows = new ArrayList<>();
            if (getCurrentUrl().contains("courses"))
                contentToVerify = getElementText(CoursesPageObject.title);
            if (getCurrentUrl().contains("news")) {
                if (mdriver != null && getCurrentUrl().contains("/ar/news")) {
                    contentToVerify = getCurrentUrl();
                } else {
                    contentToVerify = getElementText(NewsAndEventsPageObject.headerTitleAfterNews);
                }
            }
            switch (socialIconName) {
                case "facebook":
                    takeScreenshotAndAttachInReport();
                    click(CoursesPageObject.socialIcons("facebook"), "clicking on " + socialIconName);
                    waitUntilExpectedWindowsToBe(2);
                    switchToWindow();
                    getDriver().manage().window().maximize();
                    waitForURLContains("facebook", "user is redirected to " + socialIconName + " page");
                    waitForVisible(CoursesPageObject.fbUserName);
                    dataMap = ExcelDataUtil.getTestDataWithTestCaseID("SocialMediaCreds", "Facebook");
                    getDriver().findElement(CoursesPageObject.fbUserName).sendKeys(dataMap.get("Username"));
                    getDriver().findElement(CoursesPageObject.fbPassword).sendKeys(dataMap.get("Password"));
                    waitForClickable(CoursesPageObject.fbLogin);
                    clickwithoutlog(CoursesPageObject.fbLogin);
                    waitForInVisible(CoursesPageObject.fbLogin);
                    waitForVisible(CoursesPageObject.fbShareScreen);
                    waitForVisible(CoursesPageObject.fbShareContent(contentToVerify));
                    Assert.assertTrue(isWebElementVisible(CoursesPageObject.fbShareContent(contentToVerify), contentToVerify + " is being shared on facebook"));
                    takeScreenshotAndAttachInReport();
                    clickWithoutLog(CoursesPageObject.fbShareScreen);
                    closeChildWindow();
                    switchToParentWindow();
                    break;
                case "facebook mobile":
                    if (getCurrentUrl().contains("/ar/news")) {
                        contentToVerify = "devacademy.sna.tv";
                    }
                    click(CoursesPageObject.socialIcons("facebook"), "clicking on facebook");
//                    String link = "window.open('https://www.facebook.com/login','_blank');";
//                    ((JavascriptExecutor) getDriver()).executeScript(link);
                    waitUntilExpectedWindowsToBe(2);
//                    waitForURLContains("facebook", "user is redirected to " + socialIconName + " page");
                    waitTillPageIsCompletelyLoaded();
//                    Thread.sleep(10000);
                    windows = new ArrayList<String>(GlobalUtil.getDriver().getWindowHandles());
                    getDriver().switchTo().window(windows.get(1));
                    mdriver.context("NATIVE_APP");
                    dataMap = ExcelDataUtil.getTestDataWithTestCaseID("SocialMediaCreds", "Facebook");
                    MobileKeywords.explicitWaitForElement(CoursesPageObject.fbUserNameMobile, CoursesPageObject.xpath);
                    mdriver.findElement(By.xpath(CoursesPageObject.fbUserNameMobile)).sendKeys(dataMap.get("Username"));
                    mdriver.findElement(By.xpath(CoursesPageObject.fbPassMobile)).sendKeys(dataMap.get("Password"));
                    MobileKeywords.scrollAndClick("Log In");
//                    Thread.sleep(5000);
//                    MobileKeywords.switchToWebBrowserContext();
//                    getDriver().switchTo().window(windows.get(0));
//                    click(CoursesPageObject.socialIcons("facebook"), "clicking on " + socialIconName);
//                    waitUntilExpectedWindowsToBe(3);
//                    windows = new ArrayList<String>(GlobalUtil.getDriver().getWindowHandles());
//                    getDriver().switchTo().window(windows.get(2));
//                    waitForURLContains("facebook", "user is redirected to " + socialIconName + " page");
//                    mdriver.context("NATIVE_APP");
                    if (isMobileElementVisible(CoursesPageObject.fbEmailOrNameXpath, "extra")) {
                        MobileKeywords.click(CoursesPageObject.fbEmailOrName, CoursesPageObject.xpath, "clicking on search by name or email instead");
                        MobileKeywords.setValue(CoursesPageObject.fbEmail, CoursesPageObject.xpath, dataMap.get("Username"), "entering username");
                        MobileKeywords.click(CoursesPageObject.submit, CoursesPageObject.xpath, "clicking on submit");
                        if (isMobileElementVisible(CoursesPageObject.tryAnotherWayXpath, "try another way")) {
                            MobileKeywords.click(CoursesPageObject.tryAnotherWay, CoursesPageObject.xpath, "clicking on try another way button");
                        }
                        MobileKeywords.click(CoursesPageObject.enterPassword, CoursesPageObject.xpath, "clicking on enter password to login radio button");
                        MobileKeywords.click(CoursesPageObject.continueButton, CoursesPageObject.xpath, "clicking on continue button");
                        MobileKeywords.explicitWaitForElement(CoursesPageObject.passwordEnter, CoursesPageObject.xpath);
                        MobileKeywords.setValue(CoursesPageObject.passwordEnter, CoursesPageObject.xpath, dataMap.get("Password"), "entering pw");
                        MobileKeywords.click(CoursesPageObject.login, CoursesPageObject.xpath, "clicking on login button");

                    }
                    MobileKeywords.explicitWaitForElement(CoursesPageObject.fbShareContentMobile(contentToVerify), CoursesPageObject.xpath);
                    Assert.assertTrue(MobileKeywords.isWebElementVisible(CoursesPageObject.fbShareContentMobile(contentToVerify), CoursesPageObject.xpath));
                    MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("correct content is being shared"));
                    takeScreenshotAndAttachInReport();
                    MobileKeywords.scrollAndClick("Post");
                    MobileKeywords.switchToWebBrowserContext();
                    closeChildWindow();
//                    getDriver().switchTo().window(windows.get(1));
//                    closeChildWindow();
                    switchToParentWindow();
                    break;
                case "twitter":
                    String courseURL = getCurrentUrl();
                    click(CoursesPageObject.socialIcons("twitter"), "clicking on twitter");
                    waitUntilExpectedWindowsToBe(2);
                    windows = new ArrayList<String>(GlobalUtil.getDriver().getWindowHandles());
                    System.out.println(windows);
                    getDriver().switchTo().window(windows.get(1));
                    waitForURLContains("twitter", "user is redirected to twitter page");
                    waitForVisible(CoursesPageObject.twitterUserName);
                    dataMap = ExcelDataUtil.getTestDataWithTestCaseID("SocialMediaCreds", "Twitter");
                    getDriver().findElement(CoursesPageObject.twitterUserName).sendKeys(dataMap.get("Username"));
                    clickwithoutlog(CoursesPageObject.twitterNextButton);
                    waitForVisible(CoursesPageObject.twitterPassword);
                    getDriver().findElement(CoursesPageObject.twitterPassword).sendKeys(dataMap.get("Password"));
                    waitForClickable(CoursesPageObject.twitterLogin);
                    clickwithoutlog(CoursesPageObject.twitterLogin);
                    waitForInVisible(CoursesPageObject.twitterLogin);
                    waitForVisible(CoursesPageObject.twitterLoggedIn);
//                    getDriver().switchTo().window(windows.get(0));
//                    clickwithoutlog(CoursesPageObject.socialIcons("twitter"));
//                    waitUntilExpectedWindowsToBe(3);
//                    windows = new ArrayList<String>(GlobalUtil.getDriver().getWindowHandles());
//                    System.out.println(windows);
//                    getDriver().switchTo().window(windows.get(2));
                    getDriver().manage().window().maximize();
                    waitForVisible(CoursesPageObject.tweetButton);
                    Assert.assertTrue(getElementText(CoursesPageObject.tweetURL), courseURL.contains(getElementText(CoursesPageObject.tweetURL)));
                    MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(contentToVerify + " is being shared"));
                    takeScreenshotAndAttachInReport();
//                    clickwithoutlog(CoursesPageObject.tweetButton);
                    closeChildWindow();
//                    getDriver().switchTo().window(windows.get(1));
//                    closeChildWindow();
                    switchToParentWindow();
                    break;
                case "twitter mobile":
                    click(CoursesPageObject.socialIcons("twitter"), "clicking on twitter");
                    waitUntilExpectedWindowsToBe(2);
                    windows = new ArrayList<String>(GlobalUtil.getDriver().getWindowHandles());
                    getDriver().switchTo().window(windows.get(1));
                    waitForURLContains("twitter", "user is redirected to twitter page");
                    waitForVisible(CoursesPageObject.twitterUserName);
                    dataMap = ExcelDataUtil.getTestDataWithTestCaseID("SocialMediaCreds", "Twitter");
                    getDriver().findElement(CoursesPageObject.twitterUserName).sendKeys(dataMap.get("Username"));
                    clickwithoutlog(CoursesPageObject.twitterNextButton);
                    waitForVisible(CoursesPageObject.twitterPassword);
                    getDriver().findElement(CoursesPageObject.twitterPassword).sendKeys(dataMap.get("Password"));
                    waitForClickable(CoursesPageObject.twitterLogin);
                    clickwithoutlog(CoursesPageObject.twitterLogin);
                    waitForInVisible(CoursesPageObject.twitterLogin);
                    waitForVisible(CoursesPageObject.twitterLoggedIn);
//                    getDriver().switchTo().window(windows.get(0));
//                    clickwithoutlog(CoursesPageObject.socialIcons("twitter"));
//                    waitUntilExpectedWindowsToBe(3);
//                    windows = new ArrayList<String>(GlobalUtil.getDriver().getWindowHandles());
//                    getDriver().switchTo().window(windows.get(2));
                    waitForVisible(CoursesPageObject.tweetButton);
                    mdriver.context("NATIVE_APP");
                    Assert.assertTrue(MobileKeywords.isWebElementVisible(CoursesPageObject.twitterMobile(contentToVerify), CoursesPageObject.xpath));
                    MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("correct content is being shared"));
                    MobileKeywords.switchToWebBrowserContext();
                    takeScreenshotAndAttachInReport();
//                    clickwithoutlog(CoursesPageObject.tweetButton);
                    closeChildWindow();
//                    getDriver().switchTo().window(windows.get(1));
//                    closeChildWindow();
                    switchToParentWindow();
                    break;
                case "whatsapp":
                    click(CoursesPageObject.socialIcons("whatsapp"), "clicking on " + socialIconName);
                    waitUntilExpectedWindowsToBe(2);
                    switchToWindow();
                    waitForURLContains("whatsapp", "user is redirected to " + socialIconName + " page");
                    if (mdriver == null) {
                        waitForVisible(CoursesPageObject.whatsappWebText);
                    }
                    takeScreenshotAndAttachInReport();
                    closeChildWindow();
                    switchToParentWindow();
                    break;
                case "linkedin":
                    click(CoursesPageObject.socialIcons("linkedin"), "clicking on " + socialIconName);
                    waitUntilExpectedWindowsToBe(2);
                    switchToWindow();
                    waitForURLContains("linkedin", "user is redirected to " + socialIconName + " page");
                    getDriver().manage().window().maximize();
                    waitForVisible(CoursesPageObject.linkedinUserName);
                    dataMap = ExcelDataUtil.getTestDataWithTestCaseID("SocialMediaCreds", "Linkedin");
                    getDriver().findElement(CoursesPageObject.linkedinUserName).sendKeys(dataMap.get("Username"));
                    getDriver().findElement(CoursesPageObject.linkedinPassword).sendKeys(dataMap.get("Password"));
                    waitForClickable(CoursesPageObject.linkedinLogin);
                    clickwithoutlog(CoursesPageObject.linkedinLogin);
                    waitForInVisible(CoursesPageObject.linkedinLogin);
                    waitTillPageIsCompletelyLoaded();
                    waitForVisible(CoursesPageObject.linkedinShareScreen);
                    waitForVisible(CoursesPageObject.linkedInImage);
                    Thread.sleep(5000);
                    takeScreenshotAndAttachInReport();
                    MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(contentToVerify + " is being shared"));
                    clickWithoutLog(CoursesPageObject.linkedinShareScreen);
                    closeChildWindow();
                    switchToParentWindow();
                    break;
                case "linkedin mobile":
                    contentToVerify = getCurrentUrl();
                    click(CoursesPageObject.socialIcons("linkedin"), "clicking on linkedin");
                    waitUntilExpectedWindowsToBe(2);
                    switchToWindow();
                    waitForURLContains("linkedin", "user is redirected to linkedin page");
                    waitForVisible(CoursesPageObject.linkedinUserName);
                    dataMap = ExcelDataUtil.getTestDataWithTestCaseID("SocialMediaCreds", "Linkedin");
                    getDriver().findElement(CoursesPageObject.linkedinUserName).sendKeys(dataMap.get("Username"));
                    getDriver().findElement(CoursesPageObject.linkedinPassword).sendKeys(dataMap.get("Password"));
                    waitForClickable(CoursesPageObject.linkedinLogin);
                    clickwithoutlog(CoursesPageObject.linkedinLogin);
                    waitForInVisible(CoursesPageObject.linkedinLogin);
                    waitTillPageIsCompletelyLoaded();
                    waitForVisible(CoursesPageObject.postMobileLinkedin);
                    mdriver.context("NATIVE_APP");
                    Assert.assertTrue(MobileKeywords.isWebElementVisible(CoursesPageObject.linkedInMobile(contentToVerify), CoursesPageObject.xpath));
                    MobileKeywords.switchToWebBrowserContext();
                    takeScreenshotAndAttachInReport();
                    MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("correct content is being shared"));
                    clickWithoutLog(CoursesPageObject.postMobileLinkedin);
                    closeChildWindow();
                    switchToParentWindow();
                    break;
                case "native share web":
                    if (getbrowserName().contains("Chrome")) {
                        if (!getbrowserName().contains("Headless")) {
                            click(CoursesPageObject.nativeShare, "clicking on native share");
                            Sikuli.verifyThatSharePopupIsVisible();
                        }
                    }
                    break;
                case "native share mobile":
                    if (!getCurrentUrl().contains("/news/")) {
                        takeScreenshotAndAttachInReport();
                    }
                    click(CoursesPageObject.nativeShare, "clicking on native share");
                    mdriver.context("NATIVE_APP");
                    Assert.assertTrue("native popup not showing", MobileKeywords.isWebElementVisible(CoursesPageObject.nativeShareMobile, CoursesPageObject.type_id));
                    MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("native share popup is visible"));
                    takeScreenshotAndAttachInReport();
                    MobileKeywords.switchToWebBrowserContext();
                    break;
            }


        } catch (Exception e) {
            catchAssertError(e);
        }
    }

    /**
     * @Description: This method will search courses
     * @Parameter: String data
     * @Created By: Diksha
     * @Date: July 07, 2023
     */
    public static void searchCourses(String category) {
        try {
            String row = "";
            if (category.contains("course name")) {
                row = category;
                category = "course name";
            }
            List<WebElement> coursesListBefore = getListElements(CoursesPageObject.courses, "getting list of courses");
            MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("number of courses displayed before " + category + " filter is " + coursesListBefore.size()));
            Random random = new Random();
            if (mdriver != null) {
                scrollingToElementofAPage(CoursesPageObject.searchBoxContainer, "");
            }
            switch (category) {
                case "course name":
                    dataMap = ExcelDataUtil.getTestDataWithTestCaseID("Courses", row);
                    String matched = dataMap.get("Matched");
                    String unmatched = dataMap.get("Unmatched");
                    inputText(CoursesPageObject.searchBox, matched, "entering data : " + matched);
                    if (mdriver != null) {
                        mdriver.hideKeyboard();
                    }
                    List<WebElement> coursesList = getListElements(CoursesPageObject.courses, "getting list of courses");
                    List<WebElement> coursesCategory = getListElements(CoursesPageObject.coursesCategory(matched), "getting list of courses with entered category");
                    Assert.assertTrue("category is not filtered", coursesList.size() == coursesCategory.size());
                    List<WebElement> coursesListAfter = getListElements(CoursesPageObject.courses, "getting list of courses");
                    MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("number of courses displayed after matched course name filter is " + coursesListAfter.size()));
                    MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("results are filtered according to course name " + matched));
                    takeScreenshotAndAttachInReport();
                    inputText(CoursesPageObject.searchBox, unmatched, "entering data : " + unmatched);
                    if (mdriver != null) {
                        mdriver.hideKeyboard();
                    }
                    MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("number of courses displayed after unmatched course name filter is 0"));
                    Assert.assertTrue("no search results found text is not visible", isWebElementVisible(CoursesPageObject.noSearchResults, "no search results are found"));
                    takeScreenshotAndAttachInReport();
                    getDriver().navigate().refresh();
                    break;
                case "course category":
                    List<WebElement> courseCategory = getListElements(CoursesPageObject.courseCategory, "getting list of courses list in search");
                    int randomNumber = random.nextInt(courseCategory.size()) + 1;
                    String categoryToBeUnSelected = getElementText(CoursesPageObject.courseCategory(randomNumber));
                    click(CoursesPageObject.courseCategory(randomNumber), "unselecting category : " + categoryToBeUnSelected);
                    List<WebElement> courseDisplayed = getListElements(CoursesPageObject.coursesCategory, "getting list of courses displayed after applying filter");
                    for (int i = 1; i < courseDisplayed.size(); i++) {
                        Assert.assertFalse(getElementText(CoursesPageObject.coursesName(i)).equalsIgnoreCase(categoryToBeUnSelected));
                    }

                    MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("no course with category as " + categoryToBeUnSelected + " is displayed"));
                    List<WebElement> coursesListAfter1 = getListElements(CoursesPageObject.courses, "getting list of courses");
                    MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("number of courses displayed after unselecting course category filter is " + coursesListAfter1.size()));

                    takeScreenshotAndAttachInReport();
                    break;

                case "course month":
                    Select dropdown = new Select(getDriver().findElement(CoursesPageObject.monthFilter));
                    int randomNumber1 = random.nextInt(dropdown.getOptions().size() - 1) + 1;
                    String value = dropdown.getOptions().get(randomNumber1).getText();
                    dropdown.selectByIndex(randomNumber1);
                    takeScreenshotAndAttachInReport();
                    MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("selecting month as " + value));
                    if (isWebElementVisibleWithoutLog(CoursesPageObject.noSearchResults)) {
                        MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("number of courses displayed after month filter is 0 as there are no courses present for the " + value + " month"));

                    } else {
                        List<WebElement> coursesListAfter2 = getListElements(CoursesPageObject.courses, "getting list of courses");
                        Assert.assertFalse(coursesListBefore.size() == coursesListAfter2.size());
                        MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("number of courses displayed after month filter is " + coursesListAfter2.size()));
                        scrollingToElementofAPage(CoursesPageObject.courses, "");
                    }
                    takeScreenshotAndAttachInReport();
                    break;

            }
        } catch (Exception e) {
            catchAssertError(e);
        }
    }


    /**
     * @Description: This method will click on filter docking arrow
     * @Created By: Diksha
     * @Date: July 13, 2023
     */
    public static void clickOnFilterDockingArrowMobile() {

        try {
            hoverOnElement(CoursesPageObject.filterDockingArrow);
            takeScreenshotAndAttachInReport();
            Assert.assertTrue(isWebElementVisible(CoursesPageObject.filterDockingArrow, "filter docking arrow is visible"));
            click(CoursesPageObject.filterDockingArrow, "clicking on filter docking arrow");
            waitForVisible(CoursesPageObject.filterDocked);
            takeScreenshotAndAttachInReport();
            Assert.assertTrue(isWebElementVisible(CoursesPageObject.filterDocked, "filtering section is docked"));

        } catch (Exception e) {
            catchAssertError(e);
        }
    }

    /**
     * @Description: This method will search course name that was created in CMS
     * @Created By: Diksha
     * @Date: July 17, 2023
     */
    public static void searchCourses() {
        try {
            int i = 0;
            inputText(CoursesPageObject.searchBox, courseName, "entering data : " + courseName);
            if (mdriver != null) {
                mdriver.hideKeyboard();
            }
            while (!isWebElementVisibleWithoutLog(CoursesPageObject.courses)) {
                getDriver().navigate().refresh();
                getDriver().findElement(CoursesPageObject.searchBox).sendKeys(courseName);
                if (mdriver != null) {
                    mdriver.hideKeyboard();
                }
                i++;
                if (i == 20) {
                    break;
                }
            }
            if (mdriver != null) {
                scrollingToElementofAPage(CoursesPageObject.searchBoxContainer, "");
            }
            if (getbrowserName().contains("Firefox")) {
                scrollingToElementofAPage(CoursesPageObject.coursesCategory, "");
            }
            takeScreenshotAndAttachInReport();


        } catch (Exception e) {
            catchAssertError(e);
        }
    }

    /**
     * @Description: This method will click on enroll and then click on checkout
     * @Created By: Diksha
     * @Date: July 17, 2023
     */
    public static void enrollAndVerify(String verificationParameter) {
        try {
            if (isWebElementVisibleWithoutLog(CoursesPageObject.courseMedia))
                scrollingToElementofAPage(CoursesPageObject.courseMedia, "");
            takeScreenshotAndAttachInReport();
            click(CoursesPageObject.enrollButton, "clicking on enroll button");
            if (verificationParameter.equalsIgnoreCase("checkout page")) {
                waitForVisible(CoursesPageObject.checkoutButton);
                takeScreenshotAndAttachInReport();
                click(CoursesPageObject.checkoutButton, "clicking on checkout button");
                waitForInVisible(CoursesPageObject.checkoutButton);
                waitForURLContains("cart", "user is redirected to the shopping cart page");
                return;
            }
            if (verificationParameter.equalsIgnoreCase("success message and add more courses")) {
                waitForVisible(CoursesPageObject.addmorecourses);
                takeScreenshotAndAttachInReport();
                waitForVisible(CoursesPageObject.successmsg);
                String successmsg = getElementText(CoursesPageObject.successmsg);
                Assert.assertTrue(isWebElementVisible(CoursesPageObject.successmsg, successmsg + " message is displayed"));
                clickJS(CoursesPageObject.addmorecourses, "clicking on add more courses");
                Assert.assertTrue(isWebElementVisible(CoursesPageObject.categorytext, "user is redirected to courses listing page"));
                takeScreenshotAndAttachInReport();
                return;
            }
            if (verificationParameter.equalsIgnoreCase("add more courses button")) {
                waitForVisible(CoursesPageObject.addmorecourses);
                clickwithoutlog(CoursesPageObject.addmorecourses);
                waitForInVisible(CoursesPageObject.addmorecourses);
                return;
            }
            if (verificationParameter.equalsIgnoreCase("success message and checkout")) {
                waitForVisible(CoursesPageObject.checkout);
                takeScreenshotAndAttachInReport();
                String checkout = getElementText(CoursesPageObject.checkout);
                clickJS(CoursesPageObject.checkout, "clicking on " + checkout + " button");
                Assert.assertTrue(isWebElementVisible(CartPageObject.shoppingpage, "user is redirected to the cart page with the selected course added in it"));
                takeScreenshotAndAttachInReport();
                return;
            } else {
                waitForVisible(CoursesPageObject.seatsFullErrorMessage);
                Assert.assertTrue(getElementText(CoursesPageObject.seatsFullErrorMessage), isWebElementVisible(CoursesPageObject.seatsFullErrorMessage, getElementText(CoursesPageObject.seatsFullErrorMessage) + " message is displayed"));
            }
            takeScreenshotAndAttachInReport();
        } catch (Exception e) {
            catchAssertError(e);
        }
    }
}
