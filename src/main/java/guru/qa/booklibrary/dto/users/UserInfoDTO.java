package guru.qa.booklibrary.dto.users;

import guru.qa.booklibrary.entity.users.UserInfoEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class UserInfoDTO {
    private UUID id;
    private String userName;
    private Integer age;

    public UserInfoDTO(UserInfoEntity userInfoEntity){
        this.id = userInfoEntity.getId();
        this.userName = userInfoEntity.getUserName();
        this.age = userInfoEntity.getAge();
    }
}
