package library.services;

import library.configuration.RepositoryConfig;
import library.configuration.ToolConfig;
import library.domain.entity.Book;
import library.domain.repository.BookRepository;
import library.tool.TaxCalculator;

public class BookService {
    private BookRepository bookRepository = RepositoryConfig.getInstance().getBookRepository();
    private TaxCalculator taxCalculator = ToolConfig.getInstance().getBookTaxCalculator();

    public int getRandomBook(){
       return bookRepository.getBookById(1).getId();
    }

    public double getBookPrice(int id){
        Book book = bookRepository.getBookById(id);
        return taxCalculator.computeCost(book);
    }

}
