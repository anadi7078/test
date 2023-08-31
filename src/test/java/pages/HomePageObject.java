package pages;

import org.openqa.selenium.By;

public class HomePageObject {

    public static By upcomingRail = By.xpath("//div[@class='ucourse_inner']");
    public static By upcomingCoursesTitle = By.xpath("//div[@class='ucourse_head']");
    public static By upcomingCoursesContent = By.xpath("//div[@class='ucourse_inner']//a[@class='rail_inner']");
    public static By upcomingCourseTitle = By.xpath("//div[@class='ucourse_card']//span[@class='ucourse_title']");
    public static By upcomingCourseTrainer = By.xpath("//div[@class='ucourse_card']//div[@class='ucourse_trainer']");
    public static By upcomingCourseDate = By.xpath("//div[@class='ucourse_card']//div[@class='ucourse_date']");
    public static By upcomingCourseImage = By.xpath("//div[@class='ucourse_card']//div[@class='ucourse_img']");
    public static By upcomingCoursesContentLast = By.xpath("(//div[@class='ucourse_inner']//a[@class='rail_inner'])[last()]");
    public static By titleOfPage = By.xpath("//h1[@class='course_detail_title_text']");
    public static By Aboutarrow = By.xpath("//img[@class='desc_arrow_icon']");
    public static By youtubeVideoClose = By.xpath("//div[@class='intro_video_close_icon_cont']");
    public static By trainerList = By.xpath("//div[@class='trainers_inner']");
    public static By trainers = By.xpath("//a[@class='train_card']");
    public static By trainersName = By.xpath("//div[@class='train_name']");
    public static By trainersImage = By.xpath("//div[contains(@class,'train_img')]");
    public static By trainerscategory = By.xpath("//div[@class='train_category']");
    public static By categorytext = By.xpath("//span[@class='sf_category']");
    public static By trainerTitle = By.xpath("//h1[@class='trainer_name']");
    public static By trainerTitletext = By.xpath("//span[@class='hero_comp_media_content_text_line_1']");
    public static final String usewithout_account = "com.android.chrome:id/signin_fre_dismiss_button";
    public static final String accept_button_chrome = "terms_accept";
    public static final String no_thanks_button_chrome = "negative_button";

    public static By allTrainers = By.xpath("//a[@class='all_tr_inner ']");
    public static By trainerSearchbox = By.xpath("//input[@name='query']");
    public static By trainerPage = By.xpath("//span[@class='hero_comp_media_content_text_line_1' and text()='تــــــــــــــعرّف على مدرّبيــــــــــــــــــــــــنا' or text()='Trainers']");
    public static By headerimage_trainer = By.xpath("//img[@class='hero_comp_grid_icon']");
    public static By lastCourse = By.xpath("(//div[@class='ucourse_card']//span[@class='ucourse_title']//h3)[last()]");
    public static By academyLogo = By.xpath("//a[@class='header_logo_cont']");
    public static By registerNowButton = By.xpath("//a[contains(@class,'hero_comp_media_content_btn') and contains(@href,'login')]");
    public static By languageDropdownHover = By.xpath("//div[@class='lang_cont']//div//a");
    public static By languageSelectionFomDropdown = By.xpath("//div[@class='lang_cont']//a[@class='nav_items_sec_menu_item']");
    public static By youtubevideoFrame = By.xpath("//iframe[contains(@src,'youtube') and contains(@allow,'autoplay')]");
    public static By youtubeVideoPlaying = By.xpath("//button[contains(@title,'Pause')]");
    public static By youtubeVideo = By.xpath("//video[@class='video-stream html5-main-video']");
    public static By header = By.xpath("//header[@class='header comp header_transparent']");
    public static By loginIcon = By.xpath("//div[@class='user_cont']//a[contains(@href,'login')]");
    public static By headerImage = By.xpath("//div[@class='hero_comp comp']//img");
    public static By footerRegisterButton = By.xpath("//footer[@class='footer_comp comp']//a[contains(@href,'login')]");
    public static By socialMediaFooter = By.xpath("//div[@class='sm_container']//a");
    public static By staticPagesFooter = By.xpath("//div[@class='static_container']//a");
    public static By copyright = By.xpath("//p[contains(@class,'f_l2_cr')]");
    public static By facebookClosePopup = By.xpath("//div[@aria-label='Close']");
    public static By snaAcademySocialAccount = By.xpath("//*[text()='thesnaacademy' or text()='SNA Academy' or text()='The SNA Academy']");
    public static By twitterUserName = By.xpath("//input[@autocomplete='username']");
    public static By twitterNextButton = By.xpath("//span[text()='Next']");
    public static By twitterPassword = By.xpath("//input[@autocomplete='current-password']");
    public static By twitterLogin = By.xpath("//span[text()='Log in']");
    public static By twitterLoggedIn = By.xpath("//a[@aria-label='Twitter']");
    public static String moreOptions = "com.android.chrome:id/menu_button";
    public static By headerImageMobile = By.xpath("(//div[@class='hero_comp comp']//img)[last()]");
    public static String notificationsToggle = "com.android.chrome:id/switchWidget";
    public static String back = "//android.widget.ImageButton[@content-desc='Navigate up']";
    public static String type_id = "id";
    public static String type_xpath = "xpath";
    public static By burgerMenu = By.className("menu_icon_cont");
    public static By burgerMenuClose = By.className("menu_close_icon_inner_cont");
    public static String youtubeSNA = "//android.view.ViewGroup[@content-desc='Subscribe to SNA Academy.']";
    public static By burgerMenuOpenedList = By.xpath("//div[@class='header_items_cont menu_opened']");
    public static By coursesListOpened = By.xpath("//div[@class='nav_items_sec_menu_cont sub_nav_item_expanded']");
    public static By allCoursesInMenu = By.xpath("//a[@class='nav_items_sec_menu_item hide_large_only' and contains(@href,'courses')]");
    public static By upcomingCoursesButtonHeader = By.xpath("//a[contains(@class,'hero_comp_media') and contains(@href,'courses')]");
    public static By footerCoursesBtn = By.xpath("//footer//a[contains(@href,'courses')]");
    public static By loggedInAccountIcon = By.xpath("//div[@class='user_cont user_cont_with_logged_in_user']//a[contains(@href,'account')]");
    public static By myAccountMenu = By.xpath("//div[@class='user_cont user_cont_with_logged_in_user']//div[contains(@class,'nav_items_sec_menu_cont')]//a[contains(@href,'account')]");
    public static By accounticon = By.xpath("//div[@class='user_cont user_cont_with_logged_in_user']//div[@class='nav_item nav_item_with_sec_menu']");
    public static By logout = By.xpath("//div[@class='user_cont user_cont_with_logged_in_user']//div[contains(@class,'nav_items_sec_menu_cont')]//span");
    public static By cartbutton = By.xpath("//div[@class='user_cont user_cont_with_logged_in_user']//div[contains(@class,'nav_items_sec_menu_cont')]//a[contains(@href,'cart')]");


    public static By socialIcon(String platform) {
        return By.xpath("//img[@alt='" + platform + "']//parent::a");
    }

    public static By menuNavigation(String menu) {
        return By.xpath("//a[contains(@href,'" + menu + "')]");
    }
}
