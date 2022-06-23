Feature: Browse Deliveries App

  Scenario: Login to account
    When I navigate to "http://deti-tqs-15.ua.pt:4200/"
    Then I login with "rider@gmail.com" and "riderpass"
