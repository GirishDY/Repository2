package com.test.framework;


import io.restassured.RestAssured ;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.google.gson.Gson;

import com.test.framework.SessionRequest;





public class CreateSessionHelper {

	
//@Test	
//	public String getSession(String user , String pass) {

public String getSession()  {


	FileInputStream fs;
	Properties prop=new Properties();
 ;
	try {
		fs = new FileInputStream("/Users/GirishD/Desktop/SelWeb/Eclipse/eclipse-workspace/FirstTestFrameWork/src/main/resources/env.properties");
	
	    prop.load(fs);

	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	

	RestAssured.baseURI = prop.getProperty("HOST") ;


	Gson gson = new Gson() ;	

	SessionRequest sesR = new SessionRequest(prop.getProperty("USER"), prop.getProperty("PASSWORD")) ;


	String json = gson.toJson(sesR) ;  //Object to JSON Conversion

//	System.out.println(""+json);


	//Use rest assured to Create Session

	Response res = 

			given().header("Content-Type","application/json")
			.body(json)

			.when().post("/rest/auth/1/session")

			.then()

			.extract().response()

			;

	String responseString = res.asString() ;

 //   System.out.println(responseString) ;
    
    //Using JsonPath
    
	JsonPath js = new JsonPath(responseString) ;
	
	String sessID = js.get("session.value")    ;
	
	
//	System.out.println("JSESSIONID =  "+sessID);
    
    

  //Using JasonPath. Commenting below code. Need to fix it .LEARN how to convert response to POJO .  
    /*
	
	//Converting JSON to Java Object 

	SessionResponse resp = gson.fromJson(json,SessionResponse.class ) ;
	
	
	System.out.println(""
			+ ""
			+ ""
			+ " "+resp.session) ;


 //Need to type Cast O/P from loginInfo hash  to String or Integer (value field) see JASON .
	
//Might need to drop HASH in SessionResponse	
	
*/

	return sessID ;
	
}
}
