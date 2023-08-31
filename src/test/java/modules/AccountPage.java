package modules;

import com.relevantcodes.extentreports.LogStatus;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import pages.AccountPageObject;
import runner.MyTestRunner;
import utilities.ExcelDataUtil;
import utilities.HTMLReportUtil;
import utilities.KeywordUtil;

import java.util.HashMap;
import java.util.List;

import static modules.PaymentPage.cartAmountTotal;

public class AccountPage extends KeywordUtil {
    public static HashMap<String, String> dataMap = new HashMap<String, String>();

    /**
     * @Description: This method will click on the button
     * @Param: text
     * @Created By: Diksha
     * @Date: July 12, 2023
     */
    public static void clickOnButtonInAccount(String text) {
        try {
            switch (text) {
                case "add new contact information":
                    waitForVisible(AccountPageObject.addContactInfoButton);
                    scrollingToElementofAPage(AccountPageObject.addContactInfoButton, "");
                    click(AccountPageObject.addContactInfoButton, "clicking on add new contact information button");
                    waitForInVisible(AccountPageObject.addContactInfoButton);
                    waitForURLContains("contact", "user is redirected to the contact information page");
                    takeScreenshotAndAttachInReport();
                    break;
                case "cancel":
                    scrollingToElementofAPage(AccountPageObject.cancelButton, "");
                    waitForVisible(AccountPageObject.cancelButton);
                    takeScreenshotAndAttachInReport();
                    click(AccountPageObject.cancelButton, "clicking on cancel button");
                    waitForInVisible(AccountPageObject.cancelButton);
                    waitForURLContains("account", "user is redirected to the account page");
                    takeScreenshotAndAttachInReport();
                    break;
                case "save":
                    scrollingToElementofAPage(AccountPageObject.saveButton, "");
                    waitForVisible(AccountPageObject.saveButton);
                    click(AccountPageObject.saveButton, "clicking on save button");
                    waitForInVisible(AccountPageObject.saveButton);
                    waitForURLContains("account", "user is redirected to the account page");
                    waitTillPageIsCompletelyLoaded();
                    waitForVisible(AccountPageObject.deleteDetails);
                    waitForVisible(AccountPageObject.order);
                    takeScreenshotAndAttachInReport();
                    break;
                case "delete":
                    List<WebElement> details = getListElements(AccountPageObject.deleteDetails, "getting list of details present");
                    if (details.isEmpty()) {
                        MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("no contact details are present in the account"));

                    } else {
                        for (int i = 1; i <= details.size(); i++) {
                            clickwithoutlog(AccountPageObject.deleteDetails);
                            waitForVisible(AccountPageObject.yesButton);
                            clickwithoutlog(AccountPageObject.yesButton);
                        }
                        waitForInVisible(AccountPageObject.deleteDetails);
                        takeScreenshotAndAttachInReport();
                        MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("added contact details are deleted successfully as part of pre requisite script"));
                    }
                    break;
                case "remove":
                    List<WebElement> contactAddedListBefore = getListElements(AccountPageObject.deleteDetails, "getting list of details present");
                    for (int i = 1; i <= contactAddedListBefore.size(); i++) {
                        click(AccountPageObject.deleteDetails, "clicking on remove button for " + i + " information");
                        waitForVisible(AccountPageObject.yesButton);
                        takeScreenshotAndAttachInReport();
                        click(AccountPageObject.yesButton, "clicking on yes button in remove popup");
                        waitForInVisible(AccountPageObject.yesButton);
                        waitForVisible(AccountPageObject.addContactInfoButton);
                    }
                    waitForInVisible(AccountPageObject.deleteDetails);
                    scrollingToElementofAPage(AccountPageObject.contactInfo, "");
                    Assert.assertFalse(isWebElementVisibleWithoutLog(AccountPageObject.deleteDetails));

                    MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("details are deleted successfully"));
                    takeScreenshotAndAttachInReport();
                    break;
            }
        } catch (Exception e) {
            catchAssertError(e);
        }
    }

    /**
     * @Description: This method will fill new contact info details
     * @Param: String TestDataName
     * @Created By: Diksha
     * @Date: July 12, 2023
     */
    public static void addContactInfoDetails(String testDataName) {
        try {
            dataMap = ExcelDataUtil.getTestDataWithTestCaseID("ContactDetails", testDataName);
            inputText(AccountPageObject.shortname, dataMap.get("shortname"), "entering shortname : " + dataMap.get("shortname"));
            inputText(AccountPageObject.firstname, dataMap.get("firstname"), "entering first name : " + dataMap.get("firstname"));
            inputText(AccountPageObject.lastname, dataMap.get("lastname"), "entering last name : " + dataMap.get("lastname"));
            inputText(AccountPageObject.email, dataMap.get("email"), "entering email : " + dataMap.get("email"));
            inputText(AccountPageObject.address, dataMap.get("address"), "entering address : " + dataMap.get("address"));
            inputText(AccountPageObject.city, dataMap.get("city"), "entering city : " + dataMap.get("city"));
            inputText(AccountPageObject.state, dataMap.get("state"), "entering state : " + dataMap.get("state"));
            inputText(AccountPageObject.zipCode, dataMap.get("zipCode"), "entering zipCode : " + dataMap.get("zipCode"));
            inputText(AccountPageObject.mobile, dataMap.get("mobile"), "entering mobile : " + dataMap.get("mobile"));
            inputText(AccountPageObject.phone, dataMap.get("phone"), "entering phone : " + dataMap.get("phone"));


            if (mdriver != null) {
                mdriver.hideKeyboard();
                scrollingToElementofAPage(AccountPageObject.title, "");
                takeScreenshotAndAttachInReport();
                scrollingToElementofAPage(AccountPageObject.email, "");
                takeScreenshotAndAttachInReport();
                scrollingToElementofAPage(AccountPageObject.zipCode, "");
            }
            takeScreenshotAndAttachInReport();

        } catch (Exception e) {

        }
    }

    /**
     * @Description: This method will verify contact info details added
     * @Param: String TestDataName
     * @Created By: Diksha
     * @Date: July 12, 2023
     */
    public static void verifyContactInfoDetails(String testDataName) {
        try {
            scrollingToElementofAPage(AccountPageObject.contactInfo, "");
            dataMap = ExcelDataUtil.getTestDataWithTestCaseID("ContactDetails", testDataName);
            waitForVisible(By.xpath(AccountPageObject.fnameLname.replace("%fname%", dataMap.get("firstname")).replace("%lname%", dataMap.get("lastname"))));
            waitForVisible(By.xpath(AccountPageObject.accountDetail.replace("%text%", dataMap.get("address"))));
            waitForVisible(By.xpath(AccountPageObject.accountDetail.replace("%text%", dataMap.get("city"))));
            waitForVisible(By.xpath(AccountPageObject.accountDetail.replace("%text%", dataMap.get("state"))));
            waitForVisible(By.xpath(AccountPageObject.accountDetail.replace("%text%", dataMap.get("mobile"))));
            Assert.assertTrue(isWebElementVisibleWithoutLog(By.xpath(AccountPageObject.fnameLname.replace("%fname%", dataMap.get("firstname")).replace("%lname%", dataMap.get("lastname")))));
            Assert.assertTrue(isWebElementVisibleWithoutLog(By.xpath(AccountPageObject.accountDetail.replace("%text%", dataMap.get("address")))));
            Assert.assertTrue(isWebElementVisibleWithoutLog(By.xpath(AccountPageObject.accountDetail.replace("%text%", dataMap.get("city")))));
            Assert.assertTrue(isWebElementVisibleWithoutLog(By.xpath(AccountPageObject.accountDetail.replace("%text%", dataMap.get("state")))));
            Assert.assertTrue(isWebElementVisibleWithoutLog(By.xpath(AccountPageObject.accountDetail.replace("%text%", dataMap.get("mobile")))));
            MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("added details are displayed"));
            takeScreenshotAndAttachInReport();

        } catch (Exception e) {

        }
    }

    /**
     * @Description: This method will verify add new info button is not visible
     * @Created By: Diksha
     * @Date: July 12, 2023
     */
    public static void verifyAddInfoButton() {
        try {
            scrollingToElementofAPage(AccountPageObject.contactInfo, "");
            waitForInVisible(AccountPageObject.addContactInfoButton);
            Assert.assertFalse(isWebElementVisibleWithoutLog(AccountPageObject.addContactInfoButton));
            MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("add new contact information button is not visible as user cannot add more than two contact information"));
            takeScreenshotAndAttachInReport();

        } catch (Exception e) {
            catchAssertError(e);

        }
    }

    /**
     * @Description: This method will add contact information only if no contact info is there
     * @Created By: Diksha
     * @Date: July 18, 2023
     */
    public static void addContactDetailsIfNotPresent() {
        try {
            if (!isWebElementVisibleWithoutLog(AccountPageObject.deleteDetails)) {
                clickOnButtonInAccount("add new contact information");
                addContactInfoDetails("valid");
                clickOnButtonInAccount("save");
            } else {
                scrollingToElementofAPage(AccountPageObject.contactDetails, "");
                MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("contact details are already present"));
                takeScreenshotAndAttachInReport();
            }
        } catch (Exception e) {
            catchAssertError(e);
        }
    }

    /**
     * @Description: This method will verify the newly created order
     * @Created By: Diksha
     * @Date: July 19, 2023
     */
    public static void verifyNewOrderGettingDisplayed() {
        try {
            scrollingToElementofAPage(AccountPageObject.title, "");
            waitForVisible(AccountPageObject.orderPayment);
            if (mdriver != null) {
                mdriver.rotate(ScreenOrientation.LANDSCAPE);
                hoverOnElement(AccountPageObject.orderPayment);
            }
            Assert.assertEquals(getElementText(AccountPageObject.orderPayment), cartAmountTotal);
            MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("newly created order having amount as " + cartAmountTotal + " is visible in my account page"));
            takeScreenshotAndAttachInReport();
            if (mdriver != null) {
                mdriver.rotate(ScreenOrientation.PORTRAIT);
            }
        } catch (Exception e) {
            catchAssertError(e);
        }
    }

    /**
     * @Description: This method will verify the newly created order
     * @Created By: Diksha
     * @Date: July 19, 2023
     */
    public static void verifyNewOrderGettingDisplayedWithPaymentMethod(String mode) {
        try {
            scrollingToElementofAPage(AccountPageObject.title, "");
            waitForVisible(AccountPageObject.paymentMethod);
            if (mdriver != null) {
                mdriver.rotate(ScreenOrientation.LANDSCAPE);
                hoverOnElement(AccountPageObject.paymentMethod);
            }
            if (mode.equalsIgnoreCase("Paypal") && getCurrentUrl().contains("/ar/account")) {
                Assert.assertEquals(getElementText(AccountPageObject.paymentMethod), "باي بال");
            } else if (mode.equalsIgnoreCase("Credit/Debit Card") && getCurrentUrl().contains("/ar/account")) {
                Assert.assertEquals(getElementText(AccountPageObject.paymentMethod), "بطاقة ائتمان");
            } else if (mode.equalsIgnoreCase("Payment Error") && getCurrentUrl().contains("/ar/account")) {
                Assert.assertEquals(getElementText(AccountPageObject.paymentMethod), "خطأ في الدفع");
            } else {
                Assert.assertEquals(getElementText(AccountPageObject.paymentMethod), mode);
            }

            MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("newly created order having payment method as " + mode + " is visible in my account page"));
            takeScreenshotAndAttachInReport();
            if (mdriver != null) {
                mdriver.rotate(ScreenOrientation.PORTRAIT);
            }
        } catch (Exception e) {
            catchAssertError(e);
        }
    }
}
