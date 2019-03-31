package com.typhoon.rest.webservices.restfulwebservices;

public class HelloWorldBean {

    private String message;

    public HelloWorldBean(String message) {
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    // This function is a requirement (to generate json)
	public String getMessage() {
		return message;
	}

    // Refactore by Eclipse/Source
	@Override
	public String toString() {
		return "HelloWorldBean [message=" + message + "]";
	}

}