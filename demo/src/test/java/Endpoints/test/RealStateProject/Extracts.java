package Endpoints.test.RealStateProject;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import com.example.Pojo.RealStateProject.ExtractRequest;
import com.example.utils.EnvironmentReader;
import com.example.utils.JsonReader;
import java.util.List;

public class Extracts {

    private final String jsonFilePath = "src/test/resources/test/TestDatat/RealStateProject/Extracts.json";
    private final String baseUrl = EnvironmentReader.getBaseUrl("baseurl");
    private final String bearerToken = EnvironmentReader.getBaseUrl("token");
    private final List<ExtractRequest> payload = JsonReader.readJsonList(jsonFilePath, ExtractRequest.class);

    public Response createExtract() {
        if (payload.isEmpty()) {
            throw new IllegalStateException("No payload found in " + jsonFilePath);
        }
        ExtractRequest req = payload.get(0);
        String basePath = String.format("/api/v1/dashboard/admin/unites/%d/extracts", req.getUnitId());

        io.restassured.specification.RequestSpecification spec = given()
            .baseUri(baseUrl)
            .header("Accept", "application/json")
            .auth().preemptive().oauth2(bearerToken)
            .multiPart("real_state_project_id", req.getRealStateProjectId())
            .multiPart("developer_id", req.getDeveloperId())
            .multiPart("invoice_amount", req.getInvoiceAmount())
            .multiPart("description", req.getDescription())
            .multiPart("extract_date", req.getExtractDate())
            .multiPart("pay_type", req.getPayType());

        if (req.getAttachments() != null) {
            for (Integer a : req.getAttachments()) {
                spec.multiPart("attachments[]", a);
            }
        }

        return spec.when().post(basePath);
    }

    public Response createExtract(ExtractRequest request) {
        String basePath = String.format("/api/v1/dashboard/admin/unites/%d/extracts", request.getUnitId());

        io.restassured.specification.RequestSpecification spec = given()
            .baseUri(baseUrl)
            .header("Accept", "application/json")
            .auth().preemptive().oauth2(bearerToken)
            .multiPart("real_state_project_id", request.getRealStateProjectId())
            .multiPart("developer_id", request.getDeveloperId())
            .multiPart("invoice_amount", request.getInvoiceAmount())
            .multiPart("description", request.getDescription())
            .multiPart("extract_date", request.getExtractDate())
            .multiPart("pay_type", request.getPayType());

        if (request.getAttachments() != null) {
            for (Integer a : request.getAttachments()) {
                spec.multiPart("attachments[]", a);
            }
        }

        return spec.when().post(basePath);
    }
}
