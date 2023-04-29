package in.regres.tests;

import in.regres.models.resource.ListResourceResponse;
import in.regres.models.resource.SingleResourceResponse;
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

public class ResourceTests {
    String url = "https://reqres.in/#support-heading";
    String text = "To keep ReqRes free, contributions towards server costs are appreciated!";

    @Owner("parfionov")
    @Severity(SeverityLevel.NORMAL)
    @Feature("Single <Resource>")
    @Test
    @DisplayName("Проверка значений полей для одного ресурса")
    void singleResource() {
        SingleResourceResponse response = given()
                .spec(requestSpec)
                .when()
                .get("/unknown/2")
                .then()
                .spec(responseSpec)
                .log().body()
                .statusCode(200)
                .extract().as(SingleResourceResponse.class);
        assertEquals(2, response.getData().getId());
        assertEquals("fuchsia rose", response.getData().getName());
        assertEquals(2001, response.getData().getYear());
        assertEquals("#C74375", response.getData().getColor());
        assertEquals("17-2031", response.getData().getPantoneValue());
        assertEquals(text, response.getSupport().getText());
        assertEquals(url, response.getSupport().getUrl());
    }

    @Owner("parfionov")
    @Severity(SeverityLevel.NORMAL)
    @Feature("List <Resource>")
    @Test
    @DisplayName("Проверка значений: по одному полю для каждого ресурcа")
    void checkInputInDiferentObjectonListResponse() {
        ListResourceResponse response = given()
                .spec(requestSpec)
                .when()
                .get("/unknown")
                .then()
                .spec(responseSpec)
                .log().body()
                .statusCode(200)
                .extract().as(ListResourceResponse.class);
        assertEquals(1, response.getPage());
        assertEquals(6, response.getPerPage());
        assertEquals(12, response.getTotal());
        assertEquals(2, response.getTotalPages());
        assertEquals(1, response.getData().get(0).getId());
        assertEquals("fuchsia rose", response.getData().get(1).getName());
        assertEquals(2002, response.getData().get(2).getYear());
        assertEquals("#7BC4C4", response.getData().get(3).getColor());
        assertEquals("17-1456", response.getData().get(4).getPantoneValue());
        assertEquals(url, response.getSupport().getUrl());
        assertEquals(text, response.getSupport().getText());
    }

    @Owner("parfionov")
    @Severity(SeverityLevel.NORMAL)
    @Feature("Single <Resource> not found")
    @Test
    @DisplayName("Ресурс не найден")
    void singleRasourceNotFound() {
        SingleResourceResponse response = given()
                .spec(requestSpec)
                .when()
                .get("/unknown/23")
                .then()
                .log().body()
                .statusCode(404)
                .extract().as(SingleResourceResponse.class);
        assertEquals(false, response.equals(false));

    }
}
