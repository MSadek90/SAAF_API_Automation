package TestCases.Auth.RealStateProject;

import org.testng.annotations.Test;
import Endpoints.test.RealStateProject.Extracts;
import com.example.Pojo.RealStateProject.ExtractRequest;
import com.example.utils.JsonReader;
import io.restassured.response.Response;
import java.util.List;

public class ExtractsTest {

    Extracts extractsEndpoint = new Extracts();

    @Test
    public void testCreateExtract_Valid() {
        Response response = extractsEndpoint.createExtract();
        response.then().log().all();
        response.then().assertThat().statusCode(200);
    }

    @Test
    public void testCreateExtract_FromAllCases() {
        // iterate through all entries in the JSON file and post them (logs only)
        String jsonFilePath = "src/test/resources/test/TestDatat/RealStateProject/Extracts.json";
        List<ExtractRequest> cases = JsonReader.readJsonList(jsonFilePath, ExtractRequest.class);
        for (int i = 0; i < cases.size(); i++) {
            ExtractRequest r = cases.get(i);
            Response resp = extractsEndpoint.createExtract(r);
            System.out.println("Case #" + i + " -> status: " + resp.getStatusCode());
            resp.then().log().all();
        }
    }
}
