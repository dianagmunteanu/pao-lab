import library.Book;
import library.LibraryService;
import library.UserService;

import java.util.Date;
import java.util.Scanner;

public class Start {

    public static void main(String[] args) {

        System.out.println("Welcome to Diana's library");


       LibraryService libraryService = LibraryService.getInstance();

       libraryService.addReservation(1,1, new Date());
       libraryService.getNumberOfReservations();
       System.out.println("- Serviciul 2 -");
       LibraryService libraryService2 = LibraryService.getInstance();
       libraryService2.getNumberOfReservations();


        UserService userService = new UserService();
        userService.setLibraryService(LibraryService.getInstance());
        System.out.println("Numarul de rezervari ale lui 1 este:"+ userService.getNumberOfReservationsOfUser(1));
    }
}
