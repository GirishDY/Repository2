package com.test.framework;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SessionResponse {

@SerializedName("session")
@Expose
public Session session;


@SerializedName("loginInfo")
@Expose
public LoginInfo loginInfo;



}