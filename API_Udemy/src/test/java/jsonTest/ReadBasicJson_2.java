package jsonTest;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;

public class ReadBasicJson_2 {
    @Test
    public void readBasicJsonTest() throws IOException, ParseException {
        // parsing file "JSONExample.json"
        ///Users/pankaj.gup/Documents/Ud/FW-Git/TestProjectU/src/main/resources/payload/basicResponse.json
        final String filePath = System.getProperty("user.dir") + "/src/main/resources/payload/basicResponse.json";
        Object obj =
                new JSONParser().parse(new FileReader(filePath));
        // typecasting obj to JSONObject
        JSONObject jo = (JSONObject) obj;
        // getting firstName and lastName
        String firstName = (String) jo.get("First_Name");
        String lastName = (String) jo.get("Last_Name");
        System.out.println(firstName);
        System.out.println(lastName);
    }
}
