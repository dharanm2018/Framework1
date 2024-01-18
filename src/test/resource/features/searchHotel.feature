Feature: Search Hotel
Background:
Given user has already logged in to application
|username|password|
|dharanm2018|Canon@550|
@SearchHotel
Scenario: Adactin Search page Title
Given user is on Search page
When user gets the title of the page
Then page title should be "Adactin.com - Search Hotel"
@SearchHotel
Scenario: Search Hotel Section
Given user is on Search page
Then user gets Location section criteria
|- Select Location -|
|Sydney|
|Melbourne|
|Brisbane|
|Adelaide|
|London|
|New York|
|Los Angeles|
|Paris|
And Search criteria should be 9



#Scenario: Result Page of Search Hotel
#Given user is on search hotel result page 
#When user gets the title of the page
#Then page title should be "Adactin.com - Search Hotel"
#And click on the searched result and Continue




