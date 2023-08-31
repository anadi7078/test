package modules;

import com.relevantcodes.extentreports.LogStatus;
import mobileutil.MobileKeywords;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.GmailPageObject;
import runner.MyTestRunner;
import utilities.HTMLReportUtil;
import utilities.KeywordUtil;

public class GmailPage extends KeywordUtil {

    /**
     * @Description: This method will sign in to gmail account
     * @Parameter: String UserName, String Password
     * @Created By: Diksha
     * @Date: July 20, 2023
     */
    public static void loginGmail(String user, String password) {
        try {
            getDriver().get("https://mail.google.com/mail");
            if (mdriver != null) {
                mdriver.context("NATIVE_APP");
                if (MobileKeywords.isWebElementVisible(GmailPageObject.signInMobile, GmailPageObject.xpath)) {
                    MobileKeywords.click(GmailPageObject.signInMobile, GmailPageObject.xpath, "clicking on sign in");
                }
                MobileKeywords.switchToWebBrowserContext();
            } else {
                if (isWebElementVisibleWithoutLog(GmailPageObject.signIN)) {
                    clickwithoutlog(GmailPageObject.signIN);
                }
            }
            waitForVisible(GmailPageObject.UserName);
            MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.infoStringGreenColor("user is navigated to gmail page"));
            inputText(GmailPageObject.UserName, user, "entering username");
            takeScreenshotAndAttachInReport();
            waitForClickable(GmailPageObject.NextButton);
            click(GmailPageObject.NextButton, "clicking on next button");
            inputText(GmailPageObject.Password, password, "entering password");
            takeScreenshotAndAttachInReport();
            waitForClickable(GmailPageObject.NextButton);
            click(GmailPageObject.NextButton, "clicking on next button");
            waitForInVisible(GmailPageObject.NextButton);
            if (isWebElementVisibleWithoutLog(GmailPageObject.useWebVersion)) {
                clickwithoutlog(GmailPageObject.useWebVersion);
            }
            waitForVisible(GmailPageObject.SubjectSearch);
            takeScreenshotAndAttachInReport();
        } catch (Exception e) {
            catchAssertError(e);
        }

    }

    /**
     * @Description: This method will verify the welcome email for web browser
     * @Created By: Diksha
     * @Date: July 20, 2023
     */
    public static void welcomeEmailVerificationWeb() {
        try {

            waitForVisible(GmailPageObject.SubjectSearch);
            inputText(GmailPageObject.SubjectSearch, "Sky News Arabia Academy Registration", "searching for welcome mail");
            getDriver().findElement(GmailPageObject.SubjectSearch).sendKeys(Keys.ENTER);
            while (!isWebElementVisibleWithoutLog(GmailPageObject.openMail)) {
                getDriver().navigate().refresh();
                waitForVisible(GmailPageObject.SubjectSearch);
            }
            waitForVisible(GmailPageObject.openMail);
            takeScreenshotAndAttachInReport();
            click(GmailPageObject.openMail, "opening mail");
            waitForVisible(GmailPageObject.registrationTextInMail);
            if (isWebElementVisibleWithoutLog(GmailPageObject.quotedMail)) {
                clickwithoutlog(GmailPageObject.quotedMail);
            }
            waitForVisible(GmailPageObject.registrationTextInMail);
            takeScreenshotAndAttachInReport();
            Assert.assertTrue(isWebElementVisible(GmailPageObject.registrationTextInMail, "welcome mail is received successfully"));
        } catch (Exception e) {
            catchAssertError(e);
        }
    }

    /**
     * @Description: This method will verify the welcome email for mobile browser
     * @Created By: Diksha
     * @Date: July 20, 2023
     */
    public static void welcomeEmailVerificationMobile() {
        try {
            waitForVisible(GmailPageObject.SubjectSearch);
            inputText(GmailPageObject.SubjectSearch, "Sky News Arabia Academy Registration", "searching for welcome mail");
            getDriver().findElement(GmailPageObject.SubjectSearch).sendKeys(Keys.ENTER);
            while (!isWebElementVisibleWithoutLog(GmailPageObject.openMailPhoneRegistration)) {
                getDriver().navigate().refresh();
                waitForVisible(GmailPageObject.SubjectSearch);
            }
            waitForVisible(GmailPageObject.openMailPhoneRegistration);
            takeScreenshotAndAttachInReport();
            doubleClick(GmailPageObject.openMailPhoneRegistration, "opening mail");
            waitForInVisible(GmailPageObject.openMailPhoneRegistration);
            if (isWebElementVisibleWithoutLog(GmailPageObject.quotedMail)) {
                scrollingToElementofAPage(GmailPageObject.quotedMail, "");
                clickwithoutlog(GmailPageObject.quotedMail);
            }
            waitForVisible(GmailPageObject.registrationTextInMailPhone);
            scrollingToElementofAPage(GmailPageObject.registrationTextInMailPhone, "");
            takeScreenshotAndAttachInReport();
            Assert.assertTrue(isWebElementVisible(GmailPageObject.registrationTextInMailPhone, "welcome mail is received successfully"));
        } catch (Exception e) {
            catchAssertError(e);
        }
    }

    /**
     * @Description: This method will verify the reset password email for web browser and will click on the link
     * @Created By: Diksha
     * @Date: July 20, 2023
     */
    public static void resetPasswordEmailVerificationWeb() {
        try {

            waitForVisible(GmailPageObject.SubjectSearch);
            inputText(GmailPageObject.SubjectSearch, "Sky News Arabia Academy Reset Password ", "searching for reset password mail");
            getDriver().findElement(GmailPageObject.SubjectSearch).sendKeys(Keys.ENTER);

            while (!isWebElementVisibleWithoutLog(GmailPageObject.openMail)) {
                getDriver().navigate().refresh();
                waitForVisible(GmailPageObject.SubjectSearch);
            }
            waitForVisible(GmailPageObject.openMail);
            takeScreenshotAndAttachInReport();
            click(GmailPageObject.openMail, "opening mail");

            waitForVisible(GmailPageObject.resetPassMailWeb);
            scrollingToElementofAPage(GmailPageObject.resetPassMailWeb, "reset password mail is received successfully");
            takeScreenshotAndAttachInReport();
            click(GmailPageObject.resetPasswordLink, "clicking on the link for reset password");
            waitUntilExpectedWindowsToBe(2);
            switchToWindow();
            waitForURLContains("reset-password", "user is redirected to reset password screen");
            takeScreenshotAndAttachInReport();
        } catch (Exception e) {
            catchAssertError(e);
        }
    }

    /**
     * @Description: This method will verify the reset password email for mobile browser and will click on the link
     * @Created By: Diksha
     * @Date: July 20, 2023
     */
    public static void resetPasswordEmailVerificationMobile() {
        try {

            waitForVisible(GmailPageObject.SubjectSearch);
            inputText(GmailPageObject.SubjectSearch, "Sky News Arabia Academy Reset Password ", "searching for reset password mail");
            getDriver().findElement(GmailPageObject.SubjectSearch).sendKeys(Keys.ENTER);

            while (!isWebElementVisibleWithoutLog(GmailPageObject.openMailPhone)) {
                getDriver().navigate().refresh();
                waitForVisible(GmailPageObject.SubjectSearch);
            }
            waitForVisible(GmailPageObject.openMailPhone);
            takeScreenshotAndAttachInReport();
            doubleClick(GmailPageObject.openMailPhone, "opening mail");
            waitForInVisible(GmailPageObject.openMailPhone);
            if (isWebElementVisibleWithoutLog(GmailPageObject.quotedMail)) {
                clickwithoutlog(GmailPageObject.quotedMail);
            }
            waitForVisible(GmailPageObject.resetPasswordMailPhone);
            scrollingToElementofAPage(GmailPageObject.resetPasswordMailPhone, "reset password mail is received successfully");
            takeScreenshotAndAttachInReport();
            click(GmailPageObject.resetPasswordLink, "clicking on the link for reset password");
            waitUntilExpectedWindowsToBe(2);
            switchToWindow();
            waitForURLContains("reset-password", "user is redirected to reset password screen");
            if (isWebElementVisibleWithoutLog(GmailPageObject.youtubeVideoClose))
                clickwithoutlog(GmailPageObject.youtubeVideoClose);
            takeScreenshotAndAttachInReport();
        } catch (Exception e) {
            catchAssertError(e);
        }
    }

    /**
     * @Description: This method will verify the order confirmation email for bank transfer
     * @Created By: Diksha
     * @Date: July 20, 2023
     */
    public static void orderConfirmationMail() {
        try {
            waitForVisible(GmailPageObject.SubjectSearch);
            inputText(GmailPageObject.SubjectSearch, "Sky News Arabia Academy order", "searching for order confirmation mail");
            getDriver().findElement(GmailPageObject.SubjectSearch).sendKeys(Keys.ENTER);
            while (!isWebElementVisibleWithoutLog(GmailPageObject.openMail)) {
                getDriver().navigate().refresh();
                waitForVisible(GmailPageObject.SubjectSearch);
            }
            waitForVisible(GmailPageObject.openMail);
            takeScreenshotAndAttachInReport();
            click(GmailPageObject.openMail, "opening mail");
            waitForVisible(GmailPageObject.transferDetails);
            takeScreenshotAndAttachInReport();
            Assert.assertTrue(isWebElementVisibleWithoutLog(GmailPageObject.transferDetails));
            scrollingToElementofAPage(GmailPageObject.bankDetails, "bank details are visible in order confirmation mail");
            String bankDetail = getElementText(GmailPageObject.bankDetails);
            String AEDTransferDetail = bankDetail.split("For AED transfers")[1].split("For USD and other FCY transfers")[0];
            String USDTransferDetail = bankDetail.split("For USD and other FCY transfers")[1].split("Once the wire transfer")[0];
            MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.infoStringGreenColor("bank details for AED transfers : "));
            MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.infoStringGreenColor(AEDTransferDetail));
            MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.infoStringGreenColor("bank details for USD and other FCY transfers : "));
            MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.infoStringGreenColor(USDTransferDetail));

            takeScreenshotAndAttachInReport();
        } catch (Exception e) {
            catchAssertError(e);
        }
    }

    /**
     * @Description: This method will verify the order confirmation email for mobile browser for bank transfer payment method
     * @Created By: Diksha
     * @Date: July 20, 2023
     */
    public static void orderConfirmationMailMobile() {
        try {
            waitForVisible(GmailPageObject.SubjectSearch);
            inputText(GmailPageObject.SubjectSearch, "Sky News Arabia Academy order", "searching for order confirmation mail");
            getDriver().findElement(GmailPageObject.SubjectSearch).sendKeys(Keys.ENTER);
            while (!isWebElementVisibleWithoutLog(GmailPageObject.openMailPhone)) {
                getDriver().navigate().refresh();
                waitForVisible(GmailPageObject.SubjectSearch);
            }
            waitForVisible(GmailPageObject.openMailPhone);
            takeScreenshotAndAttachInReport();
            doubleClick(GmailPageObject.openMailPhone, "opening mail");
            waitForInVisible(GmailPageObject.openMailPhone);
            waitForVisible(GmailPageObject.transferDetails);
            takeScreenshotAndAttachInReport();
            Assert.assertTrue(isWebElementVisibleWithoutLog(GmailPageObject.transferDetails));
            scrollingToElementofAPage(GmailPageObject.bankDetails, "bank details are visible in order confirmation mail");
            String bankDetail = getElementText(GmailPageObject.bankDetails);
            String AEDTransferDetail = bankDetail.split("For AED transfers")[1].split("For USD and other FCY transfers")[0];
            String USDTransferDetail = bankDetail.split("For USD and other FCY transfers")[1].split("Once the wire transfer")[0];
            MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.infoStringGreenColor("bank details for AED transfers : "));
            MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.infoStringGreenColor(AEDTransferDetail));
            MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.infoStringGreenColor("bank details for USD and other FCY transfers : "));
            MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.infoStringGreenColor(USDTransferDetail));
            takeScreenshotAndAttachInReport();
        } catch (Exception e) {
            catchAssertError(e);
        }
    }

    /**
     * @Description: This method will verify the order confirmation mail for all other payment methods except bank transfer
     * @Param: String paymentMode
     * @Created By: Diksha
     * @Date: July 20, 2023
     */
    public static void orderConfirmationMailPayment(String mode) {
        try {
            waitForVisible(GmailPageObject.SubjectSearch);
            inputText(GmailPageObject.SubjectSearch, "Sky News Arabia Academy order", "searching for order confirmation mail");
            getDriver().findElement(GmailPageObject.SubjectSearch).sendKeys(Keys.ENTER);

            if (mdriver == null) {
                while (!isWebElementVisibleWithoutLog(GmailPageObject.openMail)) {
                    getDriver().navigate().refresh();
                    waitForVisible(GmailPageObject.SubjectSearch);
                }
                waitForVisible(GmailPageObject.openMail);
                takeScreenshotAndAttachInReport();
                click(GmailPageObject.openMail, "opening mail");
            } else {
                while (!isWebElementVisibleWithoutLog(GmailPageObject.openMailPhone)) {
                    getDriver().navigate().refresh();
                    waitForVisible(GmailPageObject.SubjectSearch);
                }
                waitForVisible(GmailPageObject.openMailPhone);
                takeScreenshotAndAttachInReport();
                doubleClick(GmailPageObject.openMailPhone, "opening mail");
                waitForInVisible(GmailPageObject.openMailPhone);
            }
            waitForVisible(GmailPageObject.paymentMethod);
            takeScreenshotAndAttachInReport();
            Assert.assertTrue(isWebElementVisibleWithoutLog(GmailPageObject.paymentMethod));
            Assert.assertTrue(getElementText(GmailPageObject.paymentMethod).contains(mode));
            scrollingToElementofAPage(GmailPageObject.paymentMethod, "order confirmation mail with payment method as " + mode + " is received");
            takeScreenshotAndAttachInReport();
        } catch (Exception e) {
            catchAssertError(e);
        }
    }

}
