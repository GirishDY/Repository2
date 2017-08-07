package com.test.framework;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateSessionTest {

	CreateSessionHelper csh;

	@BeforeTest

	public void setup() {

		csh = new CreateSessionHelper();

	}

	@Test
	public void sessCreate() {

		String jSessId = csh.getSession();

		// Assert.assertTrue(!jSessId.isEmpty());

		Assert.assertFalse(jSessId.isEmpty());

		// Inside assertTrue() has to be some boolean value. True/False and testcase
		// will fail/pass accordingly .

	}
}
