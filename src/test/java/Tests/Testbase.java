package Tests;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class Testbase {


    @BeforeAll
    public static void init(){

        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8087;
        RestAssured.basePath = "/student";


    }
}
