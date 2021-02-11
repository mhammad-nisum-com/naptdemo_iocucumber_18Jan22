@oAuth
Feature: Card Enrollment feature

  Background:
    Given that param "base_url.url" is set to value "https://ecommerceaugusta-credit-card-orchestration-service-ccservice785.services.west.nonprod.wsgc.com"

  @post @CCRT-504 @CardEnrollment
  Scenario: POST InitiateLookUp Scenario
    Given that param "headers.Content-Type" is set to value "application/x-www-form-urlencoded"
    When that param "headers.Authorization" is set to value "Basic ZWNvbV9XUy9RQTpXU2Vjb20xMjM="
    When I read the JSON from file "/src/main/resources/testData/CardEnrollment/body.txt" into Dictionary Key "PostUsers"
    When I make a "POST" REST Call with URL "https://webauth-qa-rk01v.wsgc.com/oauth/token" and Body from Dictionary Key "PostUsers" to get oauth
    Then I verify that the response code is "200" for the response with Dictionary Key "PostUsers" and get oAuth


  @post @CCRT-504 @CardEnrollment
  Scenario Outline: POST InitiateLookUp Scenario
    Given that param "headers.Content-Type" is set to value "application/json"
    When that param "headers.Authorization" is set to value "access_token"
    Then I read the JSON from file "<testData_Path>" into Dictionary Key "PostUsers"
    When I make a "POST" REST Call with URL "/creditcard-orchestration/v1/card-enrollment" and Body from Dictionary Key "PostUsers"
    Then I verify that the response code is "<StatusCode>" for the response with Dictionary Key "PostUsers" and get "<ResponseObject>" and "<responseMessage>"
    Examples:
      | testData_Path                                                                           | StatusCode | ResponseObject | responseMessage                                                |
      | /src/main/resources/testData/CardEnrollment/SuccessRequest.json                         | 200        | status         | processed card successfully                                                        |
      | /src/main/resources/testData/CardEnrollment/missingFirstName_400Response.json           | 400        | errorMessage   | Attribute is required but missing: firstName                   |
      | /src/main/resources/testData/CardEnrollment/LastNameMissing_400Response.json            | 400        | errorMessage   | Attribute is required but missing: lastName                    |
      | /src/main/resources/testData/CardEnrollment/PartnerRequestIDMissing_400Response.json    | 400        | errorMessage   | Attribute is required but missing: partnerapplicationrequestid |
     | /src/main/resources/testData/CardEnrollment/InvalidEmail_400Response.json               | 400        | errorMessage   |Attribute is not in a valid format: emailAddress            |
      | /src/main/resources/testData/CardEnrollment/missingEmail_400Response.json               | 400        | errorMessage   | Attribute is required but missing: emailAddress                |
      | /src/main/resources/testData/CardEnrollment/PhoneNumberMissing_400Response.json         | 400        | errorMessage   | Attribute is required but missing: phone                       |
      | /src/main/resources/testData/CardEnrollment/AddressLineOneMissing_400Response.json      | 400        | errorMessage   | Attribute is required but missing: addressLineOne              |
      | /src/main/resources/testData/CardEnrollment/CityMissing_400Response.json                | 400        | errorMessage   | Attribute is required but missing: city                        |
      |/src/main/resources/testData/CardEnrollment/MissingTimeStamp.json                        |400         |errorMessage    |Attribute is required but missing: timestamp                    |
      | /src/main/resources/testData/CardEnrollment/CountryCodeMissing_400Response.json         | 400        | errorMessage   | Attribute is required but missing: countryCode                     |
      | /src/main/resources/testData/CardEnrollment/CountryMissing_400Response.json             | 400        | errorMessage   | Attribute is required but missing: country                    |
      | /src/main/resources/testData/CardEnrollment/PostalCodeMissing_400Response.json          | 400        | errorMessage   | Attribute is required but missing: postalCode                  |
      | /src/main/resources/testData/CardEnrollment/StateOrProvinceNameMissing_400Response.json | 400        | errorMessage   | Attribute is required but missing: stateOrProvinceName         |
      | /src/main/resources/testData/CardEnrollment/CardExpiryMissing_400Response.json          | 400        | errorMessage   | Attribute is required but missing: cardExpiry                   |
      | /src/main/resources/testData/CardEnrollment/CardTypeMissing_400Response.json            | 400        | errorMessage   | Attribute is required but missing: cardType                    |
      | /src/main/resources/testData/CardEnrollment/AccountIdMissing_400Response.json           | 400        | errorMessage   | Attribute is required but missing: accountId                   |
      | /src/main/resources/testData/CardEnrollment/PartnerNameMissing_400Response.json         | 400        | errorMessage   | Attribute is required but missing: partnerName                 |
      |/src/main/resources/testData/CardEnrollment/MissingVCNNumber.json                        |400         |errorMessage    |Attribute is required but missing: vcnNumber                    |
      | /src/main/resources/testData/CardEnrollment/EnrollmentTypeMissing_400Response.json      | 400        | errorMessage   | Attribute is required but missing: enrollmentConcept           |
      | /src/main/resources/testData/CardEnrollment/Last4DigitsMissing_400Response.json         | 400        | errorMessage   | Attribute is required but missing: last4Digits                            |
      |/src/main/resources/testData/CardEnrollment/invalidRequestID.json                        |400         |errorMessage    |Attribute is not in a valid format: partnerapplicationrequestid            |
      |/src/main/resources/testData/CardEnrollment/InvalidPhoneNumber.json                      |400         |errorMessage    |Attribute is not in a valid format: phone                                  |
      |/src/main/resources/testData/CardEnrollment/InvalidAddressLineOne.json                   |400         |errorMessage    |Attribute is not in a valid format: addressLineOne                         |
      |/src/main/resources/testData/CardEnrollment/InvalidAddressType.json                      |400         |errorMessage    |Attribute is not in a valid format: addressType                            |
      |/src/main/resources/testData/CardEnrollment/InvalidCountry.json                          |400         |errorMessage    |Attribute is not in a valid format: country                                |
      |/src/main/resources/testData/CardEnrollment/InvalidPostalCode.json                       |400         |errorMessage    |Attribute is not in a valid format: postalCode                             |
      |/src/main/resources/testData/CardEnrollment/InvalidStateOrProvince.json                  |400         |errorMessage    |Attribute is not in a valid format: stateOrProvinceName                    |
      |/src/main/resources/testData/CardEnrollment/InvalidLast4digits.json                      |400         |errorMessage    |Attribute is not in a valid format: last4Digits                            |
      | /src/main/resources/testData/CardEnrollment/InvalidTimeStamp_400Response.json           | 400        |errorMessage   |Attribute is not in a valid format: timestamp                   |
      |/src/main/resources/testData/CardEnrollment/InvalidChannelType.json                      |400         |errorMessage   |Attribute is not in a valid format: channelType                 |
      |/src/main/resources/testData/CardEnrollment/InvalidEnrollmentConcept.json                |400         |errorMessage   |Attribute is not in a valid format: enrollmentConcept           |

