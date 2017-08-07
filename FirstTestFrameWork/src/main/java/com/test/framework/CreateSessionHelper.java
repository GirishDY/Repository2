package com.test.framework;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.google.gson.Gson;

import com.test.framework.SessionRequest;

public class CreateSessionHelper {



	public String getSession() {

		FileInputStream fs;
		Properties prop = new Properties();

		try {
			fs = new FileInputStream(
					"/Users/GirishD/Desktop/SelWeb/Eclipse/eclipse-workspace/FirstTestFrameWork/src/main/resources/env.properties");

			prop.load(fs);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		RestAssured.baseURI = prop.getProperty("HOST");

		Gson gson = new Gson();

		SessionRequest sesRq = new SessionRequest();

		sesRq.setPassword(prop.getProperty("PASSWORD"));
		sesRq.setUsername(prop.getProperty("USER"));

		// Object to JSON Conversion . JSON is a STRING type. Treat it like a String

		String json = gson.toJson(sesRq)  ;

		System.out.println("Printing Request Json :    " + json);

		// Using rest assured to Create Session

		Response res =

				given().header("Content-Type", "application/json").body(json)

						.when().post("/rest/auth/1/session")

						.then()

						.extract().response();

		
//---------------Extracting  FOUR +1  parts of Response : Body,header,cookie, statuscode 	+ 	
		Integer status = res.statusCode();			// --->1
		System.out.println("Status Code :" + status);


		SessionResponse sessR2 = res.body().as(SessionResponse.class);   //--->2
		System.out.println("Printing Body : " + sessR2.toString());  // Exactly Same as Printing entire response .
		
		
		
		Long responseTime  = res.getTime() ;
		System.out.println("API Response Time in millisecs : "+ responseTime);
		
		
///////////////////////////////IMP!!   Storing all the Response cookies in a Map . Here we use COLLECTIONS.////////////////////////////////--->3
	
		
		Map<String,String> coke = res.cookies() ;
		
//		Iterator<Map.Entry<String,String>> entries = map.entrySet().iterator();
		
		Iterator<Map.Entry<String,String>> itr = coke.entrySet().iterator() ;
		
		while (itr.hasNext()) {
		    Map.Entry<String,String> i = itr.next();
		    System.out.println("Key = " + i.getKey() + ", Value = " + i.getValue());
		}
		


		///Access value os  a Key
		
		System.out.println(""
				+ "Accessing value of a given key of the hash : "+ coke.get("JSESSIONID"));
		
		
//////////////////////////////IMP!!   Storing all the Response headrs in a List . Here we use COLLECTIONS.////////////////////////////////----->4
		
		List<Header> headerList = res.headers().asList();
		
		int i =0 ;
		Iterator<Header> iter = headerList.iterator() ;
		
		while (iter.hasNext()) {
		    Header elem = iter.next();
   
		    System.out.println("Heade elemet"+  ++i +" :   " + elem.toString()) ;
		
		}
		
		
		
		
/////////////////////////////////////////////////////////////////////////////////
		
		
		String responseString = res.asString();

		System.out.println("Printing Response Json :    " + responseString);

//////////////////// Using JsonPath  to access response /////////////////////////////////////////

		JsonPath js = new JsonPath(responseString);

		String sessID = js.get("session.value");

////////////////////// Converting to CLass_Object directly from "Response res"///////////////////////////////////////////

		SessionResponse sesRp1 = res.as(SessionResponse.class);

		System.out.println("Directly from Response : " + "" + "" + sesRp1.toString());

////////////////////////// CONVERTING JSON TO CLass_Object/////////////////////////////////////////////////////////////

		SessionResponse sesRp = gson.fromJson(responseString, SessionResponse.class);
		System.out.println("Out put is --> " + sesRp.toString());

		// IMP!! This is how to access Values in RESPONSE JSON . to set values(in Request Json) use setter methods .

		System.out.println(sesRp.getSession().getName());
		System.out.println(sesRp.getSession().getValue());

		System.out.println(sesRp.loginInfo.getLastFailedLoginTime());
		System.out.println(sesRp.getLoginInfo().getPreviousLoginTime());
		System.out.println(sesRp.getLoginInfo().getFailedLoginCount());
		System.out.println(sesRp.getLoginInfo().getLoginCount());

		return sessID;

	}
}
