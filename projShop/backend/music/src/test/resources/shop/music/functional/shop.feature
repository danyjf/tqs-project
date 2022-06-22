Feature: Browse Music Store App
  Scenario: Create an Account
    When I navigate to "http://localhost:4200/"
    And I Go to "Login" page
    And I click "Create New Account"
    Then I create new account with user "Admin", fullname "ShopAdmin", email "admin@gmail.com", password "password"

  Scenario: Login to Account
    When I navigate to "http://localhost:4200/"
    And I Go to "Login" page
    Then I login with "admin@gmail.com" and "password"

  Scenario: Buy a specific product
    When I navigate to "http://localhost:4200/"
    And I Select the Product I Want
    And I Click "Add to Cart" button
    And I click "Create New Account"
    And I create new account with user "Joe", fullname "Joe Mama", email "joe@gmail.com", password "pass12345"
    And I Select the Product I Want
    And I Click "Add to Cart" button
    And I Go to "Shopping Cart" Page
    And I fill the delivery note "leave at the door"
    And I fill the delivery phone number "917755443"
    And I fill the delivery address "University of Aveiro"
    And I fill the delivery name "Joe"
    Then I Checkout

  Scenario: Manage Shopping Cart
    When I navigate to "http://localhost:4200/"
    And I Go to "Login" page
    And I login with "admin@gmail.com" and "password"
    And I add some products to my shopping cart
    And I Go to "Shopping Cart" Page
    And I delete some products from the Cart
    Then I empty the cart
