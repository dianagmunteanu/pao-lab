import library.Book;
import library.LibraryService;

import java.util.Date;
import java.util.Scanner;

public class Start {

    public static void main(String[] args) {

        System.out.println("Welcome to Diana's library");


       LibraryService libraryService = new LibraryService();

       libraryService.addReservation(1,1, new Date());

    }
}
