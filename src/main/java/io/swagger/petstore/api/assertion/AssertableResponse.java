package io.swagger.petstore.api.assertion;

import io.qameta.allure.Step;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.swagger.petstore.api.condition.Condition;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public class AssertableResponse {
    private final Response response;

    @Step("RESPONSE SHOULD BE - {condition}")
    public AssertableResponse shouldHave(Condition condition) {
        log.info("CONDITION ---> {}", condition);
        condition.check(response);
        return this;
    }

    public <T> T jsonToPojo(Class<T> claszz) {
        return response.as(claszz);
    }

    public Headers headers() {
        return response.getHeaders();
    }
}