package edu.bsu.cs;


import com.jayway.jsonpath.JsonPath;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Scanner;

public class WikipediaRevisionReader {
    public static void main(String[] args) {
        WikipediaRevisionReader revisionReader = new WikipediaRevisionReader();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter article title: ");
        String line = scanner.nextLine();
        try {
            // Retrieve and print recent revisions of the article
            revisionReader.getRecentRevisionsOf(line);
        } catch (IOException ioException) {
            System.err.println("Network connection problem: " + ioException.getMessage());
        }
    }

    public void getRecentRevisionsOf(String articleTitle) throws IOException {
        // Only gets the Article Title
        String encodedArticleTitle = URLEncoder.encode(articleTitle, StandardCharsets.UTF_8);

        // Format the URL with the encoded article title
        String urlString = String.format("https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=%s&formatversion=2&rvprop=timestamp%%7Cuser&rvlimit=15", encodedArticleTitle);

        try {
            // Create a URL object from the string
            URL url = new URL(urlString);

            // Open a connection to the URL
            URLConnection connection = url.openConnection();
            connection.setRequestProperty("User-Agent", "CS222FirstProject/0.1 (aemar@bsu.edu)");
            connection.connect();

            // Read JSON data from the connection
            String jsonData = readJsonAsStringFrom(connection);

            // Print the recent users and timestamps
            printRecentUsersAndTimestamps(jsonData);

        } catch (IOException e) {
            throw new IOException("Failed to retrieve revisions: " + e.getMessage());
        }
    }

    private static String readJsonAsStringFrom(URLConnection connection) throws IOException {
        try (InputStream inputStream = connection.getInputStream()) {
            return new String(inputStream.readAllBytes(), Charset.defaultCharset());
        }
    }

    private static void printRecentUsersAndTimestamps(String jsonData) {
        // Use JsonPath to extract the users and timestamps from the JSON response
        List<String> users = JsonPath.read(jsonData, "$..revisions[*].user");
        List<String> timestamps = JsonPath.read(jsonData, "$..revisions[*].timestamp");

        // Print the users and timestamps
        for (int i = 0; i < users.size(); i++) {
            System.out.println("User: " + users.get(i) + ", Timestamp: " + timestamps.get(i));
        }
    }
}
