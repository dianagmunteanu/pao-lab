package library.configuration;

import library.domain.repository.*;

public class RepositoryConfig {
    private final UserRepository userRepository = new UserRepositorySmartImpl();
    private final BookRepository bookRepository = new BookRepository();
    private final ReservationRepository reservationRepository = new ReservationRepositoryImpl();

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
    }


}
