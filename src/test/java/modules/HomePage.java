package modules;

import com.relevantcodes.extentreports.LogStatus;
import mobileutil.MobileKeywords;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.HomePageObject;
import runner.MyTestRunner;
import utilities.ExcelDataUtil;
import utilities.GlobalUtil;
import utilities.HTMLReportUtil;
import utilities.KeywordUtil;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import static hooks.AppHooks.closeYoutubeVideo;

public class HomePage extends KeywordUtil {
    public static HashMap<String, String> dataMap = new HashMap<String, String>();
    public static String sheetName = HomePage.class.getSimpleName();

    /**
     * @Description: This method will navigate to the website
     * @Parameter: String testDataName
     * @Created By: Diksha
     * @Date: July 04, 2023
     */
    public static void launchURL(String testDataName) {
        try {
            dataMap = ExcelDataUtil.getTestDataWithTestCaseID("HomePage", testDataName);
            String url = dataMap.get("URL");
            navigateToUrl(url);
            if (!testDataName.equalsIgnoreCase("CMS")) {
                if (closeYoutubeVideo) {
                    clickwithoutlog(HomePageObject.youtubeVideoClose);
                }
                if (!getbrowserName().contains("Headless")) {
                    zoomOut();
                }
            } else {
                Thread.sleep(5000);
            }
            waitTillPageIsCompletelyLoaded();
            takeScreenshotAndAttachInReport();
        } catch (Exception e) {
            catchAssertError(e);
        }
    }

    /**
     * Method used to zoom out the screen
     */
    public static void zoomOut() {
        try {
            Thread.sleep(2000);
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            for (int i = 0; i < 4; i++) {

                robot.keyPress(KeyEvent.VK_SUBTRACT);
                robot.keyRelease(KeyEvent.VK_SUBTRACT);

            }
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_SUBTRACT);
            Thread.sleep(2000);
        } catch (AWTException | InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * @Description: This method will verify broken links and images on the page
     * @Created By: Diksha
     * @Date: July 04, 2023
     */

    public void brokenImagesORLinksVerification(String type) {
        try {
            MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("verifying broken " + type + " on the page"));

            switch (type) {
                case "images":
                    checkBrokenImages();
                    break;
                case "links":
                    checkBrokenLinks();
                    break;
            }
            MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("no broken " + type + " are found on the page"));

        } catch (Throwable e) {
            catchAssertError(e);
        }

    }

    /**
     * @Description: This method will verify rail on homepage
     * @Parameter: String component type
     * @Created By: Diksha
     * @Date: July 04, 2023
     */
    public static void RailProperylyDisplayed(String type) {
        try {
            switch (type) {
                case "upcoming courses rail":
                    scrollingToElementofAPage(HomePageObject.Aboutarrow, "");
                    Assert.assertTrue(isWebElementVisible(HomePageObject.upcomingRail, "upcoming courses rail is visible"));
                    takeScreenshotAndAttachInReport();
                    Assert.assertTrue("upcoming course title is not there", isWebElementVisible(HomePageObject.upcomingCoursesTitle, "upcoming courses title is visible"));
                    List<WebElement> courses = getListElements(HomePageObject.upcomingCoursesContent, "getting list of contents in upcoming courses");
                    Assert.assertTrue("upcoming course content is not there", courses.size() > 0);
                    MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(courses.size() + " courses are showing in upcoming courses rail"));
                    List<WebElement> coursesTitle = getListElements(HomePageObject.upcomingCourseTitle, "getting list of upcoming courses titles");
                    Assert.assertTrue("upcoming course titles is not there", courses.size() == coursesTitle.size());
                    MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("titles are showing for all the upcoming courses"));
                    List<WebElement> coursesTrainer = getListElements(HomePageObject.upcomingCourseTrainer, "getting list of upcoming courses trainer");
                    Assert.assertTrue("upcoming course titles is not there", courses.size() == coursesTrainer.size());
                    MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("trainers are showing for all the upcoming courses"));
                    List<WebElement> coursesDate = getListElements(HomePageObject.upcomingCourseDate, "getting list of upcoming courses dates");
                    Assert.assertTrue("upcoming course titles is not there", courses.size() == coursesDate.size());
                    MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("courses dates are showing for all the upcoming courses"));
                    List<WebElement> coursesImage = getListElements(HomePageObject.upcomingCourseImage, "getting list of upcoming courses image");
                    Assert.assertTrue("upcoming course titles is not there", courses.size() == coursesImage.size());
                    MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("images are showing for all the upcoming courses"));
                    scrollingToElementofAPage(HomePageObject.upcomingCoursesContentLast, "");
                    Assert.assertTrue("last course is not showing", isWebElementVisible(HomePageObject.upcomingCoursesContentLast, "scrolling within rail is showing the later courses"));
                    scrollingToElementofAPage(HomePageObject.Aboutarrow, "");
                    takeScreenshotAndAttachInReport();
                    break;
                case "trainers list":
                    scrollingToElementofAPage(HomePageObject.trainerList, "trainers list is visible");
                    takeScreenshotAndAttachInReport();
                    List<WebElement> trainers = getListElements(HomePageObject.trainers, "getting list of trainers");
                    Assert.assertTrue("trainers are not there", trainers.size() > 0);
                    MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(trainers.size() + " trainers are showing"));
                    List<WebElement> trainersName = getListElements(HomePageObject.trainersName, "getting list of upcoming courses titles");
                    Assert.assertTrue("trainers names are not there", trainers.size() == trainersName.size());
                    MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("trainer name is showing for all the trainers"));
                    List<WebElement> trainersCategory = getListElements(HomePageObject.trainerscategory, "getting list of trainer category");
                    Assert.assertTrue("trainer category is not there", trainers.size() == trainersCategory.size());
                    MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("trainer category is showing for all the trainers"));
                    List<WebElement> trainerImages = getListElements(HomePageObject.trainersImage, "getting list of trainer images");
                    Assert.assertTrue("trainer images is not there", trainers.size() == trainerImages.size());
                    MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("trainer image is showing for all the trainers"));
                    break;
                case "youtube video popup":
                    WebElement YTFrame = getDriver().findElement(HomePageObject.youtubevideoFrame);
                    getDriver().switchTo().frame(YTFrame);
                    Assert.assertTrue("youtube video is not visible", isWebElementVisible(HomePageObject.youtubeVideo, "youtube video pop up is visible"));
                    MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("youtube video is auto playing"));
                    getDriver().switchTo().defaultContent();
                    waitForVisible(HomePageObject.youtubeVideoClose);
                    Assert.assertTrue("close icon is not visible", isWebElementVisible(HomePageObject.youtubeVideoClose, "youtube video popup close icon is visible and clickable"));
                    clickwithoutlog(HomePageObject.youtubeVideoClose);
                    break;
                case "clickable academy's logo":
                    takeScreenshotAndAttachInReport();
                    waitForClickable(HomePageObject.academyLogo);
                    Assert.assertTrue("academy logo not visible", isWebElementVisible(HomePageObject.academyLogo, "academy's logo is visible and clickable"));
                    break;
                case "header menu":
                    waitForVisible(HomePageObject.header);
                    Assert.assertTrue("header not visible", isWebElementVisible(HomePageObject.header, "header menu is visible"));
                    break;
                case "language change menu":
                    hoverOnElement(HomePageObject.languageDropdownHover);
                    if (mdriver != null) {
                        clickwithoutlog(HomePageObject.languageDropdownHover);
                    }
                    Assert.assertTrue("language change menu not visible", isWebElementVisible(HomePageObject.languageSelectionFomDropdown, "language change menu is visible"));
                    break;
                case "login icon":
                    Assert.assertTrue("login Icon not visible", isWebElementVisible(HomePageObject.loginIcon, "login icon is visible"));
                    break;
                case "register now button":
                    Assert.assertTrue("register now button not visible", isWebElementVisible(HomePageObject.registerNowButton, "register now button is visible"));
                    break;
                case "header image":
                    if (mdriver == null) {
                        waitForVisible(HomePageObject.headerImage);
                        Assert.assertTrue("header image not visible", isWebElementVisible(HomePageObject.headerImage, "header image is visible"));
                    }
                    if (mdriver != null) {
                        waitForVisible(HomePageObject.headerImageMobile);
                        Assert.assertTrue("header image not visible", isWebElementVisible(HomePageObject.headerImageMobile, "header image is visible"));

                    }
                    break;
                case "home screen contents":
                    scrollingToElementofAPage(HomePageObject.Aboutarrow, "");
                    Assert.assertTrue(isWebElementVisible(HomePageObject.upcomingRail, "upcoming courses component is visible"));
                    takeScreenshotAndAttachInReport();
                    scrollingToElementofAPage(HomePageObject.trainerList, "trainers component is visible");
                    takeScreenshotAndAttachInReport();
                    break;
                case "register now button in footer":
                    scrollingToElementofAPage(HomePageObject.footerRegisterButton, "register now button is visible in footer");
                    waitForVisible(HomePageObject.footerRegisterButton);
                    click(HomePageObject.footerRegisterButton, "clicking on register now button in footer");
                    waitForURLContains("login", "user is redirected to login page");
                    takeScreenshotAndAttachInReport();
                    if (mdriver != null) {
                        getDriver().navigate().back();
                        takeScreenshotAndAttachInReport();
                    }
                    break;
                case "footer components":
                    scrollingToElementofAPage(HomePageObject.socialMediaFooter, "");
                    waitForVisible(HomePageObject.socialMediaFooter);
                    takeScreenshotAndAttachInReport();
                    List<WebElement> socialIcons = getListElements(HomePageObject.socialMediaFooter, "getting social icons");
                    MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(socialIcons.size() + " social icons are visible in footer"));
                    List<WebElement> staticPages = getListElements(HomePageObject.staticPagesFooter, "getting static pages");
                    MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(staticPages.size() + " static pages links are visible in footer"));
                    Assert.assertTrue("copyright text not there", isWebElementVisible(HomePageObject.copyright, "copyright text is visible"));
                    break;
                case "burger menu":
                    waitForVisible(HomePageObject.burgerMenu);
                    Assert.assertTrue("burger menu icon not visible", isWebElementVisible(HomePageObject.burgerMenu, "burger menu icon is visible"));
                    break;
                case "upcoming courses button in header":
                    waitForVisible(HomePageObject.upcomingCoursesButtonHeader);
                    Assert.assertTrue("upcoming courses button in header not visible", isWebElementVisible(HomePageObject.upcomingCoursesButtonHeader, "upcoming courses button in header is visible"));
                    break;
            }
        } catch (Throwable e) {
            catchAssertError(e);
        }

    }

    /**
     * @Description: This method will click on item and verify redirection of page
     * @Parameter: String item, String page to be opened
     * @Created By: Diksha
     * @Date: July 04, 2023
     */
    public static void clickAndVerifyRedirection(String clickOnItem, String PageOpened) {
        try {
            switch (clickOnItem) {
                case "course":
                    String courseTitle = getElementText(HomePageObject.lastCourse);
                    scrollingToElementofAPage(HomePageObject.Aboutarrow, "");
                    click(HomePageObject.lastCourse, "clicking on " + courseTitle + " course");
                    waitForURLContains("courses", "user is redirected to course detail page");
                    Assert.assertTrue("same course is not opened", getElementText(HomePageObject.titleOfPage).equalsIgnoreCase(courseTitle));
                    takeScreenshotAndAttachInReport();
                    break;
                case "any trainer":
                    String trainersName = getElementText(HomePageObject.trainersName);
                    click(HomePageObject.trainersName, "clicking on " + trainersName + " trainer");
                    waitForURLContains("trainers", "user is redirected to trainer's detail page");
                    Assert.assertTrue("same trainer is not opened", getElementText(HomePageObject.trainerTitle).equalsIgnoreCase(trainersName));
                    takeScreenshotAndAttachInReport();
                    getDriver().navigate().back();
                    break;
                case "all trainers button":
                    scrollingToElementofAPage(HomePageObject.allTrainers, "all trainers button is visible");
                    takeScreenshotAndAttachInReport();
                    click(HomePageObject.allTrainers, "clicking on all trainers button");
                    waitForURLContains("trainers", "user is redirected to all trainers page");
                    Assert.assertTrue("all trainers page is not opened", isWebElementVisibleWithoutLog(HomePageObject.trainerPage));
                    takeScreenshotAndAttachInReport();
                    break;
                case "academy's logo":
                    waitForClickable(HomePageObject.academyLogo);
                    click(HomePageObject.academyLogo, "clicking on academy's logo at the top");
                    waitForVisible(HomePageObject.registerNowButton);
                    Assert.assertTrue("register now button not visible", isWebElementVisible(HomePageObject.registerNowButton, "user is redirected to the home page"));
                    takeScreenshotAndAttachInReport();
                    break;
                case "language dropdown":
                    String languageAlreadySelected = getElementText(HomePageObject.languageDropdownHover);
                    hoverOnElement(HomePageObject.languageDropdownHover);
                    if (mdriver != null) {
                        clickwithoutlog(HomePageObject.languageDropdownHover);
                    }
                    String prevUrl = getCurrentUrl();
                    String href = getElementAttribute(HomePageObject.languageSelectionFomDropdown, "href");
                    String language = getElementText(HomePageObject.languageSelectionFomDropdown);
                    waitForVisible(HomePageObject.languageSelectionFomDropdown);
                    takeScreenshotAndAttachInReport();
                    click(HomePageObject.languageSelectionFomDropdown, "changing the language to " + language + " from dropdown");
                    if (mdriver == null) {
                        waitForURLToBe(href.substring(0, href.length() - 1), "user is redirected to SNA Academy " + language + " home page");
                        Assert.assertFalse(getElementText(HomePageObject.languageDropdownHover).equalsIgnoreCase(languageAlreadySelected));
                    } else {
                        Assert.assertFalse(prevUrl.equalsIgnoreCase(getCurrentUrl()));
                        MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("user is redirected to SNA Academy " + language + " home page"));

                    }
                    takeScreenshotAndAttachInReport();
                    break;
                case "social media account":
                    Random random = new Random();
                    int randomNumber = random.nextInt(3) + 1;
                    switch (randomNumber) {
                        case 1:
                            clickOnItem = "facebook";
                            scrollingToElementofAPage(HomePageObject.socialIcon(clickOnItem), clickOnItem + " social icon is visible");
                            takeScreenshotAndAttachInReport();
                            click(HomePageObject.socialIcon(clickOnItem), "clicking on " + clickOnItem + " social media icon");
                            waitUntilExpectedWindowsToBe(2);
                            switchToWindow();
                            waitForURLContains(clickOnItem, "user is redirected to " + clickOnItem + " page");
                            if (mdriver != null) {
                                System.out.println(getCurrentUrl());
                                waitForURLContains("TheSNAAcademy", "SNA Academy account is opened");

                            } else {
                                waitForVisible(HomePageObject.facebookClosePopup);
                                if (isWebElementVisibleWithoutLog(HomePageObject.facebookClosePopup)) {
                                    clickwithoutlog(HomePageObject.facebookClosePopup);
                                }
                                waitForVisible(HomePageObject.snaAcademySocialAccount);
                                Assert.assertTrue("sna account is not visible", isWebElementVisible(HomePageObject.snaAcademySocialAccount, "SNA Academy account is opened"));
                            }
                            takeScreenshotAndAttachInReport();
                            closeChildWindow();
                            switchToParentWindow();
                            break;
                        case 2:
                            clickOnItem = "twitter";
                            scrollingToElementofAPage(HomePageObject.socialIcon(clickOnItem), clickOnItem + " social icon is visible");
                            takeScreenshotAndAttachInReport();
                            click(HomePageObject.socialIcon(clickOnItem), "clicking on " + clickOnItem + " social media icon");
                            waitUntilExpectedWindowsToBe(2);
                            ArrayList<String> windows = new ArrayList<String>(GlobalUtil.getDriver().getWindowHandles());
                            getDriver().switchTo().window(windows.get(1));
                            waitForURLContains(clickOnItem, "user is redirected to " + clickOnItem + " page");
                            waitForVisible(HomePageObject.twitterUserName);
                            if (isWebElementVisibleWithoutLog(HomePageObject.twitterUserName)) {
                                dataMap = ExcelDataUtil.getTestDataWithTestCaseID("SocialMediaCreds", "Twitter");
                                getDriver().findElement(HomePageObject.twitterUserName).sendKeys(dataMap.get("Username"));
                                clickwithoutlog(HomePageObject.twitterNextButton);
                                waitForVisible(HomePageObject.twitterPassword);
                                getDriver().findElement(HomePageObject.twitterPassword).sendKeys(dataMap.get("Password"));
                                waitForClickable(HomePageObject.twitterLogin);
                                clickwithoutlog(HomePageObject.twitterLogin);
                                waitForInVisible(HomePageObject.twitterLogin);
                                waitForVisible(HomePageObject.twitterLoggedIn);
                            }
                            getDriver().switchTo().window(windows.get(0));
                            clickwithoutlog(HomePageObject.socialIcon(clickOnItem));
                            waitUntilExpectedWindowsToBe(3);
                            windows = new ArrayList<String>(GlobalUtil.getDriver().getWindowHandles());
                            getDriver().switchTo().window(windows.get(2));
                            waitForVisible(HomePageObject.snaAcademySocialAccount);
                            Assert.assertTrue("sna account is not visible", isWebElementVisible(HomePageObject.snaAcademySocialAccount, "SNA Academy account is opened"));
                            takeScreenshotAndAttachInReport();
                            closeChildWindow();
                            getDriver().switchTo().window(windows.get(1));
                            closeChildWindow();
                            switchToParentWindow();
                            break;
                        case 3:
                            clickOnItem = "youtube";
                            scrollingToElementofAPage(HomePageObject.socialIcon(clickOnItem), clickOnItem + " social icon is visible");
                            takeScreenshotAndAttachInReport();
                            click(HomePageObject.socialIcon(clickOnItem), "clicking on " + clickOnItem + " social media icon");
                            if (mdriver == null) {
                                waitUntilExpectedWindowsToBe(2);
                                switchToWindow();
                                waitForVisible(HomePageObject.snaAcademySocialAccount);
                                Assert.assertTrue("sna account is not visible", isWebElementVisible(HomePageObject.snaAcademySocialAccount, "SNA Academy account is opened"));
                                takeScreenshotAndAttachInReport();
                                closeChildWindow();
                                switchToParentWindow();
                            } else {
                                mdriver.context("NATIVE_APP");
                                Assert.assertTrue(MobileKeywords.isWebElementVisible(HomePageObject.youtubeSNA, HomePageObject.type_xpath));
                                MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("user is redirected to the youtube channel of SNA Academy"));
                                takeScreenshotAndAttachInReport();
                            }
                            break;
                    }
                    break;
                case "burger menu icon":
                    Assert.assertTrue(isWebElementVisible(HomePageObject.burgerMenu, "burger menu icon is visible"));
                    click(HomePageObject.burgerMenu, "clicking on burger menu icon");
                    waitForVisible(HomePageObject.burgerMenuOpenedList);
                    takeScreenshotAndAttachInReport();
                    Assert.assertTrue(isWebElementVisible(HomePageObject.burgerMenuOpenedList, "menu items are displayed"));
                    break;
                case "courses in burger menu":
                    click(HomePageObject.menuNavigation("courses"), "clicking on courses in burger menu");
                    waitForVisible(HomePageObject.coursesListOpened);
                    takeScreenshotAndAttachInReport();
                    Assert.assertTrue(isWebElementVisible(HomePageObject.coursesListOpened, "courses list is displayed"));
                    OpenBurgerMenu("close");
                    break;
                case "any menu item":
                    Random random1 = new Random();
                    int randomNumber1 = random1.nextInt(4) + 1;
                    switch (randomNumber1) {
                        case 1:
                            clickOnMenu("about", "burger menu");
                            break;
                        case 3:
                            clickOnMenu("news", "burger menu");
                            break;
                        case 4:
                            clickOnMenu("trainers", "burger menu");
                            break;
                    }
                    break;
                case "register now button in footer":
                    scrollingToElementofAPage(HomePageObject.footerRegisterButton, "register now button is visible in footer");
                    waitForVisible(HomePageObject.footerRegisterButton);
                    takeScreenshotAndAttachInReport();
                    click(HomePageObject.footerRegisterButton, "clicking on register now button in footer");
                    Assert.assertTrue(waitForURLContains("login", "user is redirected to login page"));
                    takeScreenshotAndAttachInReport();
                    getDriver().navigate().back();
                    takeScreenshotAndAttachInReport();
                    break;
                case "register now button in header":
                    waitForVisible(HomePageObject.registerNowButton);
                    Assert.assertTrue("register now button is not there", isWebElementVisible(HomePageObject.registerNowButton, "register now button is visible in header"));
                    click(HomePageObject.registerNowButton, "clicking on register now button in header");
                    Assert.assertTrue(waitForURLContains("login", "user is redirected to login page"));
                    takeScreenshotAndAttachInReport();
                    getDriver().navigate().back();
                    takeScreenshotAndAttachInReport();
                    break;
                case "register now button":
                    waitForVisible(HomePageObject.registerNowButton);
                    click(HomePageObject.registerNowButton, "clicking on register now button in header");
                    Assert.assertTrue(waitForURLContains("login", "user is redirected to login page"));
                    takeScreenshotAndAttachInReport();
                    break;
                case "account icon in header":
                    waitForVisible(HomePageObject.loginIcon);
                    Assert.assertTrue("account icon in header is not there", isWebElementVisible(HomePageObject.loginIcon, "account icon is visible in header"));
                    click(HomePageObject.loginIcon, "clicking on account icon in header");
                    Assert.assertTrue(waitForURLContains("login", "user is redirected to login page"));
                    takeScreenshotAndAttachInReport();
                    getDriver().navigate().back();
                    takeScreenshotAndAttachInReport();
                    break;
                case "account icon":
                    waitForVisible(HomePageObject.loginIcon);
                    click(HomePageObject.loginIcon, "clicking on account icon in header");
                    Assert.assertTrue(waitForURLContains("login", "user is redirected to login page"));
                    takeScreenshotAndAttachInReport();
                    break;
                case "upcoming courses button in header":
                    waitForVisible(HomePageObject.upcomingCoursesButtonHeader);
                    click(HomePageObject.upcomingCoursesButtonHeader, "clicking on upcoming courses button in header");
                    waitForURLContains("courses", "user is navigated to courses listing page");
                    takeScreenshotAndAttachInReport();
                    getDriver().navigate().back();
                    break;
                case "upcoming courses button in footer":
                    waitForVisible(HomePageObject.footerCoursesBtn);
                    scrollingToElementofAPage(HomePageObject.footerCoursesBtn, "");
                    takeScreenshotAndAttachInReport();
                    click(HomePageObject.footerCoursesBtn, "clicking on upcoming courses button in footer");
                    waitForURLContains("courses", "user is navigated to courses listing page");
                    takeScreenshotAndAttachInReport();
                    break;

            }
        } catch (Throwable e) {
            catchAssertError(e);
        }
    }

    /**
     * @Description: This method will click on an item from header
     * @Param : String menu
     * @Created By: Diksha
     * @Date: July 5, 2023
     */
    public static void verifyRedirection(String format) {
        try {
            Random random = new Random();
            int randomNumber = random.nextInt(4) + 1;
            if (format.equalsIgnoreCase("header")) {
                switch (randomNumber) {
                    case 1:
                        clickOnMenu("about", "header");
                        break;
                    case 2:
                        clickOnMenu("courses", "header");
                        break;
                    case 3:
                        clickOnMenu("news", "header");
                        break;
                    case 4:
                        clickOnMenu("trainers", "header");
                        break;
                }
            }
            if (format.equalsIgnoreCase("footer")) {
                switch (randomNumber) {
                    case 1:
                        clickOnMenu("privacy", "footer");
                        break;
                    case 2:
                        clickOnMenu("terms", "footer");
                        break;
                    case 3:
                        clickOnMenu("faq", "footer");
                        break;
                    case 4:
                        clickOnMenu("contact-us", "footer");
                        break;
                }
            }

        } catch (Exception e) {
            catchAssertError(e);
        }

    }

    /**
     * @Description: This method will click on the menu based on user format such as header or footer
     * @Parameter: String Menu and format
     * @Created By: Diksha
     * @Date: July 05, 2023
     */
    public static void clickOnMenu(String menu, String format) {
        try {
            if (format.equalsIgnoreCase("footer")) {
                scrollingToElementofAPage(HomePageObject.menuNavigation(menu), "");
                takeScreenshotAndAttachInReport();
            } else {
                if (!isWebElementVisibleWithoutLog(HomePageObject.menuNavigation(menu))) {
                    if (mdriver != null) {
                        clickwithoutlog(HomePageObject.burgerMenu);
                        waitForVisible(HomePageObject.menuNavigation(menu));
                    }
                }
            }
            click(HomePageObject.menuNavigation(menu), "clicking on " + menu + " in " + format);
            if (menu.equalsIgnoreCase("courses") && mdriver != null) {
                waitForVisible(HomePageObject.allCoursesInMenu);
                clickwithoutlog(HomePageObject.allCoursesInMenu);
            }
            waitForInVisible(HomePageObject.Aboutarrow);
            if (mdriver == null) {
                hoverOnElement(HomePageObject.menuNavigation("about"));
            }
            Assert.assertTrue("redirection did not happen", waitForURLContains(menu, "user is redirected to the " + menu + " page"));
            waitTillPageIsCompletelyLoaded();
            takeScreenshotAndAttachInReport();
        } catch (Exception e) {
            catchAssertError(e);
        }
    }

    /**
     * @Description: This method will disable notifications and open chrome App on android device
     * @Created By: Diksha
     * @Date: June 08, 2023
     */
    public static void launchWebsiteOnMobileChrome(String testDataName) {
        dataMap = ExcelDataUtil.getTestDataWithTestCaseID(sheetName, testDataName);
        String url = dataMap.get("URL");
        try {
            getDriver().get(url);
            MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("user is navigated to " + url));
            if (closeYoutubeVideo) {
                clickwithoutlog(HomePageObject.youtubeVideoClose);
            }
            takeScreenshotAndAttachInReport();
        } catch (Exception e) {
            catchAssertError(e);
        }
    }


    /**
     * @Description: This method will click on the burger
     * @Param: Action (Open/Close)
     * @Created By: Diksha
     * @Date: July 06, 2023
     */
    public static void OpenBurgerMenu(String action) {
        try {
            switch (action) {
                case "open":
                    clickwithoutlog(HomePageObject.burgerMenu);
                    waitForVisible(HomePageObject.loginIcon);
                    takeScreenshotAndAttachInReport();
                    break;
                case "close":
                    clickwithoutlog(HomePageObject.burgerMenuClose);
                    break;
            }
        } catch (Exception e) {
            catchAssertError(e);
        }
    }

    /**
     * @Description: This method will click on items in account icon
     * @Param: String menuItem
     * @Created By: Diksha
     * @Date: July 12, 2023
     */
    public static void navigateToItemsInAccountMenu(String menu) {
        try {
            clickwithoutlog(HomePageObject.loggedInAccountIcon);
            switch (menu) {
                case "my account":
                    waitForVisible(HomePageObject.myAccountMenu);
                    click(HomePageObject.myAccountMenu, "clicking on my account");
                    waitForURLContains("account", "user is redirected to account page");
                    break;
                case "logout":
                    waitForVisible(HomePageObject.logout);
                    takeScreenshotAndAttachInReport();
                    click(HomePageObject.logout, "clicking on logout button");
                    if (mdriver == null)
                        Assert.assertTrue(waitForURLContains("login", "user is logged out successfully"));
                    else {
                        clickwithoutlog(HomePageObject.burgerMenuClose);
                        Assert.assertTrue(isWebElementVisible(HomePageObject.registerNowButton, "user is logged out successfully"));
                    }
                    break;
                case "shopping cart":
                    takeScreenshotAndAttachInReport();
                    waitForVisible(HomePageObject.cartbutton);
                    click(HomePageObject.cartbutton, "clicking on the Shopping Cart button");
                    waitForURLContains("cart", "user is redirected to cart page");
                    break;
            }
            takeScreenshotAndAttachInReport();
        } catch (Exception e) {
            catchAssertError(e);
        }
    }
}
