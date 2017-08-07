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

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public LoginInfo getLoginInfo() {
		return loginInfo;
	}

	public void setLoginInfo(LoginInfo loginInfo) {
		this.loginInfo = loginInfo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((loginInfo == null) ? 0 : loginInfo.hashCode());
		result = prime * result + ((session == null) ? 0 : session.hashCode());
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
		SessionResponse other = (SessionResponse) obj;
		if (loginInfo == null) {
			if (other.loginInfo != null)
				return false;
		} else if (!loginInfo.equals(other.loginInfo))
			return false;
		if (session == null) {
			if (other.session != null)
				return false;
		} else if (!session.equals(other.session))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SessionResponse [session=" + session + ", loginInfo=" + loginInfo + "]";
	}

}