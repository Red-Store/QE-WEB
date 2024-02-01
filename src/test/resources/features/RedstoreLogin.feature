@Login
Feature: Login
  User want login to website Redstore

  @Flow
  Scenario: User login with valid credential
    Given User already on homepage
    Then User click button sign in
    When User input "tuanpenguin12@gmail.com" as email and "12345" as password
    Then User already on homepage

