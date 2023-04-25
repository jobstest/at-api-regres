package in.regres.tests;

import in.regres.LombokObject.SingleUser.SingleUserResponse;
import org.junit.jupiter.api.Test;

import static in.regres.specs.Specs.requestSpec;
import static in.regres.specs.Specs.responseSpec;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SingleUserTests {

    SingleUserResponse response = new SingleUserResponse();

    @Test
    void singleUserTest() {
        response = given()
                .spec(requestSpec)
                .when()
                .get("/users/2")
                .then()
                .spec(responseSpec)
                .log().body()
                .statusCode(200)
                .extract().as(SingleUserResponse.class);
        assertEquals(2, response.getData().getId());
        assertEquals("janet.weaver@reqres.in", response.getData().getEmail());
        assertEquals("Janet", response.getData().getFirstName());
        assertEquals("Weaver", response.getData().getLastName());
        assertEquals("janet.weaver@reqres.in", response.getData().getEmail());
        assertEquals("https://reqres.in/#support-heading", response.getSupport().getUrl());
        assertEquals("To keep ReqRes free, contributions towards server costs are appreciated!", response.getSupport().getText());
    }

}
