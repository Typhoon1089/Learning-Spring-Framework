package com.typhoon.rest.webservices.restfulwebservices;

import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    // @RequestMapping(method = RequestMethod.GET, path = "/hello-world")
    @GetMapping(path = "/hello-world")
    public String helloWorld() {
        return "Hello World";
    }

    // This function will generate a json file (not text as the previous function)
    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldeBean() {
        return new HelloWorldBean("Hello World");
    }

}