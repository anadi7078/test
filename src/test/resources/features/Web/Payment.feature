@Payment @SNAAcademy @Web
Feature: Payment

  @ACAWEB042 @Payment @P1 @Regression @Gmail
  Scenario Outline: ACAWEB042 - Checking out courses and paying using Bank Transfer
        #  -----PRE REQUISITE STATED ------
    Given launch the "CMS" website
    And login to CMS website
    And navigate to "Collection Types > Carts" tab in CMS
    And  search "email" in CMS using filter
    And  delete an entry in CMS
    And  logout from the CMS application
        #  -----PRE REQUISITE ENDED ------
    Given launch the "<Sna Academy URL>" website
    And click on "account icon" and verify "login page" is opened
    And enter "valid" credentials in login page
    And navigate to "my account" from account icon menu
    And add contact information details if not present
    And navigate to "courses" page from header
    And click on more details button of any course
    And click on enroll button and verify "checkout page" is displayed
    And click on checkout button in cart page
    Then verify "billing details" is displayed for the payment page
    Then verify "order summary" is displayed for the payment page
    Then verify "total amount" is displayed for the payment page
    And click on "continue payment" button in payment page
    Then verify "payment methods" is displayed for the payment page
    And select "bank transfer" as the payment method and proceed to payment
    Then verify new order is displayed in the account page
    And login into "Gmail" account
    Then verify order confirmation mail is received for "web"

    Examples:
      | Sna Academy URL     |
      | SNA Academy English |
      | SNA Academy Arabic  |

  @ACAWEB043 @Payment @P1 @Regression @Gmail
  Scenario Outline: ACAWEB043 - Checking out courses and paying using PayPal account
       #  -----PRE REQUISITE STATED ------
    Given launch the "CMS" website
    And login to CMS website
    And navigate to "Collection Types > Carts" tab in CMS
    And  search "email" in CMS using filter
    And  delete an entry in CMS
    And  logout from the CMS application
        #  -----PRE REQUISITE ENDED ------
    Given launch the "<Sna Academy URL>" website
    And click on "account icon" and verify "login page" is opened
    And enter "valid" credentials in login page
    And navigate to "my account" from account icon menu
    And add contact information details if not present
    And navigate to "courses" page from header
    And click on more details button of any course
    And click on enroll button and verify "checkout page" is displayed
    And click on checkout button in cart page
    And click on "add billing details" button in payment page
    And fill "new" contact information details
    And click on "save" button in payment page
    Then verify "new" contact information details are selected
    And click on "continue payment" button in payment page
    And select "paypal" as the payment method and proceed to payment
    Then verify new order is displayed with payment method as "PayPal" in the account page
    And login into "Gmail" account
    Then verify order confirmation mail for "PayPal" payment is received

    Examples:
      | Sna Academy URL     |
      | SNA Academy English |
      | SNA Academy Arabic  |

  @ACAWEB044 @Payment @P1 @Regression @Gmail
  Scenario Outline: ACAWEB044 - Checking out courses and paying using PayPal debit/credit card
        #  -----PRE REQUISITE STATED ------
    Given launch the "CMS" website
    And login to CMS website
    And navigate to "Collection Types > Carts" tab in CMS
    And  search "email" in CMS using filter
    And  delete an entry in CMS
    And  logout from the CMS application
        #  -----PRE REQUISITE ENDED ------
    Given launch the "<Sna Academy URL>" website
    And click on "account icon" and verify "login page" is opened
    And enter "valid" credentials in login page
    And navigate to "my account" from account icon menu
    And add contact information details if not present
    And navigate to "courses" page from header
    And click on more details button of any course
    And click on enroll button and verify "checkout page" is displayed
    And click on checkout button in cart page
    And click on "continue payment" button in payment page
    And select "paypal button" as the payment method and proceed to payment
    Then verify new order is displayed with payment method as "PayPal" in the account page
    And login into "Gmail" account
    Then verify order confirmation mail for "PayPal" payment is received
    Examples:
      | Sna Academy URL     |
      | SNA Academy English |
      | SNA Academy Arabic  |

  @ACAWEB045 @Payment @P1 @Regression @Gmail
  Scenario Outline: ACAWEB045 - Checking out courses and paying using debit/credit card (Accepted)
        #  -----PRE REQUISITE STATED ------
    Given launch the "CMS" website
    And login to CMS website
    And navigate to "Collection Types > Carts" tab in CMS
    And  search "email" in CMS using filter
    And  delete an entry in CMS
    And  logout from the CMS application
        #  -----PRE REQUISITE ENDED ------
    Given launch the "<Sna Academy URL>" website
    And click on "account icon" and verify "login page" is opened
    And enter "valid" credentials in login page
    And navigate to "my account" from account icon menu
    And add contact information details if not present
    And navigate to "courses" page from header
    And click on more details button of any course
    And click on enroll button and verify "checkout page" is displayed
    And click on checkout button in cart page
    And click on "continue payment" button in payment page
    And select "valid credit/debit card" as the payment method and proceed to payment
    Then verify new order is displayed with payment method as "Credit/Debit Card" in the account page
    And login into "Gmail" account
    Then verify order confirmation mail for "Credit/Debit Card" payment is received

    Examples:
      | Sna Academy URL     |
      | SNA Academy English |
      | SNA Academy Arabic  |


  @ACAWEB046 @Payment @P1 @Regression
  Scenario Outline: ACAWEB046 - Checking out courses and paying using debit/credit card (Rejected)
        #  -----PRE REQUISITE STATED ------
    Given launch the "CMS" website
    And login to CMS website
    And navigate to "Collection Types > Carts" tab in CMS
    And  search "email" in CMS using filter
    And  delete an entry in CMS
    And  logout from the CMS application
        #  -----PRE REQUISITE ENDED ------
    Given launch the "<Sna Academy URL>" website
    And click on "account icon" and verify "login page" is opened
    And enter "valid" credentials in login page
    And navigate to "my account" from account icon menu
    And add contact information details if not present
    And navigate to "courses" page from header
    And click on more details button of any course
    And click on enroll button and verify "add more courses button" is displayed
    And click on more details button of the course
    And click on enroll button and verify "checkout page" is displayed
    And click on checkout button in cart page
    And click on "remove button" button in payment page
    And click on "continue payment" button in payment page
    And select "invalid credit/debit card" as the payment method and proceed to payment
    And navigate to "my account" from account icon menu
    Then verify new order is displayed with payment method as "Payment Error" in the account page
    Examples:
      | Sna Academy URL     |
      | SNA Academy English |
      | SNA Academy Arabic  |

  @ACAWEB047 @Payment @P1 @Regression
  Scenario Outline: ACAWEB047 - Can't complete payment if course's seats are fully booked
      #  -----PRE REQUISITE STATED ------
    Given launch the "CMS" website
    And login to CMS website
    And navigate to "Collection Types > Carts" tab in CMS
    And  search "email" in CMS using filter
    And  delete an entry in CMS
    And  logout from the CMS application
        #  -----PRE REQUISITE ENDED ------
    Given launch the "CMS" website
    And login to CMS website
    And navigate to "Collection Types > Courses" tab in CMS
    And change language to "<language>" in dropdown
    Then clone a published course to have very few seats
    And logout from the CMS application
    Given launch the "<Sna Academy URL>" website
    And click on "account icon" and verify "login page" is opened
    And enter "valid" credentials in login page
    And navigate to "my account" from account icon menu
    And add contact information details if not present
    And navigate to "courses" page from header
    And search for the created course
    And click on more details button of any course
    And click on enroll button and verify "success message and add more courses" is displayed
    And search for the created course
    And click on more details button of any course
    And click on enroll button and verify "checkout page" is displayed
    And click on checkout button in cart page
    And click on "continue payment" button in payment page
    And select "invalid bank transfer" as the payment method and proceed to payment
    Then navigate to "shopping cart" from account icon menu
    Then delete all items present in cart
    Given launch the "CMS" website
    And login to CMS website
    And navigate to "Collection Types > Courses" tab in CMS
    And change language to "<language>" in dropdown
    And search and delete the course

    Examples:
      | Sna Academy URL     | language     |
      | SNA Academy English | English (en) |
      | SNA Academy Arabic  | Arabic (ar)  |