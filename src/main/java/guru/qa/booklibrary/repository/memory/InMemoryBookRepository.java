package guru.qa.booklibrary.repository.memory;

import guru.qa.booklibrary.model.entity.books.BookEntity;
import guru.qa.booklibrary.repository.BookRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
@Profile("dev")
public class InMemoryBookRepository implements BookRepository {

    private final List<BookEntity> books = new ArrayList<>();

    @Override
    public BookEntity addBook(BookEntity bookEntity){
        books.add(bookEntity);
        return bookEntity;
    }

    @Override
    public BookEntity getBookById(UUID id) {
        return books.stream()
                .filter(bookEntity -> bookEntity.getId().equals(id))
                .findFirst().orElse(null);
    }

    @Override
    public List<BookEntity> getBooks() {
        return new ArrayList<>(books);
    }

}
