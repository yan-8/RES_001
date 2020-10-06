package io.swagger.petstore.api.service;

import io.swagger.petstore.api.assertion.AssertableResponse;
import io.swagger.petstore.api.entity.Pet;

public class PetService extends ApiService {
    public AssertableResponse addPetToStore(Pet pet) {
        return new AssertableResponse(setup().body(pet)
                .when().post("/pet"));
    }
}