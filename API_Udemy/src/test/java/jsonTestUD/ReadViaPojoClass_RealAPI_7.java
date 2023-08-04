package jsonTestUD;


import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

public class ReadViaPojoClass_RealAPI_7
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
}
