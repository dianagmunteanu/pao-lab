import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BankOcrApplication {

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

    public static void main(String[] args) throws IOException {

        BankOcrApplication bankApplication = new BankOcrApplication();
        bankApplication.run();
    }

    private void run() {
        File inputFile = new File(getClass().getClassLoader().getResource("ibans2.txt").getFile());
        File rezultat = new File("rezultat.txt");
        //TODO extract into a clas fileReader
        try(PrintWriter printWriter = new PrintWriter(new FileOutputStream(rezultat))) {


            Scanner s = new Scanner(new FileInputStream(inputFile));
            while(s.hasNext()){
                String linia1 = s.nextLine();
                String linia2 = s.nextLine();
                String linia3 = s.nextLine();
                String linia4 = s.nextLine();
                //TODO extract contansts
                if(linia1.length() != 27) linia1 += "                           ";
                if(linia2.length() != 27) linia2 += "                           ";
                if(linia3.length() != 27) linia3 += "                           ";

                String numarString = "";

                String cifre;
                Boolean err = false;
                //TODO make it possible to read accounts longer then 9 digits
                for (int i = 0; i < 9; i++) {
                    int beginIndex = 3 * i;
                    int endIndex = beginIndex + 3;
                    cifre = linia1.substring(beginIndex, endIndex) +
                            linia2.substring(beginIndex, endIndex) +
                            linia3.substring(beginIndex, endIndex);
                    Character c = OCR_DIGITS.get(cifre);

                    if(c == null) {
                        err = true;
                        numarString += "?";
                    }
                    else
                        numarString += c;
                }
                System.out.println(numarString);
                String reverted=new StringBuilder(numarString).reverse().toString();
                int checksum=0;
                //TODO extract method
                for(int i=1;i<=9;i++)
                {
                    checksum=(checksum+ Integer.valueOf(reverted.charAt(i-1))*i)%11;
                }

                //TODO extract class AccountExporter
                if(checksum==0)
                    printWriter.println(numarString);
                else if (err)
                    printWriter.println(numarString + " ILL");
                else
                    printWriter.println(numarString + " ERR");


            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }

}