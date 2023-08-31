package modules;

import com.relevantcodes.extentreports.LogStatus;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import pages.NewsAndEventsPageObject;
import runner.MyTestRunner;
import utilities.HTMLReportUtil;
import utilities.KeywordUtil;

import java.util.List;

import static utilities.Sikuli.takeDesktopScreenshot;

public class NewsAndEventsPage extends KeywordUtil {

    /**
     * @Description: This method will verify components for the news page
     * @Parameter: String verificationParameter
     * @Created By: Diksha
     * @Date: July 08, 2023
     */
    public static void verificationOfComponents(String verificationParameter, String page) {
        try {
            switch (verificationParameter) {
                case "header image":
                    if (page.equalsIgnoreCase("testimonials")) {
                        if (mdriver == null) {
                            waitForVisible(NewsAndEventsPageObject.headerImage);
                            if (isWebElementVisibleWithoutLog(NewsAndEventsPageObject.headerImage)) {
                                Assert.assertTrue("header image is not visible", isWebElementVisible(NewsAndEventsPageObject.headerImage, "header image is visible"));
                            } else
                                MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("there is no header image visible"));
                        } else {
                            if (isWebElementVisibleWithoutLog(NewsAndEventsPageObject.headerImageMobile)) {
                                Assert.assertTrue("header image is not visible", isWebElementVisible(NewsAndEventsPageObject.headerImageMobile, "header image is visible"));
                            } else
                                MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("there is no header image visible"));
                        }
                    } else {
                        if (mdriver == null) {
                            waitForVisible(NewsAndEventsPageObject.headerImage);
                            Assert.assertTrue("header image is not visible", isWebElementVisible(NewsAndEventsPageObject.headerImage, "header image is visible"));
                        } else {
                            waitForVisible(NewsAndEventsPageObject.headerImageMobile);
                            Assert.assertTrue("header image is not visible", isWebElementVisible(NewsAndEventsPageObject.headerImageMobile, "header image is visible"));
                        }
                    }
                    break;
                case "title":
                    if (page.equalsIgnoreCase("testimonials")) {
                        if (isWebElementVisibleWithoutLog(NewsAndEventsPageObject.title)) {
                            Assert.assertTrue("title is not visible", isWebElementVisible(NewsAndEventsPageObject.title, "title is visible"));
                        } else
                            MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("title is not visible"));
                    } else {
                        waitForVisible(NewsAndEventsPageObject.title);
                        Assert.assertTrue("title is not visible", isWebElementVisible(NewsAndEventsPageObject.title, "title is visible"));
                    }
                    break;
                case "news section":
                    if (isWebElementVisibleWithoutLog(NewsAndEventsPageObject.sections("News", "الأخبــــــــــار"))) {
                        if (mdriver != null) {
                            scrollingToElementofAPage(NewsAndEventsPageObject.sections("News", "الأخبــــــــــار"), "");
                            takeScreenshotAndAttachInReport();
                        }
                        Assert.assertTrue("news section is not visible", isWebElementVisible(NewsAndEventsPageObject.sections("News", "الأخبــــــــــار"), "news section is visible"));
                        List<WebElement> news = getListElements(NewsAndEventsPageObject.newsInNewsSection, "getting list of news in news section");
                        List<WebElement> newsHeadline = getListElements(NewsAndEventsPageObject.newsHeadlineInNewsSection, "getting list of news headline in news section");
                        List<WebElement> newsImage = getListElements(NewsAndEventsPageObject.newsImageInNewsSection, "getting list of news image in news section");
                        List<WebElement> newsDate = getListElements(NewsAndEventsPageObject.newsDateInNewsSection, "getting list of news date in news section");
                        Assert.assertTrue(news.size() > 0);
                        Assert.assertEquals(news.size(), newsHeadline.size());
                        Assert.assertEquals(news.size(), newsImage.size());
                        Assert.assertEquals(news.size(), newsDate.size());
                        MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(news.size() + " news are visible in news section"));
                        MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("image is visible for all the news"));
                        MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("headline is visible for all the news"));
                        MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("date is visible for all the news"));
                    } else {
                        MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("news section is not visible"));

                    }
                    break;
                case "videos section":
                    if (isWebElementVisibleWithoutLog(NewsAndEventsPageObject.sections("Videos", "أشرطة فيديو"))) {
                        scrollingToElementofAPage(NewsAndEventsPageObject.sections("Videos", "أشرطة فيديو"), "");
                        takeScreenshotAndAttachInReport();
                        Assert.assertTrue("videos section is not visible", isWebElementVisible(NewsAndEventsPageObject.sections("Videos", "أشرطة فيديو"), "videos section is visible"));
                        List<WebElement> videos = getListElements(NewsAndEventsPageObject.videosInVideoSection, "getting list of videos in video section");
                        List<WebElement> videoPlayIcon = getListElements(NewsAndEventsPageObject.videoPlayIcon, "getting list of video play icon");
                        List<WebElement> videoImage = getListElements(NewsAndEventsPageObject.videoImage, "getting list of video image in videos section");
                        List<WebElement> videoTitle = getListElements(NewsAndEventsPageObject.videoTitle, "getting list of video title");
                        List<WebElement> videoDesc = getListElements(NewsAndEventsPageObject.videoDescription, "getting list of video description");
                        List<WebElement> videoDate = getListElements(NewsAndEventsPageObject.videoDate, "getting list of video date");
                        Assert.assertTrue(videos.size() > 0);
                        Assert.assertEquals(videos.size(), videoPlayIcon.size());
                        Assert.assertEquals(videos.size(), videoImage.size());
                        Assert.assertEquals(videos.size(), videoTitle.size());
                        Assert.assertEquals(videos.size(), videoDesc.size());
                        Assert.assertEquals(videos.size(), videoDate.size());
                        MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(videos.size() + " videos are visible in videos section"));
                        MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("image is visible for all the videos"));
                        MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("play icon is visible for all the videos"));
                        MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("title is visible for all the videos"));
                        MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("description is visible for all the videos"));
                        MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("date is visible for all the videos"));
                    } else {
                        MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("videos section is not visible"));

                    }
                    break;
                case "testimonials section":
                    if (isWebElementVisibleWithoutLog(NewsAndEventsPageObject.sections("Testimonials", "توصيات الخريجين"))) {
                        scrollingToElementofAPage(NewsAndEventsPageObject.sections("Testimonials", "توصيات الخريجين"), "");
                        takeScreenshotAndAttachInReport();
                        Assert.assertTrue("testimonials section is not visible", isWebElementVisible(NewsAndEventsPageObject.sections("Testimonials", "توصيات الخريجين"), "testimonials section is visible"));
                        List<WebElement> testimonials = getListElements(NewsAndEventsPageObject.testimonials, "getting list of testimonials in testimonials section");
                        List<WebElement> testimonialsPlayIcon = getListElements(NewsAndEventsPageObject.testimonialsPlayIcon, "getting list of testimonials play icon");
                        List<WebElement> testimonialsImage = getListElements(NewsAndEventsPageObject.testimonialsImage, "getting list of testimonials image in testimonials section");
                        List<WebElement> testimonialsTitle = getListElements(NewsAndEventsPageObject.testimonialsTitle, "getting list of testimonials title");
                        List<WebElement> testimonialsDate = getListElements(NewsAndEventsPageObject.testimonialsDate, "getting list of testimonials date");
                        Assert.assertTrue(testimonials.size() > 0);
                        Assert.assertEquals(testimonials.size(), testimonialsPlayIcon.size());
                        Assert.assertEquals(testimonials.size(), testimonialsImage.size());
                        Assert.assertEquals(testimonials.size(), testimonialsTitle.size());
                        Assert.assertEquals(testimonials.size(), testimonialsDate.size());
                        MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(testimonials.size() + " testimonials are visible in testimonials section"));
                        MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("image is visible for all the testimonials"));
                        MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("play icon is visible for all the testimonials"));
                        MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("title is visible for all the testimonials"));
                        MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("description is visible for all the testimonials"));
                        MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("date is visible for all the testimonials"));
                    } else {
                        MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("testimonials section is not visible"));

                    }
                    break;
                case "headline":
                    waitForVisible(NewsAndEventsPageObject.headerTitleAfterNews);
                    Assert.assertTrue("headline is not visible", isWebElementVisible(NewsAndEventsPageObject.headerTitleAfterNews, getElementText(NewsAndEventsPageObject.headerTitleAfterNews) + " headline is visible"));
                    break;
                case "date":
                    waitForVisible(NewsAndEventsPageObject.date);
                    Assert.assertTrue("date is not visible", isWebElementVisible(NewsAndEventsPageObject.date, getElementText(NewsAndEventsPageObject.date) + " is visible"));
                    break;
                case "sharing icons":
                    waitForVisible(NewsAndEventsPageObject.socialIcons);
                    Assert.assertTrue("sharing icons are not visible", isWebElementVisible(NewsAndEventsPageObject.socialIcons, "sharing icons are visible"));
                    break;
                case "image":
                    scrollingToElementofAPage(NewsAndEventsPageObject.newsImage, "");
                    takeScreenshotAndAttachInReport();
                    waitForVisible(NewsAndEventsPageObject.newsImage);
                    Assert.assertTrue("newsImage is not visible", isWebElementVisible(NewsAndEventsPageObject.newsImage, "news image is visible"));
                    break;
                case "news details":
                    waitForVisible(NewsAndEventsPageObject.newsDescription);
                    Assert.assertTrue("news description not visible", isWebElementVisible(NewsAndEventsPageObject.newsDescription, "news details are visible"));
                    break;
                case "more news":
                    scrollingToElementofAPage(NewsAndEventsPageObject.moreNews, "");
                    takeScreenshotAndAttachInReport();
                    waitForVisible(NewsAndEventsPageObject.moreNews);
                    Assert.assertTrue("more News not visible", isWebElementVisible(NewsAndEventsPageObject.moreNews, "more news is visible"));
                    break;
                case "more news image":
                    waitForVisible(NewsAndEventsPageObject.moreNewsImage);
                    Assert.assertTrue("more News image not visible", isWebElementVisible(NewsAndEventsPageObject.moreNewsImage, "image is visible for more news"));
                    break;
                case "more news headline":
                    waitForVisible(NewsAndEventsPageObject.moreNewsHeadline);
                    Assert.assertTrue("more News headline not visible", isWebElementVisible(NewsAndEventsPageObject.moreNewsHeadline, "headline is visible for more news"));
                    break;
                case "more news date":
                    waitForVisible(NewsAndEventsPageObject.moreNewsDate);
                    Assert.assertTrue("more News date not visible", isWebElementVisible(NewsAndEventsPageObject.moreNewsDate, "date is visible for more news"));
                    break;
                case "list of news":
                    List<WebElement> news = getListElements(NewsAndEventsPageObject.newsInNewsSection, "getting list of news in news archive page");
                    Assert.assertTrue(news.size() > 0);
                    MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(news.size() + " news are visible in news archive page"));
                    break;
                case "list of videos":
                    List<WebElement> videos = getListElements(NewsAndEventsPageObject.videosInVideoSection, "getting list of videos in video section");
                    List<WebElement> videoPlayIcon = getListElements(NewsAndEventsPageObject.videoPlayIcon, "getting list of video play icon");
                    List<WebElement> videoImage = getListElements(NewsAndEventsPageObject.videoImage, "getting list of video image in videos section");
                    List<WebElement> videoTitle = getListElements(NewsAndEventsPageObject.videoTitle, "getting list of video title");
                    List<WebElement> videoDesc = getListElements(NewsAndEventsPageObject.videoDescription, "getting list of video description");
                    List<WebElement> videoDate = getListElements(NewsAndEventsPageObject.videoDate, "getting list of video date");
                    Assert.assertTrue(videos.size() > 0);
                    Assert.assertEquals(videos.size(), videoPlayIcon.size());
                    Assert.assertEquals(videos.size(), videoImage.size());
                    Assert.assertEquals(videos.size(), videoTitle.size());
                    Assert.assertEquals(videos.size(), videoDesc.size());
                    Assert.assertEquals(videos.size(), videoDate.size());
                    MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(videos.size() + " videos are visible in videos archive page"));
                    MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("image is visible for all the videos"));
                    MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("play icon is visible for all the videos"));
                    MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("title is visible for all the videos"));
                    MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("description is visible for all the videos"));
                    MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("date is visible for all the videos"));
                    break;
                case "list of testimonials":
                    List<WebElement> testimonials = getListElements(NewsAndEventsPageObject.testimonials, "getting list of testimonials in testimonials section");
                    List<WebElement> testimonialsPlayIcon = getListElements(NewsAndEventsPageObject.testimonialsPlayIcon, "getting list of testimonials play icon");
                    List<WebElement> testimonialsImage = getListElements(NewsAndEventsPageObject.testimonialsImage, "getting list of testimonials image in testimonials section");
                    List<WebElement> testimonialsTitle = getListElements(NewsAndEventsPageObject.testimonialsTitle, "getting list of testimonials title");
                    List<WebElement> testimonialsDate = getListElements(NewsAndEventsPageObject.testimonialsDate, "getting list of testimonials date");
                    if (testimonials.size() == 0) {
                        MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("testimonials are not present"));
                    } else {
                        Assert.assertTrue(testimonials.size() > 0);
                        Assert.assertEquals(testimonials.size(), testimonialsPlayIcon.size());
                        Assert.assertEquals(testimonials.size(), testimonialsImage.size());
                        Assert.assertEquals(testimonials.size(), testimonialsTitle.size());
                        Assert.assertEquals(testimonials.size(), testimonialsDate.size());
                        MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(testimonials.size() + " testimonials are visible in testimonials archive page"));
                        MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("image is visible for all the testimonials"));
                        MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("play icon is visible for all the testimonials"));
                        MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("title is visible for all the testimonials"));
                        MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("description is visible for all the testimonials"));
                        MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("date is visible for all the testimonials"));
                    }
                    break;


            }
        } catch (Exception e) {
            catchAssertError(e);
        }

    }

    /**
     * @Description: This method will click on news
     * @Created By: Diksha
     * @Date: July 10, 2023
     */
    public static void clickNews(String type) {
        try {
            String url = getCurrentUrl();
            String title = "";
            String category = "";
            if (type.contains("view all link")) {
                category = type.split("view all link for ")[1];
                type = "view all link";
            }
            switch (type) {
                case "news":
                    title = getElementText(NewsAndEventsPageObject.newsHeadlineInNewsSection);
                    click(NewsAndEventsPageObject.newsHeadlineInNewsSection, "clicking on news card");
                    waitForVisible(NewsAndEventsPageObject.headerTitleAfterNews);
                    waitTillPageIsCompletelyLoaded();
                    Assert.assertEquals(getElementText(NewsAndEventsPageObject.headerTitleAfterNews), title);
                    Assert.assertFalse(url.equalsIgnoreCase(getCurrentUrl()));
                    MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(title + " page is opened"));
                    takeScreenshotAndAttachInReport();
                    break;
                case "more news":
                    title = getElementText(NewsAndEventsPageObject.moreNewsHeadline);
                    click(NewsAndEventsPageObject.moreNewsHeadline, "clicking on more news");
                    waitForVisible(NewsAndEventsPageObject.headerTitleAfterNews);
                    waitTillPageIsCompletelyLoaded();
                    Assert.assertEquals(getElementText(NewsAndEventsPageObject.headerTitleAfterNews), title);
                    MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(title + " page is opened"));
                    takeScreenshotAndAttachInReport();
                    getDriver().navigate().back();
                    break;
            }
        } catch (Exception e) {
            catchAssertError(e);
        }
    }

    /**
     * @Description: This method will click on view all link
     * @Param: String category
     * @Created By: Diksha
     * @Date: July 10, 2023
     */
    public static void viewAllLink(String type) {
        try {
            int count = 0;
            switch (type) {

                case "news":
                    while (!isWebElementVisibleWithoutLog(NewsAndEventsPageObject.viewAllNews)) {
                        getDriver().navigate().refresh();
                        count++;
                        if (count == 30)
                            break;
                    }
                    waitForVisible(NewsAndEventsPageObject.viewAllNews);
                    Assert.assertTrue(isWebElementVisible(NewsAndEventsPageObject.viewAllNews, "view all link is visible for news"));
                    click(NewsAndEventsPageObject.viewAllNews, "clicking on view all link for news");
                    waitForURLContains("news-archive", "user is redirected to the news archive page");
                    while (!isWebElementVisibleWithoutLog(NewsAndEventsPageObject.newsHeadlineInNewsSection)) {
                        getDriver().navigate().refresh();
                    }
                    break;
                case "videos":
                    while (!isWebElementVisibleWithoutLog(NewsAndEventsPageObject.viewAllVideos)) {
                        getDriver().navigate().refresh();
                        count++;
                        if (count == 30)
                            break;
                    }
                    waitForVisible(NewsAndEventsPageObject.viewAllVideos);
                    scrollingToElementofAPage(NewsAndEventsPageObject.newsInNewsSection, "");
                    takeScreenshotAndAttachInReport();
                    Assert.assertTrue(isWebElementVisible(NewsAndEventsPageObject.viewAllVideos, "view all link is visible for videos"));
                    click(NewsAndEventsPageObject.viewAllVideos, "clicking on view all link for videos");
                    waitForURLContains("videos-archive", "user is redirected to the videos archive page");
                    while (!isWebElementVisibleWithoutLog(NewsAndEventsPageObject.videoPlayIcon)) {
                        getDriver().navigate().refresh();
                    }
                    break;
                case "testimonials":
                    while (!isWebElementVisibleWithoutLog(NewsAndEventsPageObject.viewAllTestimonials)) {
                        getDriver().navigate().refresh();
                        count++;
                        if (count == 30)
                            break;
                    }
                    waitForVisible(NewsAndEventsPageObject.viewAllTestimonials);
                    scrollingToElementofAPage(NewsAndEventsPageObject.videosInVideoSection, "");
                    takeScreenshotAndAttachInReport();
                    if (!isWebElementVisibleWithoutLog(NewsAndEventsPageObject.viewAllTestimonials)) {
                        MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("there is no view all link present for testimonial"));
                    } else {
                        Assert.assertTrue(isWebElementVisible(NewsAndEventsPageObject.viewAllTestimonials, "view all link is visible for testimonials"));
                        click(NewsAndEventsPageObject.viewAllTestimonials, "clicking on view all link for testimonials");
                        waitForURLContains("testimonials-archive", "user is redirected to the testimonials archive page");
                        while (!isWebElementVisibleWithoutLog(NewsAndEventsPageObject.testimonialsPlayIcon)) {
                            getDriver().navigate().refresh();
                        }
                    }
                    break;
            }
            waitTillPageIsCompletelyLoaded();
            takeScreenshotAndAttachInReport();


        } catch (Exception e) {
            catchAssertError(e);
        }
    }

    /**
     * @Description: This method will click on video and verify video pop up is displayed
     * @Created By: Diksha
     * @Date: July 13, 2023
     */
    public static void clickOnVideo(String type) {
        try {
            switch (type) {
                case "video":
                    if (!getCurrentUrl().contains("archive"))
                        scrollingToElementofAPage(NewsAndEventsPageObject.newsHeadlineInNewsSection, "");
                    waitForVisible(NewsAndEventsPageObject.videoPlayIcon);
                    click(NewsAndEventsPageObject.videoPlayIcon, "clicking on a video");
                    break;
                case "testimonial":
                    if (!getCurrentUrl().contains("archive"))
                        scrollingToElementofAPage(NewsAndEventsPageObject.videoDescriptionLast, "");
                    waitForVisible(NewsAndEventsPageObject.testimonialsPlayIcon);
                    click(NewsAndEventsPageObject.testimonialsPlayIcon, "clicking on a testimonial");
                    break;
            }
            waitForVisible(NewsAndEventsPageObject.videoPlaying);
            Thread.sleep(10000);
            Assert.assertTrue(isWebElementVisible(NewsAndEventsPageObject.videoPlaying, type + " is playing in a popup window"));
            takeScreenshotAndAttachInReport();
            if (getCurrentUrl().contains("archive"))
                clickwithoutlog(NewsAndEventsPageObject.closeVideo);
        } catch (Exception e) {
            catchAssertError(e);
        }

    }

    /**
     * @Description: This method will verify video controls are working fine
     * @Param : Video Controls/Actions
     * @Created By: Diksha
     * @Date: July 17, 2023
     */
    public static void videoActions(String action) {
        try {
            WebElement videoElement = getDriver().findElement(By.tagName("video"));
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            switch (action) {

                case "pause":
                    js.executeScript("arguments[0].pause();", videoElement);
                    Assert.assertTrue((Boolean) (js.executeScript("return arguments[0].paused;", videoElement)));
                    MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("pause control is working fine"));
                    takeScreenshotAndAttachInReport();
                    break;
                case "play":
                    js.executeScript("arguments[0].play();", videoElement);
                    Assert.assertFalse((Boolean) (js.executeScript("return arguments[0].paused;", videoElement)));
                    MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("play control is working fine"));
                    takeScreenshotAndAttachInReport();
                    pressEnter();
                    break;
                case "mute":
                    js.executeScript("document.querySelector('video').muted = true;");
                    Assert.assertTrue((Boolean) (js.executeScript("return arguments[0].muted;", videoElement)));
                    MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("mute control is working fine"));
                    takeScreenshotAndAttachInReport();
                    break;
                case "full screen":
                    js.executeScript("arguments[0].requestFullscreen()", videoElement);
                    Assert.assertTrue((Boolean) (js.executeScript("return document.fullscreenElement !== null", videoElement)));
                    MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("full screen control is working fine"));
                    takeScreenshotAndAttachInReport();
                    js.executeScript("document.exitFullscreen()");
                    break;
                case "playback speed":
                    if (!getbrowserName().contains("Firefox")) {
                        js.executeScript("document.querySelector('video').playbackRate = 1.25;", videoElement);
                        Assert.assertEquals(1.25, js.executeScript("return document.querySelector('video').playbackRate"));
                        MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("playback speed control is working fine"));
                        takeScreenshotAndAttachInReport();
                    }
                    break;
                case "download":
                    if (!getbrowserName().contains("Firefox")) {
                        pressEnter();
                        pressUp();
                        pressUp();
                        pressEnter();
                        Thread.sleep(3000);
                        MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("download control is working fine"));
                        takeDesktopScreenshot();
                    }
                    break;
                case "picture in picture":
                    if (!getbrowserName().contains("Firefox")) {
                        js.executeScript("arguments[0].requestPictureInPicture()", videoElement);
                        Thread.sleep(2000);
                        Assert.assertTrue((Boolean) js.executeScript("return document.pictureInPictureElement !== null;"));
                        MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("picture in picture control is working fine"));
                        takeDesktopScreenshot();
                    }
                    break;
                case "close":
                    clickwithoutlog(NewsAndEventsPageObject.closeVideo);
                    waitForInVisible(NewsAndEventsPageObject.closeVideo);
                    MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("close control is working fine"));
                    takeScreenshotAndAttachInReport();
                    break;
            }

        } catch (Exception e) {
            catchAssertError(e);
        }

    }
}
