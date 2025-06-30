package guru.qa.booklibrary.entity.books;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class BookEntity {
    private UUID id;
    private UUID authorId;
    private String bookName;
}
