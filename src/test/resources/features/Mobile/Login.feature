@Login @SNAAcademy @Mobile
Feature: Login

  Background:
    Given open the Chrome app on "android device"

  @ACAWEB033Mobile @Login @P1 @MobileDailyCheckList
  Scenario Outline: ACAWEB033 - User is able to login successfully with valid credentials
    Given launch the "<Sna Academy URL>" website on chrome
    And "open" burger menu
    And click on "account icon" and verify "login page" is opened
    And enter "valid" credentials in login page
    Then verify "upcoming courses button in header" is displayed properly

    Examples:
      | Sna Academy URL     |
      | SNA Academy English |
      | SNA Academy Arabic  |

  @ACAWEB034Mobile @Login @P1 @MobileDailyCheckList
  Scenario Outline: ACAWEB034 - User is not able to login with invalid credentials
    Given launch the "<Sna Academy URL>" website on chrome
    And "open" burger menu
    And click on "account icon" and verify "login page" is opened
    And enter "invalid" credentials in login page
    Then verify unsuccessful login message is displayed

    Examples:
      | Sna Academy URL     |
      | SNA Academy English |
      | SNA Academy Arabic  |

  @ACAWEB035Mobile @Login @P1 @MobileDailyCheckList
  Scenario Outline: ACAWEB035 - Logged in user accesses the Upcoming courses
    Given launch the "<Sna Academy URL>" website on chrome
    And "open" burger menu
    And click on "account icon" and verify "login page" is opened
    And enter "valid" credentials in login page
    And click on "upcoming courses button in header" and verify "courses listing page" is opened
    And click on "upcoming courses button in footer" and verify "courses listing page" is opened

    Examples:
      | Sna Academy URL     |
      | SNA Academy English |
      | SNA Academy Arabic  |