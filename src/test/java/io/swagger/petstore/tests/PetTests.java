package io.swagger.petstore.tests;

import io.swagger.petstore.entity.Category;
import io.swagger.petstore.entity.Pet;
import io.swagger.petstore.entity.Tag;
import io.swagger.petstore.http.HttpClient;
import org.testng.annotations.Test;
import java.util.ArrayList;
import static io.restassured.RestAssured.given;
import static io.swagger.petstore.data.Status.AVAILABLE;

public class PetTests extends HttpClient {
    @Test(description = "POST /pet")
    public void addPetToStoreTest() {
        String randomName = "Test Pet " + faker.lorem().characters(10);

        ArrayList<Tag> tag = new ArrayList();
        tag.add(new Tag(0, randomName));

        Pet pet = new Pet(0,
                new Category(0, randomName),
                randomName,
                new String[] {"https://www.testing-x.com"},
                tag,
                AVAILABLE.getValue());

        given().body(pet)
        .when().post("/pet")
        .then();
    }

}