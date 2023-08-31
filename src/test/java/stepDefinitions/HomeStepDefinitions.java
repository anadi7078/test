package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import modules.HomePage;
import utilities.LayoutUtil;

public class HomeStepDefinitions extends HomePage {

    @Given("^launch the \"([^\"]*)\" website$")
    public void launchTheBusinessWebsite(String testDataName) {
        launchURL(testDataName);
    }

    @Then("^verify that there are no broken \"([^\"]*)\" on the page$")
    public void verifyThatTheLayoutIsNotBroken(String type) throws InterruptedException {
        brokenImagesORLinksVerification(type);
    }

    @Then("^verify the layout is not broken for the page$")
    public void verifyLayoutBroken() {
        if (getbrowserName().contains("Firefox")) {
            System.out.println("Checking broken layout in firefox");
            LayoutUtil.checkLogUsingBrowserMobFireFox(getDriver().getCurrentUrl());
        } else if (getbrowserName().contains("Chrome")) {
            LayoutUtil.checkLogUsingBrowserMob(getDriver().getCurrentUrl());
        }
    }

    @Then("^verify \"([^\"]*)\" is displayed properly$")
    public void verifyRailIsDisplayedProperly(String component) {
        RailProperylyDisplayed(component);
    }

    @And("^click on \"([^\"]*)\" and verify \"([^\"]*)\" is opened$")
    public void clickOnAndVerifyIsOpened(String clickOnItem, String PageOpened) {
        clickAndVerifyRedirection(clickOnItem, PageOpened);
    }

    @When("^verify that the respective page is opening on clicking the menu item from the \"([^\"]*)\"$")
    public static void VerifyRedirectionPage(String format) throws InterruptedException {
        verifyRedirection(format);
    }

    @And("^navigate to \"([^\"]*)\" page from header$")
    public void navigateToPageFromHeader(String menu) {
        clickOnMenu(menu, "header");
    }

    @And("^\"([^\"]*)\" burger menu$")
    public void clickOnBurgerMenu(String action) {
        OpenBurgerMenu(action);
    }

    @And("^navigate to \"([^\"]*)\" from account icon menu$")
    public void navigateToMyAccountFromAccountIconMenu(String menu) {
        navigateToItemsInAccountMenu(menu);
    }

    @And("^navigate back$")
    public void navigateBack() {
        getDriver().navigate().back();
    }
}