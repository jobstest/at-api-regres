package in.regres.tests;

import com.github.javafaker.Faker;
import in.regres.models.base.RegisterLoginRequest;
import in.regres.models.register.RegisterSuccessfulResponse;
import in.regres.models.login.LoginSuccessfulResponce;
import in.regres.models.base.RegisterLoginUnsuccessfulResponse;
import org.junit.jupiter.api.Test;

import static in.regres.specs.Specs.requestSpec;
import static in.regres.specs.Specs.responseSpec;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegisterLoginTests {

    Faker faker = new Faker();

    String email = "eve.holt@reqres.in";
    String password = faker.internet().password();
    int id = 4;
    String token = "QpwL5tke4Pnpja7X4";
    String errorMessage = "Missing email or username";

    @Test
    void registerSuccessful(){
        RegisterLoginRequest register = new RegisterLoginRequest();
        register.setEmail(email);
        register.setPassword(password);

        RegisterSuccessfulResponse response = given()
                .spec(requestSpec)
                .body(register.toString())
                .when()
                .post("/register")
                .then()
                .spec(responseSpec)
                .log().all()
                .statusCode(200)
                .extract().as(RegisterSuccessfulResponse.class);
        assertEquals(id, response.getId());
        assertEquals(token, response.getToken());
    }

    @Test
    void registerUnsuccessfulWithoutPassword(){
        RegisterLoginRequest register = new RegisterLoginRequest();
        register.setEmail(email);

        RegisterLoginUnsuccessfulResponse response = given()
                .spec(requestSpec)
                .contentType("text/html")
                .formParam("email", email)
                .post("/register")
                .then()
                .spec(responseSpec)
                .log().all()
                .statusCode(400)
                .extract().as(RegisterLoginUnsuccessfulResponse.class);
        assertEquals(errorMessage, response.getError());
    }

    @Test
    void registerUnsuccessfulWithoutEmail(){
        RegisterLoginRequest register = new RegisterLoginRequest();
        register.setPassword(password);

        RegisterLoginUnsuccessfulResponse response = given()
                .spec(requestSpec)
                .contentType("text/html")
                .formParam("password", password)
                .post("/register")
                .then()
                .spec(responseSpec)
                .log().all()
                .statusCode(400)
                .extract().as(RegisterLoginUnsuccessfulResponse.class);
        assertEquals(errorMessage, response.getError());
    }

    @Test
    void loginSuccessful(){
        RegisterLoginRequest login = new RegisterLoginRequest();
        login.setEmail(email);
        login.setPassword(password);

        LoginSuccessfulResponce response = given()
                .spec(requestSpec)
                .body(login.toString())
                .when()
                .post("/login")
                .then()
                .spec(responseSpec)
                .log().all()
                .statusCode(200)
                .extract().as(LoginSuccessfulResponce.class);
        assertEquals(token, response.getToken());
    }

    @Test
    void loginUnsuccessfulWithoutPassword(){
        RegisterLoginRequest register = new RegisterLoginRequest();
        register.setEmail(email);

        RegisterLoginUnsuccessfulResponse response = given()
                .spec(requestSpec)
                .contentType("text/html")
                .formParam("email", email)
                .post("/login")
                .then()
                .spec(responseSpec)
                .log().all()
                .statusCode(400)
                .extract().as(RegisterLoginUnsuccessfulResponse.class);
        assertEquals(errorMessage, response.getError());
    }

    @Test
    void loginUnsuccessfulWithoutEmail(){
        RegisterLoginRequest register = new RegisterLoginRequest();
        register.setPassword(password);

        RegisterLoginUnsuccessfulResponse response = given()
                .spec(requestSpec)
                .contentType("text/html")
                .formParam("password", password)
                .post("/login")
                .then()
                .spec(responseSpec)
                .log().all()
                .statusCode(400)
                .extract().as(RegisterLoginUnsuccessfulResponse.class);
        assertEquals(errorMessage, response.getError());
    }

}
