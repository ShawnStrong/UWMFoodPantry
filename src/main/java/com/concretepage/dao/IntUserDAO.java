package com.concretepage.dao;


public interface IntUserDAO {
	
	public int createUser(String username, String password);
	
	public int login(String username, String password);

	public int changeUserPassword(String username, String oldpassword, String newpassword);

}
