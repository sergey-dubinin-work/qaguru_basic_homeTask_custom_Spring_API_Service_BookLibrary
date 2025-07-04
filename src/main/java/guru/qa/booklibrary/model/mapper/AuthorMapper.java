package guru.qa.booklibrary.model.mapper;

import guru.qa.booklibrary.model.entity.authors.AuthorEntity;
import guru.qa.booklibrary.model.dto.authors.AddAuthorRequest;
import guru.qa.booklibrary.model.dto.authors.AuthorResponse;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class AuthorMapper {

    public AuthorResponse toResponse(AuthorEntity authorEntity){
        return new AuthorResponse(
                authorEntity.getId(),
                authorEntity.getAuthorName()
        );
    }

}
