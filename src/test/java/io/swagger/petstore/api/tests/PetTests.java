package io.swagger.petstore.api.tests;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.swagger.petstore.api.ProjectConfig;
import io.swagger.petstore.api.entity.Category;
import io.swagger.petstore.api.entity.Pet;
import io.swagger.petstore.api.entity.Tag;
import io.swagger.petstore.api.entity.response.PetResponse;
import io.swagger.petstore.api.service.PetService;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.util.ArrayList;
import java.util.Locale;
import static io.swagger.petstore.api.condition.Conditions.bodyFieldCondition;
import static io.swagger.petstore.api.condition.Conditions.statusCode;
import static io.swagger.petstore.api.data.Status.AVAILABLE;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.not;

public class PetTests {
    private PetService petService = new PetService();
    private Faker faker;
    private SoftAssert softAssert;

    @BeforeClass
    protected void setup() {
        ProjectConfig config = ConfigFactory.create(ProjectConfig.class, System.getProperties());
        RestAssured.baseURI = config.baseUrl();
        faker = new Faker(new Locale(config.locale()));
    }

    @BeforeMethod
    public void startMethod() {
        softAssert = new SoftAssert();
    }

//    @AfterMethod
//    public void finishMethod() {
//        softAssert.assertAll();
//    }

//    @Test(description = "GET pet/{petId}")
//    public void getPetTest() {
//
//    }

//    @Test(description = "GET /pet/findByStatus?status=pending")
//    public void getAllPetEntitiesByStatusTest() {
//
//    }

    @Test(description = "POST /pet, validation via using deserialization + test framework JUnit or TestNG")
    public void addNewPetToTheStoreTest1() {
//        ProjectConfig config = ConfigFactory.create(ProjectConfig.class, System.getProperties());
//        RestAssured.baseURI = config.baseUrl();
//        faker = new Faker(new Locale(config.locale()));

        String rawPetName = faker.name().firstName();
        String finalPetName = "TEST PET - " + rawPetName + ", " + faker.cat().breed();
        String categoryName = faker.music().instrument();
        String tagName = faker.cat().name();
        String petAvatar = faker.internet().avatar();

        ArrayList<Tag> tagsList = new ArrayList();
        tagsList.add(new Tag(0, tagName));

        Pet pet = new Pet(0, new Category(0, categoryName), finalPetName, new String[] {petAvatar}, tagsList, AVAILABLE.getValue());

        // using deserialization + TestNG
        PetResponse response = petService.addPetToStore(pet)
                .shouldHave(statusCode(200))
                .jsonToPojo(PetResponse.class);
        softAssert.assertTrue(response.getPetId() != 0, "USER ID EQUALS 0, SHOULD NOT BE 0");
        softAssert.assertTrue(response.getCategory().getName().equals(categoryName), "CATEGORY NAME IS WRONG, IT SHOULD BE " + categoryName);
        softAssert.assertTrue(response.getPetName().equals(finalPetName), "PET NAME IS WRONG, IT SHOULD BE " + finalPetName);
        softAssert.assertTrue(response.getTags().get(0).getName().equals(tagName), "TAG NAME IS WRONG, IT SHOULD BE " + tagName);
        softAssert.assertAll();
    }

//    @Test(description = "POST /pet, validation via using Hamcrest")
//    public void addNewPetToTheStoreTest2()  {
//        String randomName = "Test Pet " + faker.lorem().characters(10);
//
//        ArrayList<Tag> tag = new ArrayList();
//        tag.add(new Tag(0, randomName));
//
//        Pet pet = new Pet(0,
//                new Category(0, randomName),
//                randomName,
//                new String[]{"https://www.testing-x.com"},
//                tag,
//                AVAILABLE.getValue());
//
//        // using Hamcrest
//        petService.addPetToStore(pet)
//                .shouldHave(statusCode(200))
//                .shouldHave(bodyFieldCondition("id", not(contains(0))));
//    }

//    @Test(description = "PUT /pet")
//    public void changePetDataTest() {
//
//    }

//    @Test(description = "DELETE /pet/{petId}")
//    public void deleteExistingPetTest() {
//
//    }
}