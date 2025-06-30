package guru.qa.booklibrary.controller;

import guru.qa.booklibrary.dto.authors.AddAuthorRequest;
import guru.qa.booklibrary.dto.authors.AuthorResponse;
import guru.qa.booklibrary.service.AuthorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/author")
@Tag(name = "Author", description = "Операции с авторами книг")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService){
        this.authorService = authorService;
    }

    @PostMapping()
    @Operation(summary = "Добавление нового автора")
    public AuthorResponse addAuthor(@RequestBody AddAuthorRequest addAuthorRequest){
        return new AuthorResponse(authorService.addAuthor(addAuthorRequest));
    }

}
