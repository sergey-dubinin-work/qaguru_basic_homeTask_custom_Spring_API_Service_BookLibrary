package guru.qa.booklibrary.service;

import guru.qa.booklibrary.exception.NotFoundException;
import guru.qa.booklibrary.model.entity.books.BookEntity;
import guru.qa.booklibrary.repository.AuthorRepository;
import guru.qa.booklibrary.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static java.util.Objects.isNull;

@Service
public class BookService {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BookService(AuthorRepository authorRepository, BookRepository bookRepository){
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    public BookEntity addBook(UUID authorId, String bookName){
        if (isNull(authorRepository.getAuthorById(authorId))){
            throw new NotFoundException();
        }

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
