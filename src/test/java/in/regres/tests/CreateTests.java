package in.regres.tests;

import in.regres.models.create.CreateRequest;
import in.regres.models.create.CreateResponse;
import org.junit.jupiter.api.Test;

import static in.regres.specs.Specs.requestSpec;
import static in.regres.specs.Specs.responseSpec;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateTests {

    String name = "morpheus";
    String job = "leader";

    @Test
    void create() {
        CreateRequest create = new CreateRequest();
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
                .extract().as(CreateResponse.class);
        assertEquals(name, response.getName());
        assertEquals(job, response.getJob());

    }
}
