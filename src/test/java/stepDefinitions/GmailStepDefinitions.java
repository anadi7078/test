package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import modules.GmailPage;
import utilities.ExcelDataUtil;

import java.util.HashMap;

public class GmailStepDefinitions extends GmailPage {
    public static HashMap<String, String> dataMap = new HashMap<>();

    @And("login into \"([^\"]*)\" account")
    public void loginIntoAccount(String TestData) {
        dataMap = ExcelDataUtil.getTestDataWithTestCaseID("SocialMediaCreds", TestData);
        loginGmail(dataMap.get("Username"), dataMap.get("Password"));
    }

    @Then("^verify welcome email is received for \"([^\"]*)\"$")
    public void verifyWelcomeEmailIsReceived(String type) {
        switch (type) {
            case "web":
                welcomeEmailVerificationWeb();
                break;
            case "mobile":
                welcomeEmailVerificationMobile();
                break;
        }
    }

    @Then("^verify reset password email is received for \"([^\"]*)\"$")
    public void verifyResetPasswordEmailIsReceivedFor(String type) {
        switch (type) {
            case "web":
                resetPasswordEmailVerificationWeb();
                break;
            case "mobile":
                resetPasswordEmailVerificationMobile();
                break;

        }
    }

    @Then("^verify order confirmation mail is received for \"([^\"]*)\"$")
    public void verifyOrderConfirmationMailIsReceivedFor(String type) {
        switch (type) {
            case "web":
                orderConfirmationMail();
                break;
            case "mobile":
                orderConfirmationMailMobile();

        }
    }

    @Then("^verify order confirmation mail for \"([^\"]*)\" payment is received$")
    public void verifyOrderConfirmationMailForPaypalIsReceivedFor(String mode) {
        orderConfirmationMailPayment(mode);
    }

}
