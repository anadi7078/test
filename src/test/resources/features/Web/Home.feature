@Home @SNAAcademy @Web
Feature: Home

  @ACAWEB001 @Home @P1 @DailyCheckList
  Scenario Outline: ACAWEB001 - Home page layout is proper with all it's details
    Given launch the "<Sna Academy URL>" website
    Then verify "youtube video popup" is displayed properly
    Then verify "clickable academy's logo" is displayed properly
    Then verify "header menu" is displayed properly
    Then verify "language change menu" is displayed properly
    Then verify "header image" is displayed properly
    Then verify "login icon" is displayed properly
    Then verify "register now button" is displayed properly
    Then verify "home screen contents" is displayed properly
    Then verify that there are no broken "links" on the page
    Then verify that there are no broken "images" on the page
    Then verify the layout is not broken for the page
    Then verify "footer components" is displayed properly
    Then verify "register now button in footer" is displayed properly

    Examples:
      | Sna Academy URL     |
      | SNA Academy English |
      | SNA Academy Arabic  |

  @ACAWEB002 @Home @P1 @DailyCheckList
  Scenario Outline: ACAWEB002 - Upcoming courses rail is displayed and functioning correctly
    Given launch the "<Sna Academy URL>" website
    Then verify "upcoming courses rail" is displayed properly
    And click on "course" and verify "course detail page" is opened
    Examples:
      | Sna Academy URL     |
      | SNA Academy English |
      | SNA Academy Arabic  |

  @ACAWEB003 @Home @P1 @DailyCheckList
  Scenario Outline: ACAWEB003 - Trainers list in home page is displayed properly
    Given launch the "<Sna Academy URL>" website
    Then verify "trainers list" is displayed properly
    And click on "any trainer" and verify "trainer's detail page" is opened
    And click on "all trainers button" and verify "trainers listing page" is opened
    Examples:
      | Sna Academy URL     |
      | SNA Academy English |
      | SNA Academy Arabic  |