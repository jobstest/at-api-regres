package in.regres.tests;

import com.github.javafaker.Faker;
import in.regres.models.base.CreateUpdateUserRequest;
import in.regres.models.create.CreateResponse;
import in.regres.models.update.UpdateResponse;
import org.junit.jupiter.api.Test;

import static in.regres.specs.Specs.requestSpec;
import static in.regres.specs.Specs.responseSpec;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateUpdateTests {
    Faker faker = new Faker();

    String name = faker.name().name();
    String job = faker.job().field();

    @Test
    void create() {
        CreateUpdateUserRequest create = new CreateUpdateUserRequest();
        create.setName(name);
        create.setJob(job);

        CreateResponse response = given()
                .spec(requestSpec)
                .body(create.toString())
                .when()
                .post("/users")
                .then()
                .spec(responseSpec)
                .log().all()
                .statusCode(201)
                .extract().as(CreateResponse.class);
        assertEquals(name, response.getName());
        assertEquals(job, response.getJob());
    }

    @Test
    void updatePut(){
        CreateUpdateUserRequest update = new CreateUpdateUserRequest();
        update.setName(name);
        update.setJob(job);

        UpdateResponse response = given()
                .spec(requestSpec)
                .body(update.toString())
                .when()
                .put("/users/2")
                .then()
                .spec(responseSpec)
                .log().all()
                .statusCode(200)
                .extract().as(UpdateResponse.class);
        assertEquals(name, update.getName());
        assertEquals(job,update.getJob());
    }

    @Test
    void updatePatch(){
        CreateUpdateUserRequest update = new CreateUpdateUserRequest();
        update.setName(name);
        update.setJob(job);

        UpdateResponse response = given()
                .spec(requestSpec)
                .body(update.toString())
                .when()
                .patch("/users/2")
                .then()
                .spec(responseSpec)
                .log().all()
                .statusCode(200)
                .extract().as(UpdateResponse.class);
        assertEquals(name, update.getName());
        assertEquals(job,update.getJob());
    }

    @Test
    void delete(){
        given()
                .spec(requestSpec)
                .when()
                .delete("/users/2")
                .then()
                .spec(responseSpec)
                .log().all()
                .statusCode(204);
    }


}
