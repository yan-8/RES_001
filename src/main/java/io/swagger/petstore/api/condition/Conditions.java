package io.swagger.petstore.api.condition;

import lombok.experimental.UtilityClass;
import org.hamcrest.Matcher;

@UtilityClass
public class Conditions {
    public StatusCodeCondition statusCode(int statusCode) {
        return new StatusCodeCondition(statusCode);
    }

    public BodyFieldCondition bodyFieldCondition(String jsonPath, Matcher matcher) {
        return new BodyFieldCondition(jsonPath, matcher);
    }
}