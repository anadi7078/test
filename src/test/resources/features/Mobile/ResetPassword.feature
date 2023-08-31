@ResetPassword @SNAAcademy @Mobile
Feature: ResetPassword

  @ACAWEB036Mobile @ResetPassword @P1 @MobileDailyCheckList
  Scenario Outline: ACAWEB036 - User is able to reset his password and login with the new one
    Given open the Chrome app on "android device"
    Given launch the "<Sna Academy URL>" website on chrome
    And "open" burger menu
    And click on "account icon" and verify "login page" is opened
    And click on reset your password link
    And enter "reset password" email and click on reset password button
    And login into "Gmail2" account
    Then verify reset password email is received for "mobile"
    And reset password according to "testdata1"
    And click on go to login in the success popup
    And enter "updated password" credentials in login page

    Examples:
      | Sna Academy URL     |
      | SNA Academy English |
      | SNA Academy Arabic  |