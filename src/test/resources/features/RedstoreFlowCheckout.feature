@Login
Feature: Flow usually checkout
  User want checkout a product at website Redstore

  @FlowCheckout
  Scenario: User login with valid credential
    Given User already on homepage
    Then User click button sign in
    When User input "tuanpenguin12@gmail.com" as email and "12345" as password
    Then User already on homepage
    When User click fourth product from catalog
    Then User already on product page
    When User click add to cart the product
    When User click the cart
    Then User already on cart page
    When User want increase quantity
    Then Verify total value is correct
    When User click process order
    Then User already on order page
    When User input "planet pluto" as an address
    When User set the payment method and confirm
    When User click checkout product
    Then User already complete the order




