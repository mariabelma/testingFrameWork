Feature:Login

  As a user
  I should login

  Background:
    Given I'm on Home Page
    When I click My Account icon


  @login @smoke @regression
  Scenario Outline: Validate login with valid credential
    When I enter registered "<email>" in username text field
    When I enter registered "<password>" in password text field
    When I click sign in button
    Then I should be re-directed to profile page
    Examples:


  @login
  Scenario Outline: Validate login with invalid email and password
    When I enter registered invalid "<email>" in username text field
    When I enter registered invalid "<password>" in password text field
    When I click sign in button
    Then I should be get warning message
    Examples:
      | email               | password |
      | yo12india@gmail.com | test     |

