package guru.qa.booklibrary.repository;

import guru.qa.booklibrary.model.entity.books.BookEntity;

import java.util.List;

public interface BookRepository {

    BookEntity addBook(BookEntity bookEntity);

    List<BookEntity> getBooks();
}
