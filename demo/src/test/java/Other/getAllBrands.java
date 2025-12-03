package Other;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import org.testng.annotations.Test;

import static  io.restassured.RestAssured.*;
import static  org.hamcrest.Matchers.*;
import org.json.JSONObject;


public class getAllBrands {

    @Test
    public void getAllBrands(){

        Header Accept = new Header("Accept", "application/json");
        Header Accept_Language = new Header("Accept-Language", "en");
        Headers allHeaders = new Headers(Accept,Accept_Language);


     Response res = given()
        .headers(allHeaders)
        .queryParam("limit", 10)
        .pathParam("path", "brands")
    .when()
        .get("https://pawsket.neop.co/api/user/v1/{path}");


        //JsonPath extraction only

        String URL = res.jsonPath().getString("data[6].image.url");
        System.out.println("image url is:  " + URL);


        //JsonObject parsing to convert response to json and add actions on it (loops/ add / edit)

        String responseBody = res.getBody().asString(); 

        JSONObject jo = new JSONObject(responseBody);

        for(int i = 0 ;i <jo.length(); i++){
            System.out.println(jo.getJSONArray("data").getJSONObject(i).get("name"));
        }

  }

}