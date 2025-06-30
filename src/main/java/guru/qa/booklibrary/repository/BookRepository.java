package guru.qa.booklibrary.repository;

import guru.qa.booklibrary.entity.books.BookEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository {

    private final List<BookEntity> books = new ArrayList<>();

    public BookEntity addBook(BookEntity bookEntity){
        books.add(bookEntity);
        return bookEntity;
    }

}
