
package com.test.framework;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginInfo {

@SerializedName("failedLoginCount")
@Expose
public Integer failedLoginCount;

@SerializedName("loginCount")
@Expose
public Integer loginCount;


@SerializedName("lastFailedLoginTime")
@Expose
public String lastFailedLoginTime;

@SerializedName("previousLoginTime")
@Expose
public String previousLoginTime;


LoginInfo(){	
	
	
	
}


}