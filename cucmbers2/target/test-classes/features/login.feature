Feature: Login functionality for demo site


Background:
Given user is on the login page
And clicks on the login button


@agile
  Scenario: Successful login with valid credentials
    #Given user is on the login page
    When user enters username "Admin" and password "admin123"
    #And clicks on the login button
    Then user should be redirected to the dashboard
   
   
@smoke @agile 
  Scenario: Successful login with invalid credentials
    #Given user is on the login page
    When user enters username "Admins" and password "admin1234"
    #And clicks on the login button
    But user should not redirected to dashboard
