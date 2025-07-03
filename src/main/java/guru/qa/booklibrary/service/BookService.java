package guru.qa.booklibrary.service;

import guru.qa.booklibrary.model.entity.books.BookEntity;
import guru.qa.booklibrary.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public BookEntity addBook(BookEntity bookEntity){
        return bookRepository.addBook(bookEntity);
    }

    public List<BookEntity> getBooks(){
        return bookRepository.getBooks();
    }
}
