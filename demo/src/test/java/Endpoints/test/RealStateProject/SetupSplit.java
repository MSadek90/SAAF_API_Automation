package Endpoints.test.RealStateProject;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import com.example.Pojo.RealStateProject.SplitSetupRequest;
import com.example.utils.EnvironmentReader;
import com.example.utils.JsonReader;

public class SetupSplit {

        
        private final String jsonFilePath = "src/test/resources/test/TestDatat/RealStateProject/SetupSplit.json";
        private final String baseUrl = EnvironmentReader.getBaseUrl("baseurl");
        private final String bearerToken = EnvironmentReader.getBaseUrl("token");
        private final SplitSetupRequest payload = JsonReader.readJson(jsonFilePath, SplitSetupRequest.class);
        private int projectId = payload.getProjectId();
    

    public Response createSplitSetup() {
    

      
    String basePath = String.format("/dashboard/admin/projects/%d/split-setup", projectId);
        return given()
            .baseUri(baseUrl)
            .header("Accept", "application/json")
            .auth().preemptive().oauth2(bearerToken)
            .multiPart("split_type", payload.getSplitType())
            .multiPart("number_of_units", payload.getNumberOfUnits())
            .when()
            .post(basePath);
    }
}