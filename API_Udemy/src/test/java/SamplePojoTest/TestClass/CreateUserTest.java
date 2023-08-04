package SamplePojoTest.TestClass;

import SamplePojoTest.reqPayload.RequestPayload;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class CreateUserTest
{
    @Test
    public void testPostApiWithJsonBodyReq()
    {
        String baseURI = "https://reqres.in/api/users";
        System.out.println("requestPayload after converting into Json"+ RequestPayload.createUserTest());
        Response response = RestAssured.given()
                .baseUri(baseURI)
                .body(RequestPayload.createUserTest())
                .when()
                .post();
        System.out.println("response "+ response.asString());
    }
}
