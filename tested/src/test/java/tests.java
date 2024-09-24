import edu.bsu.cs.WikipediaRevisionParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class tests {
    @Test
    public void testFirstAuthor() throws IOException {
        WikipediaRevisionParser parser = new WikipediaRevisionParser();
        // Reads "test.JSON" text file
        InputStream testDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.JSON");
        String FirstAuthor = parser.parse(testDataStream);
        Assertions.assertEquals("2A00:23C5:E212:D01:4523:A371:376:EB17", FirstAuthor);
    }


}
