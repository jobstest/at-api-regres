package in.regres.tests;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class BaseTests {
    protected final Faker faker = new Faker();

    @BeforeAll
    static void setUp(){
        RestAssured.baseURI = "https://reqres.in";
    }
}
