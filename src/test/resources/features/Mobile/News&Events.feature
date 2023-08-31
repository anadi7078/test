@News&Events @SNAAcademy @Mobile
Feature: News&Events


  @ACAWEB023Mobile @News&Events @P1 @MobileDailyCheckList
  Scenario Outline: ACAWEB023 - News & Events page is displayed correctly along with News, Videos and testimonials
    Given open the Chrome app on "android device"
    Given launch the "<Sna Academy URL>" website on chrome
    And navigate to "news" page from header
    Then verify "header image" is visible for the "news" page
    Then verify "title" is visible for the "news" page
    Then verify "news section" is visible for the "news" page
    Then verify "videos section" is visible for the "news" page
    Then verify "testimonials section" is visible for the "news" page
    Then verify that there are no broken "links" on the page
    Then verify that there are no broken "images" on the page
    Then verify the layout is not broken for the page for mobile browser

    Examples:
      | Sna Academy URL     |
      | SNA Academy English |
      | SNA Academy Arabic  |

  @ACAWEB024Mobile @News&Events @P1 @MobileDailyCheckList
  Scenario Outline: ACAWEB024 - News archive page is displayed correctly and is listing all published news
    Given launch the "CMS" website on web
    And login to CMS website
    And navigate to "Collection Types > Stories" tab in CMS
    And change language to "<language>" in dropdown
    Then click on clone if number of published "stories" is less than 5
    And close the web driver
    Given open the Chrome app on "android device"
    Given launch the "<Sna Academy URL>" website on chrome
    And navigate to "news" page from header
    And click on view all link for "news"
    Then verify "header image" is visible for the "news" page
    Then verify "title" is visible for the "news" page
    Then verify "list of news" is visible for the "news" page
    And click on any "news" in news section
    And navigate back
    Then verify that there are no broken "links" on the page
    Then verify that there are no broken "images" on the page
    Then verify the layout is not broken for the page for mobile browser

    Examples:
      | Sna Academy URL     | language     |
      | SNA Academy English | English (en) |
      | SNA Academy Arabic  | Arabic (ar)  |

  @ACAWEB025Mobile @News&Events @P1 @MobileDailyCheckList
  Scenario Outline: ACAWEB025 - News details page is displayed properly
    Given open the Chrome app on "android device"
    Given launch the "<Sna Academy URL>" website on chrome
    And navigate to "news" page from header
    And click on any "news" in news section
    Then verify "header image" is visible for the "news" page
    Then verify "headline" is visible for the "news" page
    Then verify "date" is visible for the "news" page
    Then verify "sharing icons" is visible for the "news" page
    Then verify "image" is visible for the "news" page
    Then verify "news details" is visible for the "news" page
    Then verify "more news" is visible for the "news" page
    Then verify "more news image" is visible for the "news" page
    Then verify "more news headline" is visible for the "news" page
    Then verify "more news date" is visible for the "news" page
    And click on any "more news" in news section
    Then verify that there are no broken "links" on the page
    Then verify that there are no broken "images" on the page
    Then verify the layout is not broken for the page for mobile browser

    Examples:
      | Sna Academy URL     |
      | SNA Academy English |
      | SNA Academy Arabic  |

  @ACAWEB026Mobile @Courses @P1 @MobileDailyCheckList
  Scenario Outline: ACAWEB026 - News sharing is working properly
    Given open the Chrome app on "android device"
    Given launch the "<Sna Academy URL>" website on chrome
    And navigate to "news" page from header
    And click on any "news" in news section
    And click on "twitter mobile" social icon
    And click on "whatsapp" social icon
    And click on "linkedin mobile" social icon
    And click on "facebook mobile" social icon
    And click on "native share mobile" social icon

    Examples:
      | Sna Academy URL     |
      | SNA Academy English |
      | SNA Academy Arabic  |