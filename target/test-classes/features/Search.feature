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
Feature: GoogleSearch
  As a User I sohuld be able to search on google

 
 @Regression  @Test1 @Smoke
  Scenario: User Search on Google Homepage
  	Given User navigate to url "https://google.com"
    And User "should" see page title as "Google"
    When User presses key "7"
    Then User types "java" in "SearchBar" on "GeneralPage"
    And User wait for "GoogleSearchButton" to be visible on "GeneralPage"
    Then User clicks on "GoogleSearchButton" on "GeneralPage"
    Then User wait for "FirstLink" to be clickable on "SearchPage"
    Then User wait for "FirstLink" to be present on "SearchPage"
    
    @Test2
    Scenario: Double click on element
    Given User navigate to url "http://demo.guru99.com/test/simple_context_menu.html"
    When User double click on "DoubleClickDemoButton" on "GeneralPage"
    
     @Test3
    Scenario: Click on element by link text 
    Given User navigate to url "http://demo.guru99.com/test/simple_context_menu.html"
    When User click on link having text "Insurance Project" on "GeneralPage"
    
    @Test4
    Scenario: Click on element by partial link text 
    Given User navigate to url "http://demo.guru99.com/test/simple_context_menu.html"
    When User click on link having partial text as "Ins" on "GeneralPage"
    
    @Test5
    Scenario: Verify checkbox is checked
    Given User navigate to url "http://demo.guru99.com/test/radio.html"
    #Then User clicks on "Login" on "MakeMyTripHomePage"
    When User check the "CheckBox" checkbox on "GeneralPage"
    Then User verifies "CheckBox" should be "checked" on "GeneralPage"
    Then User uncheck the "CheckBox" checkbox on "GeneralPage"
    Then User verifies "CheckBox" should be "checked" on "GeneralPage"
    #Then User clicks on checked checkbox with name "Checked" on "MakeMyTripLoginPage" 
    
    @Test6
    Scenario: Verify checkbox is unchecked
    Given User navigate to url "http://demo.guru99.com/test/radio.html"
    When User check the "CheckBox" checkbox on "GeneralPage"
    Then User uncheck the "CheckBox" checkbox on "GeneralPage"
    Then User verifies "CheckBox" should be "unchecked" on "GeneralPage"
    When User check the "CheckBox" checkbox on "GeneralPage"
    Then User verifies "CheckBox" should be "unchecked" on "GeneralPage"
    #Then User clicks on checked checkbox with name "Checked" on "MakeMyTripLoginPage" 
    
    @Regression  @Test
    Scenario: Validate Page Title on Google
    Given User navigate to url "https://google.com"
    And User "should not" see page title as "abc"
   
   @Test19
   Scenario: User Search on Google Homepage
  	Given User navigate to url "https://google.com"
    And User "should" see page title as "Google"
    Then User types "java" in "SearchBar" on "GeneralPage"
    When User presses key "1"
    
    @Regression @Test61
    Scenario: Search On Yahoo Homepage
    Given User navigate to url "http://yahoo.com"
    Then User wait for "yahooSearchBar" to be visible on "GeneralPage"
    When User clicks on "yahooSearchBar" on "GeneralPage"
    When User clicks on "About Us" on "HomePage"
    Then User wait for 2 seconds
    When User types "java" in "yahooSearchBar" on "GeneralPage"
    Then User wait for "yahooSearchBtn" to be visible on "GeneralPage"
    Then User clicks on "yahooSearchBtn" on "GeneralPage"
    Then User wait for "oracleUrl" to be visible on "GeneralPage"
    When User clicks on "oracleUrl" on "GeneralPage"
    Then User wait for 2 seconds
    Then User switch to new window
    Then User wait for "Menu" to be visible on "GeneralPage"
    Then User clicks on "Menu" on "GeneralPage"
    Then User clicks on "Attendance" on "Homepage"
    And User take screenshot
    
    @Regression @Test7
    Scenario: Mouse Hovering
    Given User navigate to url "http://www.globalsqa.com/"
    Then User hovers on "TestersHub" then hovers on "DemoTesting Site" and sees "SubMenu Items" and clicks on "Frames And Windows" on "GeneralPage"

    @Regression @Test8
    Scenario: Check and uncheck Checkbox
    Given User navigate to url "http://makemytrip.com/"
    Then User clicks on "Login" on "MakeMyTripHomePage"
    When User check the "Checkbox" checkbox on "MakeMyTripLoginPage"
    Then User clicks on checked checkbox with name "Checked" on "MakeMyTripLoginPage" 
    
    @Test7
    Scenario: Uncheck Checkbox
    Given User navigate to url "http://makemytrip.com/"
    #Then User clicks on "Login" on "MakeMyTripHomePage"
    Given User navigate to url "http://yahoo.com/"
    And User navigates back
    And User navigates forward
    When User check the "UncheckedCheckbox" checkbox on "MakeMyTripLoginPage"
    Then User wait for "10" seconds
    Then User verifies "CheckedCheckbox" is "Checked" on "MakeMyTripLoginPage"
    Then User clicks on checked checkbox with name "CheckedCheckbox" on "MakeMyTripLoginPage"
    Then User verifies "UncheckedCheckbox" is "Unchecked" on "MakeMyTripLoginPage"
    Then User verifies "CheckedCheckbox" is "Checked" on "MakeMyTripLoginPage"
    Then User verifies "Checked" should be "checked" on "MakeMyTripLoginPage"
    Then User uncheck the "checked" checkbox on "MakeMyTripLoginPage"
    
    
    @Test11
    Scenario: Select Item from Drop Down
    Given User navigate to url "http://newtours.demoaut.com/mercuryregister.php"
   When User selects "ANGUILLA" from drop down "Countries" on "GeneralPage"
    Then option with value "ANGUILLA" having string length "8" from dropdown "Countries" should be "selected" on "GeneralPage"
    
    @Test9
    Scenario: Verify radio button selected
    Given User navigate to url "http://demo.guru99.com/test/radio.html"
    When User select "Option1" radio button on "GeneralPage"
    Then radio button having title "Option1" should be "selected" on "GeneralPage"
   # Then radio button having title "Option1" should be "selected" on "GeneralPage"
    
    @Test10
    Scenario: Verify radio button is not selected
    Given User navigate to url "http://demo.guru99.com/test/radio.html"
    Then radio button having title "Option1" should be "selected" on "GeneralPage"
    
    @Test12
    Scenario: Unselect radio button
    Given User navigate to url "https://www.goibibo.com/"
    When User Unselects "OnewayRadioButton" radio button on "GoibiboHomePage"
    
    @Test12
    Scenario: Assert radio button selected
    Given User navigate to url "https://www.goibibo.com/"
    Then radio button having title "RoundTripRadioButton" should be "selected" on "GoibiboHomePage"
    
    @Test13
    Scenario: Assert radio button Unselected
    Given User navigate to url "https://www.goibibo.com/"
    Then radio button having title "OnewayRadioButton" should be "unselected" on "GoibiboHomePage"
    
    @Test12
    Scenario: Assert Element Presence
    Given User navigate to url "https://stackoverflow.com"
    Then User verfies presence of "Login" link on "StackOverflowHomePage"
    
    @Test13
    Scenario: Verify page title by partial text
    Given User navigate to url "https://stackoverflow.com"
    Then User "should see" partial text of page title as "Stack" on "StackOverflowHomePage"
    
    @Test14
    Scenario: Verify Element text
    Given User navigate to url "https://stackoverflow.com"
    Then Element "SignUpButton" "should not have" have text as "Sign Up" on "StackOverflowHomePage"   
    
    @Test15
    Scenario: Verify element state
    Given User navigate to url "https://hybrid.incedoinc.com/owa/#path=/calendar"
    Then Element "Calendar" "should" be present and should be in "Disabled" state on "OutlookNewEventPage"    
    
     @Test16
    Scenario: Verify element state
    Given User navigate to url "https://hybrid.incedoinc.com/owa/#path=/calendar"
    Then User types "naveen.g1" in "UserName" on "OutlookNewEventPage"
    Then User types "Incedo@123" in "password" on "OutlookNewEventPage"
    Then User clicks on "SignIn" on "OutlookNewEventPage"
    Then User wait for "10" seconds for element "Calendar" to be present on "OutlookNewEventPage"
    Then User hovers and click on "Calendar" on "OutlookNewEventPage"
    Then User wait for "10" seconds for element "NewEvent" to be present on "OutlookNewEventPage"
    Then User wait for "10" seconds
    And User navigates back
    Then User waits for "10" seconds
    Then User waits for "10" seconds
    And User navigates forward
    Then User clicks on "NewEvent" on "OutlookNewEventPage"
    Then User waits for "10" seconds
    Then User types "naveen.g1" in "Event TextBox" on "OutlookNewEventPage"
    Then User clicks on "Mail" on "OutlookNewEventPage"
    Then User waits for "10" seconds
    Then User verifies "Scheduling assistant" element "is" present by partial text "SCHEDULING ASSISTANT" on "OutlookNewEventPage"
    Then User verifies "CalendarElement" "should" be present and should be in "Disabled" state on "OutlookNewEventPage"    
    Then User verifies "Showas" "should" be present and should be in "Disabled" state on "OutlookNewEventPage"    
    
    @Test17
    Scenario: Verify alert box text(Pass)
    Given User navigate to url "http://demo.automationtesting.in/Alerts.html"
    Then User should see alert text as "I am an alert box!"
    
    @Test18
    Scenario: Verify alert box text(Fail)
    Given User navigate to url "http://demo.automationtesting.in/Alerts.html"
    Then User should see alert text as "abc"
    
   @Test20
   Scenario: Press Key
    Given User navigate to url "https://hybrid.incedoinc.com/owa/#path=/calendar"
    Then User types "naveen.g1" in "UserName" on "OutlookNewEventPage"
    Then User presses "TAB" key in "UserName" field on "OutlookNewEventPage"
    
   @Test21
   Scenario: Switch to windows using index
    Given User navigate to url "http://seleniumpractise.blogspot.com/"
    Then User prints title of window
    Then User clicks on "New window option" on "GeneralPage"
    When User switch to window having index "1"
    Then User prints title of window
    When User switch to window having index "0"
    Then User waits for "3000" milliseconds
    Then User prints title of window
    And User closes window having index "1"
    
    @Test22  
     Scenario: Switch to new windows
     Then User switch to window having window handle "7E671374420444AD98F4DBF441675014"
       
    @Test22
   Scenario: Switch to child windows
    Given User navigate to url "http://seleniumpractise.blogspot.com/"
    Then User clicks on "New window option" on "GeneralPage"
    Then User switch to child window
    
    @Test23
    Scenario: Switch to child windows
    Given User navigate to url "https://www.google.com/"
    Then User waits for "3000" milliseconds
    Then User types "he" in "SearchBar" on "GeneralPage"
    Then User selects element "headphones" from autocomplete list