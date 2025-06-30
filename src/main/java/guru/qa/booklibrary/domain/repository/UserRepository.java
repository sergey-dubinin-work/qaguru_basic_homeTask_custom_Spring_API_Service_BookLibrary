package guru.qa.booklibrary.domain.repository;

import guru.qa.booklibrary.dto.users.UserRegistrationRequest;
import guru.qa.booklibrary.domain.entity.users.UserInfoEntity;

public interface UserRepository {

    UserInfoEntity addUser(UserRegistrationRequest userRegistrationRequestBody);

}
