import library.services.BookService;
import library.services.UserService;

public class Start {


    public static void main(String[] args) {

        System.out.println("Wellcome to Diana's library");

        UserService userService = new UserService();
        BookService bookService = new BookService();

        userService.printAllUsers();

        String[] partialName = {"JDo", "JoHDo", "JoDo", "JoDMa", "Gigel"};
        System.out.println("Trying to search in our user list all users that match the partial name: " + partialName);
        for (int i = 0; i < partialName.length; i++) {
            String[] result = userService.searchUsersByASpecificPattern(partialName[i]);

            for (int counter = 0; counter < result.length; counter++) {
                if (result[counter] == null) {
                    break;
                }
                System.out.println(result[counter]);
            }
        }

        System.out.println("Calculez pretul pentru o carte");
        int bookId = bookService.getRandomBook();
        System.out.println("Costul calculat este:" + bookService.getBookPrice(bookId));

    }


}
