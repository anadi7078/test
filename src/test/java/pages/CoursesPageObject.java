package pages;

import org.openqa.selenium.By;

public class CoursesPageObject {

    public static By moreDetailsButton = By.className("course_list_item_price_and_reg_btn_cont");
    public static By moreDetailButton = By.xpath("(//div[@class='course_list_item_price' and not (contains(text(),'Free'))]//parent::div//a[@class='course_list_item_price_and_reg_btn_cont'])[last()]");
    public static By title = By.className("course_detail_title_text");
    public static By moreDetailsButton1 = By.xpath("(//div[@class='course_list_item_price' and not (contains(text(),'Free'))]//parent::div//a[@class='course_list_item_price_and_reg_btn_cont'])");

    public static By firstMonth = By.className("courses_list_month_header_text");
    public static By searchingSection = By.className("search_content");
    public static By filterByCourseName = By.xpath("//span[@class='sf_text']//input");
    public static By filterByCourseCategory = By.xpath("//span[@class='sf_category']//div[@class='sf_category_lst']");
    public static By filterByMonth = By.xpath("//span[@class='sf_month']//div[@class='select-container']");
    public static By headerImage = By.xpath("//div[@class='hero_comp comp']//img[@role='presentation']");
    public static By coursesCategory = By.className("course_list_item_name");
    public static By courseImage = By.className("course_list_item_img_cont");
    public static By coursesTrainer = By.className("course_list_item_info_cont_trainer_name");
    public static By coursesLocation = By.className("course_list_item_info_cont_row_2_location");
    public static By coursesDuration = By.className("course_list_item_info_cont_row_2_time");
    public static By coursesHoursPerDay = By.className("course_list_item_info_cont_row_2_duration");
    public static By coursesPrice = By.xpath("//div[@class='course_list_item_price']");
    public static By coursesDescription = By.className("course_list_item_info_cont_row_3");
    public static By headerImageMobile = By.xpath("(//div[@class='hero_comp comp']//img)[last()]");
    public static By titlePage = By.xpath("//div[@class='hero_comp comp']//span[contains(@class,'hero_comp_media_content_text_line_')]");
    public static By courses = By.className("course_list_item_cont");
    public static By coursesDays = By.className("course_list_item_date_month_cont");
    public static By registerNowButton = By.xpath("//a[@class='course_detail_main_content_register_btn_cont btn st']");
    public static By addmorecourses = By.xpath("//div[@class='confirm_popup_btns_cont']//a[contains(@href,'courses')]");
    public static By successmsg = By.xpath("(//div[@class='confirm_popup_body'])[1]");
    public static By nativeShare = By.xpath("//img[@alt='share']");
    public static String nativeShareMobile = "com.android.chrome:id/image_preview";
    public static String type_id = "id";
    public static By courseDetails = By.className("course_detail_faq_cont");
    public static By relatedCourses = By.xpath("//h2[text()='Related Courses' or text()=' الـــــــــدورات المماثــــــــلة']");
    public static By relatedCoursesList = By.xpath("//h2[text()='Related Courses' or text()=' الـــــــــدورات المماثــــــــلة']//ancestor::div[@class='course_detail_course_list_comp']//div[@class='course_list_item_cont']");
    public static By allCoursesButton = By.xpath("//a[@class='course_detail_course_list_more_course_btn btn']");
    public static By trainerCourse = By.className("course_detail_main_content_trainer_cont");
    public static By courseDesc = By.xpath("//div[@class='course_detail_faq_note']");
    public static By courseMedia = By.xpath("//div[contains(@class,'course_detail_media')]");
    public static By coursePrice = By.className("course_detail_main_content_price_cont");
    public static By sharingIcons = By.xpath("//ul[contains(@class,'share')]//li");
    public static By videoMainMedia = By.xpath("//div[@class='course_detail_media_inner_cont']//video");
    public static By videoMainMediaAutoPlay = By.xpath("//div[@class='course_detail_media_inner_cont']//video[@autoplay]");
    public static By searchBox = By.xpath("//input[@name='query']");
    public static By searchBoxContainer = By.className("sf_fields");
    public static By noSearchResults = By.className("no_data_available");
    public static By courseCategory = By.xpath("//button[@class='sf_category_value  ']");
    public static By monthFilter = By.xpath("//select[@name='month']");
    public static By twitterUserName = By.xpath("//input[@autocomplete='username']");
    public static By twitterNextButton = By.xpath("//span[text()='Next']");
    public static By twitterPassword = By.xpath("//input[@autocomplete='current-password']");
    public static By twitterLogin = By.xpath("//span[text()='Log in']");
    public static By twitterLoggedIn = By.xpath("//a[@aria-label='Twitter']");
    public static By tweetButton = By.xpath("//span[text()='Post']");
    public static By tweetURL = By.xpath("//span[@data-text='true' and contains(text(),'https')]");
    public static By fbUserName = By.id("email");
    public static String fbUserNameMobile = "//android.widget.EditText[@resource-id='m_login_email']";
    public static String fbPassMobile = "//android.widget.EditText[@resource-id='m_login_password']";
    public static String fbEmail = "//android.widget.EditText[@resource-id='identify_search_text_input']";
    public static String enterPassword = "//android.widget.RadioButton[@text='Enter Password to Log In']";
    public static String submit = "//android.widget.Button[@resource-id='did_submit']";
    public static String continueButton = "//android.widget.Button[@text='Continue']";
    public static String tryAnotherWay = "//android.widget.Button[@text='Try Another Way']";
    public static By tryAnotherWayXpath = By.xpath("//android.widget.Button[@text='Try Another Way']");
    public static String xpath = "xpath";
    public static By fbPassword = By.id("pass");
    public static By fbLogin = By.xpath("//input[@name='login']");
    public static By fbShareScreen = By.xpath("//span[text()='Post to Facebook']");
    public static By linkedinUserName = By.id("username");
    public static By linkedinPassword = By.id("password");
    public static By linkedinLogin = By.xpath("//button[text()='Sign in']");
    public static By linkedinShareScreen = By.xpath("//span[text()='Share in a post']");
    public static By postMobileLinkedin = By.xpath("//button[text()='Post']");
    public static By linkedInImage = By.xpath("//img[@loading='lazy']");
    public static By footerCoursesBtn = By.xpath("//footer//a[contains(@href,'courses')]");
    public static By whatsappWebText = By.xpath("//div[text()='WhatsApp Web']");
    public static By filterDockingArrow = By.className("filter_collapse");
    public static By filterDocked = By.xpath("//button[@class='filter_collapse expand']");
    public static By enrollButton = By.xpath("//span[@class='course_detail_main_content_register_btn_cont btn st']");
    public static By checkoutButton = By.xpath("//a[contains(@class,'popup') and contains(@href,'cart')]");
    public static By checkout = By.xpath("//a[@class='confirm_popup_primary_btn']");
    public static By seatsFullErrorMessage = By.xpath("//div[@class='alert alert-danger']//p");
    public static By categorytext = By.xpath("//div[@class='sf_category_lst']");
    public static String passwordEnter = "//*[@class='android.widget.EditText' and not(contains(@resource-id,'url'))]";
    public static String login = "(//android.widget.Button[@text='Log In'])";
    public static String fbEmailOrName = "//android.view.View[@content-desc='Search by your email address or name instead']/android.widget.TextView";
    public static By fbEmailOrNameXpath = By.xpath("//android.view.View[@content-desc='Search by your email address or name instead']/android.widget.TextView");

    public static By moreDetailsButton(int index) {
        return By.xpath("(//a[@class='course_list_item_price_and_reg_btn_cont'])[" + index + "]");
    }

    public static By fbShareContent(String course) {
        return By.xpath("//a[contains(@aria-label,'" + course + "')]");
    }

    public static String fbShareContentMobile(String course) {
        return "//android.widget.TextView[contains(@text,'" + course + "')]";
    }

    public static String twitterMobile(String course) {
        return "//android.widget.EditText[contains(@text,'" + course + "')]";
    }

    public static String linkedInMobile(String course) {
        return "//android.widget.EditText[contains(@text,'" + course + "')]";
    }

    public static By courses(int index) {
        return By.xpath("(//div[@class='course_list_item_cont'])[" + index + "]");
    }

    public static By courseCategory(int index) {
        return By.xpath("(//button[@class='sf_category_value  '])[" + index + "]");
    }

    public static By coursesName(int index) {
        return By.xpath("(//div[@class='course_list_item_name'])[" + index + "]");
    }

    public static By socialIcons(String socialIconName) {
        return By.xpath("//button[@aria-label='" + socialIconName + "']");
    }

    public static By detailsInCourse(String src) {
        return By.xpath("//img[contains(@src,'" + src + "')]//ancestor::div[@class='course_detail_info_item_cont']//div[@class='course_detail_info_text']");
    }

    public static By coursesCategory(String category) {
        return By.xpath("//div[@class='course_list_item_name' and text()='" + category + "']");
    }

}
