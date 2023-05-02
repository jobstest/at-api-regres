package in.regres.tests;

import com.github.javafaker.Faker;
import in.regres.models.register_login.LoginSuccessfulResponse;
import in.regres.models.register_login.RegisterLoginRequest;
import in.regres.models.register_login.RegisterLoginUnsuccessfulResponse;
import in.regres.models.register_login.RegisterSuccessfulResponse;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static in.regres.specs.Specs.requestSpec;
import static in.regres.specs.Specs.responseSpec;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegisterLoginTests extends BaseTests{

    String email = "eve.holt@reqres.in";
    String password = faker.internet().password();
    int id = 4;
    String token = "QpwL5tke4Pnpja7X4";
    String errorMessage = "Missing email or username";

    @Owner("parfionov")
    @Severity(SeverityLevel.BLOCKER)
    @Feature("Register successful")
    @Test
    @DisplayName("Регистрация пользователя")
    void registerSuccessful() {
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

    @Owner("parfionov")
    @Severity(SeverityLevel.BLOCKER)
    @Feature("Register unsuccessful without password")
    @Test
    @DisplayName("Регистрация без пароля")
    void registerUnsuccessfulWithoutPassword() {
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

    @Owner("parfionov")
    @Severity(SeverityLevel.BLOCKER)
    @Feature("Register unsuccessful without email")
    @Test
    @DisplayName("Регистрация без почты")
    void registerUnsuccessfulWithoutEmail() {
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

    @Owner("parfionov")
    @Severity(SeverityLevel.BLOCKER)
    @Feature("Register unsuccessful With emty field")
    @Test
    @DisplayName("Регистрация с пустыми полями")
    void registerUnsuccessfulWithEmtyField() {

        RegisterLoginUnsuccessfulResponse response = given()
                .spec(requestSpec)
                .post("/register")
                .then()
                .spec(responseSpec)
                .log().all()
                .statusCode(400)
                .extract().as(RegisterLoginUnsuccessfulResponse.class);
        assertEquals(errorMessage, response.getError());
    }

    @Owner("parfionov")
    @Severity(SeverityLevel.BLOCKER)
    @Feature("Login unsuccessful")
    @Test
    @DisplayName("Авторизация")
    void loginSuccessful() {
        RegisterLoginRequest login = new RegisterLoginRequest();
        login.setEmail(email);
        login.setPassword(password);

        LoginSuccessfulResponse response = given()
                .spec(requestSpec)
                .body(login.toString())
                .when()
                .post("/login")
                .then()
                .spec(responseSpec)
                .log().all()
                .statusCode(200)
                .extract().as(LoginSuccessfulResponse.class);
        assertEquals(token, response.getToken());
    }

    @Owner("parfionov")
    @Severity(SeverityLevel.BLOCKER)
    @Feature("Login unsuccessful without password")
    @Test
    @DisplayName("Авторизация без пароля")
    void loginUnsuccessfulWithoutPassword() {
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

    @Owner("parfionov")
    @Severity(SeverityLevel.BLOCKER)
    @Feature("Login unsuccessful without email")
    @Test
    @DisplayName("Авторизация без почты")
    void loginUnsuccessfulWithoutEmail() {
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

    @Owner("parfionov")
    @Severity(SeverityLevel.BLOCKER)
    @Feature("Login unsuccessful with emty field")
    @Test
    @DisplayName("Авторизация c пустыми полями")
    void loginUnsuccessfulWithEmtyField() {

        RegisterLoginUnsuccessfulResponse response = given()
                .spec(requestSpec)
                .post("/login")
                .then()
                .spec(responseSpec)
                .log().all()
                .statusCode(400)
                .extract().as(RegisterLoginUnsuccessfulResponse.class);
        assertEquals(errorMessage, response.getError());
    }

}
