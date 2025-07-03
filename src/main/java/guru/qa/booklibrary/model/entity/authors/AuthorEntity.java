package guru.qa.booklibrary.model.entity.authors;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class AuthorEntity {
    private UUID id;
    private String authorName;
}
