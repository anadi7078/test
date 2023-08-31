@MyAccount @SNAAcademy @Mobile
Feature: MyAccount

  Background:
    Given open the Chrome app on "android device"

  @ACAWEB048Mobile @MyAccount @P1
  Scenario Outline: ACAWEB048 - User can add contact information to his account
       ####----Pre Requisite Started-------###
    Given launch the "<Sna Academy URL>" website on chrome
    And "open" burger menu
    And click on "account icon" and verify "login page" is opened
    And enter "valid" credentials in login page
    And "open" burger menu
    And navigate to "my account" from account icon menu
    And delete already added contact details if any
    And "open" burger menu
    Then navigate to "logout" from account icon menu
     ####----Pre Requisite Ended-------###
    And enter "valid" credentials in login page
    And "open" burger menu
    And navigate to "my account" from account icon menu
    And click on "add new contact information" button
    And click on "cancel" button
    And click on "add new contact information" button
    And fill "valid" contact information details
    And click on "save" button
    And verify "valid" contact information details

    Examples:
      | Sna Academy URL     |
      | SNA Academy English |
      | SNA Academy Arabic  |

  @ACAWEB049Mobile @MyAccount @P1
  Scenario Outline: ACAWEB049 - User can have maximum two contact details and can delete entries successfully
     ####----Pre Requisite Started-------###
    Given launch the "<Sna Academy URL>" website on chrome
    And "open" burger menu
    And click on "account icon" and verify "login page" is opened
    And enter "valid" credentials in login page
    And "open" burger menu
    And navigate to "my account" from account icon menu
    And delete already added contact details if any
    And "open" burger menu
    Then navigate to "logout" from account icon menu
     ####----Pre Requisite Ended-------###
    And enter "valid" credentials in login page
    And "open" burger menu
    And navigate to "my account" from account icon menu
    And click on "add new contact information" button
    And fill "valid" contact information details
    And click on "save" button
    And click on "add new contact information" button
    And fill "valid" contact information details
    And click on "save" button
    Then verify add new contact information button is not displayed
    And click on "remove" button

    Examples:
      | Sna Academy URL     |
      | SNA Academy English |
      | SNA Academy Arabic  |