package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import modules.CMSPage;

public class CMSStepDefinitions extends CMSPage {


    @And("^navigate to \"([^\"]*)\" tab in CMS$")
    public void navigateToTabInCMS(String menu) {
        tabNavigation(menu);
    }

    @Then("^click on clone if number of published \"([^\"]*)\" is less than (\\d+)$")
    public void clickOnCloneIfNumberOfPublishedIsLessThan(String type, int count) {
        cloneItems(type, count);
    }

    @And("^change language to \"([^\"]*)\" in dropdown$")
    public void changeLanguageToInDropdown(String language) {
        changeLanguage(language);
    }

    @And("^login to CMS website$")
    public void loginToCMSWebsite() {
        login();
    }

    @And("^select \"([^\"]*)\" filter$")
    public void selectFilterInSettings(String text) {
        applyFilter(text);
    }

    @And("^search \"([^\"]*)\" in CMS$")
    public void search(String testData) {
        searchEntry(testData);
    }

    @And("^delete an entry in CMS$")
    public void deleteAnEntry() {
        deleteEntry();
    }

    @Then("^clone a published course to have very few seats$")
    public void cloneAPublishedCourseToHaveVeryFewSeats() {
        cloneCourseHavingFewSeats();
    }

    @And("search and delete the course")
    public void searchTheCourse() {
        searchCourse();
    }

    @And("^logout from the CMS application$")
    public void logoutFromTheApplication() {
        logout();
    }

    @And("^search \"([^\"]*)\" in CMS using filter$")
    public void applyFilterUser(String testData) {
        applyFilterForUser(testData);
    }


}
