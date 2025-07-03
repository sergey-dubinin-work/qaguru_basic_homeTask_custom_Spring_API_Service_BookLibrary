package guru.qa.booklibrary.mapper;

import guru.qa.booklibrary.domain.entity.bookShelf.BookShelfEntity;
import guru.qa.booklibrary.dto.bookShelf.AddBookToBookShelfRequest;
import guru.qa.booklibrary.dto.bookShelf.BookShelfResponse;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class BookShelfMapper {

    public BookShelfEntity fromRequest(AddBookToBookShelfRequest addBookToBookShelfRequest){
        return new BookShelfEntity(
                UUID.randomUUID(),
                addBookToBookShelfRequest.getBookId(),
                null
        );
    }

    public BookShelfResponse toResponse(BookShelfEntity bookShelfEntity){
        return new BookShelfResponse(
                bookShelfEntity.getId(),
                bookShelfEntity.getBookId(),
                bookShelfEntity.getRentedByUserId()
        );
    }
}
