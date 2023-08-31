@Testimonials @SNAAcademy @Web
Feature: Testimonials

  @ACAWEB029 @Testimonials @P1 @DailyCheckList
  Scenario Outline: ACAWEB029 - Testimonials archive page is displayed correctly and is listing all published testimonials
    Given launch the "CMS" website
    And login to CMS website
    And navigate to "Collection Types > Videos" tab in CMS
    And change language to "<language>" in dropdown
    And select "Testimonial" filter
    Then click on clone if number of published "testimonials" is less than 8
    Given launch the "<Sna Academy URL>" website
    And navigate to "news" page from header
    And click on view all link for "testimonials"
    Then verify "header image" is visible for the "testimonials" page
    Then verify "title" is visible for the "testimonials" page
    Then verify "list of testimonials" is visible for the "testimonials" page
    And click on a "testimonial" and verify it plays in a pop up window
    Then verify that there are no broken "links" on the page
    Then verify that there are no broken "images" on the page
    Then verify the layout is not broken for the page

    Examples:
      | Sna Academy URL     | language     |
      | SNA Academy English | English (en) |
      | SNA Academy Arabic  | Arabic (ar)  |

#  @ACAWEB030 @Testimonials @P1
#  Scenario Outline: ACAWEB030 - Testimonials are playing correctly
#    Given launch the "<Sna Academy URL>" website
#    And navigate to "news" page from header
#    And click on a "testimonial" and verify it plays in a pop up window
#    And verify "pause" control is working fine
#    And verify "play" control is working fine
#    And verify "mute" control is working fine
#    And verify "full screen" control is working fine
#    And verify "playback speed" control is working fine
#    And verify "download" control is working fine
#    And verify "picture in picture" control is working fine
#    And verify "close" control is working fine
#
#    Examples:
#      | Sna Academy URL     |
#      | SNA Academy English |
#      | SNA Academy Arabic  |
