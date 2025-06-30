package guru.qa.booklibrary.service;

import guru.qa.booklibrary.dto.books.AddBookRequest;
import guru.qa.booklibrary.domain.entity.books.BookEntity;
import guru.qa.booklibrary.domain.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public BookEntity addBook(AddBookRequest addBookRequest){
        BookEntity bookEntity = new BookEntity(
                UUID.randomUUID(),
                addBookRequest.getAuthorId(),
                addBookRequest.getBookName()
        );

        return bookRepository.addBook(bookEntity);
    }
}
