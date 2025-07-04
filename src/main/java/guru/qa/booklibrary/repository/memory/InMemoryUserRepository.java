package guru.qa.booklibrary.repository.memory;

import guru.qa.booklibrary.model.entity.users.UserEntity;
import guru.qa.booklibrary.repository.UserRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
@Profile("dev")
public class InMemoryUserRepository implements UserRepository {

    private static final List<UserEntity> USERS = new ArrayList<>();

    @Override
    public UserEntity addUser(UserEntity userEntity){
        USERS.add(userEntity);

        return userEntity;
    }

    @Override
    public UserEntity getUserByUsernameAndPassword(String username, String password) {
        return USERS.stream()
                .filter(
                        user -> user.getUserName().equals(username)
                        && user.getPassword().equals(password)
                )
                .findFirst().orElse(null);
    }

    @Override
    public UserEntity getUserByUserId(UUID id) {
        return USERS.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

}
