package guru.qa.booklibrary.controller;

import guru.qa.booklibrary.exception.UserNotAuthorizedException;
import guru.qa.booklibrary.model.dto.authors.AddAuthorRequest;
import guru.qa.booklibrary.model.dto.authors.AuthorResponse;
import guru.qa.booklibrary.model.mapper.AuthorMapper;
import guru.qa.booklibrary.service.AuthorService;
import guru.qa.booklibrary.service.UserAuthorizationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.Objects.isNull;

@RestController
@RequestMapping("/author")
@Tag(name = "Author", description = "Operations with book authors")
public class AuthorController {

    private final AuthorService authorService;
    private final UserAuthorizationService userAuthorizationService;
    private final AuthorMapper authorMapper;

    public AuthorController(AuthorService authorService, UserAuthorizationService userAuthorizationService, AuthorMapper authorMapper) {
        this.authorService = authorService;
        this.userAuthorizationService = userAuthorizationService;
        this.authorMapper = authorMapper;
    }

    @PostMapping()
    @Operation(summary = "Adding new book author")
    public AuthorResponse addAuthor(
            @Parameter(required = true) @RequestHeader(value = "Authorization", required = false) String authHeader,
            @RequestBody AddAuthorRequest addAuthorRequest) {
        if (!isNull(userAuthorizationService.getUserByBearerTokenHeader(authHeader))) {
            return authorMapper.toResponse(
                    authorService.addAuthor(authorMapper.fromRequest(addAuthorRequest)));
        } else {
            throw new UserNotAuthorizedException();
        }

    }

    @GetMapping()
    @Operation(summary = "Getting book authors list")
    public List<AuthorResponse> getAuthors() {
        return authorService.getAuthors()
                .stream()
                .map(authorMapper::toResponse)
                .toList();
    }

}
