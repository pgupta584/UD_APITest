package jsonTestUD;

import io.restassured.RestAssured;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojoclasstest.requestBody.PostBooking;
import pojoclasstest.responseBody.GetBookingDetails;
import serviceResource.ServiceResourceTest;

public class HotelBookingTest extends ServiceResourceTest
{
    @Test
    void bookHotelTest()
    {
        String baseURI = "https://restful-booker.herokuapp.com";
        PostBooking thisTestModel = modelOfPostBookingRequest();
        thisTestModel.setAdditionalneeds("Dinner");
        thisTestModel.getBookingdates().setCheckout("2022-01-05");
        final String requestPayload = getStringOf(thisTestModel);//IllegalArgumentException
        // Converting String into Json Object
        JSONObject newPayload = new JSONObject(requestPayload);
        System.out.println("requestPayload "+newPayload);
        GetBookingDetails response = RestAssured.given()
                .baseUri(baseURI)
                .contentType("application/json")
                .body(thisTestModel)//new JSONObject(requestPayload)
                .when()
                .post("/booking").as(GetBookingDetails.class);
        System.out.println("Needs "+ response.getBooking().getAdditionalneeds());
        System.out.println("Checkout Date "+ response.getBooking().getBookingdates().getCheckout());
        Assert.assertEquals(thisTestModel.getBookingdates().getCheckout(),response.getBooking().getBookingdates().getCheckout());
        Assert.assertEquals(thisTestModel.getAdditionalneeds(),response.getBooking().getAdditionalneeds());
    }
}
