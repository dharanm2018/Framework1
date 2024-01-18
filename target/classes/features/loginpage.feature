@Login
Feature: Login page feature

@Smoke
Scenario: Login page title
Given user is on login page
When user gets the title of the page
Then page title should be "Adactin.com - Hotel Reservation System"
@Smoke
Scenario: Forgot Password link
Given user is on login page
Then forgot your password link should be displayed
@Regression @Skip
Scenario: Login with correct credentials
Given user is on login page
When user enters username "dharanm2018"
And user enters password "Canon@550"
And user clicks on Login button
Then user gets the title of the page
And page title should be "Adactin.com - Search Hotel"