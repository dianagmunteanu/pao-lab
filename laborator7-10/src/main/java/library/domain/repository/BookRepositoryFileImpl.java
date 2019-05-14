package library.domain.repository;

import library.domain.entity.Book;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookRepositoryFileImpl implements BookRepository {
    private List<Book> books = new ArrayList<>();

    public BookRepositoryFileImpl(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        FileInputStream fileInputStream = new FileInputStream(file);
        Scanner scanner = new Scanner(fileInputStream);
        int counter = 0;
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] values = line.split(",");
            Book newEntry = new Book(new Integer(values[0]), values[1], values[2]);
            books.add(newEntry);
        }
    }

    @Override
    public Book getBookById(int bookId) {
        Book selectedBook = null;
        for (Book book : books) {
            if (book.getId() == bookId)
                return book;
        }
        return null;
    }

    @Override
    public boolean existsByTitle(String bookTitle) {
        //interam prin lista de carti si
        return false;
    }
}
