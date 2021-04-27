Feature: User access Mercury tours application

@Test1
Scenario: Login screen check
Given user open "chrome" browser
And user enter application url "http://demo.guru99.com/test/newtours/index.php"
Given enter user name as "QQQQQ"
And enter password as "qqqqq"
Then we get success page