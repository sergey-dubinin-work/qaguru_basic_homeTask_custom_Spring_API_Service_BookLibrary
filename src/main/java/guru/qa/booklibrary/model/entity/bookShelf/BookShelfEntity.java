package guru.qa.booklibrary.model.entity.bookShelf;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class BookShelfEntity {
    private UUID id;
    private UUID bookId;
    @Setter
    private UUID rentedByUserId;
}
