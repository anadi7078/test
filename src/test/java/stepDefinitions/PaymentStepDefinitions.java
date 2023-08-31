package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import modules.PaymentPage;

public class PaymentStepDefinitions extends PaymentPage {


    @And("^select \"([^\"]*)\" as the payment method and proceed to payment$")
    public void selectPaymentMethodAndPayment(String paymentMethod) throws InterruptedException {
        selectPaymentMethodAndProceedPayment(paymentMethod);
    }

    @And("^click on \"([^\"]*)\" button in payment page$")
    public void addBillingDetailsButton(String button) {
        addBillingDetailsButtonClick(button);
    }


    @Then("^verify \"([^\"]*)\" contact information details are selected$")
    public void verifyContactInformationDetailsAreSelected(String testDataName) {
        verifyContactInfoDetailsAddedAndSelected(testDataName);
    }

    @And("^verify \"([^\"]*)\" is displayed for the payment page$")
    public void verifyTheIsVisibleForThePage(String verificationParameter) {
        verifyDetailsINPaymentPage(verificationParameter);
    }

    @And("^click on delete entry button in cms$")
    public void clickOnDeleteEntryButtonInCms() {
        deleteCart();
    }
}
