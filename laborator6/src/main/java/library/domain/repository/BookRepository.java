package library.domain.repository;

import library.domain.entity.Book;

public interface BookRepository {
    Book getBookById(int bookId);

    boolean existsByTitle(String bookTitle);
}
