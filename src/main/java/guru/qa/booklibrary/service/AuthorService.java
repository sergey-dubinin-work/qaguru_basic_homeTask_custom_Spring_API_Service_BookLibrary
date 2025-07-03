package guru.qa.booklibrary.service;

import guru.qa.booklibrary.model.entity.authors.AuthorEntity;
import guru.qa.booklibrary.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
    }

    public AuthorEntity addAuthor(AuthorEntity authorEntity){
        return authorRepository.addAuthor(authorEntity);
    }

    public List<AuthorEntity> getAuthors(){
        return authorRepository.getAuthors();
    }
}
