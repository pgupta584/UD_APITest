package jsonTest;

import pojoClass.accountRequest.pojoTest.BookTest;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;
import pojoClass.accountRequest.userRes.UserTest;
import serviceResource.ServiceResourceTest;

import java.io.File;
import java.io.IOException;

// Convert json to Pojo using below site
// https://www.jsonschema2pojo.org/
// Now create Model
public class PostApiCallWithPojo_8 extends ServiceResourceTest
{
    @Test
    public void testPostApiWithJsonBodyReq()
    {
        String baseURI = "https://reqres.in/api/users";
        UserTest thisTestModel = modelOfUserRequestTest();
        thisTestModel.setName("Pankaj G");
        thisTestModel.setJob("QAE");
        final String requestPayload = getStringOf(thisTestModel);//IllegalArgumentException
        // Converting String into Json Object
        JSONObject newPayload = new JSONObject(requestPayload);
        System.out.println("requestPayload "+requestPayload);
        System.out.println("requestPayload after converting into Json"+newPayload);
        Response response = RestAssured.given()
                .baseUri(baseURI)
                //.contentType("ContentType.JSON")
                .body(newPayload)//new JSONObject(requestPayload)
                .when()
                .post();
        System.out.println("response "+ response.asString());
    }

    @Test
    public void testPostApiWithJsonBody()
    {
        String baseURI = "https://restful-booker.herokuapp.com/booking";
        BookTest thisTestModel = modelOfBookRequest();
        thisTestModel.setFirstname("Pankaj");
        final String requestPayload = getStringOf(thisTestModel);//IllegalArgumentException
        // Converting String into Json Object
        //JSONObject newPayload = new JSONObject(requestPayload);
        System.out.println("requestPayload "+requestPayload);
        Response response = RestAssured.given()
                .baseUri(baseURI)
                .header("Content-Type","application/json")// Refer API Contract
                .body(requestPayload)//new JSONObject(requestPayload)
                .when()
                .post();
        System.out.println("Status Code "+ response.getStatusCode());
        System.out.println("response "+ response.asString());
    }

    @Test
    public void testPostApiWithUpdatingJsonBody() throws IOException {
        String baseURI = "https://reqres.in/api/users";
        // Creating a File instance and Accessing json
        File jsonPayload = new File("src/main/resources/payload/userRes.json");
        DocumentContext parsedDataContext = JsonPath.parse(jsonPayload);
        parsedDataContext.set("$.name", "Pankaj Gupta");
        parsedDataContext.set("$.job", "QAE");
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
