package guru.qa.booklibrary.controller;

import guru.qa.booklibrary.dto.authors.AddAuthorRequest;
import guru.qa.booklibrary.dto.authors.AuthorResponse;
import guru.qa.booklibrary.mapper.AuthorMapper;
import guru.qa.booklibrary.service.AuthorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
@Tag(name = "Author", description = "Operations with book authors")
public class AuthorController {

    private final AuthorService authorService;
    private final AuthorMapper authorMapper;

    public AuthorController(AuthorService authorService, AuthorMapper authorMapper){
        this.authorService = authorService;
        this.authorMapper = authorMapper;
    }

    @PostMapping()
    @Operation(summary = "Adding new book author")
    public AuthorResponse addAuthor(@RequestBody AddAuthorRequest addAuthorRequest){
        return authorMapper.toResponse(
                authorService.addAuthor(authorMapper.fromRequest(addAuthorRequest))
        );
    }

    @GetMapping()
    @Operation(summary = "Getting book authors list")
    public List<AuthorResponse> getAuthors(){
        return authorService.getAuthors()
                .stream()
                .map(authorMapper::toResponse)
                .toList();
    }

}
