package pages;

import org.openqa.selenium.By;

public class NewsAndEventsPageObject {

    public static By headerImage = By.xpath("//div[@class='hero_comp comp']//img[@role='presentation']");
    public static By title = By.xpath("//div[@class='hero_comp comp']//span[contains(@class,'hero_comp_media_content_text_line_')]");
    public static By newsInNewsSection = By.className("news_list_item_cont");
    public static By newsImageInNewsSection = By.className("news_list_item_img_cont");
    public static By newsHeadlineInNewsSection = By.className("news_list_item_headline");
    public static By newsDateInNewsSection = By.className("list_card_item_date");
    public static By videosInVideoSection = By.xpath("//div[contains(@class,'videosList_video_item__')]");
    public static By videoPlayIcon = By.xpath("//img[contains(@class,'videosList_play_icon')]");
    public static By videoTitle = By.xpath("//div[contains(@class,'videosList_video_item_bottom')]//h3");
    public static By videoDescription = By.xpath("//div[contains(@class,'videosList_video_item_bottom')]//p");
    public static By videoDate = By.xpath("//div[contains(@class,'videosList_video_item_bottom')]//span");
    public static By videoImage = By.xpath("//div[contains(@class,'videosList_image_container')]");
    public static By testimonialsPlayIcon = By.xpath("//img[contains(@class,'testimonialsList_play_icon')]");
    public static By testimonials = By.xpath("//div[contains(@class,'testimonialsList_testimonial_item__')]");
    public static By testimonialsTitle = By.xpath("//div[contains(@class,'testimonialsList_testimonial_item_bottom')]//h3");
    public static By testimonialsDate = By.xpath("//div[contains(@class,'testimonialsList_testimonial_item_bottom')]//span");
    public static By testimonialsImage = By.xpath("//div[contains(@class,'testimonialsList_image_container')]");
    public static By headerImageMobile = By.xpath("(//div[@class='hero_comp comp']//img)[last()]");
    public static By headerTitleAfterNews = By.xpath("//div[@class='hero_comp comp']//h1[contains(@class,'hero_comp_media_content_text')]");
    public static By date = By.className("published_date");
    public static By socialIcons = By.xpath("//li[contains(@class,'social_share_button')]");
    public static By newsImage = By.className("news_display_image_cont");
    public static By newsDescription = By.className("article-desc");
    public static By moreNews = By.xpath("//h2[contains(@class,'pageComponentTitle_snaa_title_normal') and text()='More News' or text()='المزيد من الأخبــــــــــار']");
    public static By moreNewsImage = By.className("news_list_item_img_cont");
    public static By moreNewsHeadline = By.className("news_list_item_headline");
    public static By moreNewsDate = By.className("list_card_item_date");
    public static By viewAllNews = By.xpath("//a[contains(@href,'news-archive')]");
    public static By viewAllVideos = By.xpath("//a[contains(@href,'videos-archive')]");
    public static By videoPlaying = By.xpath("//video[contains(@class,'SnaVideoPlayer_videoPlayer_')]");
    public static By closeVideo = By.xpath("//img[@class='intro_video_close_icon']");
    public static By viewAllTestimonials = By.xpath("//a[contains(@href,'testimonials-archive')]");
    public static By videoDescriptionLast = By.xpath("(//div[contains(@class,'videosList_video_item_bottom')]//p)[last()]");


    public static By sections(String english, String arabic) {
        return By.xpath("//h2[contains(@class,'pageComponentTitle_snaa_title_normal') and text()='" + english + "' or text()='" + arabic + "']");
    }


}
