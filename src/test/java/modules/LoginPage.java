package modules;

import com.relevantcodes.extentreports.LogStatus;
import org.junit.Assert;
import pages.LoginPageObject;
import runner.MyTestRunner;
import utilities.ExcelDataUtil;
import utilities.HTMLReportUtil;
import utilities.KeywordUtil;

import java.util.HashMap;

public class LoginPage extends KeywordUtil {
    public static HashMap<String, String> dataMap = new HashMap<String, String>();
    public static String password = "";

    /**
     * @Description: This method will create new account
     * @Param: String TestDataName
     * @Created By: Diksha
     * @Date: July 11, 2023
     */
    public static void createAccount(String testDataName) {
        try {
            Long date = System.currentTimeMillis();
            click(LoginPageObject.registerNewAccount, "clicking on register new account button");
            waitForURLContains("register", "user is redirected to the register page");
            takeScreenshotAndAttachInReport();
            scrollingToElementofAPage(LoginPageObject.title, "");
            dataMap = ExcelDataUtil.getTestDataWithTestCaseID("LoginPage", testDataName);
//            String email = (dataMap.get("email").split("@"))[0];
//            String emailDomain = (dataMap.get("email").split("@"))[1];
            inputText(LoginPageObject.email, dataMap.get("email"), "entering email : " + dataMap.get("email"));
            inputText(LoginPageObject.firstname, dataMap.get("firstname"), "entering first name : " + dataMap.get("firstname"));
            inputText(LoginPageObject.lastname, dataMap.get("lastname"), "entering last name : " + dataMap.get("lastname"));
            inputText(LoginPageObject.companyname, dataMap.get("companyname"), "entering company name : " + dataMap.get("companyname"));
            inputText(LoginPageObject.job, dataMap.get("job"), "entering job : " + dataMap.get("job"));
            inputText(LoginPageObject.password, dataMap.get("password"), "entering password");
            inputText(LoginPageObject.confirmpassword, dataMap.get("password"), "entering confirm password");
            clickJS(LoginPageObject.termsCheckbox, "checking terms and conditions checkbox");
            if (mdriver != null) {
                mdriver.hideKeyboard();
                scrollingToElementofAPage(LoginPageObject.title, "");
                takeScreenshotAndAttachInReport();
                scrollingToElementofAPage(LoginPageObject.lastname, "");
                takeScreenshotAndAttachInReport();
                scrollingToElementofAPage(LoginPageObject.confirmpassword, "");
            }
            takeScreenshotAndAttachInReport();
            click(LoginPageObject.registerButton, "clicking on register button");
            waitForInVisible(LoginPageObject.email);
            waitForVisible(LoginPageObject.successPOpup);
            takeScreenshotAndAttachInReport();
            Assert.assertTrue(isWebElementVisible(LoginPageObject.successPOpup, "success pop up is visible"));
            click(LoginPageObject.showCoursesButton, "clicking on show courses button in popup");
            waitForURLContains("courses", "user is redirected to the courses page");
            takeScreenshotAndAttachInReport();

        } catch (Exception e) {

        }
    }

    /**
     * @Description: This method will create new account
     * @Param: String TestDataName
     * @Created By: Diksha
     * @Date: July 11, 2023
     */
    public static void loginAccount(String testDataName) {
        try {
            dataMap = ExcelDataUtil.getTestDataWithTestCaseID("LoginPage", testDataName);
            if (password.equalsIgnoreCase("")) {
                password = dataMap.get("password");
            }
            System.out.println("Password:" + password);
            inputText(LoginPageObject.email, dataMap.get("email"), "entering email : " + dataMap.get("email"));
            inputText(LoginPageObject.password, password, "entering password");
            if (mdriver != null) {
                mdriver.hideKeyboard();
            }
            takeScreenshotAndAttachInReport();
            click(LoginPageObject.registerButton, "clicking on login button");
            if (!testDataName.equalsIgnoreCase("invalid")) {
                waitForInVisible(LoginPageObject.email);
                Assert.assertFalse(isWebElementVisibleWithoutLog(LoginPageObject.email));
                Assert.assertTrue(isWebElementVisible(LoginPageObject.upcomingCoursesButtonHeader, "user is logged in successfully"));
                takeScreenshotAndAttachInReport();
            }
        } catch (Exception e) {
            catchAssertError(e);
        }
    }

    /**
     * @Description: This method will verify unsuccessful message
     * @Created By: Diksha
     * @Date: July 12, 2023
     */
    public static void unsuccessfulLoginMessage() {
        try {
            Boolean status = false;
            waitForVisible(LoginPageObject.unsuccessfulLoginMsg);
            if (getElementText(LoginPageObject.unsuccessfulLoginMsg).equalsIgnoreCase("حدث خطأ. يرجى اعادة المحاولة") ||
                    getElementText(LoginPageObject.unsuccessfulLoginMsg).equalsIgnoreCase("Login was not successful, please try again")) {
                status = true;
            }
            Assert.assertTrue(status);
            takeScreenshotAndAttachInReport();
            MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("unsuccessful login message is displayed and user is not logged in"));
        } catch (Exception e) {
            catchAssertError(e);
        }
    }

    /**
     * @Description: This method will click on reset your password link
     * @Created By: Diksha
     * @Date: July 14, 2023
     */
    public static void resetYourPassword() {
        try {
            waitForVisible(LoginPageObject.resetPasswordLink);
            takeScreenshotAndAttachInReport();
            click(LoginPageObject.resetPasswordLink, "clicking on reset your password link");
            waitForURLContains("forgot-password", "user is redirected to the forgot password page");
            waitTillPageIsCompletelyLoaded();
            waitForVisible(LoginPageObject.email);
            takeScreenshotAndAttachInReport();
        } catch (Exception e) {
            catchAssertError(e);
        }
    }

    /**
     * @Description: This method will enter email and click on reset password button
     * @Param: String testDataName
     * @Created By: Diksha
     * @Date: July 14, 2023
     */
    public static void enterEmailAndResetPassword(String testDataName) {
        try {
            dataMap = ExcelDataUtil.getTestDataWithTestCaseID("LoginPage", testDataName);
            waitForVisible(LoginPageObject.email);
            inputText(LoginPageObject.email, dataMap.get("email"), "entering email : " + dataMap.get("email"));
            if (mdriver != null) {
                mdriver.hideKeyboard();
            }
            takeScreenshotAndAttachInReport();
            clickJS(LoginPageObject.resetPasswordButton, "clicking on reset password button");
            waitForVisible(LoginPageObject.restPasswordSuccessMessage);
            Assert.assertTrue(isWebElementVisible(LoginPageObject.restPasswordSuccessMessage, "success message is displayed"));
            takeScreenshotAndAttachInReport();
        } catch (Exception e) {
            catchAssertError(e);
        }
    }

    /**
     * @Description: This method will enter new password
     * @Param: String testDataName
     * @Created By: Diksha
     * @Date: July 14, 2023
     */
    public static void resetThePassword(String testdataName) {
        try {
            dataMap = ExcelDataUtil.getTestDataWithTestCaseID("LoginPage", testdataName);
            waitForVisible(LoginPageObject.password);
            password = (dataMap.get("password") + System.currentTimeMillis()).replace(" ", "");
            System.out.println("updated password : " + password);
            inputText(LoginPageObject.password, password, "entering password");
            inputText(LoginPageObject.confirmPasswordInResetScreen, password, "entering confirm password");
            if (mdriver != null) {
                mdriver.hideKeyboard();
            }
            takeScreenshotAndAttachInReport();
            click(LoginPageObject.resetPasswordButton, "clicking on reset password button");
            waitForVisible(LoginPageObject.successPOpup);
            takeScreenshotAndAttachInReport();
        } catch (Exception e) {
            catchAssertError(e);
        }
    }

    /**
     * @Description: This method will click on go to login
     * @Created By: Diksha
     * @Date: July 18, 2023
     */
    public static void clickOnGoToLogin() {
        try {
            waitForVisible(LoginPageObject.gotToLoginButton);
            click(LoginPageObject.gotToLoginButton, "clicking on go to login button");
            waitForInVisible(LoginPageObject.gotToLoginButton);
            waitForURLContains("login", "user is redirected to login page");
            takeScreenshotAndAttachInReport();
        } catch (Exception e) {
            catchAssertError(e);
        }
    }
}
