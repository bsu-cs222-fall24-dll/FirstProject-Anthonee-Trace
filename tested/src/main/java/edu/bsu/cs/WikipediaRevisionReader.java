package edu.bsu.cs;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class WikipediaRevisionReader {
    public static void main(String[] args) {


        WikipediaRevisionReader revisionReader = new WikipediaRevisionReader();
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        try {
            String user = revisionReader.getLatestRevisionOf(line);
            System.out.println(user);
        } catch (IOException ioException) {
            System.err.println("Network connection problem: " + ioException.getMessage());

        }
    }

    public String getLatestRevisionOf(String articleTitle) throws IOException {
        // Encode only the article title, not the entire URL
        String encodedArticleTitle = URLEncoder.encode(articleTitle, StandardCharsets.UTF_8.toString());

        // Correctly format the URL with the encoded article title
        String urlString = String.format("https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=%s&formatversion=2&rvprop=timestamp%%7Cuser&rvlimit=15", encodedArticleTitle);
        try {
            // Create a URL object from the string
            URL url = new URL(urlString);

            // Open a connection to the URL
            URLConnection connection = url.openConnection();
            connection.setRequestProperty("User-Agent",
                    "CS222FirstProject/0.1 (aemar@bsu.edu)");

            // Get input stream from the connection
            InputStream inputStream = connection.getInputStream();
            WikipediaRevisionParser parser = new WikipediaRevisionParser();
            String user = parser.parse(inputStream);
            return user;
        } catch (MalformedURLException malformedURLException) {
            throw new RuntimeException(malformedURLException);
        }


    }
}




