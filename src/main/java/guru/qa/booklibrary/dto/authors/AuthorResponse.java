package guru.qa.booklibrary.dto.authors;

import guru.qa.booklibrary.domain.entity.authors.AuthorEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorResponse {
    private UUID id;
    private String authorName;

    public AuthorResponse(AuthorEntity authorEntity){
        this.id = authorEntity.getId();
        this.authorName = authorEntity.getAuthorName();
    }
}
