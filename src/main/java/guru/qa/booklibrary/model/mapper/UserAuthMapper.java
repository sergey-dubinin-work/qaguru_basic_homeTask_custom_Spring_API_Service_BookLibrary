package guru.qa.booklibrary.model.mapper;

import guru.qa.booklibrary.model.entity.userTokens.UserTokenEntity;
import guru.qa.booklibrary.model.entity.users.UserEntity;
import guru.qa.booklibrary.model.dto.users.UserAuthRequest;
import guru.qa.booklibrary.model.dto.users.UserAuthResponse;
import org.springframework.stereotype.Component;

@Component
public class UserAuthMapper {

    public UserAuthResponse toResponse(UserTokenEntity userTokenEntity){
        return new UserAuthResponse(userTokenEntity.getToken());
    }

}
