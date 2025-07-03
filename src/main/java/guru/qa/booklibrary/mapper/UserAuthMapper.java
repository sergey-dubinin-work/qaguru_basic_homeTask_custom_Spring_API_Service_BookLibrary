package guru.qa.booklibrary.mapper;

import guru.qa.booklibrary.domain.entity.userTokens.UserTokenEntity;
import guru.qa.booklibrary.domain.entity.users.UserEntity;
import guru.qa.booklibrary.dto.users.UserAuthRequest;
import guru.qa.booklibrary.dto.users.UserAuthResponse;
import org.springframework.stereotype.Component;

@Component
public class UserAuthMapper {

    public UserEntity fromRequest(UserAuthRequest userAuthRequest){
        return new UserEntity(
                null,
                userAuthRequest.getUserName(),
                userAuthRequest.getPassword(),
                null
        );
    }

    public UserAuthResponse toResponse(UserTokenEntity userTokenEntity){
        return new UserAuthResponse(userTokenEntity.getToken());
    }

}
