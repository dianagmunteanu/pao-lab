import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class FileDataExtractorTest {

    @Test(expected = BankOcrException.class)
    public void testFileReadFileNotFound(){
        FileDataExtractor fileDataExtractor = new FileDataExtractor();
        fileDataExtractor.readNumbersFromFile("not a file");
    }

    @Test
    public void testExtractedElements(){
        FileDataExtractor fileDataExtractor = new FileDataExtractor();
        List<List<String>> result = fileDataExtractor.readNumbersFromFile("testibans1.txt");

        List<String> expected = Arrays.asList(" _ | ||_|"," _ | ||_|"," _ | ||_|"," _ | ||_|"," _ | ||_|"," _ | ||_|"," _ | ||_|"," _ | ||_|"," _ | ||_|");
        assertArrayEquals(expected.toArray(), (result.get(0)).toArray());
    }


    @Test
    public void testExtractCifre() {
        String linia1 = "012345678";
        String linia2 = "012345678";
        String linia3 = "012345678";

        FileDataExtractor fileDataExtractor = new FileDataExtractor();
        assertEquals("012012012", fileDataExtractor.getCifre(linia1, linia2, linia3, 0));
        assertEquals("678678678", fileDataExtractor.getCifre(linia1, linia2, linia3, 2));
        try {
            fileDataExtractor.getCifre(linia1, linia2, linia3, 4);
        } catch (RuntimeException e) {
            assertEquals("Invalid parameters: lungimea liniilor trebuie sa fie mai mare sau egala ...", e.getMessage());
        }
    }

    @Test(expected = BankOcrException.class)
    public void testExtractCifreInvalidParameter() {
        String linia1 = "012345678";
        String linia2 = "012345678";
        String linia3 = "012345678";

        FileDataExtractor fileDataExtractor = new FileDataExtractor();
        fileDataExtractor.getCifre(linia1, linia2, linia3, 5);
    }
}
