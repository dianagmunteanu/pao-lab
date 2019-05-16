package library.configuration;

import library.domain.repository.*;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class RepositoryConfig {
    private UserRepository userRepository = new UserRepositoryDBImpl();
    private BookRepository bookRepository;
    private ReservationRepository reservationRepository = new ReservationRepositoryImpl();


    public UserRepository getUserRepository() {
        return userRepository;
    }

    public BookRepository getBookRepository() {
        return bookRepository;
    }

    public ReservationRepository getReservationRepository() {
        return reservationRepository;
    }

    private static RepositoryConfig ourInstance = new RepositoryConfig();

    public static RepositoryConfig getInstance() {
        return ourInstance;
    }

    private RepositoryConfig() {
        try {
            bookRepository = new BookRepositoryFileImpl("books.csv");
        } catch (FileNotFoundException e) {
            System.out.println("Cound not create BookRepositoryFileImpl: "+e.getMessage());
            System.out.println("The system will use the mock data from  BookRepositoryImpl");
            bookRepository = new BookRepositoryImpl(); //Use data from another source
        }
    }


}
