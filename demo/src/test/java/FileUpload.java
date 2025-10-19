import java.io.File;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;



public class FileUpload {

    @Test
    void singleFileUpload(){

        File myfile= new File( System.getProperty("user.dir")+ "/src/test/java/resources/Files");
        File[] files = myfile.listFiles();
        System.out.println(files.length); 

      
        for (File file : files) {
            given()
            .multiPart("file",file)
            .contentType("multipart/form-data") 
        
       
        .when().post("")
        .then().statusCode(200).log().all()
        .body("file_name", equalTo(file.getName()));
        }

    }
}
