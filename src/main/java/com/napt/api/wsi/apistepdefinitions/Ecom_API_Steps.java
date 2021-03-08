package com.napt.api.wsi.apistepdefinitions;

import com.google.gson.JsonObject;
import com.napt.api.wsi.apistores.ApiEngine;
import com.napt.api.wsi.apistores.Globals;
import com.napt.api.wsi.pojo.GetCardDetailsresponse.Example;
import com.napt.api.wsi.steps.BrowserSteps;
import com.napt.framework.ui.runner.WebDriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import java.sql.DriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;


import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
        Assert.assertTrue(emp.getSystemContext().getEnvironmentIdentifier().equals("QA"));
        log.info("environment identifier is getting displayed properly "+emp.getSystemContext().getEnvironmentIdentifier());
        Assert.assertTrue(!emp.getSystemContext().getSourceSystemIdentifier().isEmpty());
        log.info("Source system identifier is getting displayed properly "+emp.getSystemContext().getSourceSystemIdentifier());
        Assert.assertTrue(!emp.getSystemContext().getTransactionId().isEmpty());
        log.info("Transaction id is not null. Value="+emp.getSystemContext().getTransactionId());
        Assert.assertTrue(!emp.getSystemContext().getTransactionTime().isEmpty());
        log.info("Transaction id is not null. Value="+emp.getSystemContext().getTransactionTime());
        Assert.assertTrue(!emp.getCardAccountDetails().getPartnerRequestId().isEmpty());
        log.info("Partner Request ID  "+emp.getCardAccountDetails().getPartnerRequestId());
        Assert.assertTrue(!emp.getCardAccountDetails().getFirstName().isEmpty());
        log.info("First Name  "+emp.getCardAccountDetails().getFirstName());
        Assert.assertTrue(!emp.getCardAccountDetails().getLastName().isEmpty());
        log.info("Last Name  "+emp.getCardAccountDetails().getLastName());
        Assert.assertTrue(!emp.getCardAccountDetails().getEmailAddress().isEmpty());
        log.info("Email Address  "+emp.getCardAccountDetails().getEmailAddress());
        Assert.assertTrue(!emp.getCardAccountDetails().getPhone().isEmpty());
        log.info("Phone  "+emp.getCardAccountDetails().getPhone());
        Assert.assertTrue(emp.getCardAccountDetails().getAddress().getAddressLineOne().equals(""));
        log.info("Address 1  "+emp.getCardAccountDetails().getAddress().getAddressLineOne());
        Assert.assertTrue(emp.getCardAccountDetails().getAddress().getAddressType().equals(""));
        log.info("Address Type  "+emp.getCardAccountDetails().getAddress().getAddressType());
        Assert.assertTrue(emp.getCardAccountDetails().getAddress().getAddressType().equals(""));
        log.info("Address Type  "+emp.getCardAccountDetails().getAddress().getAddressType());
        Assert.assertTrue(emp.getCardAccountDetails().getAddress().getCity().equals(""));
        log.info("City  "+emp.getCardAccountDetails().getAddress().getCity());
        Assert.assertTrue(emp.getCardAccountDetails().getAddress().getCountryCode().equals(""));
        log.info("Country Code"+emp.getCardAccountDetails().getAddress().getCountryCode());
        Assert.assertTrue(emp.getCardAccountDetails().getAddress().getCountry().equals(""));
        log.info("Country "+emp.getCardAccountDetails().getAddress().getCountry());
        Assert.assertTrue(emp.getCardAccountDetails().getAddress().getPostalCode().equals(""));
        log.info("Postal Code "+emp.getCardAccountDetails().getAddress().getPostalCode());
        Assert.assertTrue(emp.getCardAccountDetails().getAddress().getState().equals(""));
        log.info("State "+emp.getCardAccountDetails().getAddress().getState());
        Assert.assertTrue(emp.getCreditCard().getAccountId().equals(""));
        log.info("Credit Card Account ID "+emp.getCreditCard().getAccountId());
        Assert.assertTrue(emp.getCreditCard().getLast4Digits().equals(""));
        log.info("Credit Card last 4 digits "+emp.getCreditCard().getLast4Digits());
        Assert.assertTrue(emp.getCreditCard().getCardExpiry().equals(""));
        log.info("Credit Card expiry "+emp.getCreditCard().getCardExpiry());
        Assert.assertTrue(emp.getCreditCard().getCardType().equals(""));
        log.info("Credit Card Type "+emp.getCreditCard().getCardType());
        Assert.assertTrue(emp.getCreditCard().getTokenKey().equals(""));
        log.info("Credit Card Token Key "+emp.getCreditCard().getTokenKey());
    }
    public void connectDB() throws SQLException, ClassNotFoundException {
        Connection mysqlCon = null;
        String dbUrl = "jdbc:oracle:thin:@//sccdbqark1p:3800/sccqa";

        //Database Username
        String username = "COS_EXT_USER";

        //Database Password
        String password = "wergr8t!m";

        //Query to Execute
        String query = "select * from COS_EXT_USER.card_enrollment_details where id='4';";

        //Load mysql jdbc driver

        //Class.forName("com.mysql.jdbc.Driver");

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            mysqlCon = DriverManager.getConnection("jdbc:oracle:thin:@//sccdbqark1p:3800/sccqa", "COS_EXT_USER", "wergr8t!m");
        } catch (Exception e) {
            System.out.println(e);
        }



        //Create Connection to DB
        Connection con = DriverManager.getConnection(dbUrl,username, password);

        //Create Statement Object
        Statement stmt = con.createStatement();

         //Execute the SQL Query. Store results in ResultSet
        ResultSet rs= stmt.executeQuery(query);

         //While Loop to iterate through all data and print results
        while (rs.next()){
            String myName = rs.getString(1);
            String myAge = rs.getString(2);
            System. out.println(myName+"  "+myAge);
        }
        // closing DB Connection
        con.close();
    }
    @Given("I connect to DB")
    public void iConnectToDB() throws SQLException, ClassNotFoundException {
     connectDB();

    }
    }


