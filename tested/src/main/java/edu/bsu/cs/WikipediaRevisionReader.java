package edu.bsu.cs;

import com.jayway.jsonpath.JsonPath;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class WikipediaRevisionReader {

    public List<Revision> getRecentRevisionsOf(String articleTitle) throws IOException {
        String encodedArticleTitle = URLEncoder.encode(articleTitle, StandardCharsets.UTF_8);
        String urlString = String.format("https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=%s&formatversion=2&rvprop=timestamp%%7Cuser&rvlimit=15", encodedArticleTitle);

        URL url = new URL(urlString);
        URLConnection connection = url.openConnection();
        connection.setRequestProperty("User-Agent", "CS222FirstProject/0.1 (aemar@bsu.edu)");
        connection.connect();

        String jsonData = readJsonAsStringFrom(connection);

        return parseRevisions(jsonData);
    }

    private String readJsonAsStringFrom(URLConnection connection) throws IOException {
        try (InputStream inputStream = connection.getInputStream()) {
            return new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
        }
    }

    private List<Revision> parseRevisions(String jsonData) {
        List<String> users = JsonPath.read(jsonData, "$..revisions[*].user");
        List<String> timestamps = JsonPath.read(jsonData, "$..revisions[*].timestamp");

        List<Revision> revisions = new ArrayList<>();
        for (int i = 0; i < users.size(); i++) {
            revisions.add(new Revision(users.get(i), timestamps.get(i)));
        }
        return revisions;
    }
}
