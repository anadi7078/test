package stepDefinitions;

import cucumber.api.java.en.And;
import modules.NewsAndEventsPage;

public class NewsAndEventsStepDefinitions extends NewsAndEventsPage {

    @And("^verify \"([^\"]*)\" is visible for the \"([^\"]*)\" page$")
    public void verifyComponentsNews(String verificationParameter, String page) {
        verificationOfComponents(verificationParameter, page);
    }

    @And("^click on any \"([^\"]*)\" in news section$")
    public void clickOnNews(String news) {
        clickNews(news);
    }

    @And("^click on view all link for \"([^\"]*)\"$")
    public void clickOnFor(String category) {
        viewAllLink(category);
    }

    @And("click on a \"([^\"]*)\" and verify it plays in a pop up window")
    public void clickOnAAndVerifyVideoPopUpIsDisplayed(String type) {
        clickOnVideo(type);
    }

    @And("verify \"([^\"]*)\" control is working fine")
    public void verifyControlIsWorkingFine(String action) {
        videoActions(action);
    }
}
