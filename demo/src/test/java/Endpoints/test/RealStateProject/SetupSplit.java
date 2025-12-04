package Endpoints.test.RealStateProject;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import com.example.Pojo.RealStateProject.SplitSetupRequest;
import com.example.utils.EnvironmentReader;
import com.example.utils.JsonReader;
import java.util.List;

public class SetupSplit {

        
        private final String jsonFilePath = "src/test/resources/test/TestDatat/RealStateProject/SetupSplit.json";
        private final String baseUrl = EnvironmentReader.getBaseUrl("baseurl");
        private final String bearerToken = EnvironmentReader.getBaseUrl("token");
        private final List<SplitSetupRequest> payload = JsonReader.readJsonList(jsonFilePath, SplitSetupRequest.class);
        private int projectId = payload.isEmpty() ? 0 : payload.get(0).getProjectId();
    

    public Response createSplitSetup() {
    

      
    String basePath = String.format("/dashboard/admin/projects/%d/split-setup", projectId);
        return given()
            .baseUri(baseUrl)
            .header("Accept", "application/json")
            .auth().preemptive().oauth2(bearerToken)
            .multiPart("split_type", payload.get(0).getSplitType())
            .multiPart("number_of_units", payload.get(0).getNumberOfUnits())
            .when()
            .post(basePath);
    }

    /**
     * Create split setup using a specific SplitSetupRequest instance.
     */
    public Response createSplitSetup(SplitSetupRequest request) {
        String basePath = String.format("/dashboard/admin/projects/%d/split-setup", request.getProjectId());
        return given()
                .baseUri(baseUrl)
                .header("Accept", "application/json")
                .auth().preemptive().oauth2(bearerToken)
                .multiPart("split_type", request.getSplitType())
                .multiPart("number_of_units", request.getNumberOfUnits())
                .when()
                .post(basePath);
    }
}