package com.napt.api.safeway.steps;

import com.google.common.io.Resources;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.napt.api.safeway.pojo.request.ldap.Request;
import com.napt.framework.api.ApiEngine.ApiEngine;
import com.napt.framework.api.ApiEngine.Globals;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.testng.Assert;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;

public class StepDef_Orders {

    HashMap<String, String> header_ldapToken = new HashMap<String,String>();
    HashMap<String, String> header_searchActivites = new HashMap<String,String>();
    HashMap<String, String> header_getActivity = new HashMap<String,String>();
    ApiEngine ae = new ApiEngine();
    String jsonLdapTokenRequestBody = null;
    ObjectMapper om = new ObjectMapper();
    String ldaptoken = "Bearer " + "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyX25hbWUiOiJ2Z3VuajAwIiwiZXhwIjoxNjEwNzU1ODAwLCJ1c2VyIjp7ImlkIjoiNWVkNTgzNDZhNWY4NzIwMDBmNzczZmI2IiwidXNlcklkIjoidmd1bmowMCIsImZpcnN0TmFtZSI6IlZhcnVuIiwibGFzdE5hbWUiOiJHdW5qYXBhbGx5IiwiYmFubmVycyI6WyJTYWZld2F5Il0sInNpdGVzIjpbIjE1NzQiLCIyOTQxIiwiMzEzMiIsIjI4NTYiLCIyNjAwIiwiMDAyMyIsIjEyMzQiLCIxMjI0IiwiMTIyMSIsIjAwNjgiLCIyOTk1IiwiMDYwMiIsIjA2MjEiLCI0NTk2IiwiMjk5NSIsIjA2MDIiLCIwNjIxIiwiNDU5NiJdLCJyb2xlcyI6WyJNRkMgTWFuYWdlciJdLCJwZXJtaXNzaW9ucyI6WyJVSV9PUkRFUl9FRElUIiwiVUlfT1JERVJfU0VBUkNIIl19fQ.Ie0CiOQRnR5vM2PdoeW56aY2gzvg7rxcuXDW5n7Fxj8";
    
    com.napt.api.safeway.pojo.response.searchactivities.Response[] resSearchActivities;
    com.napt.api.safeway.pojo.response.getactivity.Response resGetActivity;

    public StepDef_Orders() throws IOException {
        URL resourcePath = Resources.getResource("ldapRequestBody.json");
        jsonLdapTokenRequestBody = ae.jsonFileToString(resourcePath.getPath());
    }


    @Given("that I set the headers for {string}")
    public void setHeaders(String apiName){
        if(apiName.equals("ldapToken")){
            header_ldapToken.put("Authorization","Basic c2FmZXdheS1jbGllbnQ6c2FmZXdheS1zZWNyZXQ=");
            header_ldapToken.put("Content-Type","application/json");
            header_ldapToken.put("Accept","*/*");
        }else if(apiName.equals("searchActivities")){
            header_searchActivites.put("Authorization",ldaptoken);
        }else if(apiName.equals("getActivity")){
            header_getActivity.put("Authorization",ldaptoken);
        }
    }


    @Given("^that param \"([^\"]*)\" is set to value \"([^\"]*)\"$")
    public void that_param_is_set_to_value(String dictionaryKey, String value) throws Throwable {
        String[] paramCategory = dictionaryKey.split("\\.");
        switch(paramCategory[0]) {
            case "headers":
                Globals.headers.put(paramCategory[1],value);
                break;
            case "globals":
                Globals.globalVariables.put(paramCategory[1],value);
                break;
        }
    }
    @Given("that I generate a new LDAP token")
        public void generateLdapToken() throws Throwable {
        Request reqLdap = new Request();
        reqLdap.setAppId("APS_APP");
        reqLdap.setGrant_type("password");
        reqLdap.setPassword("Safeway45");
        reqLdap.setUser_id("vgunj00");
        Response resLdap = ae.callAPI("POST",header_ldapToken,reqLdap,Globals.globalVariables.get("ldapApi").toString() + Globals.globalVariables.get("uriLdapToken").toString());
            String jsonLdapTokenResponseBody = resLdap.getBody().asString();
            Globals.globalVariables.put("ldapToken",ae.searchJsonFileByJsonPath(jsonLdapTokenResponseBody,"$.access_token"));

        }

    @When("I call the get search activities for storeId {string}")
    public void searchActivities(String storeId) throws Throwable {
        HashMap<String,String> pathParams= new HashMap<String,String>();
        //pathParams.put("activityId",activityId);

        HashMap<String,String> queryStringParams = new HashMap<String,String>();
        queryStringParams.put("open","true");
        queryStringParams.put("userId","vgunj00");
        queryStringParams.put("siteId",storeId);

        HashMap<String,String> params = new HashMap<String,String>();

        Response resSearchActivities = ae.callAPI("get",header_searchActivites,"",Globals.globalVariables.get("activitiesApi").toString() + Globals.globalVariables.get("uriSearchActivities"),pathParams,queryStringParams,params);
        String jsonSearchActivitiesResp = resSearchActivities.getBody().asString();
        this.resSearchActivities = om.readValue(jsonSearchActivitiesResp,com.napt.api.safeway.pojo.response.searchactivities.Response[].class);
    }

    @Then("I verify that activity {string} is present in the response")
    public void verifyActivityPresent(String actId) throws Throwable {
        Boolean found=false;
        for(Integer i=0;i<this.resSearchActivities[0].getData().size();i++){
            if(resSearchActivities[0].getData().get(i).getActId()== Integer.parseInt(actId)){
               found=true;
               break;
            }
        }
        Assert.assertTrue(found,"Activity Id Not present");

    }

    @When("I get details for activity id {string}")
    public void getActivity(String activityId) throws Throwable {
        HashMap<String,String> pathParams= new HashMap<String,String>();
        pathParams.put("activityId",activityId);

        HashMap<String,String> queryStringParams = new HashMap<String,String>();
        queryStringParams.put("loadCA","true");
        queryStringParams.put("loadIA","true");

        HashMap<String,String> params = new HashMap<String,String>();
        Response resGetActivity = ae.callAPI("get",header_getActivity,"",Globals.globalVariables.get("activitiesApi").toString() + Globals.globalVariables.get("uriGetActivity").toString(), pathParams, queryStringParams, params);
        String getActivityResponse = resGetActivity.getBody().asString();
        this.resGetActivity = om.readValue(getActivityResponse, com.napt.api.safeway.pojo.response.getactivity.Response.class);
    }


    @Then("I verify that the following items are present in the activity.")
    public void verifyItems(List<List<String>> dt) throws Throwable {
        List<String> itemIds = new ArrayList<String>();
        for(Integer i=0;i<this.resGetActivity.getItemActivities().size();i++){
            itemIds.add(this.resGetActivity.getItemActivities().get(i).getItemId().toString());
        }
        for(Integer i=1;i<dt.size();i++){
            Assert.assertTrue(itemIds.contains(dt.get(i).get(0).toString()),"Item " + dt.get(i).get(0).toString() + " not found");
        }
    }

}
