package serviceResource;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import pojoClass.accountRequest.pojoTest.BookTest;
import pojoClass.accountRequest.userRes.UserTest;
import pojoclasstest.requestBody.PostBooking;

import java.io.File;
import java.io.IOException;

public class ServiceResourceTest {
    public BookTest modelOfBookRequest() {
        return (BookTest)this.mapObject(BookTest.class, ServicePayloads.BOOK_REQUEST.asFile());
    }

    public UserTest modelOfUserRequestTest() {
        return (UserTest)this.mapObject(UserTest.class, ServicePayloads.USER_REQUEST_TEST.asFile());
    }

    public PostBooking modelOfPostBookingRequest() {
        return (PostBooking)this.mapObject(PostBooking.class, ServicePayloads.BOOKING_REQUEST_TEST.asFile());
    }

    public static String getStringOf(Object aClazz) {
        try {
            return (new ObjectMapper()).writeValueAsString(aClazz);
        } catch (JsonProcessingException var3) {
            return "";
        }
    }
    private Object mapObject(Class<?> aClazz, File filePath) {
        Object aMappedClass = null;
        ObjectMapper objMapper = new ObjectMapper();

        try {
            aMappedClass = objMapper.readValue(filePath, aClazz);
        } catch (IOException var6) {
            var6.printStackTrace();
            System.out.println(var6);
        }
        return aMappedClass;
    }
}
