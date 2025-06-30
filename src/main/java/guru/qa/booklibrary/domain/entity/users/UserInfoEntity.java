package guru.qa.booklibrary.domain.entity.users;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class UserInfoEntity {
    private UUID id;
    private String userName;
    private String password;
    private Integer age;
}
