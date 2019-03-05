package library;

import java.util.Date;

public class LibraryService {
    private User[] users =
            new User[]{
                    new User(1, "Gigel")
            };
    private Book[] books =
            new Book[]{
                    new Book(1, "Titlul1"),
                    new Book(2, "Titlul2")
            };
    Reservation[] reservations = new Reservation[50];
    int currentIndex = 0;

    public Book[] listAll() {
        return books;
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
        for( int i =0 ; i< books.length; i++){
            if(books[i].getId() == bookId){
                selectedBook = books[i];
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


}
