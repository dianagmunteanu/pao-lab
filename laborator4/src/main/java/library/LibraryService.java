package library;

import java.util.Date;

public class LibraryService {
    private User[] users =
            new User[]{
                    new UserBuilder()
                            .withName("Gigel")
                            .withId(1)
                            .withEmail("email@test.com")
                            .build(),
                    new UserBuilder()
                            .withName("John Doe")
                            .withId(2)
                            .withEmail("email@test.com")
                            .build(),
                    new UserBuilder()
                            .withName("John Mark Doe")
                            .withId(3)
                            .withEmail("email@test.com")
                            .build(),
                    new UserBuilder()
                            .withName("John Doe Mark")
                            .withId(4)
                            .withEmail("email@test.com")
                            .build(),
                    new UserBuilder()
                            .withName("John Dan")
                            .withId(5)
                            .withEmail("email@test.com")
                            .build()
            };
    private Item[] items =
            new Item[]{
                    new Book(1, "Titlul1", "Author1"),
                    new Book(2, "Titlul2", "Author2"),
                    new CD(3,"CD3","test",1001),
                    new CD(4,"CD4")
            };
    Reservation[] reservations = new Reservation[50];
    int currentIndex = 0;
    private static LibraryService instance;

    public Item[] listAll() {
        return items;
    }

    public int existsByTitle(String bookTitle) {
        //interam prin lista de carti si
        return -1;
    }


    public void addReservation(int userId, int bookId, Date endDate) {
        System.out.println("Userul cu id-ul: "+userId);
        User user = getUserById(userId);
        System.out.println("se numeste "+ user.getName());
        System.out.println("si vrea sa imprumute cartea cu id-ul:"+bookId);
        Book book = getBookById(bookId);
        System.out.println("si cu numele "+book.getTitle());
        Date startDate = new Date();
        Reservation newReservation = new Reservation(user, book, startDate, endDate);
        reservations[currentIndex] = newReservation;
        currentIndex++;
    }

    private Book getBookById(int bookId) {
        Book selectedBook = null;
        for(int i = 0; i< items.length; i++){
            if(items[i] instanceof Book &&
                    items[i].getId() == bookId){
                selectedBook = (Book) items[i];
            }
        }
        return selectedBook;
    }

    private User getUserById(int userId) {
        User selectedUser = null;
        for (int i = 0; i < users.length; i++) {
            if (users[i].getId() == userId) {
                selectedUser = users[i];
            }
        }
        if(selectedUser == null){
            System.out.println("Nu a fost gasit un user cu id-ul: "+userId);
        }
        return selectedUser;
    }


    public int getNumberOfReservations() {
        System.out.println("Numarul de rezervari din acest serviciu este: "+ currentIndex);
        return currentIndex;
    }

    private LibraryService(){
        System.out.println("Apel constructor");
    }



    public static LibraryService getInstance(){
        System.out.println("Se apeleaza getInstance.");
        if(instance == null){
            instance = new LibraryService();
            System.out.println("S-a instantiat singleton-ul");
        }
        return instance;
    }

    public Reservation[] getReservations() {
        return reservations;
    }

    public User[] getUsers() {
        return users;
    }
}
