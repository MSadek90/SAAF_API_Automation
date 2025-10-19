import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class SchemaValidator {

    @Test
    void SchemaValidator(){
         

          Header Accept = new Header("Accept", "application/json");
        Header Accept_Language = new Header("Accept-Language", "en");
        Headers allHeaders = new Headers(Accept,Accept_Language);


        System.out.println(getClass().getClassLoader().getResource("Files/Schema.json"));

 


     given()
        .headers(allHeaders)
        .queryParam("limit", 10)
        .pathParam("path", "brands")
    .when()
        .get("https://pawsket.neop.co/api/user/v1/{path}")

    .then()
    .assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("Files/Schema.json"));


    
    }
}
