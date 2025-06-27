package guru.qa.booklibrary.repository;

import guru.qa.booklibrary.dto.users.UserRegistrationRequest;
import guru.qa.booklibrary.entity.users.UserInfoEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserRepository {

    private static final List<UserInfoEntity> USERS = new ArrayList<>();

    public UserInfoEntity addUser(UserRegistrationRequest userRegistrationRequestBody){

        UserInfoEntity userInfoEntity = new UserInfoEntity(
                UUID.randomUUID(),
                userRegistrationRequestBody.getUserName(),
                userRegistrationRequestBody.getPassword(),
                userRegistrationRequestBody.getAge()
        );

        USERS.add(userInfoEntity);

        return userInfoEntity;
    }
}
