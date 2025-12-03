package Endpoints.test.Auth;

import com.example.Pojo.Auth.CreateClientPage;
import com.example.utils.EnvironmentReader;
import com.example.utils.JsonReader;
import io.restassured.RestAssured;
import io.restassured.response.Response;



public class CreateClient {
    
    private final String basePath = "/mobile/clients";
    private final String jsonFilePath = "src/test/resources/test/TestDatat/Auth/CreateClient.json";

    public Response createClient() {
        String baseUrl = EnvironmentReader.getBaseUrl("baseurl");
        CreateClientPage payload = JsonReader.readJson(jsonFilePath, CreateClientPage.class);
        

        return RestAssured
                .given()
                    .baseUri(baseUrl)
                    .basePath(basePath)
                    .accept("application/json")
                    .contentType("multipart/form-data")
                    .multiPart("device_id", payload.getDeviceId())
                    .multiPart("device_type", payload.getDeviceType())
                    .multiPart("os", payload.getOs())
                    .multiPart("timezone", payload.getTimezone())
                    .multiPart("fcm_token", payload.getFcmToken())
                    .multiPart("app_version", payload.getAppVersion())
                    .multiPart("os_version", payload.getOsVersion())
                .when()
                    .post()
                .then()
                    .extract()
                    .response();
    }
}
