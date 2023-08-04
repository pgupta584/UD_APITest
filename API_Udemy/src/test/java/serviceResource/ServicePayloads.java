package serviceResource;

import org.apache.commons.io.FileUtils;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;

public enum ServicePayloads
{

    BOOK_REQUEST("booktest.json"),
    USER_REQUEST_TEST("userRes.json"),
    BOOKING_REQUEST_TEST("BookHotel.json");
    private JSONObject payloadContent = new JSONObject();
    private String payloadFile;

    private ServicePayloads(String json) {
        String jsonContent = "";

        try {
            this.payloadFile = String.format("%s/%s/%s", System.getProperty("user.dir"), "src/test/testpayload/", json);
            jsonContent = FileUtils.readFileToString(new File(this.payloadFile));
            if (!jsonContent.isEmpty()) {
                this.payloadContent = new JSONObject(jsonContent);
            }
        } catch (IOException var6) {
        }

    }

    public File asFile() {
        return new File(this.payloadFile);
    }

    public JSONObject asJSON() {
        return this.payloadContent;
    }

    public String asString() {
        return this.payloadContent.toString();
    }
}
