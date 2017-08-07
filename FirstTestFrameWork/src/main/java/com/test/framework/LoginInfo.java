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

public Integer getFailedLoginCount() {
	return failedLoginCount;
}

public void setFailedLoginCount(Integer failedLoginCount) {
	this.failedLoginCount = failedLoginCount;
}

public Integer getLoginCount() {
	return loginCount;
}

public void setLoginCount(Integer loginCount) {
	this.loginCount = loginCount;
}

public String getLastFailedLoginTime() {
	return lastFailedLoginTime;
}

public void setLastFailedLoginTime(String lastFailedLoginTime) {
	this.lastFailedLoginTime = lastFailedLoginTime;
}

public String getPreviousLoginTime() {
	return previousLoginTime;
}

public void setPreviousLoginTime(String previousLoginTime) {
	this.previousLoginTime = previousLoginTime;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((failedLoginCount == null) ? 0 : failedLoginCount.hashCode());
	result = prime * result + ((lastFailedLoginTime == null) ? 0 : lastFailedLoginTime.hashCode());
	result = prime * result + ((loginCount == null) ? 0 : loginCount.hashCode());
	result = prime * result + ((previousLoginTime == null) ? 0 : previousLoginTime.hashCode());
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	LoginInfo other = (LoginInfo) obj;
	if (failedLoginCount == null) {
		if (other.failedLoginCount != null)
			return false;
	} else if (!failedLoginCount.equals(other.failedLoginCount))
		return false;
	if (lastFailedLoginTime == null) {
		if (other.lastFailedLoginTime != null)
			return false;
	} else if (!lastFailedLoginTime.equals(other.lastFailedLoginTime))
		return false;
	if (loginCount == null) {
		if (other.loginCount != null)
			return false;
	} else if (!loginCount.equals(other.loginCount))
		return false;
	if (previousLoginTime == null) {
		if (other.previousLoginTime != null)
			return false;
	} else if (!previousLoginTime.equals(other.previousLoginTime))
		return false;
	return true;
}

@Override
public String toString() {
	return "LoginInfo [failedLoginCount=" + failedLoginCount + ", loginCount=" + loginCount + ", lastFailedLoginTime="
			+ lastFailedLoginTime + ", previousLoginTime=" + previousLoginTime + "]";
}





}