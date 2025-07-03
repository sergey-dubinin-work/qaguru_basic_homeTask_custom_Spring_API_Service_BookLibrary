package guru.qa.booklibrary.controller;

import guru.qa.booklibrary.dto.bookShelf.AddBookToBookShelfRequest;
import guru.qa.booklibrary.dto.bookShelf.BookShelfResponse;
import guru.qa.booklibrary.mapper.BookShelfMapper;
import guru.qa.booklibrary.service.BookShelfService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookshelf")
@Tag(name = "BookShelf", description = "BookShelf operations")
public class BookShelfController {

    private final BookShelfService bookShelfService;
    private final BookShelfMapper bookShelfMapper;

    public BookShelfController(BookShelfService bookShelfService, BookShelfMapper bookShelfMapper){
        this.bookShelfService = bookShelfService;
        this.bookShelfMapper = bookShelfMapper;
    }

    @PostMapping("/addToBookShelf")
    @Operation(summary = "Adding new book to book shelf")
    public BookShelfResponse addToBookShelf(@RequestBody AddBookToBookShelfRequest addBookToBookShelfRequest){

        return bookShelfMapper.toResponse(
                bookShelfService.addBookToBookShelf(bookShelfMapper.fromRequest(addBookToBookShelfRequest))
        );

    }

}
