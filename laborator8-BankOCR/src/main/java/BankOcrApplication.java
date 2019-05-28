import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BankOcrApplication {


    public static void main(String[] args) throws IOException {

        BankOcrApplication bankApplication = new BankOcrApplication();
        bankApplication.run();
    }

    private void run() {
        FileDataExtractor fileDataExtractor = new FileDataExtractor();
        DataValidator validator = new DataValidator();
        File rezultat = new File("rezultat.txt");

        List<List<String>> resultList = fileDataExtractor.readNumbersFromFile("ibans2.txt");

        List<String> numberString = new ArrayList<>();
        for (List<String> numberLine : resultList) {
            numberString.add(numberLine.stream()
                    .map(string -> validator.getCifreFromString(string))
                    .collect(Collectors.joining()));
        }
        Map<String, NumberCode> result = validator.verifyNumber(numberString);
        result.entrySet().forEach(entry -> System.out.println(entry.getKey() + "-> " + entry.getValue()));
    }

}
