@LogoutTest
Feature: logout

  Background:
    When user opens page "https://www.way2automation.com/angularjs-protractor/registeration/#/login"

  Scenario: logout scenario
    When user enters angular and password and username
    And clicks login btn
    And waits page load "https://www.way2automation.com/angularjs-protractor/registeration/#/"
    When clicks logout btn
    Then user is redirected to the page "https://www.way2automation.com/angularjs-protractor/registeration/#/login"
