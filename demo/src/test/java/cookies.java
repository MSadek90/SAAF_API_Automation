import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;


public class cookies {

    @Test
    void testCookies(){

      Response res;
      given()

     .when()
        .get("https://www.google.com/")
        
        .then()
        .log().body();


       Map<String,String> Cookies_ = res.getCookies();
       Cookies_.forEach((key,value) -> System.out.println("each cookie:: " + key + value ));
       


       Cookies allCookies = res.detailedCookies();
       
       for (Cookie cookie : allCookies) {
        System.out.println("each cookie is: " + cookie.getName());



        Headers headers = res.getHeaders();
        for (Header headers2 : headers) {
            System.out.println("Header: " + headers2);
        }

        
       }
        

       

    }


