package guru.qa.booklibrary.dto.users;

import guru.qa.booklibrary.domain.entity.users.UserInfoEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoResponse {
    private UUID id;
    private String userName;
    private Integer age;

    public UserInfoResponse(UserInfoEntity userInfoEntity){
        this.id = userInfoEntity.getId();
        this.userName = userInfoEntity.getUserName();
        this.age = userInfoEntity.getAge();
    }
}
