@SocialIcons @SNAAcademy @Web
Feature: Social Icons

  @ACAWEB007 @SocialIcons @P1 @DailyCheckList
  Scenario Outline: ACAWEB007 - Clicking on social icons opens the Academy's page on the respective social media platform
    Given launch the "<Sna Academy URL>" website
    Then click on "social media account" and verify "respective SNA page" is opened

    Examples:
      | Sna Academy URL     |
      | SNA Academy English |
      | SNA Academy Arabic  |