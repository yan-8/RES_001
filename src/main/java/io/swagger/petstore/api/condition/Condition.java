package io.swagger.petstore.api.condition;

import io.restassured.response.Response;

public interface Condition {
    void check(Response response);
}