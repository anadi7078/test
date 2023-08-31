@AboutUs @SNAAcademy @Mobile
Feature: About Us


  @ACAWEB008Mobile @AboutUs @P1 @MobileDailyCheckList
  Scenario Outline: ACAWEB008 - About us page is displayed properly
    Given open the Chrome app on "android device"
    And launch the "<Sna Academy URL>" website on chrome
    And navigate to "about" page from header
    Then verify "header image" is visible for the about us page
    Then verify "title" is visible for the about us page
    Then verify "about us text" is visible for the about us page
    Then verify "vision and mission" is visible for the about us page
    Then verify "team" is visible for the about us page
    Then verify that there are no broken "links" on the page
    Then verify that there are no broken "images" on the page
    Then verify the layout is not broken for the page for mobile browser

    Examples:
      | Sna Academy URL     |
      | SNA Academy English |
      | SNA Academy Arabic  |