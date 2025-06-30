package guru.qa.booklibrary.dto.users;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserRegistrationRequest {
    private String userName;
    private String password;
    private Integer age;
}
