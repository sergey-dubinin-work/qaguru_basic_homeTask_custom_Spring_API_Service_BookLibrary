package guru.qa.booklibrary.model.entity.userTokens;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class UserTokenEntity {
    private UUID id;
    private UUID userId;
    private String token;
}
