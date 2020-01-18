package com.typhoon.rest.webservices.restfulwebservices.versioning;

public class PersonV2 {

    private Name name;

    public PersonV2() {
    }

    public PersonV2(Name name) {
        super();
        this.name = name;
    }

    public Name getName() {
		return this.name;
	}

	public void setName(Name name) {
		this.name = name;
	}

}