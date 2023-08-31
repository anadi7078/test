@Logout @SNAAcademy @Web
Feature: Logout

  @ACAWEB037 @Logout @P1 @DailyCheckList
  Scenario Outline:ACAWEB037 -  User can logout from his account successfully
    Given launch the "<Sna Academy URL>" website
    And click on "account icon" and verify "login page" is opened
    And enter "valid" credentials in login page
    Then navigate to "logout" from account icon menu
    Examples:
      | Sna Academy URL     |
      | SNA Academy English |
      | SNA Academy Arabic  |