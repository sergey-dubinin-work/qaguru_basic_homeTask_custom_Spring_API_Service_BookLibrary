package guru.qa.booklibrary.model.entity.users;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class UserEntity {
    private UUID id;
    private String userName;
    private String password;
    private Integer age;
}
