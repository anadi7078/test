@Courses @SNAAcademy @Web
Feature: Courses

  @ACAWEB009 @Courses @P1 @DailyCheckList
  Scenario Outline: ACAWEB009 - Courses page is displayed properly
    Given launch the "<Sna Academy URL>" website
    And navigate to "courses" page from header
    Then verify "header image" is displayed for courses page
    Then verify "title" is displayed for courses page
    Then verify "searching section" is displayed for courses page
    Then verify "courses list" is displayed for courses page
    Then verify "courses details" is displayed for courses page
    Then verify that there are no broken "links" on the page
    Then verify that there are no broken "images" on the page
    Then verify the layout is not broken for the page

    Examples:
      | Sna Academy URL     |
      | SNA Academy English |
      | SNA Academy Arabic  |

  @ACAWEB010 @Courses @P1 @DailyCheckList
  Scenario Outline: ACAWEB010 - Navigating to course detail page upon clicking on view details from course listing
    Given launch the "<Sna Academy URL>" website
    And navigate to "courses" page from header
    And click on more details button of any course and verify respective page is opened

    Examples:
      | Sna Academy URL     |
      | SNA Academy English |
      | SNA Academy Arabic  |

  @ACAWEB011 @Courses @P1 @DailyCheckList
  Scenario Outline: ACAWEB011 - Courses filters are displayed properly
    Given launch the "<Sna Academy URL>" website
    And navigate to "courses" page from header
    Then verify "three filtering criteria" is displayed for courses page

    Examples:
      | Sna Academy URL     |
      | SNA Academy English |
      | SNA Academy Arabic  |

  @ACAWEB012 @Courses @P1 @DailyCheckList
  Scenario Outline: ACAWEB012 - Courses filtering is working correctly
    Given launch the "<Sna Academy URL>" website
    And navigate to "courses" page from header
    Then verify search results when filtered by "<course name>"
    Then verify search results when filtered by "course category"
    Then verify search results when filtered by "course month"

    Examples:
      | Sna Academy URL     | course name         |
      | SNA Academy English | course name English |
      | SNA Academy Arabic  | course name Arabic  |

  @ACAWEB013 @Courses @P1 @DailyCheckList
  Scenario Outline: ACAWEB013 - Course detail page is displayed correctly
    Given launch the "<Sna Academy URL>" website
    And navigate to "courses" page from header
    Then click on more details button of any course
    Then verify "header image" is displayed for courses page
    Then verify "opened course details" is displayed for courses page
    Then verify "related courses" is displayed for courses page
    Then verify "all courses button" is displayed for courses page
    Then verify that there are no broken "links" on the page
    Then verify that there are no broken "images" on the page
    Then verify the layout is not broken for the page

    Examples:
      | Sna Academy URL     |
      | SNA Academy English |
      | SNA Academy Arabic  |

  @ACAWEB014 @Courses @P1 @DailyCheckList
  Scenario Outline: ACAWEB014 - Related courses are displayed in course detail page
    Given launch the "<Sna Academy URL>" website
    And navigate to "courses" page from header
    Then click on more details button of any course
    Then verify "related courses details" is displayed for courses page
    And click on more details button of any course and verify respective page is opened

    Examples:
      | Sna Academy URL     |
      | SNA Academy English |
      | SNA Academy Arabic  |

  @ACAWEB015 @Courses @P1 @DailyCheckList
  Scenario Outline: ACAWEB015 - Courses sharing is working properly (desktop)
    Given launch the "<Sna Academy URL>" website
    And navigate to "courses" page from header
    Then click on more details button of any course
    And click on "facebook" social icon
    And click on "twitter" social icon
    And click on "whatsapp" social icon
    And click on "linkedin" social icon
    And click on "native share web" social icon

    Examples:
      | Sna Academy URL     |
      | SNA Academy English |
      | SNA Academy Arabic  |

  @ACAWEB017 @Courses @P1 @Regression
  Scenario Outline: ACAWEB017 - Can't enroll in a course if course's seats are fully booked
    Given launch the "CMS" website
    And login to CMS website
    And navigate to "Collection Types > Courses" tab in CMS
    And change language to "<language>" in dropdown
    Then clone a published course to have very few seats
    And logout from the CMS application
    Given launch the "<Sna Academy URL>" website
    And click on "account icon" and verify "login page" is opened
    And enter "valid" credentials in login page
    And navigate to "my account" from account icon menu
    And add contact information details if not present
    And navigate to "courses" page from header
    And search for the created course
    And click on more details button of any course
    And click on enroll button and verify "checkout page" is displayed
    And click on checkout button in cart page
    And click on "continue payment" button in payment page
    And select "bank transfer" as the payment method and proceed to payment
    And navigate to "courses" page from header
    And search for the created course
    And click on more details button of any course
    And click on enroll button and verify "error message" is displayed
    Given launch the "CMS" website
    And login to CMS website
    And navigate to "Collection Types > Courses" tab in CMS
    And change language to "<language>" in dropdown
    And search and delete the course

    Examples:
      | Sna Academy URL     | language     |
      | SNA Academy English | English (en) |
      | SNA Academy Arabic  | Arabic (ar)  |
