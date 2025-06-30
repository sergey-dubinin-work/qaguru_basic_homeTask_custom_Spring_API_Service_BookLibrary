package guru.qa.booklibrary.dto.books;

import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
public class AddBookRequest {
    private UUID authorId;
    private String bookName;
}
