package io.swagger.petstore.api.assertion;

import io.restassured.response.Response;
import io.swagger.petstore.api.condition.Condition;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AssertableResponse {
    private final Response response;

    public AssertableResponse shouldHave(Condition condition) {
        condition.check(response);
        return this;
    }

    public <T> T jsonToPojo(Class<T> claszz) {
        return response.as(claszz);
    }
}