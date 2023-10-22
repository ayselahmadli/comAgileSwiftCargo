
Feature:As an administrator, I want to access the Purpose List through an API connection.

  @API_US001
  @TC_01
  Scenario: To validate that the status code is 200 and the response message is "Success"
  when sending a GET request to the api/adminHubList endpoint with valid authorization
  credentials, you would typically need to use a programming language or a tool to make the
  API request and perform the validation.

    * Admin sets the parameters in the path "api/hub/list".
    * send Get request for adminHubList
    * verifies that the return response for the adminHubList Api succesfull

  @TC_02
