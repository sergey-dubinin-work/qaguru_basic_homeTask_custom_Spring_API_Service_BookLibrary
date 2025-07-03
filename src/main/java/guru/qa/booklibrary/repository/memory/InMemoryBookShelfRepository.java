package guru.qa.booklibrary.repository.memory;

import guru.qa.booklibrary.model.entity.bookShelf.BookShelfEntity;
import guru.qa.booklibrary.repository.BookShelfRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Profile("dev")
public class InMemoryBookShelfRepository implements BookShelfRepository {

    private static final List<BookShelfEntity> bookShelf = new ArrayList<>();

    @Override
    public BookShelfEntity addToBookShelf(BookShelfEntity bookShelfEntity) {
        bookShelf.add(bookShelfEntity);
        return bookShelfEntity;
    }

}
