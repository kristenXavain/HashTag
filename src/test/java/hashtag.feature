Feature: HashTagWebsite

  Scenario: HashTag Join Us Page
    Given user Launch The Application By Using The Url
    When user Enters The UserName in The Name Field
    And user Enters The EmailId Of The User in the Email Field
    And user Enters The Phone Number In The Phone Number Field and It Must be only Integer
    And user Clicks The Choose File Option For Uploading Resume and File Folder Will Open
    And user Selects Some file
    And user Can Give Their Description In the Description Field
    Then user Clicks The Apply Now button and It Will Navigate To The Apply Now Page
