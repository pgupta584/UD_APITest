package jsonTest;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class PostApiCallWithoutPojo_6
{
    @Test
    public void testPostApiWithJsonBody()
    {
        String baseURI = "https://reqres.in/api/users";
        // Direct Hard Coding the payload - Not good practice
        String payload = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}";
        System.out.println("payload "+ payload);
        // Creating a File instance and Accessing json
        File jsonPayload = new File("src/main/resources/payload/userRes.json");
        Response response = RestAssured.given()
                .baseUri(baseURI)
                .contentType("ContentType.JSON")
                .body(jsonPayload)
                .when()
                .post();
        System.out.println("response "+ response.asString());
    }
// Part - II Below








    // We should not hard code payload in the test script
    // We should always fetch it from json file and do all the action



    @Test
    public void testPostApiWithUpdatingJsonBody() throws IOException {
        String baseURI = "https://reqres.in/api/users";
        // Creating a File instance and Accessing json
        File jsonPayload = new File("src/main/resources/payload/userRes.json");
        DocumentContext parsedDataContext = JsonPath.parse(jsonPayload);
        parsedDataContext.set("$.name", "Pankaj Gupta");
        parsedDataContext.set("$.job", "SDET");
        System.out.println("request Body "+ parsedDataContext.json());
        Response response = RestAssured.given()
                .baseUri(baseURI)
                .contentType("ContentType.JSON")
                .body(jsonPayload)
                .when()
                .post();
        System.out.println("response "+ response.asString());
    }
}
