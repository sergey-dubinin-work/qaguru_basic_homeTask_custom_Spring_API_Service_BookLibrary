package guru.qa.booklibrary.controller;

import guru.qa.booklibrary.dto.users.UserInfoResponse;
import guru.qa.booklibrary.dto.users.UserRegistrationRequest;
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
    public UserInfoResponse registerUser(@RequestBody UserRegistrationRequest userRegistrationRequest){
        return new UserInfoResponse(userRepository.addUser(userRegistrationRequest));
    }

}
