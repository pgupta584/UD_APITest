package SamplePojoTest.reqPayload;

import com.google.gson.Gson;
import pojoClass.accountRequest.userRes.UserTest;

public class RequestPayload {

    static Gson gson = new Gson();
    public static String createUserTest()
    {
        UserTest userTest = new UserTest();
        userTest.setName("Pankaj G");
        userTest.setJob("QAE");
        return gson.toJson(userTest);
    }
    public static String createUserCustomTest(String Name, String Job)
    {
        UserTest userTest = new UserTest();
        userTest.setName(Name);
        userTest.setJob(Job);
        return gson.toJson(userTest);
    }
}
