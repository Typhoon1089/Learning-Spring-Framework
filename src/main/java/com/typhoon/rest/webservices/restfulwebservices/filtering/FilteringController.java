package com.typhoon.rest.webservices.restfulwebservices.filtering;

import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilteringController {

    /**
     * The two following method is Static filtering
     * @return SomeBean
     */
    // @GetMapping("filtering")
    // public SomeBean retrieveSomeBean() {
    // return new SomeBean("value1", "value2", "value3");
    // }

    // @GetMapping("filtering-list")
    // public List<SomeBean> retrieveListOfSomeBean() {
    // return Arrays.asList(new SomeBean("value1", "value2", "value3"),
    // new SomeBean("value12", "value22", "value32"));
    // }

    /**
     * The two following method is Dynamic filtering
     * Remember to set @JsonFilter("SomeBeanFilter") at the somebean
     * @return MappingJacksonValue
     */
    // only field1 and field2
    @GetMapping("filtering")
    public MappingJacksonValue retrieveSomeBean() {
        SomeBean someBean = new SomeBean("value1", "value2", "value3");

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.
                filterOutAllExcept("field1", "field3");

        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);

        MappingJacksonValue mapping = new MappingJacksonValue(someBean);
        mapping.setFilters(filters);

        return mapping;
    }

    @GetMapping("filtering-list")
    public MappingJacksonValue retrieveListOfSomeBean() {
        List<SomeBean> list = Arrays.asList(new SomeBean("value1", "value2", "value3"),
                new SomeBean("value12", "value22", "value32"));

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.
                filterOutAllExcept("field2", "field3");

        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);

        MappingJacksonValue mapping = new MappingJacksonValue(list);
        mapping.setFilters(filters);

        return mapping;
    }
}