package guru.qa.booklibrary.controller;

import guru.qa.booklibrary.exception.UserNotAuthorizedException;
import guru.qa.booklibrary.model.dto.books.AddBookRequest;
import guru.qa.booklibrary.model.dto.books.BookResponse;
import guru.qa.booklibrary.model.mapper.BookMapper;
import guru.qa.booklibrary.service.BookService;
import guru.qa.booklibrary.service.UserAuthorizationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/book")
@Tag(name = "Book", description = "Operations with books")
public class BookController {

    private final BookService bookService;
    private final UserAuthorizationService userAuthorizationService;
    private final BookMapper bookMapper;

    public BookController(BookService bookService, UserAuthorizationService userAuthorizationService, BookMapper bookMapper) {
        this.bookService = bookService;
        this.userAuthorizationService = userAuthorizationService;
        this.bookMapper = bookMapper;
    }

    @PostMapping()
    @Operation(summary = "Adding book")
    public BookResponse addBook(
            @Parameter(required = true) @RequestHeader(value = "Authorization", required = false) String authHeader,
            @RequestBody AddBookRequest addBookRequest) {
        if (!Objects.isNull(userAuthorizationService.getUserByBearerTokenHeader(authHeader))) {
            return bookMapper.toResponse(
                    bookService.addBook(bookMapper.fromRequest(addBookRequest))
            );
        } else {
            throw new UserNotAuthorizedException();
        }
    }

    @GetMapping()
    @Operation(summary = "Getting books list")
    public List<BookResponse> getBooks(){
        return bookService.getBooks().stream()
                .map(bookMapper::toResponse)
                .toList();
    }

}
