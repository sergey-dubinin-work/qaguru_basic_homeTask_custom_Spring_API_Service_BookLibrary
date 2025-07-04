package guru.qa.booklibrary.service;

import guru.qa.booklibrary.model.entity.authors.AuthorEntity;
import guru.qa.booklibrary.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
    }

    public AuthorEntity addAuthor(String authorName){
        AuthorEntity authorEntity = new AuthorEntity(
                UUID.randomUUID(),
                authorName
        );

        return authorRepository.addAuthor(authorEntity);
    }

    public List<AuthorEntity> getAuthors(){
        return authorRepository.getAuthors();
    }
}
