package guru.qa.booklibrary.controller;

import guru.qa.booklibrary.exception.UserNotAuthorizedException;
import guru.qa.booklibrary.model.dto.bookShelf.AddBookToBookShelfRequest;
import guru.qa.booklibrary.model.dto.bookShelf.BookShelfResponse;
import guru.qa.booklibrary.model.mapper.BookShelfMapper;
import guru.qa.booklibrary.service.BookShelfService;
import guru.qa.booklibrary.service.UserAuthorizationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import static java.util.Objects.isNull;

@RestController
@RequestMapping("/bookshelf")
@Tag(name = "BookShelf", description = "BookShelf operations")
public class BookShelfController {

    private final BookShelfService bookShelfService;
    private final BookShelfMapper bookShelfMapper;
    private final UserAuthorizationService userAuthorizationService;

    public BookShelfController(BookShelfService bookShelfService, BookShelfMapper bookShelfMapper, UserAuthorizationService userAuthorizationService){
        this.bookShelfService = bookShelfService;
        this.bookShelfMapper = bookShelfMapper;
        this.userAuthorizationService = userAuthorizationService;
    }

    @PostMapping("/addToBookShelf")
    @Operation(summary = "Adding new book to book shelf")
    public BookShelfResponse addToBookShelf(
            @Parameter(required = true) @RequestHeader(value = "Authorization", required = false) String authHeader,
            @RequestBody AddBookToBookShelfRequest addBookToBookShelfRequest){

        if (!isNull(userAuthorizationService.getUserByBearerTokenHeader(authHeader))) {
            return bookShelfMapper.toResponse(
                    bookShelfService.addBookToBookShelf(bookShelfMapper.fromRequest(addBookToBookShelfRequest))
            );
        } else{
            throw new UserNotAuthorizedException();
        }
    }

}
