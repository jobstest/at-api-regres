package in.regres.specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static in.regres.helpers.CustomApiListener.withCustomTemplates;
import static io.restassured.RestAssured.with;

public class Specs {
    private static String testUri = "https://reqres.in";
    private static String testPath = "/api";
    public static RequestSpecification requestSpec = with()
            .baseUri(testUri)
            .basePath(testPath)
            .log().all()
            .filter(withCustomTemplates())
            .contentType(ContentType.JSON);

    public static ResponseSpecification responseSpec = new ResponseSpecBuilder()
            .build();

}