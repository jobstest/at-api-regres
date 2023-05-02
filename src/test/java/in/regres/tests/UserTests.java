package in.regres.tests;

import in.regres.models.users.ListUsersResponse;
import in.regres.models.users.SingleUserResponse;
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

public class UserTests {
    String url = "https://reqres.in/#support-heading";
    String text = "To keep ReqRes free, contributions towards server costs are appreciated!";

    @Owner("parfionov")
    @Severity(SeverityLevel.NORMAL)
    @Feature("List users")
    @Test
    @DisplayName("Проверка значений: по одному полю для каждого пользователя")
    void checkInputInDiferentObjectOnListResponse() {
        ListUsersResponse response = given()
                .spec(requestSpec)
                .when()
                .get("/users?page=2")
                .then()
                .spec(responseSpec)
                .log().body()
                .statusCode(201)
                .extract().as(ListUsersResponse.class);
        assertEquals(2, response.getPage());
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

    @Owner("parfionov")
    @Severity(SeverityLevel.NORMAL)
    @Feature("Single user")
    @Test
    @DisplayName("Проверка значений полей для одного пользователя")
    void singleUser() {
        SingleUserResponse response = given()
                .spec(requestSpec)
                .when()
                .get("/users/2")
                .then()
                .spec(responseSpec)
                .log().body()
                .statusCode(400)
                .extract().as(SingleUserResponse.class);
        assertEquals(2, response.getData().getId());
        assertEquals("janet.weaver@reqres.in", response.getData().getEmail());
        assertEquals("Janet", response.getData().getFirstName());
        assertEquals("Weaver", response.getData().getLastName());
        assertEquals("janet.weaver@reqres.in", response.getData().getEmail());
        assertEquals(url, response.getSupport().getUrl());
        assertEquals(text, response.getSupport().getText());
    }

    @Owner("parfionov")
    @Severity(SeverityLevel.NORMAL)
    @Feature("Single user not found")
    @Test
    @DisplayName("Пользователь не найден")
    void singleUserNotFound() {
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

    @Owner("parfionov")
    @Severity(SeverityLevel.NORMAL)
    @Feature("Delayed response")
    @Test
    @DisplayName("Проверка значений при медленной загрузке: по одному полю для каждого пользователя")
    void checkInputInDiferentObjectOnDelayedResponse() {
        ListUsersResponse response = given()
                .spec(requestSpec)
                .when()
                .get("/users?delay=3")
                .then()
                .spec(responseSpec)
                .log().body()
                .statusCode(200)
                .extract().as(ListUsersResponse.class);
        assertEquals(1, response.getPage());
        assertEquals(6, response.getPerPage());
        assertEquals(12, response.getTotal());
        assertEquals(2, response.getTotalPages());
        assertEquals(1, response.getData().get(0).getId());
        assertEquals("janet.weaver@reqres.in", response.getData().get(1).getEmail());
        assertEquals("Emma", response.getData().get(2).getFirstName());
        assertEquals("Holt", response.getData().get(3).getLastName());
        assertEquals(url, response.getSupport().getUrl());
        assertEquals(text, response.getSupport().getText());
    }

}
