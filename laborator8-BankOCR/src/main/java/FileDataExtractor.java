import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileDataExtractor {

    public List<List<String>> readNumbersFromFile(String fileName) {
        List<List<String>> result = new ArrayList<>();
        URL resource = getClass().getClassLoader().getResource(fileName);
        if(resource == null){
            throw new BankOcrException("File was not found!");
        }
        try {
            Scanner s = new Scanner(new FileInputStream(resource.getFile()));
            while (s.hasNext()) {
                String linia1 = s.nextLine();
                String linia2 = s.nextLine();
                String linia3 = s.nextLine();
                if (s.hasNext()) {
                    s.nextLine();
                }

                if (linia1.length() != 27) linia1 += "                           ";
                if (linia2.length() != 27) linia2 += "                           ";
                if (linia3.length() != 27) linia3 += "                           ";

                List<String> line = new ArrayList<>();
                for (int i = 0; i < 9; i++) {
                    line.add(getCifre(linia1, linia2, linia3, i));
                }
                result.add(line);
            }
            return result;
        } catch (FileNotFoundException e) {
            throw new BankOcrException("File was not found!");
        }
    }

    protected String getCifre(String linia1, String linia2, String linia3, int index) {
        int beginIndex = 3 * index;
        int endIndex = beginIndex + 3;
        if (linia1.length() < endIndex || linia2.length() < endIndex || linia3.length() < endIndex) {
            throw new BankOcrException("Invalid parameters: lungimea liniilor trebuie sa fie mai mare sau egala ...");
        }
        return linia1.substring(beginIndex, endIndex) +
                linia2.substring(beginIndex, endIndex) +
                linia3.substring(beginIndex, endIndex);
    }
}
