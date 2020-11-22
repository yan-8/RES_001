package io.swagger.petstore.api.service;

import io.qameta.allure.Step;
import io.swagger.petstore.api.assertion.AssertableResponse;
import io.swagger.petstore.api.entity.Pet;

public class PetService extends ApiService {
    @Step
    public AssertableResponse addPetToStore(Pet pet) {
        return new AssertableResponse(setup().body(pet).when().post("/pet"));
    }

    @Step
    public AssertableResponse validateExistedPetInStore(long petId) {
        return new AssertableResponse(setup().when().get("/pet/" + petId));
    }
}