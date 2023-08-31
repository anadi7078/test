package modules;

import com.relevantcodes.extentreports.LogStatus;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.HomePageObject;
import pages.PaymentPageObject;
import runner.MyTestRunner;
import utilities.ExcelDataUtil;
import utilities.HTMLReportUtil;
import utilities.KeywordUtil;

import java.util.HashMap;
import java.util.List;

public class PaymentPage extends KeywordUtil {
    public static HashMap<String, String> dataMap = new HashMap<String, String>();
    public static String cartAmountTotal = "";

    /**
     * @Description: This method will select payment methods
     * @Param: Payment method
     * @Created By: Diksha
     * @Date: July 17, 2023
     */

    public static void selectPaymentMethodAndProceedPayment(String paymentMethod) throws InterruptedException {
        try {
            switch (paymentMethod) {
                case "bank transfer":
                    waitForVisible(PaymentPageObject.bankTransferPaymentMethod);
                    click(PaymentPageObject.bankTransferPaymentMethod, "selecting bank transfer payment method");
                    takeScreenshotAndAttachInReport();
                    waitForVisible(PaymentPageObject.placeOrder);
                    click(PaymentPageObject.placeOrder, "clicking on place order button");
                    waitForVisible(PaymentPageObject.orderConfirmationPopup);
                    Assert.assertTrue(isWebElementVisible(PaymentPageObject.orderConfirmationPopup, "order confirmation popup is visible"));
                    takeScreenshotAndAttachInReport();
                    click(PaymentPageObject.goToAccountButtonInPopup, "clicking on go to account in confirmation popup");
                    waitForURLContains("account", "user is redirected to the account page");
                    break;
                case "paypal":
                    waitForVisible(PaymentPageObject.paypalPaymentMethod);
                    waitForClickable(PaymentPageObject.paypalPaymentMethod);
                    click(PaymentPageObject.paypalPaymentMethod, "selecting paypal payment method");
                    waitForVisible(PaymentPageObject.paypalButtons);
                    getDriver().switchTo().frame(getDriver().findElement(PaymentPageObject.paypalFrame));
                    waitForVisible(PaymentPageObject.paypalButton);
                    takeScreenshotAndAttachInReport();
                    click(PaymentPageObject.paypalButton, "clicking on paypal button");
                    getDriver().switchTo().defaultContent();
                    waitUntilExpectedWindowsToBe(2);
                    switchToWindow();
                    getDriver().manage().window().maximize();
                    waitForVisible(PaymentPageObject.paypalEmail);
                    dataMap = ExcelDataUtil.getTestDataWithTestCaseID("SocialMediaCreds", "PayPal");
                    inputText(PaymentPageObject.paypalEmail, dataMap.get("Username"), "entering username : " + dataMap.get("Username"));
                    waitForClickable(PaymentPageObject.paypalNext);
                    takeScreenshotAndAttachInReport();
                    click(PaymentPageObject.paypalNext, "clicking on next button");
                    waitForVisible(PaymentPageObject.paypalPassword);
                    inputText(PaymentPageObject.paypalPassword, dataMap.get("Password"), "entering password");
                    waitForClickable(PaymentPageObject.paypalLoginButton);
                    takeScreenshotAndAttachInReport();
                    click(PaymentPageObject.paypalLoginButton, "clicking on login button");
                    waitForVisible(PaymentPageObject.paypalCompletePayment);
                    waitForClickable(PaymentPageObject.paypalCompletePayment);
                    takeScreenshotAndAttachInReport();
                    click(PaymentPageObject.paypalCompletePayment, "clicking on complete payment button");
                    waitUntilExpectedWindowsToBe(1);
                    switchToParentWindow();
                    waitForVisible(PaymentPageObject.orderConfirmationPopup);
                    Assert.assertTrue(isWebElementVisible(PaymentPageObject.orderConfirmationPopup, "order confirmation popup is visible"));
                    takeScreenshotAndAttachInReport();
                    click(PaymentPageObject.goToAccountButtonInPopup, "clicking on go to account in confirmation popup");
                    waitForURLContains("account", "user is redirected to the account page");
                    break;
                case "paypal button":
                    waitForVisible(PaymentPageObject.paypalPaymentMethod);
                    waitForClickable(PaymentPageObject.paypalPaymentMethod);
                    click(PaymentPageObject.paypalPaymentMethod, "selecting paypal payment method");
                    takeScreenshotAndAttachInReport();
                    waitForVisible(PaymentPageObject.paypalButtons);
                    getDriver().switchTo().frame(getDriver().findElement(PaymentPageObject.paypalFrame));
                    waitForVisible(PaymentPageObject.paypalCreditDebit);
                    takeScreenshotAndAttachInReport();
                    click(PaymentPageObject.paypalCreditDebit, "clicking on Debit or Credit card in paypal");
                    getDriver().switchTo().defaultContent();
                    waitUntilExpectedWindowsToBe(2);
                    switchToWindow();
                    getDriver().manage().window().maximize();
                    dataMap = ExcelDataUtil.getTestDataWithTestCaseID("CardDetails", "valid");
                    System.out.println(dataMap);
                    waitForVisible(PaymentPageObject.payWithPaypalCC);
                    waitTillPageIsCompletelyLoaded();
                    waitForVisible(PaymentPageObject.country);
                    Select dropdown = new Select(getDriver().findElement(PaymentPageObject.country));
                    dropdown.selectByVisibleText(dataMap.get("country"));
                    Thread.sleep(1000);
                    waitTillPageIsCompletelyLoaded();
                    waitForVisible(PaymentPageObject.cardNumber);
                    inputText(PaymentPageObject.cardNumber, dataMap.get("cardNumber"), "entering card number : " + dataMap.get("cardNumber"));
                    pressTabKey();
                    Thread.sleep(2000);
                    waitTillPageIsCompletelyLoaded();
                    waitForVisible(PaymentPageObject.expiryDate);
                    inputText(PaymentPageObject.expiryDate, dataMap.get("expiryDate"), "entering expiry date : " + dataMap.get("expiryDate"));
                    waitForVisible(PaymentPageObject.cvv);
                    inputText(PaymentPageObject.cvv, dataMap.get("cvv"), "entering cvv : " + dataMap.get("cvv"));
                    waitForClickable(PaymentPageObject.firstname);
                    waitForVisible(PaymentPageObject.firstname);
                    inputText(PaymentPageObject.firstname, dataMap.get("firstname"), "entering firstname : " + dataMap.get("firstname"));
                    waitForVisible(PaymentPageObject.lastname);
                    inputText(PaymentPageObject.lastname, dataMap.get("lastname"), "entering lastname : " + dataMap.get("lastname"));
                    takeScreenshotAndAttachInReport();
                    waitForVisible(PaymentPageObject.addressline);
                    inputText(PaymentPageObject.addressline, dataMap.get("addressline1"), "entering address : " + dataMap.get("addressline1"));
                    waitForVisible(PaymentPageObject.billingcity);
                    inputText(PaymentPageObject.billingcity, dataMap.get("town/city"), "entering zipCode : " + dataMap.get("town/city"));
                    waitForVisible(PaymentPageObject.billingstate);
                    Select dropdown2 = new Select(getDriver().findElement(PaymentPageObject.billingstate));
                    dropdown2.selectByVisibleText(dataMap.get("state"));
                    waitForVisible(PaymentPageObject.phonenumbertype);
                    inputText(PaymentPageObject.mobilenumber, dataMap.get("mobileNumber"), "entering  mobile number : " + dataMap.get("mobileNumber"));
                    waitForVisible(PaymentPageObject.emailAddress);
                    inputText(PaymentPageObject.emailAddress, dataMap.get("emailaddress"), "entering email : " + dataMap.get("emailaddress"));
                    takeScreenshotAndAttachInReport();
                    waitForVisible(PaymentPageObject.securitydontwantoption);
                    clickwithoutlog(PaymentPageObject.securitydontwantoption);
                    scrollingToElementofAPage(PaymentPageObject.payNow, "");
                    waitForVisible(PaymentPageObject.privacystatement);
                    clickwithoutlog(PaymentPageObject.privacystatement);
                    takeScreenshotAndAttachInReport();
                    waitForVisible(PaymentPageObject.payNow);
                    clickJS(PaymentPageObject.payNow, "clicking on pay now button");
                    waitUntilExpectedWindowsToBe(1);
                    switchToParentWindow();
                    waitForVisible(PaymentPageObject.orderConfirmationPopup);
                    Assert.assertTrue(isWebElementVisible(PaymentPageObject.orderConfirmationPopup, "order confirmation popup is visible"));
                    takeScreenshotAndAttachInReport();
                    click(PaymentPageObject.goToAccountButtonInPopup, "clicking on go to account in confirmation popup");
                    waitForURLContains("account", "user is redirected to the account page");
                    break;
                case "valid credit/debit card":
                    waitForVisible(PaymentPageObject.creditDebitPaymentMethod);
                    waitForClickable(PaymentPageObject.creditDebitPaymentMethod);
                    click(PaymentPageObject.creditDebitPaymentMethod, "selecting credit/debit card payment method");
                    click(PaymentPageObject.proceedToPaymentButton, "clicking on proceed to payment button");
                    waitForInVisible(PaymentPageObject.proceedToPaymentButton);
                    waitForVisible(PaymentPageObject.paymentDetailsPage);
                    dataMap = ExcelDataUtil.getTestDataWithTestCaseID("CardDetails", "creditCard");
                    scrollingToElementofAPage(PaymentPageObject.creditCardNumber, "");
                    inputText(PaymentPageObject.creditCardNumber, dataMap.get("cardNumber"), "entering card number : " + dataMap.get("cardNumber"));
                    pressTabKey();
                    pressTabKey();
                    pressDown();
                    pressEnter();
                    inputText(PaymentPageObject.cvvCreditCard, dataMap.get("validationCode"), "entering cvv : " + dataMap.get("validationCode"));
                    takeScreenshotAndAttachInReport();
                    clickJS(PaymentPageObject.payButtonCC, "clicking on pay button");
                    if (isWebElementVisibleWithoutLog(PaymentPageObject.payButtonCC)) {
                        clickwithoutlog(PaymentPageObject.payButtonCC);
                    }
                    waitForInVisible(PaymentPageObject.payButtonCC);
                    waitForVisible(PaymentPageObject.transactionProcessing);
                    waitForInVisible(PaymentPageObject.transactionProcessing);
                    waitForURLContains("/payment/", "user is redirected to the application");
                    waitForVisible(PaymentPageObject.orderConfirmationPopup);
                    Assert.assertTrue(isWebElementVisible(PaymentPageObject.orderConfirmationPopup, "order confirmation popup is visible"));
                    takeScreenshotAndAttachInReport();
                    click(PaymentPageObject.goToAccountButtonInPopup, "clicking on go to account in confirmation popup");
                    waitForURLContains("account", "user is redirected to the account page");
                    break;

                case "invalid bank transfer":
                    waitForVisible(PaymentPageObject.bankTransferPaymentMethod);
                    click(PaymentPageObject.bankTransferPaymentMethod, "selecting bank transfer payment method");
                    takeScreenshotAndAttachInReport();
                    waitForVisible(PaymentPageObject.placeOrder);
                    click(PaymentPageObject.placeOrder, "clicking on place order button");
                    waitForVisible(PaymentPageObject.errorMessageINPayment);
                    Assert.assertTrue(isWebElementVisible(PaymentPageObject.errorMessageINPayment, getElementText(PaymentPageObject.errorMessageINPayment) + " message is visible"));
                    break;
                case "invalid credit/debit card":
                    waitForVisible(PaymentPageObject.creditDebitPaymentMethod);
                    waitForClickable(PaymentPageObject.creditDebitPaymentMethod);
                    click(PaymentPageObject.creditDebitPaymentMethod, "selecting credit/debit card payment method");
                    clickJS(PaymentPageObject.proceedToPaymentButton, "clicking on proceed to payment button");
                    waitForInVisible(PaymentPageObject.proceedToPaymentButton);
                    waitForVisible(PaymentPageObject.paymentDetailsPage);
                    dataMap = ExcelDataUtil.getTestDataWithTestCaseID("CardDetails", "invalidCreditCard");
                    scrollingToElementofAPage(PaymentPageObject.creditCardNumber, "");
                    inputText(PaymentPageObject.creditCardNumber, dataMap.get("cardNumber"), "entering card number : " + dataMap.get("cardNumber"));
                    pressTabKey();
                    pressTabKey();
                    pressDown();
                    pressEnter();
                    inputText(PaymentPageObject.cvvCreditCard, dataMap.get("validationCode"), "entering cvv : " + dataMap.get("validationCode"));
                    takeScreenshotAndAttachInReport();
                    clickJS(PaymentPageObject.payButtonCC, "clicking on pay button");
                    if (isWebElementVisibleWithoutLog(PaymentPageObject.payButtonCC)) {
                        clickwithoutlog(PaymentPageObject.payButtonCC);
                    }
                    waitForInVisible(PaymentPageObject.payButtonCC);
                    waitForVisible(PaymentPageObject.transactionProcessing);
                    waitForInVisible(PaymentPageObject.transactionProcessing);
                    if (isWebElementVisibleWithoutLog(PaymentPageObject.otpValue)) {
                        inputText(PaymentPageObject.otpValue, dataMap.get("OTPValue"), "entering OTP : " + dataMap.get("OTPValue"));
                        takeScreenshotAndAttachInReport();
                        clickwithoutlog(PaymentPageObject.continueButton);
                        waitForInVisible(PaymentPageObject.continueButton);
                        waitForURLContains("/payment/", "user is redirected to the application");
                        waitForVisible(PaymentPageObject.errorMessageINPayment);
                        String errorMsg = getElementText(PaymentPageObject.errorMessageINPayment);
                        Assert.assertTrue(isWebElementVisible(PaymentPageObject.errorMessageINPayment, errorMsg + " message is displayed"));
                        waitForVisible(HomePageObject.myAccountMenu);
                    }
                    break;
            }
            takeScreenshotAndAttachInReport();
        } catch (Throwable e) {
            catchAssertError(e);
        }
    }

    public static void deleteCart()
    {
        try {
            if (isWebElementVisibleWithoutLog(PaymentPageObject.gmail)) {
                clickwithoutlog(PaymentPageObject.deleteEntry);
                clickwithoutlog(PaymentPageObject.confirmdelButton);
                waitForInVisible(PaymentPageObject.confirmdelButton);
                waitTillPageIsCompletelyLoaded();
            } else {
                MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("user already deleted"));
            }
            waitForVisible(PaymentPageObject.admin);
            clickwithoutlog(PaymentPageObject.admin);
            waitForVisible(PaymentPageObject.logout);
            clickwithoutlog(PaymentPageObject.logout);
            waitForInVisible(PaymentPageObject.logout);
            waitTillPageIsCompletelyLoaded();
        }
        catch (Throwable e) {
            catchAssertError(e);
        }
    }


    /**
     * @Description: This method will click on add billing details button
     * @Created By: Diksha
     * @Date: July 17, 2023
     */

    public static void addBillingDetailsButtonClick(String text) {

        try {
            switch (text) {
                case "add billing details":
                    waitForVisible(PaymentPageObject.addBillingAddressButton);
                    click(PaymentPageObject.addBillingAddressButton, "clicking on add billing details button");
                    waitForInVisible(PaymentPageObject.addBillingAddressButton);
                    break;
                case "continue payment":
                    waitForVisible(PaymentPageObject.paymentButton);
                    scrollingToElementofAPage(PaymentPageObject.paymentButton, "");
                    takeScreenshotAndAttachInReport();
                    click(PaymentPageObject.paymentButton, "clicking on continue payment button");
                    waitForVisible(PaymentPageObject.paymentMethods);
                    waitTillPageIsCompletelyLoaded();
                    if (isWebElementVisibleWithoutLog(PaymentPageObject.paymentButton)) {
                        clickwithoutlog(PaymentPageObject.paymentButton);
                    }
                    break;
                case "save":
                    waitForVisible(PaymentPageObject.saveButton);
                    clickJS(PaymentPageObject.saveButton, "clicking on save button");
                    waitForInVisible(PaymentPageObject.saveButton);
                    break;
                case "remove button":
                    if (mdriver != null) {
                        hoverOnElement(PaymentPageObject.removebttn);
                    }
                    List<WebElement> courses = getListElements(PaymentPageObject.removebttn, "getting list of courses");
                    takeScreenshotAndAttachInReport();
                    waitForVisible(PaymentPageObject.removebttn);
                    click(PaymentPageObject.removebttn, "clicking on remove button");
                    waitForVisible(PaymentPageObject.confirmdelete);
                    Assert.assertTrue(isWebElementVisible(PaymentPageObject.confirmdelete, "delete confirmation pop up is visible"));
                    click(PaymentPageObject.confirmdelete, "clicking on yes button");
                    waitForInVisible(PaymentPageObject.confirmdelete);
                    Thread.sleep(2000);
                    List<WebElement> coursesAfter = getListElements(PaymentPageObject.removebttn, "getting list of courses");
                    Assert.assertFalse(coursesAfter.size() == courses.size());
                    MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("course is deleted successfully"));

                    break;

            }
            takeScreenshotAndAttachInReport();

        } catch (Exception e) {
            catchAssertError(e);
        }
    }

    /**
     * @Description: This method will verify contact info details added
     * @Param: String TestDataName
     * @Created By: Diksha
     * @Date: July 19, 2023
     */
    public static void verifyContactInfoDetailsAddedAndSelected(String testDataName) {
        try {
            dataMap = ExcelDataUtil.getTestDataWithTestCaseID("ContactDetails", testDataName);
            waitForVisible(By.xpath(PaymentPageObject.fnameLname.replace("%fname%", dataMap.get("firstname")).replace("%lname%", dataMap.get("lastname"))));
            waitForVisible(By.xpath(PaymentPageObject.accountDetail.replace("%text%", dataMap.get("address"))));
            waitForVisible(By.xpath(PaymentPageObject.accountDetail.replace("%text%", dataMap.get("city"))));
            waitForVisible(By.xpath(PaymentPageObject.accountDetail.replace("%text%", dataMap.get("state"))));
            waitForVisible(By.xpath(PaymentPageObject.accountDetail.replace("%text%", dataMap.get("mobile"))));
            Assert.assertTrue(isWebElementVisibleWithoutLog(By.xpath(PaymentPageObject.selectedDetail.replace("%fname%", dataMap.get("firstname")).replace("%lname%", dataMap.get("lastname")))));
            Assert.assertTrue(isWebElementVisibleWithoutLog(By.xpath(PaymentPageObject.fnameLname.replace("%fname%", dataMap.get("firstname")).replace("%lname%", dataMap.get("lastname")))));
            Assert.assertTrue(isWebElementVisibleWithoutLog(By.xpath(PaymentPageObject.accountDetail.replace("%text%", dataMap.get("address")))));
            Assert.assertTrue(isWebElementVisibleWithoutLog(By.xpath(PaymentPageObject.accountDetail.replace("%text%", dataMap.get("city")))));
            Assert.assertTrue(isWebElementVisibleWithoutLog(By.xpath(PaymentPageObject.accountDetail.replace("%text%", dataMap.get("state")))));
            Assert.assertTrue(isWebElementVisibleWithoutLog(By.xpath(PaymentPageObject.accountDetail.replace("%text%", dataMap.get("mobile")))));
            MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("billing details are displayed and selected"));
            if (mdriver != null) {
                scrollingToElementofAPage(PaymentPageObject.title, "");
                takeScreenshotAndAttachInReport();
            }
        } catch (Exception e) {

        }
    }

    /**
     * @Description: This method will verify details for payment page
     * @Param: String verification parameter
     * @Created By: Diksha
     * @Date: July 19, 2023
     */
    public static void verifyDetailsINPaymentPage(String verificationParameter) {
        try {
            switch (verificationParameter) {
                case "billing details":
                    verifyContactInfoDetailsAddedAndSelected("valid");
                    break;
                case "order summary details":
                    scrollingToElementofAPage(PaymentPageObject.addBillingAddressButton, "");
                    Assert.assertTrue(isWebElementVisible(PaymentPageObject.orderSummary, "order summary is visible"));
                    takeScreenshotAndAttachInReport();
                    break;
                case "total amount":
                    cartAmountTotal = getElementText(PaymentPageObject.totalAmount).split(":")[1].trim();
                    System.out.println("cart total:" + cartAmountTotal);
                    Assert.assertTrue(isWebElementVisible(PaymentPageObject.totalAmount, "total amount " + cartAmountTotal + " is visible"));
                    break;
                case "payment methods":
                    Assert.assertTrue(isWebElementVisibleWithoutLog(PaymentPageObject.creditDebitPaymentMethod));
                    Assert.assertTrue(isWebElementVisibleWithoutLog(PaymentPageObject.paypalPaymentMethod));
                    Assert.assertTrue(isWebElementVisibleWithoutLog(PaymentPageObject.bankTransferPaymentMethod));
                    MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("three payment methods are visible"));
                    break;
            }
        } catch (Exception e) {
            catchAssertError(e);
        }
    }
}


