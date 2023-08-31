package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import modules.CartPage;

public class CartStepDefinition extends CartPage {
    @And("^click on checkout button in cart page$")
    public void clickOnCheckoutButtonInCartPage() {
        checkoutButtonClickInCart();
    }

    @And("^verify the \"([^\"]*)\" is visible for the \"([^\"]*)\" page$")
    public void verifyTheIsVisibleForThePage(String verificationParameter, String Page) {
        verifyshoppingcartdetails(verificationParameter, Page);
    }

    @Then("^delete all items present in cart$")
    public void deleteAllItemsPresentInCart() {
        deleteItemsPresent();
    }

    @Then("^delete all courses if present in the cart$")
    public void deleteAllCoursesIfPresentInTheCart() {
        deleteCourseIfPresent();
    }
}
