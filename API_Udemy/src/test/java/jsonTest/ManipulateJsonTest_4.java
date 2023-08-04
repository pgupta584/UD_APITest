package jsonTest;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.apache.commons.io.FileUtils;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Random;

public class ManipulateJsonTest_4
{
    public static String updateJsonTest(String transactionAmount, String userLedgerID, String systemLedgerID) throws IOException {
        //Users/pankaj.gup/Documents/Ud/FW-Git/TestProjectU/src/main/resources/payload/modifyExample.json
        final String filePath = System.getProperty("user.dir") + "/src/main/resources/payload/modifyExample.json";
        // We would need Apache POI ,common-io & json path for readFileToString
        String payload = FileUtils.readFileToString(new File(filePath), "UTF-8");
        DocumentContext parsedDataContext = JsonPath.parse(payload);
        parsedDataContext.set("$.amount.value", transactionAmount);
        parsedDataContext.set("$.userLedgerID", userLedgerID);
        parsedDataContext.set("$.systemLedgerID", systemLedgerID);
        parsedDataContext.set("$.requestID", "AUTO_PKG" + new Random().nextInt(999999999));
        return parsedDataContext.jsonString();
    }

    @Test
    public static void testUpdateJson() throws IOException, ParseException {
        String res = updateJsonTest("1000", "1234567", "7654321");
        System.out.println(res);
    }
}
