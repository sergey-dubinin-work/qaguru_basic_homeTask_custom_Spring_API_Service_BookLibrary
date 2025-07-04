package guru.qa.booklibrary.repository;

import guru.qa.booklibrary.model.entity.authors.AuthorEntity;

import java.util.List;
import java.util.UUID;

public interface AuthorRepository {

    AuthorEntity addAuthor(AuthorEntity addAuthorEntity);

    AuthorEntity getAuthorById(UUID id);

    List<AuthorEntity> getAuthors();

}
