package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import modules.TrainersPage;

public class TrainersStepDefinitions extends TrainersPage {

    @And("^verify \"([^\"]*)\" is visible for the trainers page$")
    public void verifyIsOpenedAlongWithAllOfItsComponents(String listingPageComponents) {
        trainersPage(listingPageComponents);
    }

    @Then("^verify that filtering criteria Trainer Name and By Category is visible$")
    public void verifyThatFilteringCriteriaTrainerNameandByCategoryIsVisible() {
        trainersfilteringCreteria();
    }

    @Then("^verify search result when filtered by \"([^\"]*)\"$")
    public void verifySearchResultWhenFilteredBy(String data) {
        TrainerCategory(data);
    }


    @Then("^unselect one or more of the categories$")
    public void unselectOneOrMoreOfTheCategories() {
        unselectcategorgy();
    }

    @Then("^click on any trainer and verify trainer's detail page is opened$")
    public void clickOnAnyTrainerAndVerifyTrainerSDetailPageIsOpened() throws InterruptedException {
        verifytrainerdetailpage();

    }

    @Then("^click on any trainer image and verify trainer's detail page$")
    public void clickOnAnyTrainerImageAndVerifySearchResultWhenFilteredBy() {
        verifyallcomponentsoftrainer();
    }
}
