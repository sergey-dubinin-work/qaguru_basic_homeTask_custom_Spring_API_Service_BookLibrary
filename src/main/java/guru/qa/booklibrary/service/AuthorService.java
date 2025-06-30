package guru.qa.booklibrary.service;

import guru.qa.booklibrary.dto.authors.AddAuthorRequest;
import guru.qa.booklibrary.domain.entity.authors.AuthorEntity;
import guru.qa.booklibrary.domain.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
    }

    public AuthorEntity addAuthor(AddAuthorRequest addAuthorRequest){

        AuthorEntity authorEntity = new AuthorEntity(
                UUID.randomUUID(),
                addAuthorRequest.getAuthorName()
        );

        return authorRepository.addAuthor(authorEntity);
    }

    public List<AuthorEntity> getAuthors(){
        return authorRepository.getAuthors();
    }
}
