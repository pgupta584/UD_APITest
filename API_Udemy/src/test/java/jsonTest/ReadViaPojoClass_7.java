package jsonTest;


import pojoClass.accountRequest.reqres2.GetUser;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.path.json.JsonPath.given;
//https://www.toolsqa.com/rest-assured/rest-api-test-using-rest-assured/

public class ReadViaPojoClass_7
{
    @Test // Working -- Reading Json & putting assertion
    public void readResponseWithoutPojoTest(){
        RestAssured.baseURI = "https://reqres.in/api/users/2";
        Response response = RestAssured.given().when().get();
        System.out.println("Response -"+ response.asString());

        ResponseBody body = response.getBody();
        String bodyObject = body.asString();
        System.out.println("Response Body - "+bodyObject);
        // Verify if Json Body contains a String key if you don't know expected value - Verification type -1
        Assert.assertEquals(bodyObject.contains("data"),true,"Response doesn't contains Data");

        // Getting the Value and then verifying with actual value - Verification type -2
        JsonPath jsonPath = response.jsonPath();
        HashMap dataObject = jsonPath.getJsonObject("data"); // this object returning Hashmap so holding with Hashmap
        System.out.println("dataObject-"+dataObject);
        Object email = dataObject.get("email");
        System.out.println("email- "+email.toString());
        dataObject = jsonPath.getJsonObject("support");
        System.out.println("Url- "+dataObject.get("url"));
    }

    @Test
    public void testhttp()
    {
        //-=========Without Pojo ======== Working - hence commented
//        // Specify the base URL to the RESTful web service
//        RestAssured.baseURI = "https://reqres.in/api/users/2";
//        // Get the RequestSpecification of the request to be sent to the server.
//        RequestSpecification httpRequest = RestAssured.given();
//        // specify the method type (GET) and the parameters if any.
//        //In this case the request does not take any parameters
//        Response response = httpRequest.request(Method.GET, "");
//        // Print the status and message body of the response received from the server
//        System.out.println("Status received => " + response.getStatusLine());
//        System.out.println("Response=>" + response.prettyPrint());

        //-=========With Pojo ========
        RestAssured.baseURI = "https://reqres.in/api/users/2";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET, "");
        System.out.println("Status received => " + response.getStatusLine());
        System.out.println("Response=>" + response.prettyPrint());

    }

    @Test
    public void readResponseWithPojo()
    {
        RestAssured.baseURI = "https://reqres.in/api/users/2";
        GetUser getUser = RestAssured.given().when().get().as(GetUser.class);
        System.out.println("Email - "+getUser.getData().getEmail());
        System.out.println("URL - "+getUser.getSupport().getUrl());
    }
    @Test()
    public void getRequest() {
        RestAssured.given().when().get("http://dummy.restapiexample.com/api/v1/employee").
            then().assertThat().statusCode(200);
        System.out.println("PASS");
    }
}
