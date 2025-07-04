package guru.qa.booklibrary.model.mapper;

import guru.qa.booklibrary.model.entity.bookShelf.BookShelfEntity;
import guru.qa.booklibrary.model.dto.bookShelf.BookShelfResponse;
import org.springframework.stereotype.Component;

@Component
public class BookShelfMapper {

    public BookShelfResponse toResponse(BookShelfEntity bookShelfEntity) {
        return new BookShelfResponse(
                bookShelfEntity.getId(),
                bookShelfEntity.getBookId(),
                bookShelfEntity.getRentedByUserId()
        );
    }
}
