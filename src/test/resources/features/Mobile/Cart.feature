@Cart @SNAAcademy @Mobile
Feature: Cart

  Background:
    Given launch the "CMS" website on web
    And login to CMS website
    And navigate to "Collection Types > Carts" tab in CMS
    And  search "email" in CMS using filter
    And  delete an entry in CMS
    And  logout from the CMS application
    And close the web driver
    Given open the Chrome app on "android device"

  @ACAWEB038Mobile @Cart @P1 @MobileDailyCheckList
  Scenario Outline: ACAWEB038 - User can access his empty cart
    Given launch the "<Sna Academy URL>" website on chrome
    And "open" burger menu
    And click on "account icon" and verify "login page" is opened
    And enter "valid" credentials in login page
    And "open" burger menu
    Then navigate to "shopping cart" from account icon menu
    And verify the "cart empty" is visible for the "shopping cart" page
    Examples:
      | Sna Academy URL     |
      | SNA Academy English |
      | SNA Academy Arabic  |

  @ACAWEB039Mobile @Cart @P1
  Scenario Outline: ACAWEB039 - Adding courses to the cart
    Given launch the "<Sna Academy URL>" website on chrome
    And "open" burger menu
    And click on "account icon" and verify "login page" is opened
    And enter "valid" credentials in login page
    And navigate to "courses" page from header
    And click on more details button of any course
    And click on enroll button and verify "success message and add more courses" is displayed
    And click on more details button of any course
    And click on enroll button and verify "success message and checkout" is displayed
    Examples:
      | Sna Academy URL     |
      | SNA Academy English |
      | SNA Academy Arabic  |


  @ACAWEB040Mobile @Cart @P1
  Scenario Outline: ACAWEB040 - Shopping cart is displayed properly with it's details
    Given launch the "<Sna Academy URL>" website on chrome
    And "open" burger menu
    And click on "account icon" and verify "login page" is opened
    And enter "valid" credentials in login page
    And navigate to "courses" page from header
    And click on more details button of any course
    And click on enroll button and verify "success message and add more courses" is displayed
    And click on more details button of any course
    And click on enroll button and verify "success message and checkout" is displayed
    And verify the "shopping cart details" is visible for the "shopping cart" page
    Examples:
      | Sna Academy URL     |
      | SNA Academy English |
      | SNA Academy Arabic  |


  @ACAWEB041Mobile @Cart @P1
  Scenario Outline: ACAWEB041 - User can add the same course more than once in the cart
    Given launch the "<Sna Academy URL>" website on chrome
    And "open" burger menu
    And click on "account icon" and verify "login page" is opened
    And enter "valid" credentials in login page
    And navigate to "courses" page from header
    And click on more details button of any course
    And click on enroll button and verify "success message and add more courses" is displayed
    And click on more details button of any course
    And click on enroll button and verify "success message and add more courses" is displayed
    And "open" burger menu
    Then navigate to "shopping cart" from account icon menu
    Then delete all items present in cart
    Examples:
      | Sna Academy URL     |
      | SNA Academy English |
      | SNA Academy Arabic  |


