package CodeExperiment;


import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


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
public Map<Object,Object> loginInfo  ;


//Instead of Setter ..Using COnstructor

SessionResponse( Map<Object,Object>  log , Session ses ){
	
	session = ses ;
	
	loginInfo = log ;
}



}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



//CONVERTING TO JSON



public class JsonConv2 {

public static void main(String args[]) {	
	
Session ses = new Session("JSESSIONID","83E7D85C80DCD866D6B2E341CD69858D") ;

//LoginInfo log = new LoginInfo() ;
 

//log.hmap1.put("failedLoginCount", 1);
//log.hmap1.put("loginCount", 53);
//
//log.hmap2.put("lastFailedLoginTime", "2017-07-25T01:04:15.825+1000") ;
//log.hmap2.put("previousLoginTime", "2017-07-30T10:58:17.718+1000") ;


Map<Object,Object> log = new HashMap<Object,Object>() ;

log.put("failedLoginCount", 1);
log.put("loginCount", 53);

log.put("lastFailedLoginTime", "2017-07-25T01:04:15.825+1000") ;
log.put("previousLoginTime", "2017-07-30T10:58:17.718+1000") ;



SessionResponse sesR = new SessionResponse(log,ses) ;



Gson gson = new Gson();

String json = gson.toJson(sesR) ;


System.out.println(json);

//COnverting Json(String)  to Class Object

//SessionResponse sesR1 =  gson.fromJson(json , sesR.getClass()) ; //  --->A


SessionResponse sesR1 =  gson.fromJson(json , SessionResponse.class) ;  // --->B

//Both   A   and B   will work .


System.out.println(" "
		+ ""
		+ ""
		+ "") ;

System.out.println(sesR.getClass());

System.out.println(sesR1.session.value);




} 
		
	
	
}


/* THis is what I get in JSON . See instead of using hasmap1,2 we can use "logininfo" as hashmap in SessionResponseClass Doing in JsonConv3 .

{
  "session": {
    "name": "JSESSIONID",
    "value": "83E7D85C80DCD866D6B2E341CD69858D"
  },
  "loginInfo": {
    "hmap1": {
      "failedLoginCount": 1,
      "loginCount": 53
    },
    "hmap2": {
      "lastFailedLoginTime": "2017-07-25T01:04:15.825+1000",
      "previousLoginTime": "2017-07-30T10:58:17.718+1000"
    }
  }
}



*/