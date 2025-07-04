package guru.qa.booklibrary.model.dto.bookShelf;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RentABookRequest {
    private UUID bookId;
}
