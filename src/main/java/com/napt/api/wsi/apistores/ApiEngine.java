package com.napt.api.wsi.apistores;

import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import gherkin.deps.com.google.gson.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class ApiEngine {

	Properties p=null;
	
	public void loadProperties(String propFilePath) throws IOException {
		FileReader reader=new FileReader(propFilePath);  
		 p=new Properties();  
		 p.load(reader);
	}
	
	public String jsonFileToString(String jsonFilePath) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(jsonFilePath)); 
		String str = ""; 
		String st;
		while (true) {
			st = br.readLine();
			if(st==null) {
				break;
			}else {
				str = str + st;
			}
		} 
		br.close();
		return str;
	}
	
	public JsonArray jsonFileToJsonArray(String json) {
		JsonParser jsonParser = new JsonParser();
		return jsonParser.parse(json).getAsJsonArray();
	}
	
	public JsonObject jsonFileToJsonObject(String jsonFilePath) throws JsonSyntaxException, IOException {
		JsonParser jp = new JsonParser();
		return jp.parse(jsonFileToString(jsonFilePath)).getAsJsonObject();
	}
	
	public String modifyJsonWithJsonPath(String jsonFilePath,String jsonPath,String newValue ) throws JsonSyntaxException, IOException {
		DocumentContext parsedDataContext =  JsonPath.parse(jsonFileToString(jsonFilePath));  
        parsedDataContext.set(jsonPath, newValue);
        return (parsedDataContext.jsonString());
	}
	
	public String searchJsonFileByJsonPath(String jsonFilePath,String jsonPath) throws JsonSyntaxException, IOException {
		DocumentContext parsedDataContext =  JsonPath.parse(jsonFileToString(jsonFilePath));  
        parsedDataContext.read(jsonPath);
        return (parsedDataContext.read(jsonPath).toString());
	}
	
	public String searchJsonStringByJsonPath(String jsonString ,String jsonPath) throws JsonSyntaxException, IOException {
		DocumentContext parsedDataContext =  JsonPath.parse(jsonString);  
        parsedDataContext.read(jsonPath);
        return (parsedDataContext.read(jsonPath).toString());
	}
	
	public JsonArray jsonStringtoJsonArray(String jsonFullString ,String jsonPathOfArrayNode) throws JsonSyntaxException, IOException {
		jsonFullString = searchJsonStringByJsonPath(jsonFullString, jsonPathOfArrayNode);
		JsonParser parser = new JsonParser();
		JsonElement elements = parser.parse(jsonFullString);
		JsonArray jsonArray = elements.getAsJsonArray();
		return jsonArray;
	}
	
	
	
	
	public Response callAPI(String ApiType, HashMap<String, String> headers, String body, String uri) throws URISyntaxException {
		Response res=null;
			
		switch(ApiType.toLowerCase()){
		case "get":
			res = given().relaxedHTTPSValidation().headers(headers).when().get(new URI(uri)).then().extract().response();
			break;
		case "post":
			res = given().relaxedHTTPSValidation().when().headers(headers).body(body).post(uri);
			break;
			case "xmlPost":
				res = given().relaxedHTTPSValidation().headers("Content-Type","application/xml").when().body(body).post(uri);
				break;
		case "put":
			res = given().relaxedHTTPSValidation().headers(headers).when().headers(headers).body(body).put(uri);
			break;
		case "patch":
			res = given().relaxedHTTPSValidation().headers(headers).when().headers(headers).body(body).patch(uri);
			break;
		case "delete":
			res = given().relaxedHTTPSValidation().headers(headers).when().headers(headers).body(body).delete(uri);
			break;
			case "auth":
//				RequestSpecification request = given().relaxedHTTPSValidation().auth().basic("ecom_WS/QA", "WSecom123");
				res=given().relaxedHTTPSValidation().auth().basic("ecom_WS","WSecom123").headers(headers).body(body).post(uri);

				break;

		}
		
		return res;
	}
	
	public void checkSchemaCompliance(String schemaFile, String jsonFile) {
		
	}
	
	public static void main(String[] args) throws URISyntaxException, IOException, ProcessingException {
		ApiEngine ae = new ApiEngine();
		//Response rs = ae.callAPI("get", new HashMap<String,String>(), "", new URI("https://reqres.in/api/users?page=2"));
		//System.out.println(rs.jsonPath().getList("data").get(0));
		
		//Response rs = ae.callAPI("post", new HashMap<String,String>(), "{\"name\": \"morpheus\",\"job\": \"leader\"}", new URI("https://reqres.in/api/users"));
		//Response rs = ae.callAPI("put", new HashMap<String,String>(), "{\"name\": \"morpheus\",\"job\": \"leader\"}", new URI("https://reqres.in/api/users/2"));
		//Response rs = ae.callAPI("patch", new HashMap<String,String>(), "{\"name\": \"morpheus\",\"job\": \"leader\"}", new URI("https://reqres.in/api/users/2"));
		//Response rs = ae.callAPI("delete", new HashMap<String,String>(), "{\"name\": \"morpheus\",\"job\": \"leader\"}", new URI("https://reqres.in/api/users/4"));
		//JsonObject s = new ApiEngine().jsonFileToJsonObject("/Users/nisum/Downloads/post.json");
		
		//System.out.println (s.getAsJsonObject("environment_variables").toString());
		//System.out.println (ae.modifyJsonWithJsonPath("/Users/nisum/Downloads/postarray.json","$.[0].name","asc"));
		System.out.println (ae.searchJsonStringByJsonPath(ae.jsonFileToString("/Users/nisum/Downloads/postarray.json"),"$.[0].name"));
		
		//JSONSchemaUtils jsu = new JSONSchemaUtils();
		//System.out.println(jsu.isJsonValid("/Users/nisum/Downloads/postschema.json", "/Users/nisum/Downloads/postarray.json"));
	}

	public String xmlFileToString(String xmlFilePath) throws IOException, ParserConfigurationException, SAXException {
		Reader fileReader = new FileReader(xmlFilePath);
		BufferedReader bufReader = new BufferedReader(fileReader);
		StringBuilder sb = new StringBuilder();
		String line = bufReader.readLine();
		while( line != null)
		{
			sb.append(line).append("\n");
//			sb.append(line).append("\r\n");
			line = bufReader.readLine();
		}
		String xml2String = sb.toString();
		System.out.println("XML to String using BufferedReader : ");
		System.out.println(xml2String);
		bufReader.close();
		return xml2String;
	}
	public static String generateStringFromResource(String path) throws IOException {

		return new String(Files.readAllBytes(Paths.get(path)));

	}
}
