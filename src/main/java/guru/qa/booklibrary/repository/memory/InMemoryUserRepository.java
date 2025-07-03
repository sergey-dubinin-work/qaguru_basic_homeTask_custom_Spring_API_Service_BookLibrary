package guru.qa.booklibrary.repository.memory;

import guru.qa.booklibrary.domain.entity.users.UserEntity;
import guru.qa.booklibrary.domain.repository.UserRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Profile("dev")
public class InMemoryUserRepository implements UserRepository {

    private static final List<UserEntity> USERS = new ArrayList<>();

    @Override
    public UserEntity addUser(UserEntity userEntity){
        USERS.add(userEntity);

        return userEntity;
    }

}
