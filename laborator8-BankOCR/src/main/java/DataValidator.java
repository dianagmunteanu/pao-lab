import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataValidator {

    private static final Map<String, Character> OCR_DIGITS = new HashMap<String, Character>();

    static {
        OCR_DIGITS.put(" _ | ||_|", '0');
        OCR_DIGITS.put("     |  |", '1');
        OCR_DIGITS.put(" _  _||_ ", '2');
        OCR_DIGITS.put(" _  _| _|", '3');
        OCR_DIGITS.put("   |_|  |", '4');
        OCR_DIGITS.put(" _ |_  _|", '5');
        OCR_DIGITS.put(" _ |_ |_|", '6');
        OCR_DIGITS.put(" _   |  |", '7');
        OCR_DIGITS.put(" _ |_||_|", '8');
        OCR_DIGITS.put(" _ |_| _|", '9');
    }

    public Map<String, NumberCode> verifyNumber(List<String> numarList) {
        Map<String, NumberCode> result = new HashMap<>();
        numarList.forEach(numarString ->
        {
            if (numarString.contains("?")) {
                result.put(numarString, NumberCode.ILL);
            } else {
                int checksum = getChecksum(numarString);
                if (checksum != 0) {
                    result.put(numarString, NumberCode.ERR);
                } else {
                    result.put(numarString, NumberCode.OK);
                }
            }
        });
        return result;
    }

    public String getCifreFromString(String string) {
        return OCR_DIGITS.get(string) != null ? (OCR_DIGITS.get(string)) + "" : "?";
    }

    protected int getChecksum(String numarString) {
        String reverted = new StringBuilder(numarString).reverse().toString();
        int checksum = 0;
        for (int i = 1; i <= 9; i++) {
            checksum = (checksum + Integer.valueOf(reverted.charAt(i - 1)) * i) % 11;
        }
        return checksum;
    }
}
