package io.swagger.petstore.api.tests;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.swagger.petstore.api.entity.Category;
import io.swagger.petstore.api.entity.Pet;
import io.swagger.petstore.api.entity.Tag;
import io.swagger.petstore.api.service.PetService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.Locale;
import static io.swagger.petstore.api.condition.Conditions.bodyFieldCondition;
import static io.swagger.petstore.api.condition.Conditions.statusCode;
import static io.swagger.petstore.api.data.Status.AVAILABLE;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.not;

public class PetTests {
    private PetService petService = new PetService();
    protected Faker faker;

    @BeforeClass
    protected void setup() {
        final String uri = "https://petstore.swagger.io/v2";

        faker = new Faker(new Locale("en-US"));
//        RestAssured.requestSpecification = new RequestSpecBuilder()
//                .setBaseUri(uri)
//                .setContentType("application/json")
//                .log(LogDetail.ALL)
//                .addFilter(new ResponseLoggingFilter())
//                .build();
        RestAssured.baseURI = uri; // ?
    }

    @Test(description = "GET pet/{petId}")
    public void getPetTest() {

    }

    @Test(description = "GET /pet/findByStatus?status=pending")
    public void getAllPetEntitiesByStatusTest() {

    }

    @Test(description = "POST /pet")
    public void addNewPetToTheStoreTest() {
        String randomName = "Test Pet " + faker.lorem().characters(10);

        ArrayList<Tag> tag = new ArrayList();
        tag.add(new Tag(0, randomName));

        Pet pet = new Pet(0,
                new Category(0, randomName),
                randomName,
                new String[] {"https://www.testing-x.com"},
                tag,
                AVAILABLE.getValue());

//        PetResponse response = petService.addPetToStore(pet) // using deserialization
        petService.addPetToStore(pet) // using Jayway JsonPath
                .shouldHave(statusCode(200))
//                .jsonToPojo(PetResponse.class); // using deserialization
                .shouldHave(bodyFieldCondition("id", not(contains(0)))); // using Jayway JsonPath + Hamcrest
//        assertTrue(response.getPetId() != 0); // using deserialization
    }

    @Test(description = "PUT /pet")
    public void changePetDataTest() {

    }

    @Test(description = "DELETE /pet/{petId}")
    public void deleteExistingPetTest() {

    }

}