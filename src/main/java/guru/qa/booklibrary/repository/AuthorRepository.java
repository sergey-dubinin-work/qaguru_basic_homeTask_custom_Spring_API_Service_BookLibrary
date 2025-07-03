package guru.qa.booklibrary.repository;

import guru.qa.booklibrary.model.entity.authors.AuthorEntity;

import java.util.List;

public interface AuthorRepository {

    AuthorEntity addAuthor(AuthorEntity addAuthorEntity);

    List<AuthorEntity> getAuthors();

}
