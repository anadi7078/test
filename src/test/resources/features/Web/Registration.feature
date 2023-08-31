@Registration @SNAAcademy @Web
Feature: Registration

  @ACAWEB031 @Registration @P1 @DailyCheckList
  Scenario Outline: ACAWEB031 - Register now redirects to Login page
    Given launch the "<Sna Academy URL>" website
    And click on "register now button in header" and verify "login page" is opened
    And click on "register now button in footer" and verify "login page" is opened
    And click on "account icon in header" and verify "login page" is opened
    And navigate to "courses" page from header
    And click on more details button of any course
    Then verify "register now button" is displayed for courses page

    Examples:
      | Sna Academy URL     |
      | SNA Academy English |
      | SNA Academy Arabic  |

  @ACAWEB032 @Registration @P1 @Regression @Gmail
  Scenario Outline: ACAWEB032 - User is able to complete the registration successfully
    #  -----PRE REQUISITE STATED ------
    Given launch the "CMS" website
    And login to CMS website
    And navigate to "Collection Types > Users" tab in CMS
    And search "email" in CMS
    And delete an entry in CMS
      #  -----PRE REQUISITE ENDED ------
    Given launch the "<Sna Academy URL>" website
    And click on "register now button" and verify "login page" is opened
    And create "new" account with valid credentials
    Then verify "upcoming courses button" is displayed for courses page
    And login into "Gmail" account
    Then verify welcome email is received for "web"

    Examples:
      | Sna Academy URL     |
      | SNA Academy English |
      | SNA Academy Arabic  |