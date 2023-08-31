@HeaderMenu @SNAAcademy @Web
Feature: Header menu, Logo and Language change

  @ACAWEB004 @HeaderMenu @P1 @DailyCheckList
  Scenario Outline:ACAWEB004 - Header menu, Academy logo + language change are displayed and functioning correctly
    Given launch the "<Sna Academy URL>" website
    Then verify that the respective page is opening on clicking the menu item from the "header"
    And click on "academy's logo" and verify "home page" is opened
    And click on "language dropdown" and verify "respective language home page" is opened
    Examples:
      | Sna Academy URL     |
      | SNA Academy English |
      | SNA Academy Arabic  |