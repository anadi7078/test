package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import modules.CoursesPage;

public class CoursesStepDefinitions extends CoursesPage {

    @And("^click on more details button of any course and verify respective page is opened$")
    public void clickOnMoreDetailsButtonOfAnyCourse() {
        moreDetailsButton();
    }

    @Then("verify \"([^\"]*)\" is displayed for courses page")
    public void verifyAreDisplayedForCoursesPage(String verificationParameter) {
        verificationOfComponents(verificationParameter);
    }

    @And("^click on more details button of any course$")
    public void clickOnMoreDetailsButton() {
        ClickMoreDetailsButton();
    }

    @And("^click on \"([^\"]*)\" social icon$")
    public void clickOnSocialIconInVideoPage(String socialMediaIcon) {
        ClickSocialIcons(socialMediaIcon);
    }

    @Then("^verify search results when filtered by \"([^\"]*)\"$")
    public void verifyCoursesDisplayedAccordingTo(String data) {
        searchCourses(data);
    }

    @Then("^click on filter docking arrow and verify filtering section is docked$")
    public void clickOnFilterDockingArrow() {
        clickOnFilterDockingArrowMobile();
    }

    @And("^search for the created course$")
    public void searchForTheCreatedCourse() {
        searchCourses();
    }

    @And("^click on enroll button and verify \"([^\"]*)\" is displayed$")
    public void clickOnEnrollButtonAndCheckout(String verificationPage) {
        enrollAndVerify(verificationPage);
    }

    @And("^click on more details button of the course$")
    public void clickOnMoreDetailsButtonOfTheCourse() {
        clickMoreDetailsButton();
    }
}
