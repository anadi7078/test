@Registration @SNAAcademy @Mobile
Feature: Registration


  @ACAWEB031Mobile @Registration @P1 @MobileDailyCheckList
  Scenario Outline: ACAWEB031 - Register now redirects to Login page
    Given open the Chrome app on "android device"
    Given launch the "<Sna Academy URL>" website on chrome
    And click on "register now button in header" and verify "login page" is opened
    And click on "register now button in footer" and verify "login page" is opened
    And "open" burger menu
    And click on "account icon in header" and verify "login page" is opened
    And navigate to "courses" page from header
    And click on more details button of any course
    Then verify "register now button" is displayed for courses page

    Examples:
      | Sna Academy URL     |
      | SNA Academy English |
      | SNA Academy Arabic  |

  @ACAWEB032Mobile @Registration @P1 @MobileRegression
  Scenario Outline: ACAWEB032 - User is able to complete the registration successfully
  #  -----PRE REQUISITE STATED ------
    Given launch the "CMS" website on web
    And login to CMS website
    And navigate to "Collection Types > Users" tab in CMS
    And search "email" in CMS
    And delete an entry in CMS
    And close the web driver
      #  -----PRE REQUISITE ENDED ------
    Given open the Chrome app on "android device"
    Given launch the "<Sna Academy URL>" website on chrome
    And click on "register now button" and verify "login page" is opened
    And create "new" account with valid credentials
    Then verify "upcoming courses button" is displayed for courses page
    And login into "Gmail" account
    Then verify welcome email is received for "mobile"

    Examples:
      | Sna Academy URL     |
      | SNA Academy English |
      | SNA Academy Arabic  |