package guru.qa.booklibrary.repository;

import guru.qa.booklibrary.model.entity.books.BookEntity;

import java.util.List;
import java.util.UUID;

public interface BookRepository {

    BookEntity addBook(BookEntity bookEntity);

    BookEntity getBookById(UUID id);

    List<BookEntity> getBooks();
}
