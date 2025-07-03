package guru.qa.booklibrary.controller;

import guru.qa.booklibrary.dto.users.UserAuthRequest;
import guru.qa.booklibrary.dto.users.UserAuthResponse;
import guru.qa.booklibrary.dto.users.UserInfoResponse;
import guru.qa.booklibrary.dto.users.UserRegistrationRequest;
import guru.qa.booklibrary.mapper.UserAuthMapper;
import guru.qa.booklibrary.mapper.UserMapper;
import guru.qa.booklibrary.service.AuthorizationService;
import guru.qa.booklibrary.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Tag(name = "User", description = "Operations with users")
public class UserController {

    private final UserService userService;
    private final AuthorizationService authorizationService;
    private final UserMapper userMapper;
    private final UserAuthMapper userAuthMapper;

    public UserController(UserService userService, AuthorizationService authorizationService, UserMapper userMapper, UserAuthMapper userAuthMapper) {
        this.userService = userService;
        this.authorizationService = authorizationService;
        this.userMapper = userMapper;
        this.userAuthMapper = userAuthMapper;
    }

    @PostMapping("/register")
    @Operation(summary = "User registration")
    public UserInfoResponse registerUser(@RequestBody UserRegistrationRequest userRegistrationRequest){
        return userMapper.toResponse(
                userService.registerUser(userMapper.fromResponse(userRegistrationRequest))
        );
    }


    @PostMapping("/getToken")
    @Operation(summary = "Authorization and getting token")
    public UserAuthResponse authorizeUser(@RequestBody UserAuthRequest userLogInData) {
        return userAuthMapper.toResponse(
                authorizationService.getToken(userAuthMapper.fromRequest(userLogInData))
        );
    }

}