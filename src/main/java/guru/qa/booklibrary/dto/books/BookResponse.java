package guru.qa.booklibrary.dto.books;

import guru.qa.booklibrary.domain.entity.books.BookEntity;
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

    public BookResponse(BookEntity bookEntity){
        this.id = bookEntity.getId();
        this.authorId = bookEntity.getAuthorId();
        this.bookName = bookEntity.getBookName();
    }
}
