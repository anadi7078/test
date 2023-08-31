package pages;

import org.openqa.selenium.By;

public class PaymentPageObject {

    public static By orderConfirmationPopup = By.xpath("//div[@class='confirm_popup_cont order_confirmation_success_popup']");
    public static By goToAccountButtonInPopup = By.xpath("//a[contains(@class,'popup') and contains(@href,'account')]");
    public static By addBillingAddressButton = By.xpath("//button[text()='Add Billing Address' or text()='اضافة عنوان الدفع']");
    public static By orderSummary = By.xpath("(//h2[text()='Order Summary' or text()='بيانات الطلب']//ancestor::div)[last()]//table");
    public static By totalAmount = By.xpath("//span[contains(text(),'Total') or contains(text(),'الإجمالي')]");
    public static By paypalButtons = By.xpath("//div[contains(@id,'paypal')]");
    public static By paymentMethods = By.id("pay_via_bank");
    public static By admin=By.xpath("//button[text()='System Admin']");
    public static By logout=By.xpath("//span[text()='Logout']");
    public static By confirmdelete = By.xpath("(//button[@class='confirm_popup_primary_btn'])[1]");
    public static By paymentButton = By.xpath("//button[text()='استكمال عملية الدفع' or text()='Continue Payment']");
    public static By bankTransferPaymentMethod = By.id("pay_via_bank");
    public static By creditDebitPaymentMethod = By.id("pay_via_etisalat");
    public static By paypalPaymentMethod = By.id("pay_via_paypal");
    public static By continueButton = By.id("btncontinue");
    public static By paypalButton = By.xpath("//div[@aria-label='PayPal' and @role='link']");
    public static By paypalCreditDebit = By.xpath("//div[@aria-label='Debit or Credit Card' and @role='link']");
    public static By placeOrder = By.xpath("//button[text()='Place Order' or text()='تسجيل الطلب']");
    public static String fnameLname = "//div[text()='%fname%' and text()='%lname%']";
    public static String selectedDetail = "//div[text()='%fname%' and text()='%lname%']//ancestor::tr[@class='row_active']";
    public static String accountDetail = "//div[text()='%text%']";
    public static By removebttn = By.xpath("//td[@class='remove_from_list_btn']/button");
    public static By country = By.xpath("//select[@name='countryName']");
    public static By cardNumber = By.xpath("//input[@name='cardNumber']");
    public static By expiryDate = By.xpath("//input[@name='expiry_value']");
    public static By cvv = By.xpath("//input[@name='cvv']");
    public static By firstname = By.xpath("//input[@name='firstName']");
    public static By lastname = By.xpath("//input[@name='lastName']");
    public static By addressline = By.xpath("//input[@name='billingLine1']");
    public static By billingcity = By.xpath("//input[@name='billingCity']");
    public static By billingstate = By.xpath("//select[@name='billingState']");
    public static By phonenumbertype = By.xpath("//select[@name='phoneType']");
    public static By mobilenumber = By.xpath("//input[@name='telephone']");
    public static By emailAddress = By.xpath("//input[@name='email']");
    public static By securitydontwantoption = By.xpath(" (//label[@class='noBottom ng-binding'])[2]");
    public static By payNow = By.xpath("//button[text()='Pay Now']");
    public static By privacystatement = By.xpath("(//label[@class='noBottom ng-binding ng-scope'])[2]");
    public static By proceedToPaymentButton = By.xpath("//button[@class='btn']");
    public static By paypalEmail = By.id("email");
    public static By paypalNext = By.xpath("//button[text()='Next']");
    public static By paypalPassword = By.id("password");
    public static By otpValue = By.id("otpval");
    public static By gmail = By.xpath("//span[text()='skynewstesting@gmail.com']");
    public static By confirmdelButton = By.xpath("//span[text()='Yes, confirm']");

    public static By deleteEntry=By.xpath("//span[@data-tip='skynewstesting@gmail.com']//ancestor::tr//button//*[@data-icon='trash-alt']");
    public static By paypalLoginButton = By.xpath("//button[text()='Log In']");
    public static By paypalCompletePayment = By.xpath("//button[@id='payment-submit-btn']");
    public static By paypalFrame = By.xpath("//iframe[@title='PayPal']");
    public static By saveButton = By.xpath("//button[text()='Save' or text()='حـــفظ']");
    public static By title = By.xpath("//div[@class='hero_comp comp']//span[contains(@class,'hero_comp_media_content_text_line_')]");
    public static By paymentDetailsPage = By.xpath("//h1[text()='Payment Details']");
    public static By creditCardNumber = By.xpath("//div[@id='CardNumberText']//input[@id='cardNumber']");
    public static By cvvCreditCard = By.xpath("//input[@name='ValidationCode']");
    public static By payButtonCC = By.id("btnPay");
    public static By transactionProcessing = By.xpath("//p[text()='Transaction processing...']");
    public static By payWithPaypalCC = By.xpath("//h1[text()='Pay with debit or credit card']");
    public static By errorMessageINPayment = By.xpath("//div[@class='alert alert-danger']//p");
    public static By email = By.xpath("//input[@id='email']");
}
