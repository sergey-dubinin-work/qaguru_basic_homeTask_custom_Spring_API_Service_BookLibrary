package guru.qa.booklibrary.model.dto.authors;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddAuthorRequest {
    private String authorName;
}
