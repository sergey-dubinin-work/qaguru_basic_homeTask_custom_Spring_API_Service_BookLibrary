package guru.qa.booklibrary.service;

import guru.qa.booklibrary.model.entity.books.BookEntity;
import guru.qa.booklibrary.repository.BookRepository;
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
    public BookEntity addBook(UUID authorId, String bookName){

        BookEntity bookEntity = new BookEntity(
                UUID.randomUUID(),
                authorId,
                bookName
        );

        return bookRepository.addBook(bookEntity);
    }

    public List<BookEntity> getBooks(){
        return bookRepository.getBooks();
    }
}
