package io.swagger.petstore.api.service;

import io.restassured.RestAssured;
import io.restassured.filter.Filter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Slf4j
public class ApiService {
    protected RequestSpecification setup() {
        return RestAssured
                .given()
                    .contentType(ContentType.JSON)
                    .filters(getFilters());
    }

    private List<Filter> getFilters() {
        Boolean isTurnOn = Boolean.valueOf(System.getProperty("requestResponseApiLogging", "true"));
        if (isTurnOn) {
            return Arrays.asList(new RequestLoggingFilter(), new ResponseLoggingFilter());
        }
        return Collections.emptyList();
    }
}