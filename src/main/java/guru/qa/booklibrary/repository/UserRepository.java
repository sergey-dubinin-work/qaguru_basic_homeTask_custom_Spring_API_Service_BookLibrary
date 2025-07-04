package guru.qa.booklibrary.repository;

import guru.qa.booklibrary.model.entity.users.UserEntity;

import java.util.UUID;

public interface UserRepository {

    UserEntity addUser(UserEntity userEntity);

    UserEntity getUserByUsernameAndPassword(String userName, String password);

    UserEntity getUserByUserId(UUID id);
}
