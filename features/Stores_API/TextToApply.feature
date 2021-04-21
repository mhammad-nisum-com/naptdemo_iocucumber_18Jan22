@textToApply
Feature: Create APIs to initiate POS based enrolment in Orchestration service

  @ApplyForCardThroughText
  Scenario: Apply For Card Through Text
    Given that param "base_url.url" is set to value "http://strwebappsqa2.wsgc.com/QuickCreditService_CCRP"
    When that param "headers.Content-Type" is set to value "application/json;v=1"
    When that param "headers.ClientCode" is set to value "ClientCode"
    When that param "headers.ClientToken" is set to value "ClientToken"
    # ******initiateCASProcess******
    When I read the JSON from file "/src/main/resources/testData/textToApply/initiateCASProcess.json" into Dictionary Key "initiateCASProcess"
    When I make a "POST" REST Call with URL "/api/CreditApplicationService/v1/initiateCASProcess" and Body from Dictionary Key "initiateCASProcess"
    # ******postDLDetails******
    When I read the JSON from file "/src/main/resources/testData/textToApply/postDLDetails.json" into Dictionary Key "PostDLDetails"
    Then I verify that the response code is "200" for the response with Dictionary Key "PostUsers"
    When that param "sessionheaders.sessionID" is set to value "sessionID"
    When I read the JSON from file "/src/main/resources/testData/textToApply/postDLDetails.json" into Dictionary Key "PostDLDetails" and replace the sessionID
    When I make a "POST" REST Call with URL "/api/CreditApplicationService/v1/sessionID/postDLDetails" and Body from Dictionary Key "PostDLDetails" and replace the sessionID
    Then I verify that the response code is "200" for the response with Dictionary Key "PostDLDetails"
    # ******getQuestions******
    When I make a "GET" REST Call with URI "/api/CreditApplicationService/v1/sessionID/getQuestions" and store the response of sessionID with Dictionary Key "GetQuestions"
    Then I verify that the response code is "200" for the response with Dictionary Key "GetQuestions"
    #  ******postPIIData******
    Given that param "xml_headers.Content-Type" is set to value "application/soap+xml; charset=utf-8"
    When I read the XML from file "/src/main/resources/testData/textToApply/PIIData.xml" into Dictionary Key "PostPIIData"
    When I make a "POST" REST Call with URL "/api/CreditApplicationService/v1/sessionID/postPIIData" and Body from Dictionary Key "PostPIIData" and replace the sessionID
    Then I verify that the response code is "200" for the response with Dictionary Key "PostPIIData"
   # ******getApplicationStatus******
    When I make a "GET" REST Call with URI "/api/CreditApplicationService/v1/sessionID/getApplicationStatus" and store the response of sessionID with Dictionary Key "GetApplicationStatus"
    Then I verify that the response code is "200" for the response with Dictionary Key "GetApplicationStatus"
