@BurgerMenu @SNAAcademy @Mobile
Feature: Burger menu, Logo and Language change

  Background:
    Given open the Chrome app on "android device"

  @ACAWEB005Mobile @BurgerMenu @P1 @MobileDailyCheckList
  Scenario Outline:ACAWEB005 - Burger menu, Academy logo + language change are displayed and functioning correctly
    Given launch the "<Sna Academy URL>" website on chrome
    And click on "academy's logo" and verify "home page" is opened
    And click on "burger menu icon" and verify "menu" is opened
    And click on "courses in burger menu" and verify "courses list" is opened
    And click on "any menu item" and verify "respective page" is opened
    And "open" burger menu
    And click on "language dropdown" and verify "respective language home page" is opened
    Examples:
      | Sna Academy URL     |
      | SNA Academy English |
      | SNA Academy Arabic  |