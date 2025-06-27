package guru.qa.booklibrary.dto.users;

import lombok.Getter;

@Getter
public class UserRegistrationRequest {
    private String userName;
    private String password;
    private Integer age;
}
