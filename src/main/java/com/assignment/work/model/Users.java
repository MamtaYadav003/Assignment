package com.assignment.work.model;

public class Users {

	private String Id;
	private String username;
	private String password;
	private boolean enabled;

	
	public String getId() {
		return Id;
	}


	public void setId(String id) {
		Id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	

	public boolean isEnabled() {
		return enabled;
	}


	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}


	@Override
	public String toString() {
		return "Users [Id=" + Id + ", username=" + username + ", password=" + password + ", enabled=" + enabled + "]";
	}


	
}