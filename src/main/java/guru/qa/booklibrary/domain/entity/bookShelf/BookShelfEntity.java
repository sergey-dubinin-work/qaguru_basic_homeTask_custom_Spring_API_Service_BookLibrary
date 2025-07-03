package guru.qa.booklibrary.domain.entity.bookShelf;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class BookShelfEntity {
    private UUID id;
    private UUID bookId;
    private UUID rentedByUserId;
}
