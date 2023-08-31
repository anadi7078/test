package pages;

import org.openqa.selenium.By;

public class CMSPageObject {

    public static By publishedItems = By.xpath("//p[text()='Published']");
    public static By title = By.xpath("//div[@class='hero_comp comp']//span[contains(@class,'hero_comp_media_content_text_line_')]");
    public static By clonePublished = By.xpath("//p[text()='Published']//ancestor::tr//button//*[not(@data-icon='pencil-alt') and not(@data-icon='trash-alt') and @width]");
    public static By languageDropdown = By.xpath("//button[@font-weight='semiBold']");
    public static By email = By.id("email");
    public static By password = By.id("password");
    public static By loginButton = By.xpath("//button[text()='Log in']");
    public static By hiSystem = By.xpath("//h2[text()='Hi System!']");
    public static By searchBox = By.xpath("//input[@placeholder='Search...']");
    public static By filter = By.xpath("//button[@type='button']//div//*[@data-icon='cog']");
    public static By configureView = By.xpath("//span[text()='Configure the view']");
    public static By typeInFilter = By.xpath("//label[text()='type']//parent::div//input");
    public static By typeFilter = By.xpath("//span[text()='Type']");
    public static By filters = By.xpath("//button//span[text()='Filters']");
    public static By filterOpen = By.xpath("//span[text()='Set the conditions to apply to filter the entries']");
    public static By dropdown = By.xpath("//select[@id='0.name']");
    public static By dropdownType = By.xpath("//select[@id='0.value']");
    public static By valueEmail = By.xpath("//input[@id='0.value']");
    public static By applyFilter = By.xpath("//span[text()='Apply']");
    public static By searchAnEntry = By.xpath("//input[@placeholder='Search for an entry...']");
    public static By deleteEntry = By.xpath("//button//*[@data-icon='trash-alt']");
    public static By oneEntry = By.xpath("//p[text()='1 entry found']");
    public static By noEntryFound = By.xpath("//p[text()='0 entry found']");
    public static By seatsInCourse = By.id("seats");
    public static By price = By.id("price");
    public static By courseName = By.id("title");
    public static By startDate = By.id("startDate");
    public static By endDate = By.id("endDate");
    public static By calendarNextMonth = By.xpath("//div[@aria-label='Move forward to switch to the next month.']");
    public static By calendarSelectDateStart = By.xpath("//div[@class='CalendarMonth CalendarMonth_1' and @data-visible='true']//table//tbody//tr//td[@class]");
    public static By calendarSelectDateEnd = By.xpath("(//div[@class='CalendarMonth CalendarMonth_1' and @data-visible='true']//table//tbody//tr//td[@class])[last()]");
    public static By editingPublishedVersion = By.xpath("//p[text()='published version']");
    public static By systemAdmin = By.xpath("//div[@class='btn-group']//button");
    public static By logout = By.xpath("//button[@role='menuitem']//span[text()='Logout']");
    public static By clonePublishedCourse = By.xpath("//span[contains(@data-for,'category') and not (@data-tip='-')]//ancestor::tr//p[text()='Published']//ancestor::tr//button//*[not(@data-icon='pencil-alt') and not(@data-icon='trash-alt') and @width]");


    public static By spanText(String text) {
        return By.xpath("//span[text()='" + text + "']");
    }

    public static By headerPage(String tab) {
        return By.xpath("//h1[text()='" + tab + "']");
    }

    public static By button(String text) {
        return By.xpath("//button[text()='" + text + "']");
    }

    public static By languageSelected(String language) {
        return By.xpath("//p[text()='" + language + "' and @color='greyDark']");
    }

    public static By languageToSelect(String language) {
        return By.xpath("//p[text()='" + language + "' and @color='greyDark']");
    }

    public static By search(String language) {
        return By.xpath("//span[text()='" + language + "']//parent::div//button//*[@data-icon='search']");
    }


}
