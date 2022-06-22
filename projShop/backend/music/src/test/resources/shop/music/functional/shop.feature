Feature: Browse Music Store App
  Scenario: Create an Account
    When I navigate to "http://localhost:4200/"
    And I Go to "Login" page
    And I click "Create New Account"
    And I create new account with user "Joe", fullname "Joe Mama", email "joe@gmail.com", password "password"



