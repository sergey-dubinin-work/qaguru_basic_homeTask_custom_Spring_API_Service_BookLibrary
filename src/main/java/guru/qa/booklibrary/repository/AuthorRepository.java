package guru.qa.booklibrary.repository;

import guru.qa.booklibrary.dto.authors.AddAuthorRequest;
import guru.qa.booklibrary.entity.authors.AuthorEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AuthorRepository {

    private List<AuthorEntity> authors = new ArrayList<>();

    public AuthorEntity addAuthor(AddAuthorRequest addAuthorRequest){

        AuthorEntity authorEntity = new AuthorEntity(
                UUID.randomUUID(),
                addAuthorRequest.getName()
        );

        authors.add(authorEntity);

        return authorEntity;
    }

}
