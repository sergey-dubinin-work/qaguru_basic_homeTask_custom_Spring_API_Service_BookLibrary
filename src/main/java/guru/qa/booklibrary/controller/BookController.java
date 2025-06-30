package guru.qa.booklibrary.controller;

import guru.qa.booklibrary.dto.books.AddBookRequest;
import guru.qa.booklibrary.dto.books.BookResponse;
import guru.qa.booklibrary.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping()
    @Operation(summary = "Получение списка книг")
    public List<BookResponse> getBooks(){
        return bookService.getBooks().stream()
                .map(BookResponse::new)
                .toList();
    }

}
