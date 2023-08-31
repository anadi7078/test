@SocialIcons @SNAAcademy @Mobile
Feature: Social Icons

  Background:
    Given open the Chrome app on "android device"

  @ACAWEB007Mobile @SocialIcons @P1 @MobileDailyCheckList
  Scenario Outline: ACAWEB007 - Clicking on social icons opens the Academy's page on the respective social media platform
    Given launch the "<Sna Academy URL>" website on chrome
    Then click on "social media account" and verify "respective SNA page" is opened

    Examples:
      | Sna Academy URL     |
      | SNA Academy English |
      | SNA Academy Arabic  |