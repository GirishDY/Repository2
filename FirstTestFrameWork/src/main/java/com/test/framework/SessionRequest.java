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

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 * 
	 * Every class implicitly or explicitly provides a hashCode() method, which
	 * digests the data stored in an instance of the class into a single hash value
	 * .
	 * 
	 * !!!!EVERY CLASS_OBJECT WILL HAVE A DIFFRENT HASH_CODE .!!!
	 * 
	 * Just use this. DOnt bother understanding the code . this is used by equals()
	 * method https://en.wikipedia.org/wiki/Java_hashCode()
	 */
	@Override  //Overriding hashCode() defined in Object Class 
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 * 
	 * This particular method is used to make comparison between two objects , if
	 * they are same are not .
	 * 
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SessionRequest other = (SessionRequest) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

}
