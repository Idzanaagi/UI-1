@LoginTest
Feature: login

  Background:
    When user opens page "https://www.way2automation.com/angularjs-protractor/registeration/#/login"

  Scenario: login with valid value scenario
  try to login with valid values
    When user enters angular and password and username
    And clicks login btn
    Then check successfully login


  Scenario Outline: login with wrong value scenario
  try to login with wrong value
    When user enters <username> and <password> and <descr>
    And clicks login btn
    Then check failed login for <username> or <password> of incorrect values

    Examples:
      | username | password | descr |
      | test | password | username  |
      | angular | test | username |


  Scenario Outline: login with invalid length value scenario
  try to login with invalid length value
    When user enters <username> and <password> and <descr>
    And clicks login btn
    Then check failed login for <username> or <password> or <descr> of invalid value length

    Examples:
      | username | password | descr |
      | te | password | username  |
      | angular | te | username   |
      | angular | password | te   |
      | username | password | descr |
      | | password | username  |
      | angular |  | username   |
      | angular | password | |
