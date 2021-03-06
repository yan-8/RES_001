package io.swagger.petstore.api.data;

import lombok.Getter;

public enum Status {
    AVAILABLE("available"),
    PENDING("pending"),
    SOLD("sold");

    private @Getter String value;

    Status(String value) {
        this.value = value;
    }
}