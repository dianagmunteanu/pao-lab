package library.domain.repository;

import library.domain.entity.Book;

public class BookRepository {
    private Book[] books = new Book[]{
            new Book(1, "Titlul1", "Author1"),
            new Book(2, "Titlul2", "Author2"),};

    public Book getBookById(int bookId) {
        Book selectedBook = null;
        for(int i = 0; i< books.length; i++){
            if(books[i] instanceof Book &&
                    books[i].getId() == bookId){
                selectedBook = (Book) books[i];
            }
        }
        return selectedBook;
    }

    public boolean existsByTitle(String bookTitle) {
        //interam prin lista de carti si
        return false;
    }
}
