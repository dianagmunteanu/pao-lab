import library.domain.LibraryException;
import library.services.BookService;
import library.services.UserService;

public class Start {


    public static void main(String[] args) {

        System.out.println("Welcome to Diana's library");

        UserService userService = new UserService();
        BookService bookService = new BookService();

        try {
            userService.printAllUsers();
            userService.getUserNameById(1);
            userService.getUserNameById("test");
        } catch (LibraryException e) {
            switch (e.getCode()) {
                case INCORRECT_USER_ID:
                    System.out.println(e.getMessage());
                case USER_NOT_FOUND:
                    //TODO
                default:
                    e.printStackTrace();
            }
        }


        System.out.println("Calculez pretul pentru o carte");
        int bookId = bookService.getRandomBook();
        System.out.println("Costul calculat este:" + bookService.getBookPrice(bookId));

    }


}
