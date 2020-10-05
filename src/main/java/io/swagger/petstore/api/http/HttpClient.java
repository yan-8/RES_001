package io.swagger.petstore.api.http;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.testng.annotations.BeforeClass;

import java.util.Locale;

public class HttpClient {
    private final String uri = "https://petstore.swagger.io/v2";
    protected Faker faker;

    @BeforeClass
    protected void setup() {
        faker = new Faker(new Locale("en-US"));
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setBaseUri(uri)
                .setContentType("application/json")
                .log(LogDetail.ALL)
                .addFilter(new ResponseLoggingFilter())
                .build();
    }
}