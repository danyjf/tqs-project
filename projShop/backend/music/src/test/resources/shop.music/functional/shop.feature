Feature: Buy a specific product

  Scenario: Buy a specific product
    When I navigate to "http://localhost:4200/"
    And I Select the Product I Want
    And I Click "Buy" button
    And I click "Create New Account"
    And I create new account with user "Joe", fullname "Joe Mama", email "joe@gmail.com", password "password"
    And I Select the Product I Want
    And I Click "Buy" button
    And I confirm buy for address "Joe's House"
