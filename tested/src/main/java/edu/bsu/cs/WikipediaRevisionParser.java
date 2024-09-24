package edu.bsu.cs;


import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class WikipediaRevisionParser {
    public String parse(InputStream testDataStream) throws IOException {
        JSONArray result= (JSONArray) JsonPath.read(testDataStream,"$..user");
        return result.get(0).toString();
    }
}
