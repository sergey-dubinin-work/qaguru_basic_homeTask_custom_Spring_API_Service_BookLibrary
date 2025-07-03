package guru.qa.booklibrary.dto.bookShelf;

import guru.qa.booklibrary.domain.entity.bookShelf.BookShelfEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookShelfResponse {
    private UUID id;
    private UUID bookId;
    private UUID rentedByUserId;

    public BookShelfResponse(BookShelfEntity bookShelfEntity){
        this.id = bookShelfEntity.getId();
        this.bookId = bookShelfEntity.getBookId();
        this.rentedByUserId = bookShelfEntity.getRentedByUserId();
    }
}
