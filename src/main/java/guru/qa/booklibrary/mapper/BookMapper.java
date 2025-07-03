package guru.qa.booklibrary.mapper;

import guru.qa.booklibrary.domain.entity.books.BookEntity;
import guru.qa.booklibrary.dto.books.AddBookRequest;
import guru.qa.booklibrary.dto.books.BookResponse;
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
