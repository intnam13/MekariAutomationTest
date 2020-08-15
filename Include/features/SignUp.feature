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
Feature: Sign Up
  As user I want to login to amazon website successfully

  @SignUp_001
  Scenario Outline: To ensure that user cannot register with invalid email format
    Given user navigate to amazon website
    When user go to sign up screen
    And user input <name> and <email> and <password> and <repeat_password>
    And user click on continue button
    Then I verify the <warningMessage>

    Examples: 
      | name | email     | password | repeat_password | warningMessage              |
      | girl | girl@     |   123456 |          123456 | Enter a valid email address |
      | boy  | girlemail | password | password        | Enter a valid email address |

  @SignUp_002
  Scenario Outline: To ensure that user cannot register if the password not match with re enter password field
    Given user navigate to amazon website
    When user go to sign up screen
    And user input <name> and <email> and <password> and <repeat_password>
    And user click on continue button
    Then I verify the <warningMessage>

    Examples: 
      | name | email     					| password | repeat_password | warningMessage       |
      | girl | girl@gmail.com     | 123456	 | abcdefg         | Passwords must match |
      | boy  | boy@gmail.com		  | password | password123     | Passwords must match |
