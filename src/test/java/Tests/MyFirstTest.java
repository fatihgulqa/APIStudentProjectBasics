package Tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.Validatable;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.*;

public class MyFirstTest {

    private void styles() {

        RestAssured.given()
                .queryParam("", "")
                .when()
                .get("www.google.com")
                .then();

        // other way
        RestAssured.given()
                .expect()
                .when();
    }


    @DisplayName("Getting all the students from database")
    @Test
    public void getAllStudents() {

        RequestSpecification requestSpec = RestAssured.given();
        Response response = requestSpec.get("http://localhost:8087/student/list");
        response.prettyPrint();
        ValidatableResponse validatableResponse = response.then();
        validatableResponse.statusCode(200);


        // other way to do it
        RestAssured.given()
                .when()
                .get("http://localhost:8087/student/list")
                .then()
                .statusCode(200);

        // other way to do it
        RestAssured.given()
                .expect()
                .statusCode(201)
                .when()
                .get("http://localhost:8087/student/list")
                .prettyPrint();
// RestAssured is static that is why we "import static io.restassured.RestAssured.*;" and no need to
//use RestAssured word any more
        given()
                .expect()
                .statusCode(201)
                .when()
                .get("http://localhost:8087/student/list")
                .prettyPrint();

    }

    @DisplayName("Get the single CS Student")
    @Test
    void getSingleCSStudent() {
        Response response = given()
                //    .queryParam("programme", "Computer Science") //We give parameters one by one
                //    .queryParam("limit", 2)
                //we gives multiple parameters as Key-Value pairs
                .queryParams("programme", "Computer Science", "limit", 1)
                .when()
                .get("http://localhost:8087/student/list");

        response.prettyPrint();

    }

    @DisplayName("Get the single CS Student V2")
    @Test
    void getSingleCSStudent2() {
// By using HasMap we assign parameters
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put("programme", "Computer Science");
        parameters.put("limit", 1);

        Response response = given()
                .queryParams(parameters)
                .when()
                .get("http://localhost:8087/student/list");

        response.prettyPrint();

    }

    @DisplayName("PathParameter: Get the first Student")
    @Test
    void getTheFirstStudent() {

        Response response = given()
                .when()
                .get("http://localhost:8087/student/1");
        response.prettyPrint();
    }

    @DisplayName("PathParameter: Get the first Student V2")
    @Test
    void getTheFirstStudent2() {

        Response response = given()
                .pathParam("id", 2)
                .when()
                .get("http://localhost:8087/student/{id}");

        response.prettyPrint();
    }

//    @DisplayName("PathParameter: Get the first Student V3")
//    @Test
//    void getTheFirstStudent3() {
//        HashMap<String, Object> parameters = new HashMap<>();
//        parameters.put("id", 1);
//        parameters.put("id", 3);
//        Response response = given()
//                .pathParams(parameters)
//                .when()
//                .get("http://localhost:8087/student/{id}");
//
//        response.prettyPrint();
//    }


}
