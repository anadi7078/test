package pages;

import org.openqa.selenium.By;

public class CartPageObject {

    public static By cartempty = By.xpath("//h2[@class='snaa_simple_section_title']");
    public static By courses = By.xpath("(//div[@class='table_cont']//td)[1]");
    public static By shoppingpage = By.xpath("//div[@class='hero_comp_media_cont_l1']");
    public static By checkoutButton = By.xpath("//a[contains(@href,'checkout')]");
    public static By paymentButton = By.xpath("//button[text()='استكمال عملية الدفع' or text()='Continue Payment']");
    public static By shoppingcarttext = By.xpath("//span[@class='hero_comp_media_content_text_line_1']");

    public static By shoppingpageimage = By.xpath("//div[@class='hero_comp_media_cont_l1']");

    public static By course = By.xpath("//div[@class='table_cont']//td[1]");
    public static By unitprice = By.xpath("//div[@class='table_cont']//td[2]");
    public static By quantity = By.xpath("//div[@class='table_cont']//td[3]");
    public static By total = By.xpath("//div[@class='table_cont']//td[3]");
    public static By removebttn = By.xpath("//td[@class='remove_from_list_btn']//button[@class='btn compact']");
    public static By correcttotal = By.xpath("//span[@class='snaa_simple_section_title']");
    public static By coursesrowsize = By.xpath("//div[@class='table_cont']//tbody//tr");
    public static By confirmdelete = By.xpath("(//button[@class='confirm_popup_primary_btn'])[1]");

    public static By finalcheckout = By.xpath("//a[contains(@href,'checkout')]");

}

