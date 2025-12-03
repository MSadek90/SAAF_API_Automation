package TestCases.Auth.RealStateProject;


import org.testng.annotations.Test;

import Endpoints.test.RealStateProject.SetupSplit;
import io.restassured.response.Response;


public class SetupSplitTest {


    SetupSplit createSplitSetupEndpoint = new SetupSplit();


    @Test
    void testCreateSplitSetup() {
        Response response = createSplitSetupEndpoint.createSplitSetup();
        response.then().log().all();
        response.then().assertThat().statusCode(200);
    }
    
}
    

