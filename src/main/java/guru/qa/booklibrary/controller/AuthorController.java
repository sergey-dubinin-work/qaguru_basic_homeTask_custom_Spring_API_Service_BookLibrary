package guru.qa.booklibrary.controller;

import guru.qa.booklibrary.dto.authors.AddAuthorRequest;
import guru.qa.booklibrary.dto.authors.AuthorResponse;
import guru.qa.booklibrary.repository.AuthorRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/author")
@Tag(name = "Author", description = "Операции с авторами книг")
public class AuthorController {

    private final AuthorRepository authorRepository = new AuthorRepository();

    @PostMapping()
    @Operation(summary = "Добавление нового автора")
    public AuthorResponse addAuthor(@RequestBody AddAuthorRequest addAuthorRequest){
        return new AuthorResponse(authorRepository.addAuthor(addAuthorRequest));

    }

}
