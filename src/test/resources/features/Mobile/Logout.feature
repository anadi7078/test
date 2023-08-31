@Logout @SNAAcademy @Mobile
Feature: Logout

  Background:
    Given open the Chrome app on "android device"

  @ACAWEB037Mobile @Logout @P1 @MobileDailyCheckList
  Scenario Outline:ACAWEB037 -  User can logout from his account successfully
    Given launch the "<Sna Academy URL>" website on chrome
    And "open" burger menu
    And click on "account icon" and verify "login page" is opened
    And enter "valid" credentials in login page
    And "open" burger menu
    Then navigate to "logout" from account icon menu
    Examples:
      | Sna Academy URL     |
      | SNA Academy English |
      | SNA Academy Arabic  |