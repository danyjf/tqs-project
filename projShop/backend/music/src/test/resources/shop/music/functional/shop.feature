Feature: Browse Music Store App

  Scenario: Login to Account
    When I navigate to "http://localhost:4269/"
    And I Go to "Login" page
    Then I login with "admin@shop.pt" and "admin123"

  Scenario: Buy a specific product
    When I navigate to "http://localhost:4269/"
    And I Go to "Login" page
    Then I login with "admin@shop.pt" and "admin123"
    And I Select the Product I Want
    And I Click "Add to Cart" button
    And I Go to "Shopping Cart" Page
    And I fill the delivery note "leave at the door"
    And I fill the delivery phone number "917755443"
    And I fill the delivery address "University of Aveiro"
    And I fill the delivery name "Joe"
    Then I Checkout

  Scenario: Manage Shopping Cart
    When I navigate to "http://localhost:4269/"
    And I Go to "Login" page
    And I login with "admin@shop.pt" and "admin123"
    And I manage my shopping cart

