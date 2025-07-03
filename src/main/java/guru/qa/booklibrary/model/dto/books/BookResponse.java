package guru.qa.booklibrary.model.dto.books;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookResponse {
    private UUID id;
    private UUID authorId;
    private String bookName;
}
