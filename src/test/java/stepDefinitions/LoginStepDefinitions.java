package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import modules.LoginPage;

public class LoginStepDefinitions extends LoginPage {

    @And("^create \"([^\"]*)\" account with valid credentials$")
    public void registerNowButton(String testdataName) {
        createAccount(testdataName);
    }

    @And("^enter \"([^\"]*)\" credentials in login page$")
    public void enterCredentialsInLoginPage(String testDataName) {
        loginAccount(testDataName);
    }

    @Then("^verify unsuccessful login message is displayed$")
    public void verifyUnsuccessfulLoginMessageIsDisplayed() {
        unsuccessfulLoginMessage();
    }

    @Then("^click on reset your password link$")
    public void resetPasswordLink() {
        resetYourPassword();
    }

    @And("^enter \"([^\"]*)\" email and click on reset password button$")
    public void enterEmailAndResetPasswordButton(String testDataName) {
        enterEmailAndResetPassword(testDataName);
    }

    @And("^reset password according to \"([^\"]*)\"$")
    public void resetPassword(String testdataName) {
        resetThePassword(testdataName);
    }

    @And("^click on go to login in the success popup$")
    public void clickGoToLogin() {
        clickOnGoToLogin();
    }
}
