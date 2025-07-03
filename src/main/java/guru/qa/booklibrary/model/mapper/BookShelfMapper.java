package guru.qa.booklibrary.model.mapper;

import guru.qa.booklibrary.model.entity.bookShelf.BookShelfEntity;
import guru.qa.booklibrary.model.dto.bookShelf.AddBookToBookShelfRequest;
import guru.qa.booklibrary.model.dto.bookShelf.BookShelfResponse;
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
