package guru.qa.booklibrary.dto.bookShelf;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookShelfResponse {
    private UUID id;
    private UUID bookId;
    private UUID rentedByUserId;
}
