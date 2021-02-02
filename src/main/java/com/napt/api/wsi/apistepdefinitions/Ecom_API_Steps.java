package com.napt.api.wsi.apistepdefinitions;

import com.google.gson.JsonObject;
import com.napt.api.wsi.apistores.ApiEngine;
import com.napt.api.wsi.apistores.Globals;
import com.napt.api.wsi.pojo.GetCardDetailsresponse.Example;
import com.napt.api.wsi.steps.BrowserSteps;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.junit.Assert;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

public class Ecom_API_Steps {
    ApiEngine ae = new ApiEngine();
    private static final Logger log = Logger.getLogger(BrowserSteps.class);





    @When("I make a {string} REST Call with URL {string} and Body from Dictionary Key {string} to get oauth")
    public void ImakePOSTcallandgetOAUTHtoken(String callType, String URI, String dictionaryKey) throws URISyntaxException {
        Response rs = ae.callAPI(callType, Globals.headers, Globals.globalVariables.get(dictionaryKey).toString(), URI );
        Globals.globalVariables.put(dictionaryKey, rs);

    }

    @Then("I verify that the response code is {string} for the response with Dictionary Key {string} and get oAuth")
    public void iVerifyThatTheResponseCodeIsForTheResponseWithDictionaryKeyAndGetOAuth(String responseCode, String dictionaryKey) {
        Response rs = (Response) Globals.globalVariables.get(dictionaryKey);
        System.out.println("return body value" +rs.asString());
        JsonPath jsonPathEvaluator = rs.jsonPath();
        String getSessionID = jsonPathEvaluator.get("access_token");
        System.out.println("access_token "+getSessionID);
        Globals.access_token.put("access_token",getSessionID);
        Assert.assertTrue("Actual Response Code is " + rs.getStatusCode() + " vs Expected Response Code" + responseCode,String.valueOf(rs.getStatusCode()).equals(responseCode));
    }
    @When("that param {string} is set to value {string} to pass username and password")
    public void thatParamIsSetToValueToPassUsernameAndPassword(String dictionaryKey, String value) throws URISyntaxException {

        Response rs = ae.callAPI("auth", Globals.headers, "", "");
        Globals.globalVariables.put(dictionaryKey,rs);
    }

    @Then("I verify that the response code is {string} for the response with Dictionary Key {string} and get {string} and {string}")
    public void iVerifyThatTheResponseCodeIsForTheResponseWithDictionaryKeyAndGetAnd(String responseCode, String dictionaryKey, String responseObject,String responseMessage) {
        Response rs = (Response) Globals.globalVariables.get(dictionaryKey);
        String Actual_message=null;
        System.out.println("return body value" + rs.asString());
        //JsonPath jsonPathEvaluator = rs.jsonPath();
        JSONObject response_new=new JSONObject(rs.getBody().asString());
        Assert.assertTrue("Actual Response Code is " + rs.getStatusCode() + " vs Expected Response Code" + responseCode, String.valueOf(rs.getStatusCode()).equals(responseCode));
        log.info("Able to retrieve response-----" + responseObject);
        if(responseObject.equalsIgnoreCase("status"))
        {
            Actual_message=response_new.getJSONObject("cardEnrollment").getString("status");
        }
       else if(responseObject.equalsIgnoreCase("errorMessage"))
        {
            Actual_message=response_new.getJSONObject("error").getString("errorMessage");

        }
       System.out.println("+++++++++++"+Actual_message);
       Assert.assertTrue("Actual response is validated",responseMessage.contains(Actual_message.trim()));
       log.info("Actual response is matching with Expected Response"+responseMessage);

    }

    @Then("I verify that the response code is {string} for the response with Dictionary Key {string} for response")
    public void iVerifyThatTheResponseCodeIsForTheResponseWithDictionaryKeyForResponse(String responseCode, String dictionaryKey) {
        Response rs = (Response) Globals.globalVariables.get(dictionaryKey);
        System.out.println("return body value" +rs.asString());
        Assert.assertTrue("Actual Response Code is " + rs.getStatusCode() + " vs Expected Response Code" + responseCode,String.valueOf(rs.getStatusCode()).equals(responseCode));
        Example emp=rs.as(Example.class);

        System.out.println("+++++++++++"+emp.toString());

    }
}

