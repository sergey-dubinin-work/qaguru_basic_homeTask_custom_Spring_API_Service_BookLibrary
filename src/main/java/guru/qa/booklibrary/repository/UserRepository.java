package guru.qa.booklibrary.repository;

import guru.qa.booklibrary.dto.users.UserInfoDTO;
import guru.qa.booklibrary.dto.users.UserRegistrationDTO;
import guru.qa.booklibrary.entity.users.UserInfoEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserRepository {

    private static final List<UserInfoEntity> USERS = new ArrayList<>();

    public UserInfoDTO addUser(UserRegistrationDTO userRegistrationDTOBody){

        UserInfoEntity userInfoEntity = new UserInfoEntity(
                UUID.randomUUID(),
                userRegistrationDTOBody.getUserName(),
                userRegistrationDTOBody.getPassword(),
                userRegistrationDTOBody.getAge()
        );

        USERS.add(userInfoEntity);

        return new UserInfoDTO(userInfoEntity);
    }
}
