package guru.qa.booklibrary.controller;

import guru.qa.booklibrary.model.dto.users.UserAuthRequest;
import guru.qa.booklibrary.model.dto.users.UserAuthResponse;
import guru.qa.booklibrary.model.dto.users.UserInfoResponse;
import guru.qa.booklibrary.model.dto.users.UserRegistrationRequest;
import guru.qa.booklibrary.model.mapper.UserAuthMapper;
import guru.qa.booklibrary.model.mapper.UserMapper;
import guru.qa.booklibrary.service.UserAuthorizationService;
import guru.qa.booklibrary.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Tag(name = "User", description = "Operations with users")
public class UserController {

    private final UserService userService;
    private final UserAuthorizationService userAuthorizationService;
    private final UserMapper userMapper;
    private final UserAuthMapper userAuthMapper;

    public UserController(UserService userService, UserAuthorizationService userAuthorizationService, UserMapper userMapper, UserAuthMapper userAuthMapper) {
        this.userService = userService;
        this.userAuthorizationService = userAuthorizationService;
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
                userAuthorizationService.getToken(userAuthMapper.fromRequest(userLogInData))
        );
    }

    @GetMapping("/userInfo")
    @Operation(summary = "Getting user info")
    public UserInfoResponse getUserInfo(@RequestHeader("Authorization") String authHeader){
        return userMapper.toResponse(
                userAuthorizationService.getUserByBearerTokenHeader(authHeader)
        );
    }

}