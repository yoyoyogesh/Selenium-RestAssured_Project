@APIAutomation
  Feature: create user using api call
    Scenario Outline: By using API call a user should get created
      Given User is ready with required details like endpoint "<endPoint>"
      When user creates a required payload with fields like "<name>", "<id>", "<job>", "<createdAt>" and sends request
      Then Verify that user is created using status code "<statusCode>" and one of the response field "<name>"
      Examples:
      |endPoint|name|id|job|createdAt|statusCode|name|
      |https://reqres.in/api/users |  yogesh  | 123 | QA LEAD   |  2021-06-06       |  201        |  yogesh  |