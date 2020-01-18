package com.typhoon.rest.webservices.restfulwebservices.user;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "All details about the user. ")
@Entity
public class User {
	
	@Id
	@GeneratedValue
	private Integer id; 
	
	@Size(min=2, message="Name should have atleast 2 characters")
	@ApiModelProperty(notes = "Name should have atleast 2 characters")
	private String name; 
	
	@Past
	@ApiModelProperty(notes = "Birth date should be in the past")
	private Date birthDate;

	// map to the property "user" in Post
	// for composite primary key, please use the @JoinColumns
	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private List<Post> posts;

	// Dont need this function for POST method
	protected User() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public User(Integer id, String name, Date birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	} 

}