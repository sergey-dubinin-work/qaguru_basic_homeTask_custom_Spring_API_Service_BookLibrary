package guru.qa.booklibrary.domain.repository;

import guru.qa.booklibrary.domain.entity.users.UserEntity;

public interface UserRepository {

    UserEntity addUser(UserEntity userEntity);

}
