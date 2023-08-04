package jsonTest;

import com.google.gson.JsonObject;
import org.testng.annotations.Test;

public class CreateSampleJson_1
{
    @Test
    public void createSampleJson()
    {
        JsonObject gson = new JsonObject();
        gson.addProperty("name", "John");
        gson.addProperty("isMarried", true);
        gson.addProperty("Salary", 10000);
        gson.addProperty("Salary", 10000);
        System.out.println("JsonObject - >" + gson);
    }
}
