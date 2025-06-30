package guru.qa.booklibrary.domain.repository;

import guru.qa.booklibrary.domain.entity.books.BookEntity;

import java.util.List;

public interface BookRepository {

    BookEntity addBook(BookEntity bookEntity);

    List<BookEntity> getBooks();
}
