package pages;

import org.openqa.selenium.By;

public class AccountPageObject {
    public static By addContactInfoButton = By.xpath("//a[contains(@href,'contact-information')]");
    public static By cancelButton = By.xpath("//input[@type='button' and @value='Cancel' or @value='إلغــاء']");
    public static By title = By.xpath("//div[@class='hero_comp comp']//span[contains(@class,'hero_comp_media_content_text_line_')]");
    public static By shortname = By.id("shortname");
    public static By firstname = By.id("firstName");
    public static By lastname = By.id("lastName");
    public static By email = By.id("email");
    public static By address = By.id("address");
    public static By city = By.id("city");
    public static By state = By.id("province");
    public static By zipCode = By.id("zipCode");
    public static By mobile = By.id("mobile");
    public static By phone = By.id("phone");
    public static By saveButton = By.xpath("//button[text()='Save' or text()='حـــفظ']");
    public static String fnameLname = "//div[text()='%fname%' and text()='%lname%']";
    public static String accountDetail = "//div[text()='%text%']";
    public static By contactInfo = By.xpath("//h2[text()='Contact Info' or text()='بيانات التواصل']");
    public static By titlePage = By.xpath("//div[@class='hero_comp comp']//span[contains(@class,'hero_comp_media_content_text_line_')]");
    public static By deleteDetails = By.xpath("//button[text()='remove' or text()='حذف']");
    public static By yesButton = By.className("confirm_popup_primary_btn");
    public static By contactDetails = By.xpath("//button[text()='remove' or text()='حذف']//ancestor::table");
    public static By orderPayment = By.xpath("//tbody//tr//td[4]");
    public static By paymentMethod = By.xpath("//tbody//tr//td[5]");
    public static By order = By.xpath("//h1[text()='الاشتراكات' or text()='Your Orders']");

    public static By deleteDetails(int index) {
        return By.xpath("(//button[text()='remove' or text()='حذف'])[" + index + "]");
    }


}
