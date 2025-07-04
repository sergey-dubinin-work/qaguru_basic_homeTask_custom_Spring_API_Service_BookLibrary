package guru.qa.booklibrary.repository.memory;

import guru.qa.booklibrary.model.entity.bookShelf.BookShelfEntity;
import guru.qa.booklibrary.repository.BookShelfRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import static java.util.Objects.isNull;

@Repository
@Profile("dev")
public class InMemoryBookShelfRepository implements BookShelfRepository {

    private static final List<BookShelfEntity> bookShelf = new ArrayList<>();

    @Override
    public BookShelfEntity addToBookShelf(BookShelfEntity bookShelfEntity) {
        bookShelf.add(bookShelfEntity);
        return bookShelfEntity;
    }

    @Override
    public BookShelfEntity getFirstFreeBook(UUID bookId) {
        return getBookWithUserFromBookShelf(bookId, null);
    }

    @Override
    public BookShelfEntity getBookRentedByUser(UUID bookId, UUID userId) {
        return getBookWithUserFromBookShelf(bookId, userId);
    }

    @Override
    public BookShelfEntity setRenterToBookShelfEntity(UUID recordId, UUID userId) {
        return bookShelf.stream()
                .filter(bookShelfEntity -> bookShelfEntity.getId().equals(recordId))
                .peek(bookShelfEntity -> bookShelfEntity.setRentedByUserId(userId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<BookShelfEntity> getBookShelfState() {
        return new ArrayList<>(bookShelf);
    }

    private BookShelfEntity getBookWithUserFromBookShelf(UUID bookId, UUID userId){
        return new ArrayList<>(bookShelf).stream()
                .filter(bookShelfEntity -> bookId.equals(bookShelfEntity.getBookId()))
                .filter(bookShelfEntity -> Objects.equals(userId, bookShelfEntity.getRentedByUserId()))
                .findFirst().orElse(null);
    }

}
