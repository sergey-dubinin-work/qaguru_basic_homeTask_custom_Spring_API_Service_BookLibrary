package guru.qa.booklibrary.service;

import guru.qa.booklibrary.model.entity.users.UserEntity;
import guru.qa.booklibrary.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public UserEntity registerUser(UserEntity userEntity){
        return userRepository.addUser(userEntity);
    }

}
