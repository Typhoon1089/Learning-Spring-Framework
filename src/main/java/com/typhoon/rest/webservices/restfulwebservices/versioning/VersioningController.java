package com.typhoon.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningController {

    @GetMapping("v1/person")
    public PersonV1 personV1() {
        return new PersonV1("Kaori Le");
    }

    // URI versioning => Twister
    @GetMapping("v2/person")
    public PersonV2 personV2() {
        return new PersonV2(new Name("Kaori", "Le"));
    }

    // Params versioning => Amazon
    @GetMapping(value = "/person/param", params = "version=2" )
    public PersonV2 paramV2() {
        return new PersonV2(new Name("Kaori", "Le"));
    }

    // Header versioning => Microsoft
    @GetMapping(value = "/person/header", headers = "X-API-VERSION=2" )
    public PersonV2 headerV2() {
        return new PersonV2(new Name("Kaori", "Le"));
    }

    // MIME type versioning => GitHub
    @GetMapping(value = "/person/produces", produces = "application/vnd.company.app-v2+json" )
    public PersonV2 produecesV2() {
        return new PersonV2(new Name("Kaori", "Le"));
    }
}