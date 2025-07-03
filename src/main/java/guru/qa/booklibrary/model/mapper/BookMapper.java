package guru.qa.booklibrary.model.mapper;

import guru.qa.booklibrary.model.entity.books.BookEntity;
import guru.qa.booklibrary.model.dto.books.AddBookRequest;
import guru.qa.booklibrary.model.dto.books.BookResponse;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class BookMapper {

    public BookEntity fromRequest(AddBookRequest addBookRequest){
        return new BookEntity(
                UUID.randomUUID(),
                addBookRequest.getAuthorId(),
                addBookRequest.getBookName()
        );
    }

    public BookResponse toResponse(BookEntity bookEntity){
        return new BookResponse(
                bookEntity.getId(),
                bookEntity.getAuthorId(),
                bookEntity.getBookName()
        );
    }

}
