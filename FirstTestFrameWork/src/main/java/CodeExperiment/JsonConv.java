/*  COMMENTED ENTITE FILE SO THAT JsonConv2.java do not show error. which is copy of this file and has SAME CLASSES in the same package.

package CodeExperiment;


import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

class LoginInfo {

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

//Setter methods
public void setFailedLoginCount(Integer i)
{
	
this.failedLoginCount = i ;	
	
}

public void setLoginCount(Integer i)
{
	
this.loginCount = i ;	
	
}

public void setLastFailedLoginTime(String s)
{
	
this.lastFailedLoginTime = s ;	
	
}



public void setPreviousLoginTime(String s)
{
	
previousLoginTime = s ;	
	
}


//Setter methods  .. Not needed here so not adding 

//JUST CREATE A HASH MAN...instead of four varibles..issue  two integers and two String here .

}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
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

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

 class SessionResponse {

@SerializedName("session")
@Expose
public Session session;
@SerializedName("loginInfo")
@Expose
public LoginInfo loginInfo;

//Instead of Setter ..Using COnstructor

SessionResponse(LoginInfo log , Session ses ){
	
	session = ses ;
	
	loginInfo = log ;
}



}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



//CONVERTING TO JSON



public class JsonConv {

public static void main(String args[]) {	
	
Session ses = new Session("JSESSIONID","83E7D85C80DCD866D6B2E341CD69858D") ;

LoginInfo log = new LoginInfo() ;
 
log.failedLoginCount = 1 ;
log.setLoginCount(53);
log.setLastFailedLoginTime("2017-07-25T01:04:15.825+1000");
log.setPreviousLoginTime("2017-07-30T10:58:17.718+1000");


SessionResponse sesR = new SessionResponse(log,ses) ;



Gson gson = new Gson();

String json = gson.toJson(sesR) ;



System.out.println(json);

//COnverting Json(String)  to Class Object

//SessionResponse sesR1 =  gson.fromJson(json , sesR.getClass()) ; //  --->A


SessionResponse sesR1 =  gson.fromJson(json , SessionResponse.class) ;  // --->B




System.out.println(" "
		+ ""
		+ ""
		+ "") ;

System.out.println(sesR.getClass());



//SessionResponse sesR1 =  gson.fromJson(json, typeOfT);


System.out.println(sesR1.session.value);







} 
	
	
	
	
}


*/
