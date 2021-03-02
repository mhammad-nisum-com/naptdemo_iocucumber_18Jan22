package com.napt.api.wsi.apirewards;

import com.napt.api.wsi.apistores.ApiEngine;
import com.napt.api.wsi.apistores.Globals;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;

import java.io.IOException;

public class Rewards_API_Steps extends ApiEngine {
    private static final Logger log = Logger.getLogger(Rewards_API_Steps.class);

    @Then("I verify that the post response code value is {string} for the response with Dictionary Key {string} and get {string} and {string}")
    public void iVerifyThatThePostResponseCodeValueIsForTheResponseWithDictionaryKeyAndGetAnd(String statusCode, String dictionaryKey, String responseCode,
                                                                                              String responseMessage) throws IOException {

        Response response = (Response) Globals.globalVariables.get(dictionaryKey);
        JSONObject jsonObject = new JSONObject(response.getBody().asString());
        jsonObject = jsonObject.getJSONObject("loyaltyCardCreateResponse").getJSONObject("loyaltyCardAccount");
        Globals.globalVariables.put("LOYALTY_CARD_ID", jsonObject.getString("loyaltyCardId"));
        JSONObject accountState = jsonObject.getJSONObject("accountState");
        JSONObject cardDetails = jsonObject.getJSONObject("cardDetails");
        JSONObject earningSummary = jsonObject.getJSONObject("earningSummary");
        JSONArray cardHolders = cardDetails.getJSONArray("cardHolders");
        JSONObject memberDetails = cardHolders.getJSONObject(0).getJSONObject("memberDetails");
        String phone = memberDetails.getString("phone");
        String email = memberDetails.getString("email");
        String firstName = memberDetails.getJSONObject("name").getString("firstName");
        String lastName = memberDetails.getJSONObject("name").getString("lastName");

        Globals.globalVariables.put("FIRST_NAME", firstName);
        Globals.globalVariables.put("LAST_NAME", lastName);
        Globals.globalVariables.put("EMAIL", email);
        Globals.globalVariables.put("PHONE", phone);

        Object partnerAccountId = Globals.globalVariables.get("partnerAccountId");
        Assert.assertNotNull(accountState.getString("statusCode"));
        Assert.assertNotNull(accountState.getString("statusInfo"));
        Assert.assertNotNull(accountState.getString("lastActivityTime"));
        Assert.assertNotNull(accountState.getString("openTime"));
        Assert.assertNotNull(accountState.getBoolean("canLogin"));
        Assert.assertNotNull(accountState.getBoolean("canEarn"));
        Assert.assertNotNull(accountState.getBoolean("canIssueCertificates"));
        Assert.assertNotNull(accountState.getBoolean("canRedeem"));
        Assert.assertNotNull(accountState.getBoolean("canLogin"));
        Assert.assertEquals("COF", cardDetails.getJSONArray("partnerIds").getJSONObject(0).getString("partnerName"));
        Assert.assertEquals(partnerAccountId.toString(), cardDetails.getJSONArray("partnerIds").getJSONObject(0).getString("accountId"));
        Assert.assertTrue(cardDetails.getJSONArray("partnerIds").getJSONObject(0).getBoolean("active"));
        Assert.assertEquals("PRIMARY", cardHolders.getJSONObject(0).getString("cardHoldertype"));
        Assert.assertNotNull(memberDetails.getString("birthday"));
        Assert.assertNotNull(memberDetails.getString("email"));
        Assert.assertNotNull(memberDetails.getString("phone"));
        Assert.assertNotNull(memberDetails.getJSONObject("address").getString("country"));
        Assert.assertNotNull(memberDetails.getJSONObject("address").getString("address2"));
        Assert.assertNotNull(memberDetails.getJSONObject("address").getString("city"));
        Assert.assertNotNull(memberDetails.getJSONObject("address").getString("address1"));
        Assert.assertNotNull(memberDetails.getJSONObject("address").getString("postalCode"));
        Assert.assertNotNull(memberDetails.getJSONObject("address").getString("stateProvince"));
        Assert.assertNotNull(memberDetails.getJSONObject("name").getString("firstName"));
        Assert.assertNotNull(memberDetails.getJSONObject("name").getString("lastName"));
        Assert.assertNotNull(cardDetails.getString("cardType"));
        Assert.assertNotNull(cardDetails.getString("cardDescription"));
        Assert.assertNotNull(cardDetails.getString("cardProgramCode"));
        Assert.assertNotNull(earningSummary);

    }

    @Then("I verify that the get response code value is {string} for the response with Dictionary Key {string}")
    public void iVerifyThatTheGetResponseCodeValueIsForTheResponseWithDictionaryKey(String statusCode, String dictionaryKey) {
        Response response = (Response) Globals.globalVariables.get(dictionaryKey);
        JSONObject jsonObject = new JSONObject(response.getBody().asString());
        jsonObject = jsonObject.getJSONObject("loyaltyCardGetResponse").getJSONObject("loyaltyCardAccount");
        JSONObject accountState = jsonObject.getJSONObject("accountState");
        JSONObject cardDetails = jsonObject.getJSONObject("cardDetails");
        JSONObject earningSummary = jsonObject.getJSONObject("earningSummary");
        JSONArray cardHolders = cardDetails.getJSONArray("cardHolders");
        JSONObject memberDetails = cardHolders.getJSONObject(0).getJSONObject("memberDetails");

        Object partnerAccountId = Globals.globalVariables.get("partnerAccountId");
        Assert.assertNotNull(accountState.getString("statusCode"));
        Assert.assertNotNull(accountState.getString("statusInfo"));
        Assert.assertNotNull(accountState.getString("lastActivityTime"));
        Assert.assertNotNull(accountState.getString("openTime"));
        Assert.assertNotNull(accountState.getBoolean("canLogin"));
        Assert.assertNotNull(accountState.getBoolean("canEarn"));
        Assert.assertNotNull(accountState.getBoolean("canIssueCertificates"));
        Assert.assertNotNull(accountState.getBoolean("canRedeem"));
        Assert.assertNotNull(accountState.getBoolean("canLogin"));
        Assert.assertEquals("COF", cardDetails.getJSONArray("partnerIds").getJSONObject(0).getString("partnerName"));
        Assert.assertEquals(partnerAccountId.toString(), cardDetails.getJSONArray("partnerIds").getJSONObject(0).getString("accountId"));
        Assert.assertTrue(cardDetails.getJSONArray("partnerIds").getJSONObject(0).getBoolean("active"));
        Assert.assertEquals("PRIMARY", cardHolders.getJSONObject(0).getString("cardHoldertype"));
        Assert.assertNotNull(memberDetails.getString("birthday"));
        Assert.assertNotNull(memberDetails.getString("email"));
        Assert.assertNotNull(memberDetails.getString("phone"));
        Assert.assertNotNull(memberDetails.getJSONObject("address").getString("country"));
        Assert.assertNotNull(memberDetails.getJSONObject("address").getString("address2"));
        Assert.assertNotNull(memberDetails.getJSONObject("address").getString("city"));
        Assert.assertNotNull(memberDetails.getJSONObject("address").getString("address1"));
        Assert.assertNotNull(memberDetails.getJSONObject("address").getString("postalCode"));
        Assert.assertNotNull(memberDetails.getJSONObject("address").getString("stateProvince"));
        Assert.assertNotNull(memberDetails.getJSONObject("name").getString("firstName"));
        Assert.assertNotNull(memberDetails.getJSONObject("name").getString("lastName"));
        Assert.assertNotNull(cardDetails.getString("cardType"));
        Assert.assertNotNull(cardDetails.getString("cardDescription"));
        Assert.assertNotNull(cardDetails.getString("cardProgramCode"));
        Assert.assertNotNull(earningSummary.getDouble("available"));
        Assert.assertNotNull(earningSummary.getDouble("pending"));
        Assert.assertNotNull(earningSummary.getDouble("toNextCertificateThreshold"));

    }

    @Then("I verify that the lookup response code value is {string} for the response with Dictionary Key {string}")
    public void iVerifyThatTheLookupResponseCodeValueIsForTheResponseWithDictionaryKey(String statusCode, String dictionaryKey) {
        Response response = (Response) Globals.globalVariables.get(dictionaryKey);
        JSONObject jsonResponse = new JSONObject(response.getBody().asString());
        JSONArray jsonArray = jsonResponse.getJSONObject("loyaltyCardLookupResponse").getJSONArray("loyaltyCardAccountCollection");
          for (Object o : jsonArray){
              if(o instanceof JSONObject){
                  JSONObject jsonObject = (JSONObject) o;
                  JSONObject accountState = jsonObject.getJSONObject("accountState");
                  JSONObject cardDetails = jsonObject.getJSONObject("cardDetails");
                  JSONArray cardHolders = cardDetails.getJSONArray("cardHolders");
                  JSONObject memberDetails = cardHolders.getJSONObject(0).getJSONObject("memberDetails");

                  Object partnerAccountId = Globals.globalVariables.get("partnerAccountId");
                  Assert.assertNotNull(accountState.getString("statusCode"));
                  Assert.assertNotNull(accountState.getString("statusInfo"));
                  Assert.assertNotNull(accountState.getString("lastActivityTime"));
                  Assert.assertNotNull(accountState.getString("openTime"));
                  Assert.assertNotNull(accountState.getBoolean("canLogin"));
                  Assert.assertNotNull(accountState.getBoolean("canEarn"));
                  Assert.assertNotNull(accountState.getBoolean("canIssueCertificates"));
                  Assert.assertNotNull(accountState.getBoolean("canRedeem"));
                  Assert.assertNotNull(accountState.getBoolean("canLogin"));
                  Assert.assertEquals("COF", cardDetails.getJSONArray("partnerIds").getJSONObject(0).getString("partnerName"));
                  Assert.assertNotNull(cardDetails.getJSONArray("partnerIds").getJSONObject(0).getString("accountId"));
                  Assert.assertTrue(cardDetails.getJSONArray("partnerIds").getJSONObject(0).getBoolean("active"));
                  Assert.assertEquals("PRIMARY", cardHolders.getJSONObject(0).getString("cardHoldertype"));
                  Assert.assertNotNull(memberDetails.getString("birthday"));
                  Assert.assertNotNull(memberDetails.getString("email"));
                  Assert.assertNotNull(memberDetails.getString("phone"));
                  Assert.assertNotNull(memberDetails.getJSONObject("address").getString("country"));
                  Assert.assertNotNull(memberDetails.getJSONObject("address").getString("address2"));
                  Assert.assertNotNull(memberDetails.getJSONObject("address").getString("city"));
                  Assert.assertNotNull(memberDetails.getJSONObject("address").getString("address1"));
                  Assert.assertNotNull(memberDetails.getJSONObject("address").getString("postalCode"));
                  Assert.assertNotNull(memberDetails.getJSONObject("address").getString("stateProvince"));
                  Assert.assertNotNull(memberDetails.getJSONObject("name").getString("firstName"));
                  Assert.assertNotNull(memberDetails.getJSONObject("name").getString("lastName"));
                  Assert.assertNotNull(cardDetails.getString("cardType"));
                  Assert.assertNotNull(cardDetails.getString("cardDescription"));
                  Assert.assertNotNull(cardDetails.getString("cardProgramCode"));
              }


        }
    }
}
