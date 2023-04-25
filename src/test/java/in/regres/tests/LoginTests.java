package in.regres.tests;

import io.qameta.allure.restassured.AllureRestAssured;
import org.junit.jupiter.api.Test;

import static in.regres.specs.Specs.requestSpec;
import static in.regres.specs.Specs.responseSpec;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.is;

public class LoginTests {
    String email = "eve.holt@reqres.in";
    String password = "cityslicka";

    @Test
    void successfullLoginTest() {
        String body = "{ \"email\": \"eve.holt@reqres.in\"," +
                "\"password\": \"cityslicka\" }";
        given()
                .filter(new AllureRestAssured())
                .log().uri()
                .log().body()
                .body(body)
                .contentType(JSON)
                .when()
                .post("https://reqres.in/api/login")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("token", is("QpwL5tke4Pnpja7X4"));
    }

    @Test
    void unsuccessfullLoginTest() {
        String body = "{ \"email\": \"eve.holt@reqres.in\"}";
        given().spec(requestSpec)
                .filter(new AllureRestAssured())
                //.formParam("email", email)
                .body(body)
                //.body("email" + email)
                //.body(format("email=%s", email))
                .when()
                .post("/login")
                .then()
                .spec(responseSpec)
                .log().body()
                .body("error", is("Missing password"));
    }
}

