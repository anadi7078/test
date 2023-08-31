package pages;

import org.openqa.selenium.By;

public class LoginPageObject {

    public static By registerNewAccount = By.xpath("//a[contains(@href,'register')]");
    public static By title = By.xpath("//div[@class='hero_comp comp']//span[contains(@class,'hero_comp_media_content_text_line_')]");
    public static By email = By.id("email");
    public static By firstname = By.id("firstname");
    public static By lastname = By.id("lastname");
    public static By companyname = By.id("companyname");
    public static By job = By.id("job");
    public static By password = By.id("password");
    public static By confirmpassword = By.id("confirmpassword");
    public static By termsCheckbox = By.id("privacy");
    public static By registerButton = By.xpath("//button[@type='submit']");
    public static By successPOpup = By.className("confirm_popup_header");
    public static By showCoursesButton = By.className("confirm_popup_primary_btn");
    public static By resetPasswordLink = By.xpath("//a[contains(@href,'forgot-password')]");
    public static By unsuccessfulLoginMsg = By.xpath("//div[@class='alert alert-danger']//p");
    public static By resetPasswordButton = By.xpath("//button[@type='submit']");
    public static By restPasswordSuccessMessage = By.xpath("//div[@class='alert alert-info']//p");
    public static By gotToLoginButton = By.xpath("//a[@class='confirm_popup_primary_btn' and contains(@href,'login')]");
    public static By confirmPasswordInResetScreen = By.id("confirmPassword");
    public static By upcomingCoursesButtonHeader = By.xpath("//a[contains(@class,'hero_comp_media') and contains(@href,'courses')]");


}
