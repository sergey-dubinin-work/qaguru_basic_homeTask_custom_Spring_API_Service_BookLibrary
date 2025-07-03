package guru.qa.booklibrary.controller;

import guru.qa.booklibrary.model.dto.books.AddBookRequest;
import guru.qa.booklibrary.model.dto.books.BookResponse;
import guru.qa.booklibrary.model.mapper.BookMapper;
import guru.qa.booklibrary.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@Tag(name = "Book", description = "Operations with books")
public class BookController {

    private final BookService bookService;
    private final BookMapper bookMapper;

    public BookController(BookService bookService, BookMapper bookMapper){
        this.bookService = bookService;
        this.bookMapper = bookMapper;
    }

    @PostMapping()
    @Operation(summary = "Adding book")
    public BookResponse addBook(@RequestBody AddBookRequest addBookRequest){
        return bookMapper.toResponse(
                bookService.addBook(bookMapper.fromRequest(addBookRequest))
        );
    }

    @GetMapping()
    @Operation(summary = "Getting books list")
    public List<BookResponse> getBooks(){
        return bookService.getBooks().stream()
                .map(bookMapper::toResponse)
                .toList();
    }

}
