package guru.qa.booklibrary.repository;

import guru.qa.booklibrary.model.entity.bookShelf.BookShelfEntity;

import java.util.List;
import java.util.UUID;

public interface BookShelfRepository {

    BookShelfEntity addToBookShelf(BookShelfEntity bookShelfEntity);

    BookShelfEntity getFirstFreeBook(UUID bookId);

    BookShelfEntity getBookRentedByUser(UUID bookId, UUID userId);

    BookShelfEntity setRenterToBookShelfEntity(UUID recordId, UUID userId);

    List<BookShelfEntity> getBookShelfState();

}
