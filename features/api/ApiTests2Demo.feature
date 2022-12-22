  Feature: Test feature

  @get @api
  Scenario: GET Scenario 2
  Given that param "headers.contentType" is set to value "application/json"
  Given that param "base_url.url" is set to value "https://reqres.in"
  When I make a "GET" REST Call with URI "/api/users?page=2" and store the response with Dictionary Key "GetUsers"
  Then I verify that the response code is "200" for the response with Dictionary Key "GetUsers"
  And I verify that the json path "$.data[?(@.email=='michaal.lawson@reqres.in')].email" for node "data >> node"  value is "[;qt;michael.lawson@reqres.in;qt;]" for the response with Dictionary Key "GetUsers"
  And I verify that the json path "$.data..email" for node array "data >> node" contains "6" number of nodes for the response with Dictionary Key "GetUsers"
  And I add the value at json path "$.data[?(@.email=='michael.lawson@reqres.in')].email" from response with Dictionary Key "GetUsers" and store it in Dictionary Key "email"

  @post @api
  Scenario: POST Scenario 2
  Given that param "headers.contentType" is set to value "application/json"
  Given that param "base_url.url" is set to value "https://reqres.in"
  When I read the JSON from file "src/main/resources/testData/postreqres.json" into Dictionary Key "PostUsers"
  When I make a "POST" REST Call with URL "/api/users" and Body from Dictionary Key "PostUsers"
  Then I verify that the response code is "2011" for the response with Dictionary Key "PostUsers"

  @put @api
  Scenario: PUT Scenario 2
  Given that param "headers.contentType" is set to value "application/xml"
  Given that param "base_url.url" is set to value "https://reqres.in"
  When I read the JSON from file "src/main/resources/testData/postreqres.json" into Dictionary Key "PutUsers"
  When I make a "PUT" REST Call with URL "/api/users/2" and Body from Dictionary Key "PutUsers"
  Then I verify that the response code is "2001" for the response with Dictionary Key "PutUsers"

  @delete @api
  Scenario: DELETE Scenario 2
  Given that param "headers.contentType" is set to value "application/json"
  Given that param "base_url.url" is set to value "https://reqres.in"
  When I make a "DELETE" REST Call with URI "/api/users/2" and store the response with Dictionary Key "PutUsers"
  Then I verify that the response code is "2001" for the response with Dictionary Key "PutUsers"

  @patch @api
  Scenario: PATCH Scenario 2
  Given that param "headers.contentType" is set to value "application/json"
  Given that param "base_url.url" is set to value "https://reqres.in"
  When I read the JSON from file "src/main/resources/testData/postreqres.json" into Dictionary Key "PutUsers"
  When I make a "PATCH" REST Call with URL "/api/users/2" and Body from Dictionary Key "PutUsers"
  Then I verify that the response code is "2001" for the response with Dictionary Key "PutUsers"






