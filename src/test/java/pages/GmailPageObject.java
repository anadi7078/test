package pages;

import org.openqa.selenium.By;

public class GmailPageObject {
    public static By UserName = By.xpath("//input[@type='email']");
    public static By Password = By.xpath("//input[@type='password']");
    public static By NextButton = By.xpath("//*[text()='Next']");
    public static By SubjectSearch = By.xpath("//input[contains(@placeholder,'Search')]");
    public static By MailFirstRow = By.xpath("//div[text()='Inbox']//ancestor::tbody//tr");
    public static By ResetPasswordURL = By.xpath("(//div[@class='gs']//a)[last()]");
    public static By openMail = By.xpath("//div[text()='Inbox']");
    public static By registrationTextInMail = By.xpath("//p[text()='Thank you for ' and text()=' in ']//span[text()='registration']//following::span[text()='Sky']//following::span[text()='News']//following::span[text()='Arabia']//following::span[text()='Academy']");
    public static By openMailPhone = By.xpath("//div[@role='listitem']//span[text()='Inbox']");
    public static By openMailPhoneRegistration = By.xpath("//div[@role='listitem']//*[text()='Sky News Arabia Academy Registration']");
    public static String signInMobile = "//android.view.View[@content-desc='Sign in']";
    public static String xpath = "xpath";
    public static By useWebVersion = By.xpath("//a[text()='Use the web version']");
    public static By registrationTextInMailPhone = By.xpath("(//p[text()='Thank you for registration in Sky News Arabia Academy'])[last()]");
    public static By resetPassMailWeb = By.xpath("(//p[text()='You can use the following link to ' and text()=' your ']//span[text()='reset']//following-sibling::span[text()='password'])[last()]");
    public static By resetPasswordLink = By.xpath("(//a[contains(@href,'reset')])[last()]");
    public static By youtubeVideoClose = By.xpath("//div[@class='intro_video_close_icon_cont']");
    public static By quotedMail = By.xpath("(//div[@aria-label='Show quoted text'])[last()]");
    public static By transferDetails = By.xpath("//h2[contains(text(),'Transfer Details')]");
    public static By bankDetails = By.xpath("(//td[@align='left'])[last()]");
    public static By signIN = By.xpath("//a[text()='Sign in']");
    public static By paymentMethod = By.xpath("(//td[@align='left'])[2]");
    public static By resetPasswordMailPhone = By.xpath("//p[contains(text(),'You can use the following link to reset your password')]");
}
