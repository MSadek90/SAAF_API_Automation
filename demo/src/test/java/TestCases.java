import io.restassured.http.Header;
import io.restassured.http.Headers;

import org.testng.Assert;
import org.testng.annotations.Test;
import static  io.restassured.RestAssured.*;

import java.io.IOException;

import com.example.Pojo.*;
import com.example.utils.EnvironmentReader;
import com.example.utils.JsonReader;






public class TestCases {
    

    private final String Base_Url = EnvironmentReader.getBaseUrl("dev");
    int id = -9999;

    private Headers getHeaders(){
        Header Accept = new Header("Accept", "application/json");
        return new Headers(Accept);
    }


    private RegisterRequest getuserData() throws IOException{
        RegisterRequest [] registerRequest = JsonReader.readUsers();
        return registerRequest[0];
    }



    private int registerRequest(Headers headers, RegisterRequest registerRequest){
         
        
             return given()
                .headers(headers)
                .body(registerRequest)
             .when()
                 .post(Base_Url+"/register")

              .then()
                 .statusCode(200)
                 .extract()   
                 .jsonPath()
                 .getInt("id");   

    }

    @Test
    public void Login(){

        
         try {
            Headers headers = getHeaders();
            RegisterRequest user = getuserData();
            id = registerRequest(headers, user);

            System.out.println("User registered successfully with ID: " + id);
            Assert.assertTrue(id > 0, "User ID should be greater than 0");

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Registration test failed: " + e.getMessage());
        }
    }   
    
}
