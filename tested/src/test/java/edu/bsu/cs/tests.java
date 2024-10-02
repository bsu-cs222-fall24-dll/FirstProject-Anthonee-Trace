package edu.bsu.cs;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class tests {
    @Test
    public void testFirstAuthor() throws IOException {
        WikipediaRevisionParser parser = new WikipediaRevisionParser();
        // Reads "test.JSON" text file
        InputStream testDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.JSON");
        String FirstAuthor = parser.parse(testDataStream);
        assertEquals("2A00:23C5:E212:D01:4523:A371:376:EB17", FirstAuthor);
    }
    @Test
    public void testNonExistentArticle() throws IOException {
        WikipediaRevisionReader reader = new WikipediaRevisionReader();
        List<Revision> revisions = reader.getRecentRevisionsOf("NonExistentArticleXYZ123");

        assertTrue(revisions.isEmpty(), "Revisions should be empty for a non-existent article");
    }




}



