package com.napt.api.wsi.apistepdefinitions;

import com.napt.api.wsi.apistores.ApiEngine;
import com.napt.api.wsi.apistores.Globals;
import gherkin.deps.com.google.gson.JsonArray;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.junit.Assert;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

public class TestSteps {
	ApiEngine ae = new ApiEngine();
	@Given("^that param \"([^\"]*)\" is set to value \"([^\"]*)\"$")
	public void that_param_is_set_to_value(String dictionaryKey, String value) {
		
		String[] paramCategory = dictionaryKey.split("\\.");
		
		switch(paramCategory[0]) {
		case "headers":
			Globals.headers.put(paramCategory[1],value);
			if (value.contains("access_token")) {
				Globals.headers.put(paramCategory[1],"Bearer "+Globals.access_token.get("access_token"));
			}
			break;
		case "base_url":
			Globals.globalVariables.put(paramCategory[1],value);
			break;
		case "xml_headers":
			Globals.xmlHeaders.put(paramCategory[1],value);
			break;
			case "Authorization":
            Globals.Authorization.put(paramCategory[1],value);
				break;
		case "sessionheaders":
			if (value.equals("sessionID")) {
				Globals.sessionHeaders.put(paramCategory[1],Globals.sessionID.get("SessionID"));
			}else{
				Globals.sessionHeaders.put(paramCategory[1], value);
			}
			break;
		case "oauthEncoded":
			Globals.oAuthEncoded.put(paramCategory[1],value);
			break;

		}


	}
		

	@When("^I make a \"([^\"]*)\" REST Call with URI \"([^\"]*)\" and store the response with Dictionary Key \"([^\"]*)\"$")
	public void i_make_a_REST_Call_with_URI_and_store_the_response_with_Dictionary_Key(String requestType, String URI, String dictionaryKey) throws Throwable {
			Response rs = ae.callAPI(requestType, Globals.headers, "", Globals.globalVariables.get("url").toString() + URI);
			Globals.globalVariables.put(dictionaryKey,rs);
	}

	@Then("^I verify that the response code is \"([^\"]*)\" for the response with Dictionary Key \"([^\"]*)\"$")
	public void i_verify_that_the_response_code_is_for_the_response_with_Dictionary_Key(String responseCode, String dictionaryKey) {
		Response rs = (Response) Globals.globalVariables.get(dictionaryKey);
		System.out.println("response value" +rs.asString());
		Assert.assertEquals("Actual Response Code is " + rs.getStatusCode() + " vs Expected Response Code" + responseCode, String.valueOf(rs.getStatusCode()), responseCode);

	}

	@Then("^I verify that the json path \"([^\"]*)\" for node \"([^\"]*)\"  value is \"([^\"]*)\" for the response with Dictionary Key \"([^\"]*)\"$")
	public void i_verify_that_the_json_path_for_node_value_is_for_the_response_with_Dictionary_Key(String jsonPath, String valueOfNode, String dictionaryKey) throws Throwable {
		valueOfNode = valueOfNode.replace(";qt;", "\"");
		Response rs = (Response) Globals.globalVariables.get(dictionaryKey);
		System.out.println(ae.searchJsonStringByJsonPath(rs.asString(), jsonPath));
		System.out.println(valueOfNode);


		Assert.assertEquals("Json Path node not found", ae.searchJsonStringByJsonPath(rs.asString(), jsonPath), valueOfNode);
	}


	@Then("^I verify that the json path \"([^\"]*)\" for node array \"([^\"]*)\" contains \"([^\"]*)\" number of nodes for the response with Dictionary Key \"([^\"]*)\"$")
	public void i_verify_that_the_json_path_for_node_array_contains_number_of_nodes_for_the_response_with_Dictionary_Key(String jsonPath, String numberOfNodes, String dictionaryKey) throws Throwable {
		Response rs = (Response) Globals.globalVariables.get(dictionaryKey);
		JsonArray ja = ae.jsonStringtoJsonArray(rs.asString(), jsonPath);
		Assert.assertEquals("Number of of elements is " + ja.size() + " vs Expected Value of " + numberOfNodes, Integer.parseInt(numberOfNodes), ja.size());
	}
	
	@When("^I read the JSON from file \"([^\"]*)\" into Dictionary Key \"([^\"]*)\"$")
	public void i_read_the_JSON_from_file_into_Dictionary_Key(String jsonFilePath, String dictionaryKey) throws Throwable {
		String cwd = System.getProperty("user.dir");
		System.out.println("current directory "+cwd);
		String jsonPath=cwd+jsonFilePath;
		System.out.println("actual directory "+jsonPath);
		Globals.globalVariables.put(dictionaryKey, ae.jsonFileToString(jsonPath));
	}

	@When("^I make a \"([^\"]*)\" REST Call with URL \"([^\"]*)\" and Body from Dictionary Key \"([^\"]*)\"$")
	public void i_make_a_REST_Call_with_URL_and_Body_from_Dictionary_Key(String callType, String URI, String dictionaryKey) throws Throwable {
		Response rs = ae.callAPI(callType, Globals.headers, Globals.globalVariables.get(dictionaryKey).toString(), Globals.globalVariables.get("url").toString() + URI );
		Globals.globalVariables.put(dictionaryKey, rs);
	}
	
	@Then("^I add the value at json path \"([^\"]*)\" from response with Dictionary Key \"([^\"]*)\" and store it in Dictionary Key \"([^\"]*)\"$")
	public void i_add_the_value_at_json_path_from_response_with_Dictionary_Key_and_store_it_in_Dictionary_Key(String jsonPath, String sourceDictionary, String destDictionary) throws Throwable {
		Response rs = (Response) Globals.globalVariables.get(sourceDictionary);
		Globals.globalVariables.put(destDictionary,ae.searchJsonStringByJsonPath(rs.asString(), jsonPath));
		
	}
	@Then("^I verify that the response code is \"([^\"]*)\" for the response with Dictionary Key \"([^\"]*)\" and get sessionID$")
	public void i_verify_that_the_response_code_is_for_the_response_with_Dictionary_Key_getSessionID(String responseCode, String dictionaryKey) {
		Response rs = (Response) Globals.globalVariables.get(dictionaryKey);
		System.out.println("return body value" +rs.asString());
		JsonPath jsonPathEvaluator = rs.jsonPath();
		String getSessionID = jsonPathEvaluator.get("sessionID");
		System.out.println("Session ID "+getSessionID);
		Globals.sessionID.put("SessionID",getSessionID);
		Assert.assertEquals("Actual Response Code is " + rs.getStatusCode() + " vs Expected Response Code" + responseCode, String.valueOf(rs.getStatusCode()), responseCode);

	}
	@When("^I make a \"([^\"]*)\" REST Call with URI \"([^\"]*)\" and store the response of sessionID with Dictionary Key \"([^\"]*)\"$")
	public void i_make_a_REST_Call_with_URI_and_store_the_response_ofSessionID_with_Dictionary_Key(String requestType, String URI, String dictionaryKey) throws Throwable {
		String uri=URI.replace("sessionID",Globals.sessionID.get("SessionID"));
		System.out.println("actual uri "+uri);
		Response rs = ae.callAPI("get", Globals.headers, "", Globals.globalVariables.get("url").toString() + uri);
		Globals.globalVariables.put(dictionaryKey,rs);
	}

	@When("^I make a \"([^\"]*)\" REST Call with URL \"([^\"]*)\" and Body from Dictionary Key \"([^\"]*)\" and replace the sessionID$")
	public void i_make_a_REST_Call_with_URL_and_Body_from_Dictionary_Key_replaceSessionID(String callType, String URI, String dictionaryKey) throws Throwable {
		String uri=URI.replace("sessionID",Globals.sessionID.get("SessionID"));
		System.out.println("actual uri "+uri);
		String val= (String) Globals.globalVariables.get(dictionaryKey);
		System.out.println(val);
		if (uri.contains("PIIData")) {
			Response rs = ae.callAPI(callType, Globals.xmlHeaders, Globals.globalVariables.get(dictionaryKey).toString(), Globals.globalVariables.get("url").toString() + uri);
			Globals.globalVariables.put(dictionaryKey, rs);
		}else{
			Response rs = ae.callAPI(callType, Globals.sessionHeaders, Globals.globalVariables.get(dictionaryKey).toString(), Globals.globalVariables.get("url").toString() + uri);
			Globals.globalVariables.put(dictionaryKey, rs);
		}

	}

	@When("^I read the XML from file \"([^\"]*)\" into Dictionary Key \"([^\"]*)\"$")
	public void i_read_the_XML_from_file_into_Dictionary_Key(String jsonFilePath, String dictionaryKey) throws Throwable {
		String cwd = System.getProperty("user.dir");
		System.out.println("current directory "+cwd);
		String jsonPath=cwd+jsonFilePath;
		System.out.println("actual directory "+jsonPath);
		Globals.globalVariables.put(dictionaryKey, ae.xmlFileToString(jsonPath));
	}

	@Then("^I verify that the response body with the Return Code as \"([^\"]*)\" and Return Message as \"([^\"]*)\" with Dictionary Key \"([^\"]*)\"$")
	public void iVerifyThatTheResponseBodyWithTheReturnCodeAsAndReturnMessageAsWithDictionaryKey(String returnCode, String returnMessage, String dictionaryKey) {
		Response rs = (Response) Globals.globalVariables.get(dictionaryKey);
		System.out.println("return body value" +rs.asString());
		JsonPath jsonPathEvaluator = rs.jsonPath();
		Integer getReturnCode = jsonPathEvaluator.get("returnCode");
		String getReturnMessage = jsonPathEvaluator.get("returnMessage");
		Assert.assertTrue("Actual Return Code is ", getReturnCode.toString().contentEquals(returnCode));
		Assert.assertEquals("Actual Return Message is ", getReturnMessage, returnMessage);

	}
	@When("^I read the JSON from file \"([^\"]*)\" into Dictionary Key \"([^\"]*)\" and replace the sessionID$")
	public void i_read_the_JSON_from_file_into_Dictionary_Key_replaceSessionID(String jsonFilePath, String dictionaryKey) throws Throwable {
		String cwd = System.getProperty("user.dir");
		System.out.println("current directory "+cwd);
		String jsonPath=cwd+jsonFilePath;
		System.out.println("actual directory "+jsonPath);
		String replaceSessionID=ae.jsonFileToString(jsonPath);
		String actualJsonBody=replaceSessionID.replace("SessionID",Globals.sessionID.get("SessionID"));
		System.out.println("actual json body  "+actualJsonBody);
		Globals.globalVariables.put(dictionaryKey, actualJsonBody);
	}
	@When("^I make a \"([^\"]*)\" REST Call with URL \"([^\"]*)\" and Body from Dictionary Key \"([^\"]*)\" to get oauthEncoded$")
	public void i_make_a_REST_Call_with_URL_and_Body_from_Dictionary_Key_oAuthEncoded(String callType, String URI, String dictionaryKey) throws Throwable {
		Response rs = ae.callAPIoAuthEncoded( Globals.headers,Globals.oAuthEncoded, Globals.globalVariables.get(dictionaryKey).toString(), Globals.globalVariables.get("url").toString() + URI );
		Globals.globalVariables.put(dictionaryKey, rs);
	}

	@When("^I read the JSON from file \"([^\"]*)\" with StoreID \"([^\"]*)\" into Dictionary Key \"([^\"]*)\"$")
	public void i_read_the_JSON_from_file_into_Dictionary_Key_StoreId(String jsonFilePath, String storeID,String dictionaryKey) throws Throwable {
		String cwd = System.getProperty("user.dir");
		System.out.println("current directory "+cwd);
		String jsonPath=cwd+jsonFilePath;
		System.out.println("actual directory "+jsonPath);
		String replaceStoreID=ae.jsonFileToString(jsonPath);
		String actualJsonBody=replaceStoreID.replace("StoreID",storeID);
		Globals.globalVariables.put(dictionaryKey, actualJsonBody);

	}

	@When("^I read the XML from file \"([^\"]*)\" with SSN \"([^\"]*)\" into Dictionary Key \"([^\"]*)\"$")
	public void i_read_the_XML_from_file_into_Dictionary_Key_SSN(String jsonFilePath, String ssn,String dictionaryKey) throws Throwable {
		String cwd = System.getProperty("user.dir");
		System.out.println("current directory "+cwd);
		String jsonPath=cwd+jsonFilePath;
		System.out.println("actual directory "+jsonPath);
		String replaceSSN=ae.xmlFileToString(jsonPath);
		String actualJsonBody=replaceSSN.replace("SSN",ssn);
		Globals.globalVariables.put(dictionaryKey, actualJsonBody);
	}

	@When("^I read the XML from file (.*?) with input values into Dictionary Key \"([^\"]*)\"$")
	public void i_read_the_XML_from_file_into_Dictionary_Key_input_values(String jsonFilePath,String dictionaryKey, Map<String, String> values) throws Throwable {
		getCurrentDate();
		getAuthExpDate();
		values.get("Link By");
		String cwd = System.getProperty("user.dir");
		System.out.println("current directory "+cwd);
		String jsonPath=cwd+jsonFilePath;
		System.out.println("actual directory "+jsonPath);
		String replaceValues=ae.xmlFileToString(jsonPath);
		String concept=replaceValues.replace("concept",values.get("concept"));
		String orderID=concept.replace("orderID",values.get("orderID"));
		String subCode=orderID.replace("subCode",values.get("subCode"));
		String accountNumber=subCode.replace("accountNumber",values.get("accountNumber"));
		String fullName=accountNumber.replace("fullName",values.get("fullName"));
		String year=fullName.replace("year",values.get("year"));
		String envId=values.get("environment").toLowerCase();
		String envIdentifier=year.replace("environmentIdentifier",envId);
		String currentDate=envIdentifier.replace("currentDate",Globals.currentDate.get("currentDate"));
		String actualJsonBody=currentDate.replace("month",values.get("month"));
		Globals.globalVariables.put(dictionaryKey, actualJsonBody);
		System.out.println("Request body "+actualJsonBody);


	}

	@Then("^I verify that the response code is \"([^\"]*)\" for the response with Dictionary Key \"([^\"]*)\" and get Token$")
	public void i_verify_that_the_response_code_is_for_the_response_with_Dictionary_Key_getToken(String responseCode, String dictionaryKey) {
		Response rs = (Response) Globals.globalVariables.get(dictionaryKey);
		System.out.println("response value" +rs.asString());
		XmlPath responebody = new XmlPath(rs.asString());
		String responsecode = responebody.getString("ns0:TokenizationResponse.Tender.Token.text()");
		System.out.println("Token"+responsecode);
		Globals.token.put("Token",responsecode);
		Assert.assertEquals("Actual Response Code is " + rs.getStatusCode() + " vs Expected Response Code" + responseCode, String.valueOf(rs.getStatusCode()), responseCode);

	}

	@When("^I make a \"([^\"]*)\" REST Call with URL \"([^\"]*)\" and Body from Dictionary Key \"([^\"]*)\" for xml$")
	public void i_make_a_REST_Call_with_URL_and_Body_from_Dictionary_Key_forXml(String callType, String URI, String dictionaryKey) throws Throwable {
		Response rs = ae.callAPI(callType, Globals.xmlHeaders, Globals.globalVariables.get(dictionaryKey).toString(), Globals.globalVariables.get("url").toString() + URI);
		Globals.globalVariables.put(dictionaryKey, rs);
	}

	@When("^I read the XML from file (.*?) with input values into Dictionary Key \"([^\"]*)\" for Auth$")
	public void i_read_the_XML_from_file_into_Dictionary_Key_input_values_auth(String jsonFilePath,String dictionaryKey, Map<String, String> values) throws Throwable {
		String cwd = System.getProperty("user.dir");
		System.out.println("current directory "+cwd);
		String jsonPath=cwd+jsonFilePath;
		System.out.println("actual directory "+jsonPath);
		String replaceValues=ae.xmlFileToString(jsonPath);
		String concept=replaceValues.replace("concept",values.get("concept"));
		String orderID=concept.replace("orderID",values.get("orderID"));
		String subCode=orderID.replace("subCode",values.get("subCode"));
		String accountNumber=subCode.replace("accountNumber",values.get("accountNumber"));
		String fullName=accountNumber.replace("fullName",values.get("fullName"));
		String year=fullName.replace("year",values.get("year"));
		String address=year.replace("address",values.get("address"));
		String city=address.replace("city",values.get("city"));
		String state=city.replace("state",values.get("state"));
		String month=state.replace("month",values.get("month"));
		String postalCode=month.replace("postalCode",values.get("postalCode"));
		String currentDate=postalCode.replace("currentDate",Globals.currentDate.get("currentDate"));
		String authExpDate=currentDate.replace("authExpDate",Globals.futureDate.get("futureDate"));
		String token=authExpDate.replace("token",Globals.token.get("Token"));
		String env=token.replace("environment",values.get("environment"));
		String envId=values.get("environment").toLowerCase();
		String envIdentifier=env.replace("envIdentifier",envId);
		String actualJsonBody=envIdentifier.replace("authAmt",values.get("authAmt"));
		Globals.globalVariables.put(dictionaryKey, actualJsonBody);
		System.out.println("Request body "+actualJsonBody);
	}
	@When("^I read the XML from file (.*?) with input values into Dictionary Key \"([^\"]*)\" for capture")
	public void i_read_the_XML_from_file_into_Dictionary_Key_input_values_capture(String jsonFilePath,String dictionaryKey, Map<String, String> values) throws Throwable {
		String cwd = System.getProperty("user.dir");
		System.out.println("current directory "+cwd);
		String jsonPath=cwd+jsonFilePath;
		System.out.println("actual directory "+jsonPath);
		String replaceValues=ae.xmlFileToString(jsonPath);
		String concept=replaceValues.replace("concept",values.get("concept"));
		String orderID=concept.replace("orderID",values.get("orderID"));
		String subCode=orderID.replace("subCode",values.get("subCode"));
		String token=subCode.replace("token",Globals.token.get("Token"));
		String currentDate=token.replace("currentDate",Globals.currentDate.get("currentDate"));
		String authExpDate=currentDate.replace("authExpDate",Globals.futureDate.get("futureDate"));
		String metadata1=authExpDate.replace("metadata1",Globals.metadata1.get("metadata1"));
		String metadata2=metadata1.replace("metadata2",Globals.metadata2.get("metadata2"));
		String env=metadata2.replace("environment",values.get("environment"));
		String envId=values.get("environment").toLowerCase();
		String envIdentifier=env.replace("envIdentifier",envId);
		String actualJsonBody=envIdentifier.replace("authAmt",values.get("authAmt"));
		Globals.globalVariables.put(dictionaryKey, actualJsonBody);
		System.out.println("Request body "+actualJsonBody);
	}

	@Then("^I verify that the response code is \"([^\"]*)\" for the response with Dictionary Key \"([^\"]*)\" and get Auth Code and its MetaData")
	public void i_verify_that_the_response_code_is_for_the_response_with_Dictionary_Key_getAuthCode(String responseCode, String dictionaryKey) {
		Response rs = (Response) Globals.globalVariables.get(dictionaryKey);
		System.out.println("response value" +rs.asString());
		XmlPath responebody = new XmlPath(rs.asString());
		String authCode = responebody.getString("ns0:CreditCardAuthorizationResponse.Authorization.Code.text()");
		String metadata1 = responebody.getString("ns0:CreditCardAuthorizationResponse.Authorization.Metadata[0].text()");
		String metadata2 = responebody.getString("ns0:CreditCardAuthorizationResponse.Authorization.Metadata[1].text()");
//		String metadata3 = responebody.getString("ns0:CreditCardAuthorizationResponse.Authorization.Metadata[3].text()");
//		String metadata4 = responebody.getString("ns0:CreditCardAuthorizationResponse.Authorization.Metadata[4].text()");
//		String metadata5 = responebody.getString("ns0:CreditCardAuthorizationResponse.Authorization.Metadata[5].text()");
		System.out.println("AuthCode"+authCode);
		System.out.println("metadata1"+metadata1);
		System.out.println("metadata2"+metadata2);
		Globals.authCode.put("authCode",authCode);
		Globals.metadata1.put("metadata1",metadata1);
		Globals.metadata2.put("metadata2",metadata2);
//		Globals.metadata3.put("metadata3",metadata3);
//		Globals.metadata4.put("metadata4",metadata4);
//		Globals.metadata5.put("metadata5",metadata5);
		Assert.assertEquals("Actual Response Code is " + rs.getStatusCode() + " vs Expected Response Code" + responseCode, String.valueOf(rs.getStatusCode()), responseCode);

	}

	@When("^I read the XML from file (.*?) with input values into Dictionary Key \"([^\"]*)\" for postAuth")
	public void i_read_the_XML_from_file_into_Dictionary_Key_input_values_postAuth(String jsonFilePath,String dictionaryKey, Map<String, String> values) throws Throwable {
		String cwd = System.getProperty("user.dir");
		System.out.println("current directory "+cwd);
		String jsonPath=cwd+jsonFilePath;
		System.out.println("actual directory "+jsonPath);
		String replaceValues=ae.xmlFileToString(jsonPath);
		String concept=replaceValues.replace("concept",values.get("concept"));
		String orderID=concept.replace("orderID",values.get("orderID"));
		String subCode=orderID.replace("subCode",values.get("subCode"));
		String accountNumber=subCode.replace("accountNumber",values.get("accountNumber"));
		String fullName=accountNumber.replace("fullName",values.get("fullName"));
		String year=fullName.replace("year",values.get("year"));
		String month=year.replace("month",values.get("month"));
		String currentDate=month.replace("currentDate",Globals.currentDate.get("currentDate"));
		String authExpDate=currentDate.replace("authExpDate",Globals.futureDate.get("futureDate"));
		String authCode=authExpDate.replace("authCode",Globals.authCode.get("authCode"));
		String metadata1=authCode.replace("metadata1",Globals.metadata1.get("metadata1"));
		String metadata2=metadata1.replace("metadata2",Globals.metadata2.get("metadata2"));
		String env=metadata2.replace("environment",values.get("environment"));
		String actualJsonBody=env.replace("authAmt",values.get("authAmt"));
		if (dictionaryKey.equalsIgnoreCase("Return"))
		{
			String env1=metadata2.replace("environment",values.get("environment"));
			String envId1=values.get("environment").toLowerCase();
			String envIdentifier1=env1.replace("envIdentifier",envId1);
			String token=envIdentifier1.replace("token",Globals.token.get("Token"));
			String actualJsonBody1=token.replace("authAmt",values.get("authAmt"));
			Globals.globalVariables.put(dictionaryKey, actualJsonBody1);
			System.out.println("Request body "+actualJsonBody1);
		}
		else {
			Globals.globalVariables.put(dictionaryKey, actualJsonBody);
			System.out.println("Request body "+actualJsonBody);
		}
	}

	public void getCurrentDate()
	{
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String getCurrDate=formatter.format(date);
		Globals.currentDate.put("currentDate",getCurrDate);
		System.out.println("Current Date "+formatter.format(date));
	}
	public void getAuthExpDate()
	{
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_YEAR, 7);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date futureDateTime = calendar.getTime();
		String getfutureDateTime=formatter.format(futureDateTime);
		Globals.futureDate.put("futureDate",getfutureDateTime);
		System.out.println("Furture Date "+formatter.format(futureDateTime));
	}
}
