package guru.qa.booklibrary.dto.bookShelf;

import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Builder
@Getter
public class AddBookToBookShelfRequest {

    private UUID bookId;

}
