@StaticPages @SNAAcademy @Web
Feature: Static Pages

  @ACAWEB006 @StaticPages @P1 @DailyCheckList
  Scenario Outline: ACAWEB006 - Clicking on static pages links opens the respective page
    Given launch the "<Sna Academy URL>" website
    Then verify that the respective page is opening on clicking the menu item from the "footer"

    Examples:
      | Sna Academy URL     |
      | SNA Academy English |
      | SNA Academy Arabic  |