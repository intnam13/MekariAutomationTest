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
Feature: Sign In
  As user I want to login to amazon website successfully

  @SignIn_001
  Scenario Outline: To ensure that user cannot cannot leave email/phone number field blank/empty (Negative Case)
    Given user navigate to amazon website
    When user go to sign in screen
    And user enter <email>
    And user click on continue button
    Then I verify the <warningMessage>

    Examples: 
      | email  		| warningMessage 														|
      | empty 		| Enter your email or mobile phone number		|
      
      
      
        @SignIn_002
  Scenario Outline: To ensure that user cannot login with invalid email or phone number (Negative Case)
    Given user navigate to amazon website
    When user go to sign in screen
    And user enter <email>
    And user click on continue button
    Then I verify the <warningMessage>

    Examples: 
      | email  						| warningMessage 																			|
      | dummy43@gmail.com | We cannot find an account with that email address		|
      | 0487384783		 		| We cannot find an account with that mobile number		|