package Tests;

import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import model.StudentPojo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class CreateStudentPojoPayloadTest2 extends Testbase {

    @DisplayName("Creat a student by sending string payload")
    @Test
    public void createNewStudent() {
        StudentPojo studentPojo = new StudentPojo();
        Faker faker = new Faker();

        studentPojo.setFirstName(faker.name().firstName());
        studentPojo.setLastName(faker.name().lastName());
        studentPojo.setEmail(faker.internet().emailAddress());
        studentPojo.setProgramme("Computer Science");

        List<String> courses = new ArrayList<>();
        courses.add("Tarih");
        courses.add("edebiyat");
        courses.add("Kimya");
        courses.add("Fizik");
        studentPojo.setCourses(courses);

        String str = given()
                .when()
                .contentType(ContentType.JSON)
                .body(studentPojo)
                .post()
                .then()
                .statusCode(201).log().all().toString();
//Deneme 2 tt6t6t6t
        //uyuy 989898
        
        System.out.println(str);
    }
}
