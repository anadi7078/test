@Home @SNAAcademy @Mobile
Feature: Home

  Background:
    Given open the Chrome app on "android device"

  @ACAWEB001Mobile @Home @P1 @MobileDailyCheckList
  Scenario Outline: ACAWEB001 - Home page layout is proper with all it's details
    Given launch the "<Sna Academy URL>" website on chrome
    Then verify "youtube video popup" is displayed properly
    Then verify "clickable academy's logo" is displayed properly
    Then verify "header image" is displayed properly
    Then verify "register now button" is displayed properly
    Then verify "burger menu" is displayed properly
    And "open" burger menu
    Then verify "language change menu" is displayed properly
    Then verify "login icon" is displayed properly
    And "close" burger menu
    Then verify "home screen contents" is displayed properly
    Then verify "footer components" is displayed properly
    Then verify "register now button in footer" is displayed properly
    Then verify that there are no broken "links" on the page
    Then verify that there are no broken "images" on the page
    Then verify the layout is not broken for the page for mobile browser

    Examples:
      | Sna Academy URL     |
      | SNA Academy English |
      | SNA Academy Arabic  |

  @ACAWEB002Mobile @Home @P1 @MobileDailyCheckList
  Scenario Outline: ACAWEB002 - Upcoming courses rail is displayed and functioning correctly
    Given launch the "<Sna Academy URL>" website on chrome
    Then verify "upcoming courses rail" is displayed properly
    And click on "course" and verify "course detail page" is opened
    Examples:
      | Sna Academy URL     |
      | SNA Academy English |
      | SNA Academy Arabic  |

  @ACAWEB003Mobile @Home @P1 @MobileDailyCheckList
  Scenario Outline: ACAWEB003 - Trainers list in home page is displayed properly
    Given launch the "<Sna Academy URL>" website on chrome
    Then verify "trainers list" is displayed properly
    And click on "any trainer" and verify "trainer's detail page" is opened
    And click on "all trainers button" and verify "trainers listing page" is opened
    Examples:
      | Sna Academy URL     |
      | SNA Academy English |
      | SNA Academy Arabic  |