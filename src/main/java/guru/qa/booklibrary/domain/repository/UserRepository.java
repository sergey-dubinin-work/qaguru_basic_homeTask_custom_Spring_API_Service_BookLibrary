package guru.qa.booklibrary.domain.repository;

import guru.qa.booklibrary.domain.entity.users.UserEntity;

import java.util.UUID;

public interface UserRepository {

    UserEntity addUser(UserEntity userEntity);

    UserEntity getUserByUsernameAndPassword(UserEntity userEntity);

    UserEntity getUserByUserId(UUID id);
}
