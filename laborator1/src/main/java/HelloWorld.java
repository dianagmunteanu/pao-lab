import java.util.Scanner;

public class HelloWorld {

    public static void main(String[] args) {
        System.out.println("Hello World!"); // Display the string.

        //Scanner example
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String userName = scanner.nextLine();
        System.out.println("Hello " + userName + "!");

    }
}
