package io.swagger.petstore.api.service;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class ApiService {




    protected RequestSpecification setup() {
        return RestAssured
                .given()
                    .contentType(ContentType.JSON)
                    .log().all();
    }
}