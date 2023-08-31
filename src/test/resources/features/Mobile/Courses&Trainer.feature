@Courses/Trainer @SNAAcademy @Mobile
Feature: Courses/Trainer

  Background:
    Given open the Chrome app on "android device"

  @ACAWEB050Mobile @Courses/Trainer @P1
  Scenario Outline: ACAWEB050 - On responsive layout, filtering section can be docked
    Given launch the "<Sna Academy URL>" website on chrome
    And navigate to "courses" page from header
    Then click on filter docking arrow and verify filtering section is docked
    And navigate to "trainers" page from header
    Then click on filter docking arrow and verify filtering section is docked

    Examples:
      | Sna Academy URL     |
      | SNA Academy English |
      | SNA Academy Arabic  |

