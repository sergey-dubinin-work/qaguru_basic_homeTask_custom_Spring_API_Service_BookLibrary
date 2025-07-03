package guru.qa.booklibrary.mapper;

import guru.qa.booklibrary.domain.entity.users.UserEntity;
import guru.qa.booklibrary.dto.users.UserInfoResponse;
import guru.qa.booklibrary.dto.users.UserRegistrationRequest;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserMapper {

    public UserEntity fromResponse(UserRegistrationRequest userRegistrationRequest){
        return new UserEntity(
                UUID.randomUUID(),
                userRegistrationRequest.getUserName(),
                userRegistrationRequest.getPassword(),
                userRegistrationRequest.getAge()
        );
    }

    public UserInfoResponse toResponse(UserEntity userEntity){
        return new UserInfoResponse(
                userEntity.getId(),
                userEntity.getUserName(),
                userEntity.getAge()
        );
    }

}
