package guru.qa.booklibrary.repository;

import guru.qa.booklibrary.entity.authors.AuthorEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AuthorRepository {

    private final List<AuthorEntity> authors = new ArrayList<>();

    public AuthorEntity addAuthor(AuthorEntity addAuthorEntity){
        authors.add(addAuthorEntity);
        return addAuthorEntity;

    }

    public List<AuthorEntity> getAuthors(){
        return new ArrayList<>(authors);
    }

}
