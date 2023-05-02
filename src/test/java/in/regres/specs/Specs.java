package in.regres.specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static in.regres.helpers.CustomApiListener.withCustomTemplates;
import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.ALL;
import static io.restassured.http.ContentType.JSON;

public class Specs {
    private static String testUri = "https://reqres.in";
    private static String testPath = "/api";
    public static RequestSpecification requestSpec = with()
            .baseUri(testUri)
            .basePath(testPath)
            .log().all()
            .filter(withCustomTemplates())
            .contentType(JSON);

    public static ResponseSpecification responseSpec = new ResponseSpecBuilder()
            .log(ALL)
            .build();

}