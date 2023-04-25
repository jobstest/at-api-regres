package in.regres.tests;

import org.junit.jupiter.api.Test;

import static in.regres.specs.Specs.requestSpec;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItem;

public class ListUsersTests {

    @Test
    void checkEmailUsingGroovy(){
        given()
                .spec(requestSpec)
                .when()
                .get("/users")
                .then()
                .log().body()
                .body("data.findAll{it.email=~/.*?@reqres.in/}.email.flatten()",
                        hasItem("eve.holt@reqres.in"));
    }
}
