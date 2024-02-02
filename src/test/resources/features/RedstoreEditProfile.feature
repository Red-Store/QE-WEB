@EditProfile
Feature: Edit Profile
  User want to edit profie then logout

  @Flow2
  Scenario: User want to edit profile then logout
    Given User already on homepage
    And User click button sign in
    When User input "tuanpenguin12@gmail.com" as email and "123456" as password
    Then User already on homepage
    And User click icon profile
    And User click button profile
    When User edit name with "Rayhan" and username with "Rai12"
    When User click button submit
    Then User see "success update data" as a message
    And User click icon profile
    When User click button logout
    Then User will go back to login page