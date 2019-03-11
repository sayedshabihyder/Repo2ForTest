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
Feature: Demo App Login
  As a User i should be able to login on Demo App

  @tag2
  Scenario Outline: Login On Demo website
    Given User navigate to url "http://demo.nopcommerce.com/"
    When User clicks on "Login" on "DemoHomePage"
    And User wait for "Email textboxs" to be visible on "DemoLoginPage"
    When User types <email> in "Email textbox" on "DemoLoginPage"
    When User types <password> in "Password textbox" on "DemoLoginPage"
    Then User clicks on "Log In" on "DemoLoginPage"
    Then User wait for "LogOut Button" to be visible on "DemoHomePage"
    And User waits for "5000" milliseconds
    And User take screenshot
     Examples: 
      | email         | password|
      | "abc@xyz.com" | "Bean12" |
      
