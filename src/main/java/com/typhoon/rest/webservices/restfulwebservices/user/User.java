package com.typhoon.rest.webservices.restfulwebservices.user;

import java.util.Date;

public class User {

    private Integer id; 
    
    private String name; 
    
    private Date birthDate;

	public User(Integer id, String name, Date birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	} 
    
    

}