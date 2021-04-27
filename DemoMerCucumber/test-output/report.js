$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("login.feature");
formatter.feature({
  "line": 1,
  "name": "User access Mercury tours application",
  "description": "",
  "id": "user-access-mercury-tours-application",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 4,
  "name": "Login screen check",
  "description": "",
  "id": "user-access-mercury-tours-application;login-screen-check",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 3,
      "name": "@Test1"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "user open \"chrome\" browser",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "user enter application url \"http://demo.guru99.com/test/newtours/index.php\"",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "chrome",
      "offset": 11
    }
  ],
  "location": "LoginStep.user_open_browser(String)"
});
formatter.result({
  "duration": 4371745311,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "http://demo.guru99.com/test/newtours/index.php",
      "offset": 28
    }
  ],
  "location": "LoginStep.user_enter_application_url(String)"
});
formatter.result({
  "duration": 14027557306,
  "status": "passed"
});
formatter.scenario({
  "line": 9,
  "name": "Enter username and password",
  "description": "",
  "id": "user-access-mercury-tours-application;enter-username-and-password",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 8,
      "name": "@Test2"
    }
  ]
});
formatter.step({
  "line": 10,
  "name": "enter user name as \"QQQQQ\"",
  "keyword": "Given "
});
formatter.step({
  "line": 11,
  "name": "enter password as \"qqqqq\"",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "we get success page",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "QQQQQ",
      "offset": 20
    }
  ],
  "location": "LoginStep.enter_user_name_as(String)"
});
formatter.result({
  "duration": 9054884,
  "error_message": "java.lang.NullPointerException\r\n\tat com.cjc.mt.step.LoginStep.enter_user_name_as(LoginStep.java:40)\r\n\tat ✽.Given enter user name as \"QQQQQ\"(login.feature:10)\r\n",
  "status": "failed"
});
formatter.match({
  "arguments": [
    {
      "val": "qqqqq",
      "offset": 19
    }
  ],
  "location": "LoginStep.enter_password_as(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "LoginStep.we_get_success_page()"
});
formatter.result({
  "status": "skipped"
});
});