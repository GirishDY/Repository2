package com.test.framework;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SessionRequest {

@SerializedName("username")
@Expose
public String username;
@SerializedName("password")
@Expose
public String password;


SessionRequest(String user , String pass){
	
username = user ;
password = pass ;

	
}

}
