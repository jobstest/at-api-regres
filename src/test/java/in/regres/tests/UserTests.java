package in.regres.tests;

import in.regres.models.users.ListUsersResponse;
import in.regres.models.users.SingleUserResponse;
import org.junit.jupiter.api.Test;

import static in.regres.specs.Specs.requestSpec;
import static in.regres.specs.Specs.responseSpec;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTests {
    String url = "https://reqres.in/#support-heading";
    String text = "To keep ReqRes free, contributions towards server costs are appreciated!";

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

    @Test
    void checkInputInDiferentObjectOnListResponse(){
        ListUsersResponse response = given()
                .spec(requestSpec)
                .when()
                .get("/users?page=2")
                .then()
                .spec(responseSpec)
                .log().body()
                .statusCode(200)
                .extract().as(ListUsersResponse.class);
        assertEquals(2,response.getPage());
        assertEquals(6, response.getPerPage());
        assertEquals(12, response.getTotal());
        assertEquals(2, response.getTotalPages());
        assertEquals(7, response.getData().get(0).getId());
        assertEquals("lindsay.ferguson@reqres.in", response.getData().get(1).getEmail());
        assertEquals("Tobias", response.getData().get(2).getFirstName());
        assertEquals("Fields", response.getData().get(3).getLastName());
        assertEquals(url, response.getSupport().getUrl());
        assertEquals(text, response.getSupport().getText());
    }

    @Test
    void singleUser() {
        SingleUserResponse response = given()
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
        assertEquals(url, response.getSupport().getUrl());
        assertEquals(text, response.getSupport().getText());
    }

    @Test
    void singleUserNotFound(){
        SingleUserResponse response = given()
                .spec(requestSpec)
                .when()
                .get("/users/23")
                .then()
                .log().body()
                .statusCode(404)
                .extract().as(SingleUserResponse.class);
        assertEquals(false, response.equals(false));
    }

}
