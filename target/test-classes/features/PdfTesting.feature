#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Sample pdf testing
  As a user i should able to download and verify pdf

  @tag1
  Scenario: Download and verify a pdf
    Given User navigate to url "http://www.google.com"
    Then User types "Sample Pdf" in "SearchBar" on "GeneralPage"
    And User wait for "GoogleSearchButton" to be visible on "GeneralPage"
    Then User clicks on "GoogleSearchButton" on "GeneralPage"
    Then User clicks on "SimplePdfFile" on "GeneralPage"
    Then User waits for "2000" milliseconds
    Then User verify pdf is downloaded in location "D:\\DownloadedFile"
    Then User verify "Virtual Mechanics" is present in downloaded pdf on location "D:\\DownloadedFile\\sample.pdf"
   