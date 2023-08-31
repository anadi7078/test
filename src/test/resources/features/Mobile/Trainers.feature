@Trainers @SNAAcademy @Mobile
Feature: Trainers

  Background:
    Given open the Chrome app on "android device"

  @ACAWEB018Mobile @Trainers @P1 @MobileDailyCheckList
  Scenario Outline:ACAWEB018 - Trainers page is displayed properly
    Given launch the "<Sna Academy URL>" website on chrome
    And navigate to "trainers" page from header
    And verify "header image" is visible for the trainers page
    And verify "trainers title" is visible for the trainers page
    And verify "trainer Searchbar" is visible for the trainers page
    And verify "trainer List" is visible for the trainers page
    And verify "trainer Image" is visible for the trainers page
    And verify "trainer Name" is visible for the trainers page
    And verify "trainer Category" is visible for the trainers page
    Then verify that there are no broken "links" on the page
    Then verify that there are no broken "images" on the page
    Then verify the layout is not broken for the page for mobile browser
    Examples:
      | Sna Academy URL     |
      | SNA Academy English |
      | SNA Academy Arabic  |

  @ACAWEB019Mobile @Trainers @P1 @MobileDailyCheckList
  Scenario Outline:ACAWEB019 - Navigating to the trainer's detail page upon clicking on view details from trainers listing
    Given launch the "<Sna Academy URL>" website on chrome
    When navigate to "trainers" page from header
    Then click on any trainer and verify trainer's detail page is opened
    Examples:
      | Sna Academy URL     |
      | SNA Academy English |
      | SNA Academy Arabic  |

  @ACAWEB020Mobile @Trainers @P1 @MobileDailyCheckList
  Scenario Outline:ACAWEB020 - Trainers filters are displayed properly
    Given launch the "<Sna Academy URL>" website on chrome
    When navigate to "trainers" page from header
    Then verify that filtering criteria Trainer Name and By Category is visible

    Examples:
      | Sna Academy URL     |
      | SNA Academy English |
      | SNA Academy Arabic  |


  @ACAWEB021Mobile @Trainers @P1 @MobileDailyCheckList
  Scenario Outline:ACAWEB021 - Trainers filtering is working correctly
    Given launch the "<Sna Academy URL>" website on chrome
    When navigate to "trainers" page from header
    Then verify search result when filtered by "<data>"
    Then unselect one or more of the categories
    Examples:
      | Sna Academy URL     | data   |
      | SNA Academy English | dataen |
      | SNA Academy Arabic  | dataar |

  @ACAWEB022Mobile @Trainers @P1 @MobileDailyCheckList
  Scenario Outline:ACAWEB022 - Trainers detail page is displayed correctly
    Given launch the "<Sna Academy URL>" website on chrome
    When navigate to "trainers" page from header
    Then click on any trainer image and verify trainer's detail page
    Examples:
      | Sna Academy URL     |
      | SNA Academy English |
      | SNA Academy Arabic  |
