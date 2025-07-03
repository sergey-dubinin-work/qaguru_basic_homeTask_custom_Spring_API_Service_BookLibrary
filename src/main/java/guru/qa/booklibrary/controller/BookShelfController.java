package guru.qa.booklibrary.controller;

import guru.qa.booklibrary.domain.entity.bookShelf.BookShelfEntity;
import guru.qa.booklibrary.dto.bookShelf.AddBookToBookShelfRequest;
import guru.qa.booklibrary.dto.bookShelf.BookShelfResponse;
import guru.qa.booklibrary.service.BookShelfService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/bookshelf")
@Tag(name = "BookShelf", description = "BookShelf operations")
public class BookShelfController {

    private final BookShelfService bookShelfService;

    public BookShelfController(BookShelfService bookShelfService){
        this.bookShelfService = bookShelfService;
    }

    @PostMapping("/addToBookShelf")
    @Operation(summary = "Adding new book to book shelf")
    public BookShelfResponse addToBookShelf(@RequestBody AddBookToBookShelfRequest addBookToBookShelfRequest){

        BookShelfEntity bookShelfEntity = new BookShelfEntity(
                UUID.randomUUID(),
                addBookToBookShelfRequest.getBookId(),
                null
        );

        return new BookShelfResponse(bookShelfService.addBookToBookShelf(bookShelfEntity));

    }

}
