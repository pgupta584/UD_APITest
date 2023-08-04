package jsonTest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReadHeavyResponse
{
    @Test
    public static void readyHeavyResponse() throws IOException, ParseException {
        // parsing file "JSONExample.json"
        Object obj =
                new JSONParser().parse(new FileReader("/Users/pankaj.gup/Documents/Ud/FW-Git/TestProjectU/src/main/resources/payload/heavyResponse.json"));
        // typecasting obj to JSONObject
        JSONObject jo = (JSONObject) obj;
        System.out.println("Complete Json payload - " + jo);

        // Read Posting Category from response payload and get the Posting Category & Balance mapping
        JSONArray content = (JSONArray) jo.get("content");
        System.out.println("Complete Content - " + content);
        System.out.println("Content Size - " + content.size());
        //Content is a JSONArray - so we can iterate all index
        // Posting Category & Balance mapping
        HashMap<String, Integer> retail = new HashMap<>();
        HashMap<String, Integer> cash = new HashMap<>();
        HashMap<String, Integer> annual = new HashMap<>();
        HashMap<String, Integer> other = new HashMap<>();
        for (int i = 0; i < content.size(); i++) {
            JSONObject contentIterator = (JSONObject) content.get(i);
            System.out.println("Content at index " + i + " " + contentIterator);
            JSONObject attribute = (JSONObject) contentIterator.get("attributes");
            System.out.println("attribute is " + attribute);
            long balance = (long) contentIterator.get("value");
            System.out.println("Balance is " + balance);
            JSONArray postingType = (JSONArray) attribute.get("postingCategories");
            System.out.println("Posting type - " + postingType);
            String postingCat = (String) postingType.get(0);
            System.out.println("Posting Category is - " + postingCat);
            if (postingCat.contains("Cash")) {
                cash.put(postingCat, (int) balance);
            } else if (postingCat.contains("Retail")) {
                retail.put(postingCat, (int) balance);
            } else if (postingCat.contains("Annual")) {
                annual.put(postingCat, (int) balance);
            } else {
                other.put(postingCat, (int) balance);
            }
        }
        System.out.println("Cash Balance is " + cash);
        System.out.println("Retail Balance is " + retail);
        System.out.println("Annual Balance is " + annual);
        System.out.println("Annual Balance is " + other);
        // Calculating balance in Each Category
        int totalRetail = 0;
        for (Map.Entry<String, Integer> entry : retail.entrySet()){
                totalRetail = totalRetail+ entry.getValue();
        }
        System.out.println("Total retail Balance is " + totalRetail);
        int totalCash = 0;
        for (Map.Entry<String, Integer> entry : cash.entrySet()){
            totalCash = totalCash+ entry.getValue();
        }
        System.out.println("Total Cash Balance is " + totalCash);
        int totalAnnual = 0;
        for (Map.Entry<String, Integer> entry : annual.entrySet()){
            totalAnnual = totalAnnual+ entry.getValue();
        }
        System.out.println("Total Annual Balance is " + totalAnnual);



//Category & Balance is {RetailPrincipalUnbilled=100, AnnualFeeUnbilled=100000, RetailUnbilled=9000, CashUnbilled=1000}
        // Read Posting Category from response payload and get the Posting Category and Coupon mapping

    }
}
