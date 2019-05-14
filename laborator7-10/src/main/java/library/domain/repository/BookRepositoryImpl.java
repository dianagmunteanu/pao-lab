package library.domain.repository;

import library.domain.entity.Book;

import java.util.Arrays;
import java.util.List;

public class BookRepositoryImpl implements BookRepository {
    private List<Book> books = Arrays.asList(
            new Book(1, "Titlul1", "Author1"),
            new Book(2, "Titlul2", "Author2"));

    @Override
    public Book getBookById(int bookId) {
        Book selectedBook = null;
        for (Book book : books) {
            if (book.getId() == bookId)
                selectedBook = book;
        }
        return selectedBook;
    }

    @Override
    public boolean existsByTitle(String bookTitle) {
        //interam prin lista de carti si
        return false;
    }
}
