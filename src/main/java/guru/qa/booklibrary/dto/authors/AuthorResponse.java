package guru.qa.booklibrary.dto.authors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorResponse {
    private UUID id;
    private String authorName;
}
