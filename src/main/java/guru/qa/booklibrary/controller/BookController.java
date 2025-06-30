package guru.qa.booklibrary.controller;

import guru.qa.booklibrary.dto.books.AddBookRequest;
import guru.qa.booklibrary.dto.books.BookResponse;
import guru.qa.booklibrary.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
@Tag(name = "Book", description = "Операции с книгами")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    @PostMapping()
    @Operation(summary = "Добавление книги")
    public BookResponse addBook(@RequestBody AddBookRequest addBookRequest){
        return new BookResponse(bookService.addBook(addBookRequest));
    }

}
