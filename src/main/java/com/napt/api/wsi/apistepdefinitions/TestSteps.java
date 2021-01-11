package com.napt.api.wsi.apistepdefinitions;

import com.napt.api.wsi.apistores.ApiEngine;
import com.napt.api.wsi.apistores.Globals;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import gherkin.deps.com.google.gson.JsonArray;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;

public class TestSteps {
	ApiEngine ae = new ApiEngine();
	@Given("^that param \"([^\"]*)\" is set to value \"([^\"]*)\"$")
	public void that_param_is_set_to_value(String dictionaryKey, String value) throws Throwable {
		
		String[] paramCategory = dictionaryKey.split("\\.");
		
		switch(paramCategory[0]) {
		case "headers":
			Globals.headers.put(paramCategory[1],value);
			break;
		case "base_url":
			Globals.globalVariables.put(paramCategory[1],value);
			break;
		case "xml_headers":
			Globals.xmlHeaders.put(paramCategory[1],value);
			break;
		case "sessionheaders":
			if (value.equals("sessionID")) {
				Globals.sessionHeaders.put(paramCategory[1],Globals.sessionID.get("SessionID"));
			}else{
				Globals.sessionHeaders.put(paramCategory[1], value);
			}
			break;
		}

	}
		

	@When("^I make a \"([^\"]*)\" REST Call with URI \"([^\"]*)\" and store the response with Dictionary Key \"([^\"]*)\"$")
	public void i_make_a_REST_Call_with_URI_and_store_the_response_with_Dictionary_Key(String requestType, String URI, String dictionaryKey) throws Throwable {
			Response rs = ae.callAPI("get", Globals.headers, "", Globals.globalVariables.get("url").toString() + URI);
			Globals.globalVariables.put(dictionaryKey,rs);
	}

	@Then("^I verify that the response code is \"([^\"]*)\" for the response with Dictionary Key \"([^\"]*)\"$")
	public void i_verify_that_the_response_code_is_for_the_response_with_Dictionary_Key(String responseCode, String dictionaryKey) throws Throwable {
		Response rs = (Response) Globals.globalVariables.get(dictionaryKey);
		System.out.println("return body value" +rs.asString());
		Assert.assertTrue("Actual Response Code is " + rs.getStatusCode() + " vs Expected Response Code" + responseCode,String.valueOf(rs.getStatusCode()).equals(responseCode));

	}

	@Then("^I verify that the json path \"([^\"]*)\" for node \"([^\"]*)\"  value is \"([^\"]*)\" for the response with Dictionary Key \"([^\"]*)\"$")
	public void i_verify_that_the_json_path_for_node_value_is_for_the_response_with_Dictionary_Key(String jsonPath, String nodeName, String valueOfNode, String dictionaryKey) throws Throwable {
		valueOfNode = valueOfNode.replace(";qt;", "\"");
		Response rs = (Response) Globals.globalVariables.get(dictionaryKey);
		System.out.println(ae.searchJsonStringByJsonPath(rs.asString(), jsonPath));
		System.out.println(valueOfNode);
		
		
		Assert.assertTrue("Json Path node not found",ae.searchJsonStringByJsonPath(rs.asString(), jsonPath).equals(valueOfNode));
	}


	@Then("^I verify that the json path \"([^\"]*)\" for node array \"([^\"]*)\" contains \"([^\"]*)\" number of nodes for the response with Dictionary Key \"([^\"]*)\"$")
	public void i_verify_that_the_json_path_for_node_array_contains_number_of_nodes_for_the_response_with_Dictionary_Key(String jsonPath, String nodeArrayName, String numberOfNodes, String dictionaryKey) throws Throwable {
		Response rs = (Response) Globals.globalVariables.get(dictionaryKey);
		JsonArray ja = ae.jsonStringtoJsonArray(rs.asString(), jsonPath);
		Assert.assertTrue("Number of of elements is " + ja.size()  +" vs Expected Value of " + numberOfNodes , Integer.parseInt(numberOfNodes)==ja.size());		
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
	public void i_verify_that_the_response_code_is_for_the_response_with_Dictionary_Key_getSessionID(String responseCode, String dictionaryKey) throws Throwable {
		Response rs = (Response) Globals.globalVariables.get(dictionaryKey);
		System.out.println("return body value" +rs.asString());
		JsonPath jsonPathEvaluator = rs.jsonPath();
		String getSessionID = jsonPathEvaluator.get("sessionID");
		System.out.println("Session ID "+getSessionID);
		Globals.sessionID.put("SessionID",getSessionID);
		Assert.assertTrue("Actual Response Code is " + rs.getStatusCode() + " vs Expected Response Code" + responseCode,String.valueOf(rs.getStatusCode()).equals(responseCode));

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
	public void iVerifyThatTheResponseBodyWithTheReturnCodeAsAndReturnMessageAsWithDictionaryKey(String returnCode, String returnMessage, String dictionaryKey) throws Throwable {
		Response rs = (Response) Globals.globalVariables.get(dictionaryKey);
		System.out.println("return body value" +rs.asString());
		JsonPath jsonPathEvaluator = rs.jsonPath();
		Integer getReturnCode = jsonPathEvaluator.get("returnCode");
		String getReturnMessage = jsonPathEvaluator.get("returnMessage");
		Assert.assertTrue("Actual Return Code is ", getReturnCode.toString().contentEquals(returnCode));
		Assert.assertTrue("Actual Return Message is ", getReturnMessage.equals(returnMessage));

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
}
