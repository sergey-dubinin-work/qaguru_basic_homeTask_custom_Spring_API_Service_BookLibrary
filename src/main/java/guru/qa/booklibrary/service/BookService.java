package guru.qa.booklibrary.service;

import guru.qa.booklibrary.dto.books.AddBookRequest;
import guru.qa.booklibrary.domain.entity.books.BookEntity;
import guru.qa.booklibrary.domain.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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
