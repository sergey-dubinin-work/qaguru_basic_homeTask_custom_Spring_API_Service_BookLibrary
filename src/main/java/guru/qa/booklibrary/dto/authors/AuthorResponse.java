package guru.qa.booklibrary.dto.authors;

import guru.qa.booklibrary.entity.authors.AuthorEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class AuthorResponse {
    private UUID uuid;
    private String name;

    public AuthorResponse(AuthorEntity authorEntity){
        this.uuid = authorEntity.getUuid();
        this.name = authorEntity.getName();
    }
}
