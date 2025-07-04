package guru.qa.booklibrary.repository.memory;

import guru.qa.booklibrary.model.entity.authors.AuthorEntity;
import guru.qa.booklibrary.repository.AuthorRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
@Profile("dev")
public class InMemoryAuthorRepository implements AuthorRepository {

    private final List<AuthorEntity> authors = new ArrayList<>();

    @Override
    public AuthorEntity addAuthor(AuthorEntity addAuthorEntity){
        authors.add(addAuthorEntity);
        return addAuthorEntity;

    }

    @Override
    public AuthorEntity getAuthorById(UUID id) {
        return new ArrayList<>(authors).stream()
                .filter(authorEntity -> authorEntity.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<AuthorEntity> getAuthors(){
        return new ArrayList<>(authors);
    }

}
