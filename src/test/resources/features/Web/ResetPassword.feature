@ResetPassword @SNAAcademy @Web
Feature: ResetPassword

  @ACAWEB036 @ResetPassword @P1 @DailyCheckList @Gmail
  Scenario Outline: ACAWEB036 - User is able to reset his password and login with the new one
    Given launch the "<Sna Academy URL>" website
    And click on "account icon" and verify "login page" is opened
    And click on reset your password link
    And enter "reset password" email and click on reset password button
    And login into "Gmail2" account
    Then verify reset password email is received for "web"
    And reset password according to "testdata1"
    And click on go to login in the success popup
    And enter "updated password" credentials in login page

    Examples:
      | Sna Academy URL     |
      | SNA Academy English |
      | SNA Academy Arabic  |