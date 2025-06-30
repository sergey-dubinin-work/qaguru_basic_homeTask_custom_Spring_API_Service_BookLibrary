package guru.qa.booklibrary.service;

import guru.qa.booklibrary.dto.authors.AddAuthorRequest;
import guru.qa.booklibrary.entity.authors.AuthorEntity;
import guru.qa.booklibrary.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AuthorService {

    AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
    }

    public AuthorEntity addAuthor(AddAuthorRequest addAuthorRequest){

        AuthorEntity authorEntity = new AuthorEntity(
                UUID.randomUUID(),
                addAuthorRequest.getAuthorName()
        );

        authorRepository.addAuthor(authorEntity);

        return authorEntity;

    }
}
