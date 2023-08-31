package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import modules.AccountPage;

public class AccountStepDefinitions extends AccountPage {


    @And("^click on \"([^\"]*)\" button$")
    public void clickOnButton(String buttonText) {
        clickOnButtonInAccount(buttonText);
    }

    @And("^fill \"([^\"]*)\" contact information details$")
    public void addContactInformationDetails(String testdataName) {
        addContactInfoDetails(testdataName);
    }

    @And("^verify \"([^\"]*)\" contact information details$")
    public void verifyContactInformationDetails(String testdataName) {
        verifyContactInfoDetails(testdataName);
    }

    @And("^delete already added contact details if any$")
    public void deleteAlreadyAddedContactDetailsIfAny() {
        clickOnButtonInAccount("delete");
    }

    @Then("^verify add new contact information button is not displayed$")
    public void verifyAddNewContactInformationButtonIsNotDisplayed() {
        verifyAddInfoButton();
    }

    @And("^add contact information details if not present$")
    public void addContactInformationDetails() {
        addContactDetailsIfNotPresent();
    }

    @Then("^verify new order is displayed in the account page$")
    public void verifyNewOrderIsDisplayedInTheAccountPage() {
        verifyNewOrderGettingDisplayed();
    }

    @Then("^verify new order is displayed with payment method as \"([^\"]*)\" in the account page$")
    public void verifyNewOrderIsDisplayedInTheAccountPagePaymentMode(String paymentMode) {
        verifyNewOrderGettingDisplayedWithPaymentMethod(paymentMode);
    }
}
