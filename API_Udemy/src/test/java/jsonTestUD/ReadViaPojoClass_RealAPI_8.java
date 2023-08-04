package jsonTestUD;


import io.restassured.RestAssured;
import org.testng.annotations.Test;
import pojoclasstest.UserTestUD;

public class ReadViaPojoClass_RealAPI_8
{
    @Test
    public void readResponseWithPojo()
    {
        RestAssured.baseURI = "https://reqres.in";
        UserTestUD getUser = RestAssured.given().when().get("/api/users/2").as(UserTestUD.class);
        System.out.println("Email - "+getUser.getData().getEmail());
        System.out.println("URL - "+getUser.getSupport().getUrl());
        System.out.println("Last Name - "+getUser.getData().getLastName());
        System.out.println("Text - "+getUser.getSupport().getText());

    }
}
