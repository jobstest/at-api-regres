package in.regres.tests;

import in.regres.models.create_update.CreateResponse;
import in.regres.models.create_update.CreateUpdateUserRequest;
import in.regres.models.create_update.UpdateResponse;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.restassured.AllureRestAssured;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static in.regres.specs.Specs.requestSpec;
import static in.regres.specs.Specs.responseSpec;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateUpdateTests extends BaseTests {
    String name = faker.name().name();
    String job = faker.job().field();

    @Owner("parfionov")
    @Severity(SeverityLevel.BLOCKER)
    @Feature("Create")
    @Test
    @DisplayName("Создание пользователя")
    void create() {
        CreateUpdateUserRequest create = new CreateUpdateUserRequest();
        create.setName(name);
        create.setJob(job);

        CreateResponse response = given()
                .filters(new AllureRestAssured())
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

    @Owner("parfionov")
    @Severity(SeverityLevel.MINOR)
    @Feature("Update/Put")
    @Test
    @DisplayName("Обновление всех данных пользователя")
    void updatePut() {
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
        assertEquals(job, update.getJob());
    }

    @Owner("parfionov")
    @Severity(SeverityLevel.MINOR)
    @Feature("Update/Patch")
    @Test
    @DisplayName("Обновление части данных пользователя")
    void updatePatch() {
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
        assertEquals(job, update.getJob());
    }

    @Owner("parfionov")
    @Severity(SeverityLevel.MINOR)
    @Feature("Delete")
    @Test
    @DisplayName("Удаление пользователя")
    void delete() {
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
