package com.test.framework;


import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.given;
import io.restassured.response.Response;

public class GetIssueHelper {

	private String JSESSIONID;
	private JsonPath jsP;

	public String getSession() {

		CreateSessionHelper csh = new CreateSessionHelper();

		JSESSIONID = csh.getSession();

		System.out.println(JSESSIONID);

		return JSESSIONID;

	}

	public JsonPath getIssueJsonPath(String JSESSIONID, String issueId) {

		Response res = given().header("Cookie", "JSESSIONID=" + JSESSIONID).header("Content-Type", "application/json")

				.when().get("/rest/api/2/issue/" + issueId)

				.then()

				.extract().response();

		String responseString = res.asString();

		 jsP = new JsonPath(responseString);

		return jsP;

	}

}
