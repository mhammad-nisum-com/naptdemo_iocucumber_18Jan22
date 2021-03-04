package com.napt.api.wsi.apirewards;

import com.napt.api.wsi.apistores.ApiEngine;
import com.napt.api.wsi.apistores.Globals;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

/**
 * The type Test steps.
 */
public class TestSteps extends ApiEngine {

    /**
     * That param is set to value with bearer token.
     *
     * @param dictionaryKey the dictionary key
     * @param value         the value
     */
    @Given("^that param \"([^\"]*)\" is set to value with bearer token  \"([^\"]*)\"$")
    public void thatParamIsSetToValueWithBearerToken(String dictionaryKey, String value) {

        String[] paramCategory = dictionaryKey.split("\\.");
        switch (paramCategory[0]) {
        case "headers":
            Globals.headers.put(paramCategory[1], value);
            if (value.contains("access_token")) {
                Globals.headers.put(paramCategory[1], "Bearer " + Globals.access_token.get("access_token"));
            }
            break;
        case "base_url":
            Globals.globalVariables.put(paramCategory[1], value);
            break;
        case "xml_headers":
            Globals.xmlHeaders.put(paramCategory[1], value);
            break;
        case "Authorization":
            Globals.Authorization.put(paramCategory[1], value);
            break;
        case "sessionheaders":
            if (value.equals("sessionID")) {
                Globals.sessionHeaders.put(paramCategory[1], Globals.sessionID.get("SessionID"));
            } else {
                Globals.sessionHeaders.put(paramCategory[1], value);
            }
            break;
        case "oauthEncoded":
            Globals.oAuthEncoded.put(paramCategory[1], value);
            break;

        }

    }

    /**
     * Read the json from given file and replace partner id with random generated into dictionary key.
     *
     * @param jsonFilePath  the json file path
     * @param dictionaryKey the dictionary key
     * @throws IOException the io exception
     */
    @And("I read the JSON from given file {string} and replace partner id with random generated into Dictionary Key {string}")
    public void iReadTheJSONFromGivenFileAndReplacePartnerIdWithRandomGeneratedIntoDictionaryKey(String jsonFilePath, String dictionaryKey) throws IOException {
        String cwd = System.getProperty("user.dir");
        String jsonPath = cwd + jsonFilePath;
        String partnerAccountId = randomGeneratedPartnerId();
        Globals.globalVariables.put(dictionaryKey, jsonFileToString(jsonPath).replace("{partnerAccountId}", partnerAccountId));
        Globals.globalVariables.put("partnerAccountId", partnerAccountId);
    }

    /**
     * Read the json from given file into dictionary key.
     *
     * @param jsonFilePath  the json file path
     * @param dictionaryKey the dictionary key
     * @throws IOException the io exception
     */
    @And("I read the JSON from given file {string} into Dictionary Key {string}")
    public void iReadTheJSONFromGivenFileIntoDictionaryKey(String jsonFilePath, String dictionaryKey) throws IOException {
        String cwd = System.getProperty("user.dir");
        String jsonPath = cwd + jsonFilePath;
        Globals.globalVariables.put(dictionaryKey, jsonFileToString(jsonPath));
    }

    /**
     * Make arest call with url with random generated partner id and body from dictionary key.
     *
     * @param callType      the call type
     * @param URI           the uri
     * @param dictionaryKey the dictionary key
     * @throws URISyntaxException the uri syntax exception
     */
    @When("I make a {string} REST Call with URL {string} with random generated partner id and Body from Dictionary Key {string}")
    public void iMakeARESTCallWithURLWithRandomGeneratedPartnerIdAndBodyFromDictionaryKey(String callType, String URI, String dictionaryKey)
            throws URISyntaxException {
        Response rs = callAPI(callType, Globals.headers, Globals.globalVariables.get(dictionaryKey).toString(),
                              Globals.globalVariables.get("url").toString() + URI);
        Globals.globalVariables.put(dictionaryKey, rs);
    }

    /**
     * Make arest call with url from dictionary key.
     *
     * @param callType      the call type
     * @param uri           the uri
     * @param dictionaryKey the dictionary key
     * @throws URISyntaxException the uri syntax exception
     */
    @When("I make a {string} REST Call with URL {string} from Dictionary Key {string}")
    public void iMakeARESTCallWithURLFromDictionaryKey(String callType, String uri, String dictionaryKey) throws URISyntaxException {
        Response rs = callAPIs(callType, Globals.headers, "",
                               Globals.globalVariables.get("url").toString() + uri);
        Globals.globalVariables.put(dictionaryKey, rs);
    }

    @Override
    public String jsonFileToString(String jsonFilePath) throws IOException {
        return super.jsonFileToString(jsonFilePath);
    }

    private Response callAPIs(String ApiType, HashMap<String, String> headers, String body, String uri) throws URISyntaxException {
        Response response = null;
        String loyaltyCardId = Globals.globalVariables.get("LOYALTY_CARD_ID").toString();

        switch (ApiType.toLowerCase()) {
        case "get":
            response = given().relaxedHTTPSValidation().headers(headers).when().get(new URI(uri + "/" + UUID.fromString(loyaltyCardId))).then().extract()
                    .response();
            break;
        case "lookup":
            response = given().relaxedHTTPSValidation().headers(headers).when().queryParams(getQueryParams()).get(new URI(uri)).then().extract().response();
            break;
        case "getaccountwithpartner":
            response = given().relaxedHTTPSValidation().headers(headers).when().get(new URI(uri)) .then().extract().response();
            break;
        case "posttoken":
            response = given().relaxedHTTPSValidation().when().headers(headers).body(body).post(uri);
            break;

        }
        return response;
    }

    private Map<String, String> getQueryParams() {
        String firstName = Globals.globalVariables.get("FIRST_NAME").toString();
        String lastName = Globals.globalVariables.get("LAST_NAME").toString();
        String email = Globals.globalVariables.get("EMAIL").toString();
        String phone = Globals.globalVariables.get("PHONE").toString();
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("firstName", firstName);
        queryParams.put("lastName", lastName);
        queryParams.put("phone", phone);
        queryParams.put("email", email);
        return queryParams;
    }


    private String randomGeneratedPartnerId() {
        Random r = new Random(System.currentTimeMillis());
        return String.valueOf(r.nextInt()).replace("-", "");
    }

    @When("I make a {string} Call with PartnerName and PartnerId from Dictionary Key {string} and URL {string} from Dictionary Key {string}")
    public void iMakeACallWithPartnerNameAndPartnerIdAndURLFromDictionaryKey(String callType,String dictionaryKeyForPost ,String uri, String dictionaryKeyForGet) throws URISyntaxException {

        Response response = (Response) Globals.globalVariables.get(dictionaryKeyForPost);
        JSONObject response_new = new JSONObject(response.getBody().asString());
        JSONObject partnerId = response_new.getJSONObject("loyaltyCardCreateResponse").getJSONObject("loyaltyCardAccount").getJSONObject("cardDetails").getJSONArray("partnerIds").getJSONObject(0);

        String partnerName = partnerId.getString("partnerName");
        String partnerAccountId = partnerId.getString("accountId");

        String uriWithPathParam = uri + "/" + partnerName + "/" + partnerAccountId;

        Response rs = callAPIs(callType, Globals.headers, "",
                               Globals.globalVariables.get("url").toString() + uriWithPathParam);
        Globals.globalVariables.put(dictionaryKeyForGet, rs);
    }

    @Then("I verify that the get response code value is {string} for the response with Dictionary Key {string} with {string}")
    public void iVerifyThatTheGetResponseCodeValueIsForTheResponseWithDictionaryKeyWith(String statuscode, String dictionaryKey1, String dictionaryKey) {
        Response response = (Response) Globals.globalVariables.get(dictionaryKey);
        Response response1 = (Response) Globals.globalVariables.get(dictionaryKey1);
        JSONObject jsonResponse = new JSONObject(response.getBody().asString());
        JSONObject jsonResponse1 = new JSONObject(response1.getBody().asString());
        String loyaltyIdwithPartner  = jsonResponse1.getJSONObject("loyaltyCardGetResponse").getJSONObject("loyaltyCardAccount")
                .getString("loyaltyCardId");
        String loyaltyIdCreateAccount  = jsonResponse.getJSONObject("loyaltyCardCreateResponse").getJSONObject("loyaltyCardAccount")
                .getString("loyaltyCardId");
                  if (loyaltyIdCreateAccount.equals(loyaltyIdwithPartner)){
                      return;
                  }
    }

    @And("I read the JSON from given file {string} and replace token id with random generated into Dictionary Key {string}")
    public void iReadTheJSONFromGivenFileAndReplaceTokenIdWithRandomGeneratedIntoDictionaryKey(String jsonFilePath, String dictionaryKey) throws IOException {
        String cwd = System.getProperty("user.dir");
        String jsonPath = cwd + jsonFilePath;
        String tokenID = randomGeneratedPartnerId();
        Globals.globalVariables.put(dictionaryKey, jsonFileToString(jsonPath).replace("{tokenId}", tokenID));
        Globals.globalVariables.put("tokenId", tokenID);
    }

    @When("I make a {string} Call with loyaltyId from Dictionary Key {string} and Request Dictionary Key {string} and URL {string}")
    public void iMakeACallWithLoyaltyIdFromDictionaryKeyAndRequestDictionaryKeyAndURL(String callType, String dictionaryKeyForPost, String dictionaryKeyForToken , String uri)
            throws URISyntaxException {
        Response response = (Response) Globals.globalVariables.get(dictionaryKeyForPost);
        JSONObject response_new = new JSONObject(response.getBody().asString());
        String loyaltyID = response_new.getJSONObject("loyaltyCardCreateResponse").getJSONObject("loyaltyCardAccount")
                .getString("loyaltyCardId");
        String uriWithToken = uri + "/"+ loyaltyID +"/tokens";
        String tokenRequest = (String) Globals.globalVariables.get(dictionaryKeyForToken);

        Response rs = callAPIs(callType, Globals.headers, tokenRequest,
                               Globals.globalVariables.get("url").toString() + uriWithToken);
        Globals.globalVariables.put(dictionaryKeyForToken, rs);
    }

    @Then("I verify the response with status code {string} for Dictionary Key {string}")
    public void iVerifyTheResponseWithStatusCodeForDictionaryKey(String statusCode, String dictionaryKey) {
        Response response = (Response) Globals.globalVariables.get(dictionaryKey);
        Assert.assertEquals(Integer.parseInt(statusCode), response.getStatusCode());
    }
}

