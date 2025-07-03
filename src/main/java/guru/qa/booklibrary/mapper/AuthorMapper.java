package guru.qa.booklibrary.mapper;

import guru.qa.booklibrary.domain.entity.authors.AuthorEntity;
import guru.qa.booklibrary.dto.authors.AddAuthorRequest;
import guru.qa.booklibrary.dto.authors.AuthorResponse;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class AuthorMapper {

    public AuthorEntity fromRequest(AddAuthorRequest addAuthorRequest){
        return new AuthorEntity(
                UUID.randomUUID(),
                addAuthorRequest.getAuthorName()
        );
    }

    public AuthorResponse toResponse(AuthorEntity authorEntity){
        return new AuthorResponse(
                authorEntity.getId(),
                authorEntity.getAuthorName()
        );
    }
}
