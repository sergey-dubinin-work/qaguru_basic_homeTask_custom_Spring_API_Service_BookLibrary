package guru.qa.booklibrary.entity.authors;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class AuthorEntity {
    private UUID uuid;
    private String name;
}
