package com.concretepage.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
	
    @Id
    @GeneratedValue
    private int user_id;

    private String username;

    private String password;
    
    private int super_user;
    
    public User() {}
    
    public User(int user_id, String username, String password) {
    	this.user_id = user_id;
    	this.username = username;
    	this.password = password;
    }

	public int getUserid() {
        return user_id;
    }

    public void setUserid(int user_id) {
        this.user_id = user_id;
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
    
    public int getUseremail() {
    	return super_user;
    }
    
    public void setUseremail(int super_user) {
    	this.super_user = super_user;
    }
}
