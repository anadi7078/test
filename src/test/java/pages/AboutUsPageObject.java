package pages;

import org.openqa.selenium.By;

public class AboutUsPageObject {

    public static By headerImage = By.xpath("//div[@class='hero_comp comp']//img[@role='presentation']");
    public static By title = By.xpath("//div[@class='hero_comp comp']//span[contains(@class,'hero_comp_media_content_text_line_')]");
    public static By aboutUsText = By.xpath("//div[@class='article_body']//p");
    public static By aboutUsHeader = By.xpath("//h1[@class='page_title']");
    public static By ourTeam = By.xpath("//div[@class='our_team']");
    public static By teamMemberName = By.xpath("//div[@class='our_team']//div[@class='our_team_inner_col']//h3");
    public static By teamMemberDesignation = By.xpath("//div[@class='our_team']//div[@class='our_team_inner_col']//h3//following::span");
    public static By vision = By.xpath("//div[@class='aboutus_vision ']//p");
    public static By mission = By.xpath("//div[@class='aboutus_mission']//p");
    public static By visionMission = By.xpath("//div[@class='aboutus_vision_and_mission']");
    public static By headerImageMobile = By.xpath("(//div[@class='hero_comp comp']//img)[last()]");


}
