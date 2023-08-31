package modules;

import com.relevantcodes.extentreports.LogStatus;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.CoursesPageObject;
import pages.TrainerPageObject;
import runner.MyTestRunner;
import utilities.ExcelDataUtil;
import utilities.HTMLReportUtil;
import utilities.KeywordUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class TrainersPage extends KeywordUtil {
    public static HashMap<String, String> dataMap = new HashMap<String, String>();


    /**
     * @Description: This method will verify components for the trainers page
     * @Parameter: String listingpagecomponents
     * @Created By: Mehak
     * @Date: July 04, 2023
     */


    public static void trainersPage(String listingpagecomponents) {
        try {
            switch (listingpagecomponents) {
                case "header image":
                    waitForVisible(TrainerPageObject.headerimage_trainer);
                    Assert.assertTrue(isWebElementVisible(TrainerPageObject.headerimage_trainer, "header image is visible"));
                    break;
                case "trainers title":
                    waitForVisible(TrainerPageObject.trainerTitletext);
                    Assert.assertTrue(isWebElementVisible(TrainerPageObject.trainerTitletext, "trainers title is visible"));
                    break;
                case "trainer List":
                    scrollingToElementofAPage(TrainerPageObject.trainerList, "");
                    Assert.assertTrue(isWebElementVisible(TrainerPageObject.trainerList, "trainers list is visible"));
                    takeScreenshotAndAttachInReport();
                    break;
                case "trainer Searchbar":
                    waitForVisible(TrainerPageObject.trainerSearchbox);
                    Assert.assertTrue(isWebElementVisible(TrainerPageObject.trainerSearchbox, "searching section is displayed properly"));
                    break;
                case "trainer Image":
                    List<WebElement> trainers = getListElements(TrainerPageObject.trainers, "getting list of trainers");
                    List<WebElement> trainerImages = getListElements(TrainerPageObject.trainersImage, "getting list of trainer images");
                    Assert.assertTrue("trainer images is not there", trainers.size() == trainerImages.size());
                    MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("trainer image is showing for all the trainers"));
                    break;
                case "trainer Name":
                    List<WebElement> trainers1 = getListElements(TrainerPageObject.trainers, "getting list of trainers");
                    List<WebElement> trainersName = getListElements(TrainerPageObject.trainersName, "getting list of trainers name");
                    Assert.assertTrue("trainers names are not there", trainers1.size() == trainersName.size());
                    MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("trainer name is showing for all the trainers"));
                    break;
                case "trainer Category":
                    List<WebElement> trainers3 = getListElements(TrainerPageObject.trainers, "getting list of trainers");
                    List<WebElement> trainersCategory = getListElements(TrainerPageObject.trainerscategory, "getting list of trainer category");
                    Assert.assertTrue("trainer category is not there", trainers3.size() == trainersCategory.size());
                    MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("trainer category is showing for all the trainers"));
                    break;
            }

        } catch (Throwable e) {
            catchAssertError(e);
        }

    }

    /**
     * @Description: This method will verify Trainers filters are displayed properly
     * @Created By: Mehak
     * @Date: July 06, 2023
     */
    public static void trainersfilteringCreteria() {
        try {
            scrollingToElementofAPage(TrainerPageObject.trainerTitletext, "");
            Assert.assertTrue(isWebElementVisible(TrainerPageObject.Trainernametext, "trainer name filtering criteria is visible"));
            Assert.assertTrue(isWebElementVisible(TrainerPageObject.Categorytext, "trainer category filtering criteria is visible"));
        } catch (Throwable e) {
            catchAssertError(e);
        }
    }

    /**
     * @Description: This method will verify that Trainers filtering is working correctly
     * @Created By: Mehak
     * @Date: July 06, 2023
     */

    public static void entername(String MatchedName, String UnmatchedName) {
        try {
            if (!MatchedName.isEmpty())
                inputText(TrainerPageObject.Trainernametext, MatchedName, " entering matched name into search box");
            Assert.assertTrue(isWebElementVisible(TrainerPageObject.Trainernametext, "matched name " + " " + MatchedName + " " + "is visible"));
            takeScreenshotAndAttachInReport();
            if (!UnmatchedName.isEmpty())
                inputText(TrainerPageObject.Trainernametext, UnmatchedName, " entering unmatched name into search box");
            String text = getElementText(TrainerPageObject.unmatchednametext);
            Assert.assertTrue(isWebElementVisible(TrainerPageObject.unmatchednametext, text + " is visible"));
            takeScreenshotAndAttachInReport();
            getDriver().findElement(TrainerPageObject.Trainernametext).clear();
        } catch (Throwable e) {
            catchAssertError(e);
        }
    }

    /**
     * @Description: This method will verify that Trainers filtering is working correctly
     * @Created By: Mehak
     * @Date: July 06, 2023
     */

    public static void TrainerCategory(String data) {
        try {
            dataMap = ExcelDataUtil.getTestDataWithTestCaseID("TrainersPage", data);
            String matched = dataMap.get("MatchedName");
            String unmatched = dataMap.get("UnmatchedName");
            inputText(TrainerPageObject.Trainernametext, matched, "entering data : " + matched);
            List<WebElement> TrainerList = getListElements(TrainerPageObject.trainersName, "getting list of trainers");
            List<WebElement> matchedTrainer = getListElements(TrainerPageObject.trainersname(matched), "getting list of trainers with entered trainer name");
            Assert.assertTrue("category is not filtered", TrainerList.size() == matchedTrainer.size());
            List<WebElement> trainerListAfter = getListElements(TrainerPageObject.trainercount, "getting list of trainers");
            MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("number of trainers displayed after matched trainer name filter is " + trainerListAfter.size()));
            MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("results are filtered according to trainer name " + matched));
            if (mdriver != null) {
                mdriver.hideKeyboard();
                hoverOnElement(TrainerPageObject.trainercount);
            }
            takeScreenshotAndAttachInReport();
            inputText(CoursesPageObject.searchBox, unmatched, "entering data : " + unmatched);
            Assert.assertTrue("no search results found text is not visible", isWebElementVisible(CoursesPageObject.noSearchResults, "no search results are found"));
            if (mdriver != null) {
                mdriver.hideKeyboard();
                hoverOnElement(CoursesPageObject.noSearchResults);
            }
            takeScreenshotAndAttachInReport();
            getDriver().findElement(TrainerPageObject.searchBox).clear();
        } catch (Throwable e) {
            catchAssertError(e);
        }
    }


    /**
     * @Description: This method will verify that Trainers filtering is working correctly
     * @Created By: Mehak
     * @Date: July 06, 2023
     */
    public static void unselectcategorgy() {
        try {
            getDriver().navigate().refresh();
            Random random = new Random();
            List<WebElement> courseCategory = getListElements(TrainerPageObject.trainercategory, "getting list of courses list in search");
            int randomNumber = random.nextInt(5) + 1;
            String categoryToBeUnSelected = getElementText(TrainerPageObject.Trainercategoryvalue(randomNumber));
            click(TrainerPageObject.Trainercategoryvalue(randomNumber), "unselecting category : " + categoryToBeUnSelected);
            List<WebElement> trainerDisplayed = getListElements(TrainerPageObject.trainercategory, "getting list of trainers category displayed after applying filter");
            for (int i = 1; i < 5; i++) {
                Assert.assertFalse(getElementText(TrainerPageObject.TrainerName(i)).equalsIgnoreCase(categoryToBeUnSelected));
            }

            MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("no trainer with category as " + categoryToBeUnSelected + " is displayed"));
            List<WebElement> trainerListAfter1 = getListElements(TrainerPageObject.trainersName, "getting list of trainers");
            MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("number of trainers displayed after unselecting trainers category filter is " + trainerListAfter1.size()));
            takeScreenshotAndAttachInReport();
        } catch (Throwable e) {
            catchAssertError(e);
        }
    }

    /**
     * @Description: This method will verify that Trainers detail page is displayed correctly
     * @Created By: Mehak
     * @Date: July 06, 2023
     */

    public static void verifytrainerdetailpage() throws InterruptedException {
        try {
            scrollingToElementofAPage(TrainerPageObject.categorytext, "");
            if (mdriver != null) {
                hoverOnElement(TrainerPageObject.trainersName);
                takeScreenshotAndAttachInReport();
            }
            String trainersName = getElementText(TrainerPageObject.trainersName);
            waitForClickable(TrainerPageObject.trainersName);
            clickJS(TrainerPageObject.trainersName, "clicking on " + trainersName + " trainer");
            waitForURLContains("trainers", "user is redirected to trainer's detail page");
            Assert.assertTrue("same trainer is not opened", getElementText(TrainerPageObject.trainerTitle).equalsIgnoreCase(trainersName));
            takeScreenshotAndAttachInReport();

        } catch (Throwable e) {
            catchAssertError(e);
        }
    }

    /**
     * @Description: This method will verify that Trainers detail page is displayed correctly
     * @Created By: Mehak
     * @Date: July 13, 2023
     */


    public static void verifyallcomponentsoftrainer() {
        try {
            waitForVisible(TrainerPageObject.trainerimage);
            clickJS(TrainerPageObject.trainerimage, "clicking on the trainer's image");
            waitForVisible(TrainerPageObject.trainersHeaderImage);
            takeScreenshotAndAttachInReport();
            Assert.assertTrue(isWebElementVisible(TrainerPageObject.trainersHeaderImage, "trainer's image is visible"));
            String trainername = getElementText(TrainerPageObject.trainername);
            Assert.assertTrue(isWebElementVisible(TrainerPageObject.trainername, "trainer's name " + trainername + "is visible"));
            if (isWebElementVisibleWithoutLog(TrainerPageObject.trainerDesignation)) {
                String trainerDesignation = getElementText(TrainerPageObject.trainerDesignation);
                Assert.assertTrue(isWebElementVisible(TrainerPageObject.trainerDesignation, "trainer's designation " + trainerDesignation + " is visible"));
            } else {
                MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("trainer's designation is not visible"));
            }
            String trainercategory = getElementText(TrainerPageObject.trainerCatogory);
            Assert.assertTrue(isWebElementVisible(TrainerPageObject.trainerCatogory, "trainer's category " + trainercategory + " is visible"));
            scrollingToElementofAPage(TrainerPageObject.trainerCatogory, "");
            if (isWebElementVisibleWithoutLog(TrainerPageObject.trainerquote)) {
                String trainerquote = getElementText(TrainerPageObject.trainerquote);
                Assert.assertTrue(isWebElementVisible(TrainerPageObject.trainerquote, "trainer's quote " + trainerquote + " is visible"));
                takeScreenshotAndAttachInReport();
            } else {
                MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("trainer's quote is not available for this trainer"));
            }
            if (isWebElementVisibleWithoutLog(TrainerPageObject.moreinfo)) {
                Assert.assertTrue(isWebElementVisible(TrainerPageObject.moreinfo, "trainer's more info is visible"));
                takeScreenshotAndAttachInReport();
            } else {
                MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("trainer's more info is not available for this trainer"));
            }
            if (isWebElementVisibleWithoutLog(TrainerPageObject.courseslist)) {
                scrollingToElementofAPage(TrainerPageObject.courseslist, "");
                List<WebElement> trainercourseslist = getListElements(TrainerPageObject.courseslist, "getting list of trainers courses");
                MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("number of trainer's courses displayed is " + trainercourseslist.size()));
                Assert.assertTrue(isWebElementVisible(TrainerPageObject.trainercoursescategory, "courses category is visible in the trainer's course details section"));
                Assert.assertTrue(isWebElementVisible(TrainerPageObject.courseslistitemtrainername, "trainer(s) name is visible in the trainer's course details section"));
                Assert.assertTrue(isWebElementVisible(TrainerPageObject.comingsoonlabel, "coming soon label/days is visible in the trainer's course details section"));
                Assert.assertTrue(isWebElementVisible(TrainerPageObject.courseimage, "course image is visible in the trainer's course details section"));
                if (mdriver == null) {
                    Assert.assertTrue(isWebElementVisible(TrainerPageObject.location, "course location is visible in the trainer's course details section"));
                    Assert.assertTrue(isWebElementVisible(TrainerPageObject.days, "course duration is visible in the trainer's course details section"));
                    Assert.assertTrue(isWebElementVisible(TrainerPageObject.hoursperday, "course hours per day is visible in the trainer's course details section"));
                    Assert.assertTrue(isWebElementVisible(TrainerPageObject.description, "course description is visible in the trainer's course details section"));
                }
                Assert.assertTrue(isWebElementVisible(TrainerPageObject.price, "course price is visible in the trainer's course details section"));
                Assert.assertTrue(isWebElementVisible(TrainerPageObject.moredetailsbutton, "course more details button is visible in the trainer's course details section"));
                takeScreenshotAndAttachInReport();
            } else {
                String coursescomingsoon = getElementText(TrainerPageObject.coursescomingsoon);
                Assert.assertTrue(isWebElementVisible(TrainerPageObject.coursescomingsoon, coursescomingsoon + " is visible"));
                takeScreenshotAndAttachInReport();
            }
        } catch (Throwable e) {
            catchAssertError(e);
        }
    }
}



