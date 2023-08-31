@Videos @SNAAcademy @Web
Feature: Videos

  @ACAWEB027 @Videos @P1 @DailyCheckList
  Scenario Outline: ACAWEB027 - Videos archive page is displayed correctly and is listing all published videos
    Given launch the "CMS" website
    And login to CMS website
    And navigate to "Collection Types > Videos" tab in CMS
    And change language to "<language>" in dropdown
    And select "Video" filter
    Then click on clone if number of published "videos" is less than 8
    Given launch the "<Sna Academy URL>" website
    And navigate to "news" page from header
    And click on view all link for "videos"
    Then verify "header image" is visible for the "videos" page
    Then verify "title" is visible for the "videos" page
    Then verify "list of videos" is visible for the "videos" page
    And click on a "video" and verify it plays in a pop up window
    Then verify that there are no broken "links" on the page
    Then verify that there are no broken "images" on the page
    Then verify the layout is not broken for the page

    Examples:
      | Sna Academy URL     | language     |
      | SNA Academy English | English (en) |
      | SNA Academy Arabic  | Arabic (ar)  |

#  @ACAWEB028 @Videos @P1
#  Scenario Outline: ACAWEB028 - Videos are playing correctly
#    Given launch the "<Sna Academy URL>" website
#    And navigate to "news" page from header
#    And click on a "video" and verify it plays in a pop up window
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
