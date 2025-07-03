package guru.qa.booklibrary.model.dto.users;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserAuthRequest {
    private String userName;
    private String password;
}
