package guru.qa.booklibrary.model.mapper;

import guru.qa.booklibrary.model.entity.books.BookEntity;
import guru.qa.booklibrary.model.dto.books.AddBookRequest;
import guru.qa.booklibrary.model.dto.books.BookResponse;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class BookMapper {

    public BookResponse toResponse(BookEntity bookEntity){
        return new BookResponse(
                bookEntity.getId(),
                bookEntity.getAuthorId(),
                bookEntity.getBookName()
        );
    }

}
