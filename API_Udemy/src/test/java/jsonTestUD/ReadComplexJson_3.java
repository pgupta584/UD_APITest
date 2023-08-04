package jsonTestUD;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;

// https://jsonlint.com/ - for viewing the json & verify if json is valid
public class ReadComplexJson_3 {
    @Test
    public void readBasicJsonTest() throws IOException, ParseException {
        // parsing file "JSONExample.json"
        //Users/pankaj.gup/Documents/Ud/FW-Git/TestProjectU/src/main/resources/payload/complexResponseUDTest.json
        final String filePath = System.getProperty("user.dir") + "/src/main/resources/payload/complexResponseUDTest.json";
        Object obj =
                new JSONParser().parse(new FileReader(filePath));
        // typecasting obj to JSONObject
        JSONObject jo = (JSONObject) obj;
        // getting firstName and lastName
        String requestID = (String) jo.get("requestID");
        System.out.println("requestID -->> "+requestID);
        JSONArray jsonArray = (JSONArray) jo.get("tags");
        Object firstObject = jsonArray.get(0);
        System.out.println("firstObject -->> "+firstObject.toString());
        Assert.assertTrue(firstObject.toString().contains("OPEN"),"Failed");
        // In details Fetch
        String [] strings = firstObject.toString().split("=");
        String tagStatus = null;
        for (int j = 0; j < strings.length-1; j++) {
            //System.out.println(strings[i]);
            tagStatus = strings[1];
        }
        System.out.println("tagStatus -->> "+tagStatus);
        String [] str = tagStatus.split("&");
        String finalStatus = null;
        for (int i = 0; i < str.length-1; i++) {
            //System.out.println(strings[i]);
            finalStatus = str[0];
        }
        System.out.println("finalStatus -->> "+finalStatus);
        Assert.assertTrue(finalStatus.equalsIgnoreCase("OPEN"));
    }
}