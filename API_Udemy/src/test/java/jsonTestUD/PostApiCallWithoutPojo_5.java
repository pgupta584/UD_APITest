package jsonTestUD;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class PostApiCallWithoutPojo_5
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
        // File jsonPayload = new File("src/main/resources/payload/userRes.json");
        Response response = RestAssured.given()
                .baseUri(baseURI)
                .contentType("ContentType.JSON")
                .body(payload)
                .when()
                .post();
        System.out.println("response "+ response.asString());
    }
}

// Part - II Below
// We should not hard code payload in the test script
// We should always fetch it from json file and do all the action
