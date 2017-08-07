package com.test.framework;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class GetIssueTest {

	private String JSESSIONID;
	private GetIssueHelper gih;
	String issueId = "10028";
	JsonPath jsp;

	@BeforeTest
	public void setup() {

		gih = new GetIssueHelper();

		JSESSIONID = gih.getSession();

		jsp = gih.getIssueJsonPath(JSESSIONID, issueId);

		// I have taken JsonPath of the Response. Now in this file write 100s testcases
		// verifying various parts of the JSON .

	}

	@Test
	public void verifyIssueId() {

		System.out.println(jsp.get("id").getClass());

		// Assert.assertFalse( jsp.get("id").toString().isEmpty() ); //Pass if String is
		// not Empty

		Assert.assertFalse(jsp.getString("id").isEmpty()); // Getting JsonPath elemet directly as string. Can get as
															// Integer/flot/double..as well

	}

	@Test
	public void verifyIssueTypeName() {

		// System.out.println(" HERE111 " + jsp.getString("fields.issuetype.name") ) ;

		Assert.assertTrue(jsp.getString("fields.issuetype.name").contains("Bug"));
	}

}
