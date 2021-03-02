package com.napt.api.wsi.apirewards;

import com.napt.api.wsi.apistores.ApiEngine;
import com.napt.api.wsi.apistores.Globals;
import com.napt.api.wsi.steps.BrowserSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;

import java.net.URISyntaxException;

public class TestSteps {
    ApiEngine ae = new ApiEngine();
    private static final Logger LOGGER = Logger.getLogger(TestSteps.class);
    private static final Logger log = Logger.getLogger(BrowserSteps.class);


    @When("I make a {string} REST Call with URI {string} and Parameters {string} and {string} and store the response of sessionID with Dictionary Key {string}")
    public void iMakeARESTCallWithURIAndParametersAndAndStoreTheResponseOfSessionIDWithDictionaryKey(String requestType, String uri, String partnerId, String partnerName, String dictionaryKey) throws URISyntaxException {
        Response response = (Response) Globals.globalVariables.get("PostUsers");
        JSONObject postResponse=new JSONObject(response.getBody().asString());

        String getUri = getUriForGetWithPartner(uri, postResponse, partnerName, partnerId);
        Response rs = ae.callAPI("get", Globals.headers, "", Globals.globalVariables.get("url").toString() + getUri);
        Globals.globalVariables.put(dictionaryKey,rs);

    }

    private String getUriForGetWithPartner(String uri, JSONObject postResponse, String partnerName, String partnerId) {
        String pName = null;
        String pId = null;
        if ("#GetFromResponse".equals(partnerName)) {
            JSONArray jsonArray = postResponse.getJSONObject("loyaltyCardCreateResponse").getJSONObject("loyaltyCardAccount").getJSONObject("cardDetails").getJSONArray("partnerIds");

        } else {
            pName = partnerName;
        }
        if ("#GetFromResponse".equals(partnerId)) {

        } else {
            pId = partnerId;
        }

        return uri+pName+"/"+pId;
    }



    @Then("I verify that the response code value is {string} for the response with Dictionary Key {string} and get {string} and {string}")
    public void iVerifyThatTheResponseCodeIsForTheResponseWithDictionaryKeyAndGetAnd(String responseCode, String dictionaryKey, String responseObject,String responseMessage) {
        Response rs = (Response) Globals.globalVariables.get(dictionaryKey);
        String Actual_message=null;
        System.out.println("return body value" + rs.asString());
        JsonPath jsonPathEvaluator = rs.jsonPath();
        JSONObject response_new=new JSONObject(rs.getBody().asString());
        Assert.assertTrue("Actual Response Code is " + rs.getStatusCode() + " vs Expected Response Code" + responseCode, String.valueOf(rs.getStatusCode()).equals(responseCode));
        log.info("Able to retrieve response-----" + responseObject);
        if(responseObject.equalsIgnoreCase("status"))
        {
            Actual_message = response_new.getJSONObject("loyaltyCardCreateResponse").getString("loyaltyCardId");
        }
        else if(responseObject.equalsIgnoreCase("errorMessage"))
        {
            Actual_message=response_new.getJSONObject("error").getString("errorMessage");

        }
        System.out.println("+++++++++++"+Actual_message);
        Assert.assertTrue("Actual response is validated",responseMessage.contains(Actual_message.trim()));
        log.info("Actual response is matching with Expected Response"+responseMessage);

    }

    @And("I make a {string} REST Call with URL {string} and Body from Dictionary Key {string} and random partnerId")
    public void iMakeARESTCallWithURLAndBodyFromDictionaryKeyAndRandomPartnerId(String callType, String URI, String dictionaryKey) throws URISyntaxException {
        Response rs = ae.callAPI(callType, Globals.headers, Globals.globalVariables.get(dictionaryKey).toString(), Globals.globalVariables.get("url").toString() + URI);
        Globals.globalVariables.put(dictionaryKey, rs);
    }
}
