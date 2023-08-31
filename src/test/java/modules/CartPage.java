package modules;

import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.CartPageObject;
import runner.MyTestRunner;
import utilities.HTMLReportUtil;
import utilities.KeywordUtil;

import java.util.List;

public class CartPage extends KeywordUtil {

    /**
     * @Description: This method will click on checkout button in cart page
     * @Created By: Diksha
     * @Date: July 17, 2023
     */

    public static void checkoutButtonClickInCart() {

        try {
            waitForVisible(CartPageObject.checkoutButton);
            scrollingToElementofAPage(CartPageObject.checkoutButton, "");
            takeScreenshotAndAttachInReport();
            click(CartPageObject.checkoutButton, "clicking on checkout button in cart page");
            waitForVisible(CartPageObject.paymentButton);

        } catch (Exception e) {
            catchAssertError(e);
        }
    }

    /**
     * @Description: This method will verify Shopping cart details
     * @Created By: Mehak
     * @Date: July 18, 2023
     */
    public static void verifyshoppingcartdetails(String verificationParameter, String Page) {
        try {
            switch (verificationParameter) {
                case "cart empty":
                    waitForVisible(CartPageObject.cartempty);
                    String cartEmptymsg = getElementText(CartPageObject.cartempty);
                    Assert.assertTrue(isWebElementVisible(CartPageObject.cartempty, cartEmptymsg + " message is displayed"));
                    Assert.assertFalse(isWebElementVisibleWithoutLog(CartPageObject.checkoutButton));
                    MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("checkout button is not visible"));
                    break;

                case "shopping cart details":
                    Assert.assertTrue(isWebElementVisible(CartPageObject.shoppingpageimage, "shopping page header image is visible"));
                    String shoppingCartText = getElementText(CartPageObject.shoppingcarttext);
                    Assert.assertTrue(isWebElementVisible(CartPageObject.course, shoppingCartText + " title is visible"));
                    List<WebElement> coursesList = getListElements(CartPageObject.coursesrowsize, "getting list of rows");
                    MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("no of courses present in the shopping cart is " + coursesList.size()));
                    List<WebElement> courseTitle = getListElements(CartPageObject.course, "getting list of courses title");
                    Assert.assertTrue(coursesList.size() == courseTitle.size(), "courses title is showing for all the courses added in the cart ");
                    MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("courses title is showing for all the courses added in the cart "));
                    List<WebElement> unitPrice = getListElements(CartPageObject.unitprice, "getting list of unit price");
                    Assert.assertTrue(coursesList.size() == unitPrice.size(), "unit price is showing for all the courses added in the cart");
                    MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("unit price is showing for all the courses added in the cart"));
                    List<WebElement> quantity = getListElements(CartPageObject.quantity, "getting list of quantity");
                    Assert.assertTrue(coursesList.size() == quantity.size(), "quantity is showing for all the courses added in the cart");
                    MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("quantity is showing for all the courses added in the cart"));
                    List<WebElement> total = getListElements(CartPageObject.total, "getting list of unit price");
                    Assert.assertTrue(coursesList.size() == total.size(), "total is showing for all the courses added in the cart");
                    MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("total is showing for all the courses added in the cart"));
                    String removeButton = getElementText(CartPageObject.removebttn);
                    Assert.assertTrue(isWebElementVisible(CartPageObject.removebttn, removeButton + " button is visible for all the courses added in the cart"));
                    String finalTotal = getElementText(CartPageObject.correcttotal);
                    System.out.println("Total amount: " + finalTotal + " USD");
                    finalTotal = finalTotal.split(":")[1];
                    Assert.assertTrue(isWebElementVisible(CartPageObject.correcttotal, finalTotal + " amount is visible"));
                    String finalCheckout = getElementText(CartPageObject.finalcheckout);
                    Assert.assertTrue(isWebElementVisible(CartPageObject.finalcheckout, finalCheckout + " button is visible"));
                    if (mdriver != null) {
                        hoverOnElement(CartPageObject.finalcheckout);
                        takeScreenshotAndAttachInReport();
                    }
                    break;
            }
        } catch (Exception e) {
            catchAssertError(e);
        }
    }


    /**
     * @Description: This method will delete all the courses if present the cart page
     * @Created By: Mehak
     * @Date: July 18, 2023
     */
    public static void deleteCourseIfPresent() {
        if (isWebElementVisibleWithoutLog(CartPageObject.removebttn)) {
            List<WebElement> courses = getListElements(CartPageObject.removebttn, "getting list of courses");
            for (int i = 1; i <= courses.size(); i++) {
                waitForVisible(CartPageObject.removebttn);
                clickwithoutlog(CartPageObject.removebttn);
                waitForVisible(CartPageObject.confirmdelete);
                clickwithoutlog(CartPageObject.confirmdelete);
                waitForInVisible(CartPageObject.confirmdelete);
            }
            waitForInVisible(CartPageObject.removebttn);
            takeScreenshotAndAttachInReport();
            MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("all items in the cart are deleted successfully"));
        } else {
            MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("there are no courses present in cart"));
        }
    }


    public static void deleteItemsPresent() {
        List<WebElement> courses = getListElements(CartPageObject.removebttn, "getting list of courses");
        for (int i = 1; i <= courses.size(); i++) {
            waitForVisible(CartPageObject.removebttn);
            clickwithoutlog(CartPageObject.removebttn);
            waitForVisible(CartPageObject.confirmdelete);
            clickwithoutlog(CartPageObject.confirmdelete);
            waitForInVisible(CartPageObject.confirmdelete);
        }
        waitForInVisible(CartPageObject.removebttn);
        takeScreenshotAndAttachInReport();
        MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("all items in the cart are deleted successfully"));

    }
}




