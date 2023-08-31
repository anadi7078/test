package pages;

import org.openqa.selenium.By;

public class TrainerPageObject {
    public static By Categorytext = By.xpath("//span[@class='sf_category']//label");
    public static By Trainernametext = By.xpath("//input[@name='query']");
    public static By unmatchednametext = By.xpath("//div[@class='no_data_available']");
    public static By trainercount = By.xpath("//div[@class='train_img snaa_img a_square scrim']");
    public static By searchBox = By.xpath("//input[@name='query']");
    public static By headerimage_trainer = By.xpath("//img[@class='hero_comp_grid_icon']");
    public static By trainerTitletext = By.xpath("//span[@class='hero_comp_media_content_text_line_1']");
    public static By trainerList = By.xpath("//div[@class='trainers_inner']");
    public static By trainerSearchbox = By.xpath("//input[@name='query']");
    public static By trainers = By.xpath("//a[@class='train_card']");
    public static By trainersName = By.xpath("//div[@class='train_name']");
    public static By trainerimage = By.xpath("//div[@class='train_img snaa_img a_square scrim']");
    public static By coursescomingsoon = By.xpath("//h2[@class='head_title']");
    public static By comingsoonlabel = By.xpath("//div[@class='course_list_item_date_month_cont']");
    public static By trainercoursescategory = By.xpath("(//div[@class='course_list_item_name'])[1]");
    public static By courseslistitemtrainername = By.xpath("//div[@class='course_list_item_info_cont_trainer_name']");
    public static By trainername = By.xpath("//h1[@class='trainer_name']");
    public static By trainerDesignation = By.xpath("//div[@class='training_category']");
    public static By trainerCatogory = By.xpath("//div[@class='training_title']");
    public static By trainerquote = By.xpath("//p[@class='quote_txt']");
    public static By moreinfo = By.xpath("//span[@class='section-title']");
    public static By courseslist = By.xpath("//div[@class='course_list_item_cont']");
    public static By courseimage = By.xpath("(//div[@class='course_list_item_img_cont'])[1]");
    public static By location = By.xpath("(//div[@class='course_list_item_info_cont_row_2_location'])[1]");
    public static By days = By.xpath("(//div[@class='course_list_item_info_cont_row_2_time'])[1]");
    public static By hoursperday = By.xpath("(//div[@class='course_list_item_info_cont_row_2_duration'])[1]");
    public static By description = By.xpath("(//div[@class='course_list_item_info_cont_row_3'])[1]");
    public static By price = By.xpath("(//div[@class='course_list_item_price'])[1]");
    public static By moredetailsbutton = By.xpath("(//span[@class='course_list_item_price_and_reg_btn'])[1]");
    public static By trainersImage = By.xpath("//a[@class='train_card']//span//img");
    public static By trainersHeaderImage = By.xpath("//div[@class='hero_comp comp']//span//img");
    public static By trainerscategory = By.xpath("//div[@class='train_category']");
    public static By categorytext = By.xpath("//span[@class='sf_category']");
    public static By trainerTitle = By.xpath("//h1[@class='trainer_name']");
    public static By trainercategory = By.xpath("//button[@class='sf_category_value  ']");

    public static By trainersname(String matched) {
        return By.xpath("//div[@class='train_name' and text()='" + matched + "']");
    }

    public static By Trainercategoryvalue(int index) {
        return By.xpath("(//button[contains(@class,'sf_category_value  ')])[" + index + "]");
    }

    public static By TrainerName(int index) {
        return By.xpath("(//div[@class='train_name'])[" + index + "]");
    }

}
