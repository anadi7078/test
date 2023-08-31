package modules;

import org.junit.Assert;
import pages.AboutUsPageObject;
import utilities.KeywordUtil;

public class AboutUsPage extends KeywordUtil {

    /**
     * @Description: This method will verify components for the about us page
     * @Parameter: String verificationParameter
     * @Created By: Diksha
     * @Date: July 05, 2023
     */
    public static void verificationOfComponents(String verificationParamter) {
        try {
            switch (verificationParamter) {
                case "header image":
                    if (mdriver == null) {
                        waitForVisible(AboutUsPageObject.headerImage);
                        Assert.assertTrue("header image is not visible", isWebElementVisible(AboutUsPageObject.headerImage, "header image is visible"));
                    } else {
                        waitForVisible(AboutUsPageObject.headerImageMobile);
                        Assert.assertTrue("header image is not visible", isWebElementVisible(AboutUsPageObject.headerImageMobile, "header image is visible"));
                    }
                    break;
                case "title":
                    waitForVisible(AboutUsPageObject.title);
                    Assert.assertTrue("title is not visible", isWebElementVisible(AboutUsPageObject.title, "title is visible"));
                    break;
                case "about us text":
                    scrollingToElementofAPage(AboutUsPageObject.title, "");
                    takeScreenshotAndAttachInReport();
                    waitForVisible(AboutUsPageObject.aboutUsText);
                    Assert.assertTrue("about us text is not visible", isWebElementVisible(AboutUsPageObject.aboutUsText, "about us text is visible"));
                    break;
                case "team":
                    if (isWebElementVisibleWithoutLog(AboutUsPageObject.ourTeam)) {
                        if (!isWebElementVisibleWithoutLog(AboutUsPageObject.visionMission))
                            takeScreenshotAndAttachInReport();
                        waitForVisible(AboutUsPageObject.teamMemberName);
                        if (mdriver != null) {
                            hoverOnElement(AboutUsPageObject.ourTeam);
                            takeScreenshotAndAttachInReport();
                        }
                        Assert.assertTrue("no member is available in team", isWebElementVisible(AboutUsPageObject.teamMemberName, getElementText(AboutUsPageObject.teamMemberName) + "(" + getElementText(AboutUsPageObject.teamMemberDesignation) + ") is present on the team"));
                    }
                    break;
                case "vision and mission":
                    if (isWebElementVisibleWithoutLog(AboutUsPageObject.vision)) {
                        if (mdriver != null) {
                            hoverOnElement(AboutUsPageObject.visionMission);
                        } else {
                            scrollingToElementofAPage(AboutUsPageObject.visionMission, "");
                        }
                        takeScreenshotAndAttachInReport();
                        Assert.assertTrue("no vision is available", isWebElementVisible(AboutUsPageObject.vision, "vision is visible"));
                    }
                    if (isWebElementVisibleWithoutLog(AboutUsPageObject.mission)) {
                        if (mdriver != null) {
                            hoverOnElement(AboutUsPageObject.visionMission);
                        } else {
                            scrollingToElementofAPage(AboutUsPageObject.visionMission, "");
                        }
                        Assert.assertTrue("no mission is available", isWebElementVisible(AboutUsPageObject.mission, "mission is visible"));
                    }
                    break;
            }
        } catch (Exception e) {
            catchAssertError(e);
        }

    }
}
