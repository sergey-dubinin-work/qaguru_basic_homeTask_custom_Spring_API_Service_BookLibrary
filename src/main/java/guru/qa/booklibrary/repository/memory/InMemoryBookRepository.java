package guru.qa.booklibrary.repository.memory;

import guru.qa.booklibrary.domain.entity.books.BookEntity;
import guru.qa.booklibrary.domain.repository.BookRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Profile("dev")
public class InMemoryBookRepository implements BookRepository {

    private final List<BookEntity> books = new ArrayList<>();

    @Override
    public BookEntity addBook(BookEntity bookEntity){
        books.add(bookEntity);
        return bookEntity;
    }

}
