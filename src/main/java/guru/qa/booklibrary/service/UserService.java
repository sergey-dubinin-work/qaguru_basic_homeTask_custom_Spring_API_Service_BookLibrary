package guru.qa.booklibrary.service;

import guru.qa.booklibrary.model.entity.users.UserEntity;
import guru.qa.booklibrary.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity registerUser(String userName, String password, Integer age) {
        UserEntity userEntity = new UserEntity(
                UUID.randomUUID(),
                userName,
                password,
                age
        );

        return userRepository.addUser(userEntity);
    }

}
