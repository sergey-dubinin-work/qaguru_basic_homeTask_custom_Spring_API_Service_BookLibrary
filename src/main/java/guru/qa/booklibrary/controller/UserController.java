package guru.qa.booklibrary.controller;

import guru.qa.booklibrary.domain.users.UserInfo;
import guru.qa.booklibrary.domain.users.UserRegistration;
import guru.qa.booklibrary.repository.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Tag(name = "User", description = "Операции с пользователями")
public class UserController {

    private final UserRepository userRepository = new UserRepository();

    @PostMapping("/register")
    @Operation(summary = "Регистрация нового пользователя")
    public UserInfo registerUser(@RequestBody UserRegistration userRegistrationData){
        return userRepository.addUser(userRegistrationData);
    }

}
