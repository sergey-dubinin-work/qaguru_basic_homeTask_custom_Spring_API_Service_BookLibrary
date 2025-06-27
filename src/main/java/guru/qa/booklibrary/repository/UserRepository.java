package guru.qa.booklibrary.repository;

import guru.qa.booklibrary.domain.users.UserInfo;
import guru.qa.booklibrary.domain.users.UserRegistration;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserRepository {

    private static final List<UserInfo> USERS = new ArrayList<>();

    public UserInfo addUser(UserRegistration userRegistrationBody){
        UserInfo userInfo = new UserInfo(
                UUID.randomUUID(),
                userRegistrationBody.getUserName(),
                userRegistrationBody.getPassword(),
                userRegistrationBody.getAge()
        );

        USERS.add(userInfo);

        return userInfo;
    }
}
