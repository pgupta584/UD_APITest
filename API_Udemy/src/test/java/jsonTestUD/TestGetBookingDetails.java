package jsonTestUD;//package jsonTestUD;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import io.restassured.RestAssured;
//import io.restassured.response.Response;
//import org.json.JSONObject;
//import org.testng.annotations.Test;
//import pojoClass.accountRequest.pojoTest.BookTest;
//import pojoClass.accountRequest.userRes.UserTest;
//import pojoclasstest.requestBody.Bookingdates;
//import pojoclasstest.requestBody.PostBooking;
//import serviceResource.ServiceResourceTest;
//
//public class TestGetBookingDetails extends ServiceResourceTest
//{
//    @Test
//    void testBookingDetails()
//    {
//        String baseURI = "https://restful-booker.herokuapp.com";
//        BookTest thisTestModel = modelOfBookRequest();
//        thisTestModel.setAdditionalneeds("Dinner");
//        thisTestModel.getBookingdates().setCheckout("2022-01-01");
//        final String requestPayload = getStringOf(thisTestModel);//IllegalArgumentException
//        // Converting String into Json Object
//        JSONObject newPayload = new JSONObject(requestPayload);
//        System.out.println("postBooking "+newPayload);
//        Response response = RestAssured.given()
//                .baseUri(baseURI)
//                .contentType("application/json")
//                .body(thisTestModel)//new JSONObject(requestPayload)
//                .when()
//                .post("/booking");
//        System.out.println("Response ->"+ response.asString());
//    }
//
//    public static String getStringOf(Object aClazz) {
//        try {
//            return (new ObjectMapper()).writeValueAsString(aClazz);
//        } catch (JsonProcessingException var3) {
//            return "";
//        }
//    }
//}
