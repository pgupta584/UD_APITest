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

public class ReadAttribute
{
    static int totalCash= 0;
    static int totalRetail=0;
    static int totalAnnual=0;
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
        HashMap<String, Integer> allCategoryBalance = new HashMap<>();
        for (int i = 0; i < content.size(); i++) {
            JSONObject contentIterator = (JSONObject) content.get(i);
            JSONObject attribute = (JSONObject) contentIterator.get("attributes");
            long balance = (long) contentIterator.get("value");
            System.out.println("Balance is " + balance);
            JSONArray postingType = (JSONArray) attribute.get("postingCategories");
            System.out.println("Posting type - " + postingType);
            String postingCat = (String) postingType.get(0);
            System.out.println("Posting Category is - " + postingCat);
            String couponState = (String) contentIterator.get("state");
            System.out.println("Coupon State is " + couponState);

            if(couponState.equalsIgnoreCase("ACTIVE")) {
                if (postingCat.contains("Cash")) {
                    totalCash = (int) (totalCash + balance);
                    allCategoryBalance.put("Cash", (int) (totalCash));
                } else if (postingCat.contains("Retail")) {
                    totalRetail = (int) (totalRetail + balance);
                    allCategoryBalance.put("Retail", (int) (totalRetail));
                } else if (postingCat.contains("Annual")) {
                    totalAnnual = (int) (totalAnnual + balance);
                    allCategoryBalance.put("totalAnnual", (int) (totalAnnual));
                }
            }
            else{
                System.out.println("No Active Coupon Found");
            }
        }
        for (Map.Entry<String, Integer> entry : allCategoryBalance.entrySet()){
            System.out.println("Category = " + entry.getKey() +
                    ", Balance = " + entry.getValue());
            }
        // Calculating balance in Each Category
//        int totalRetail = 0;
//        for (Map.Entry<String, Integer> entry : retail.entrySet()){
//            totalRetail = totalRetail+ entry.getValue();
//        }

    }
}
