package stepDefinitions;

import cucumber.api.java.en.And;
import modules.AboutUsPage;

public class AboutUsStepDefinitions extends AboutUsPage {

    @And("^verify \"([^\"]*)\" is visible for the about us page$")
    public void verifyComponents(String verificationParameter) {
        verificationOfComponents(verificationParameter);
    }

}
