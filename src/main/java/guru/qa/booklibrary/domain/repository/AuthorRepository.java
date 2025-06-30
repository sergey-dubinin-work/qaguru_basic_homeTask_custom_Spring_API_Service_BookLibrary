package guru.qa.booklibrary.domain.repository;

import guru.qa.booklibrary.domain.entity.authors.AuthorEntity;

import java.util.List;

public interface AuthorRepository {

    AuthorEntity addAuthor(AuthorEntity addAuthorEntity);

    List<AuthorEntity> getAuthors();

}
