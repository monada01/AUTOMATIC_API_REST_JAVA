package utils;

import io.restassured.path.json.JsonPath;
import net.minidev.json.JSONObject;

import java.io.InputStream;
import java.io.IOException;
import java.io.FileInputStream;

public class JsonRequestBodyHelper {
    public static JSONObject getJsonFromFile(String jsonFileName, String testDateKey){
        JSONObject bodyRequest = new JSONObject();
        try {
            InputStream is = new FileInputStream("src/test/resources/testData" + jsonFileName + ".json");
            JsonPath jsonPath = JsonPath.from(is);
            bodyRequest.putAll(jsonPath.get(testDateKey));
        } catch (IOException e) {
            System.out.println("File not found" + e);
        }
          return bodyRequest;
        }
    }

