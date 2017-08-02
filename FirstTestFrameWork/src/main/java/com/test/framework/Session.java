package com.test.framework;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


class Session {

	@SerializedName("name")
	@Expose
	public String name;
	
	@SerializedName("value")
	@Expose
	public String value;

	//Instead of Setter ..Using COnstructor

	Session(String nam , String val ){

		name = nam ;
		value = val ;

	}


}

