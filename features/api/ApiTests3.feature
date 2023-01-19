  Feature: Test feature

  @api @f3s1 @s1 @get
  Scenario: GET Scenario 1
  Given that param "headers.contentType" is set to value "application/json"
  Given that param "base_url.url" is set to value "https://reqres.in"
  When I make a "GET" REST Call with URI "/api/users?page=2" and store the response with Dictionary Key "GetUsers"
  Then I verify that the response code is "200" for the response with Dictionary Key "GetUsers"
  And I verify that the json path "$.data[?(@.email=='michael.lawson@reqres.in')].email" for node "data >> node"  value is "[;qt;michael.lawson@reqres.in;qt;]" for the response with Dictionary Key "GetUsers"
  And I verify that the json path "$.data..email" for node array "data >> node" contains "6" number of nodes for the response with Dictionary Key "GetUsers"
  And I add the value at json path "$.data[?(@.email=='michael.lawson@reqres.in')].email" from response with Dictionary Key "GetUsers" and store it in Dictionary Key "email"

  @api @f3s2 @s2 @post
  Scenario: POST Scenario 1
  Given that param "headers.contentType" is set to value "application/json"
  Given that param "base_url.url" is set to value "https://reqres.in"
  When I read the JSON from file "src/main/resources/testData/postreqres.json" into Dictionary Key "PostUsers"
  When I make a "POST" REST Call with URL "/api/users" and Body from Dictionary Key "PostUsers"
  Then I verify that the response code is "201" for the response with Dictionary Key "PostUsers"

  @api @f3s3 @s3 @put
  Scenario: PUT Scenario 1
  Given that param "headers.contentType" is set to value "application/json"
  Given that param "base_url.url" is set to value "https://reqres.in"
  When I read the JSON from file "src/main/resources/testData/postreqres.json" into Dictionary Key "PutUsers"
  When I make a "PUT" REST Call with URL "/api/users/2" and Body from Dictionary Key "PutUsers"
  Then I verify that the response code is "200" for the response with Dictionary Key "PutUsers"

  @api @f3s4 @s4 @delete
  Scenario: DELETE Scenario 1
  Given that param "headers.contentType" is set to value "application/json"
  Given that param "base_url.url" is set to value "https://reqres.in"
  When I make a "DELETE" REST Call with URI "/api/users/2" and store the response with Dictionary Key "PutUsers"
  Then I verify that the response code is "200" for the response with Dictionary Key "PutUsers"

  @api @f3s5 @s5 @patch
  Scenario: PATCH Scenario 1
  Given that param "headers.contentType" is set to value "application/json"
  Given that param "base_url.url" is set to value "https://reqres.in"
  When I read the JSON from file "src/main/resources/testData/postreqres.json" into Dictionary Key "PutUsers"
  When I make a "PATCH" REST Call with URL "/api/users/2" and Body from Dictionary Key "PutUsers"
  Then I verify that the response code is "2000" for the response with Dictionary Key "PutUsers"






