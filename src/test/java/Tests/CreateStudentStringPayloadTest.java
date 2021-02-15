package Tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class CreateStudentStringPayloadTest extends Testbase {

    @DisplayName("Creat a student by sending string payload")
    @Test
    public void createNewStudent() {
        String payload = " {" +
                "        \"firstName\": \"Zeki\",\n" +
                "        \"lastName\": \"Gul\",\n" +
                "        \"email\": \"deneme5@gmail.com\",\n" +
                "        \"programme\": \"ComputerScience\",\n" +
                "        \"courses\": [\n" +
                "            \"C++\",\n" +
                "            \"Linear Algebra\",\n" +
                "            \"calculus\"\n" +
                "        ]\n" +
                "    }";

        String str = given()
                .when()
                .contentType(ContentType.JSON)
                .body(payload)
                .post()
                .then()
                .statusCode(201).log().all().toString();

        System.out.println(str);
    }
}
