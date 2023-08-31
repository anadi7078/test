@StaticPages @SNAAcademy @Mobile
Feature: Static Pages

  Background:
    Given open the Chrome app on "android device"

  @ACAWEB006Mobile @StaticPages @P1 @MobileDailyCheckList
  Scenario Outline: ACAWEB006 - Clicking on static pages links opens the respective page
    Given launch the "<Sna Academy URL>" website on chrome
    Then verify that the respective page is opening on clicking the menu item from the "footer"

    Examples:
      | Sna Academy URL     |
      | SNA Academy English |
      | SNA Academy Arabic  |