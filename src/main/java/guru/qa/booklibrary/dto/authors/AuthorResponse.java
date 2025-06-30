package guru.qa.booklibrary.dto.authors;

import guru.qa.booklibrary.entity.authors.AuthorEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorResponse {
    private UUID uuid;
    private String authorName;

    public AuthorResponse(AuthorEntity authorEntity){
        this.uuid = authorEntity.getUuid();
        this.authorName = authorEntity.getAuthorName();
    }
}
