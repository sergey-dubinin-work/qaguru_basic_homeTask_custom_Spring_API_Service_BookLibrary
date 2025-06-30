package guru.qa.booklibrary.service;

import guru.qa.booklibrary.domain.entity.users.UserInfoEntity;
import guru.qa.booklibrary.domain.repository.UserRepository;
import guru.qa.booklibrary.dto.users.UserRegistrationRequest;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public UserInfoEntity registerUser(UserRegistrationRequest userRegistrationRequestBody){
        UserInfoEntity userInfoEntity = new UserInfoEntity(
                UUID.randomUUID(),
                userRegistrationRequestBody.getUserName(),
                userRegistrationRequestBody.getPassword(),
                userRegistrationRequestBody.getAge()
        );

        return userRepository.addUser(userInfoEntity);

    }

}
