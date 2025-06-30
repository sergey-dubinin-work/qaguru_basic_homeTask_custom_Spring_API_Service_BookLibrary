package guru.qa.booklibrary.domain.repository;

import guru.qa.booklibrary.domain.entity.books.BookEntity;

public interface BookRepository {

    BookEntity addBook(BookEntity bookEntity);

}
