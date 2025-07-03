package guru.qa.booklibrary.model.dto.bookShelf;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookShelfResponse {
    private UUID id;
    private UUID bookId;
    private UUID rentedByUserId;
}
