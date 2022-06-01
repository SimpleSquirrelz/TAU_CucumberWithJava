Feature: Login Functionality
  In order to do internet banking
  As a valid customer
  I want to login successfully

  Scenario: Login Successful
    Given I am in the login page of Para Bank Application
    When I enter valid credentials
    Then I should be taken to the Overview page

  Scenario Outline: Login Successful
    Given I am in the login page of Para Bank Application
    When I enter valid <username> and <password>
    Then I should be taken to the Overview page
  Examples:
    |username|password|
    |"test1" |"pass1" |
    |"test2" |"pass2" |

  Scenario: Login Successful
    Given I am in the login page of Para Bank Application
    When I enter valid credentials
      |"test1" |"pass1" |
      |"test2" |"pass2" |
    Then I should be taken to the Overview page

  Scenario Outline: Login Successful
    Given I am in the login page of Para Bank Application
    When I enter valid <username> and <password> with <userFullName>
    Then I should be taken to the Overview page
    Examples:
      |username|password|userFullName|
      |"test1" |"pass1" |"FullName"  |
      |"test2" |"pass2" |"FullName2" |