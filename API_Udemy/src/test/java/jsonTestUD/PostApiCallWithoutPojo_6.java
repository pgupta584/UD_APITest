package jsonTestUD;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojoclasstest.requestBody.GetUserDetails;

import java.io.IOException;

public class PostApiCallWithoutPojo_6
{
    @Test
    public void testPostApiWithUpdatingJsonBody() throws IOException {
        String baseURI = "https://reqres.in/api";
        // Creating a File instance and Accessing json
//        File jsonPayload = new File("src/main/resources/payload/userRes.json");
//        DocumentContext parsedDataContext = JsonPath.parse(jsonPayload);
//        parsedDataContext.set("$.name", "Pankaj Gupta");
//        parsedDataContext.set("$.job", "SDET");
        GetUserDetails getUser = new GetUserDetails();
        getUser.setName("Pankaj G");
        getUser.setJob("SDET");
        System.out.println("request Body "+ getUser);
        final String requestPayload = getStringOf(getUser);
        System.out.println("requestPayload "+requestPayload);
        Response response = RestAssured.given()
                .baseUri(baseURI)
                .contentType("application/json")
                .body(getUser)
                .when()
                .post("/users");
        System.out.println("response "+ response.asString());
        assert response.getStatusCode()==201;
    }

    public static String getStringOf(Object aClazz) {
        try {
            return (new ObjectMapper()).writeValueAsString(aClazz);
        } catch (JsonProcessingException var3) {
            return "";
        }
    }
}
