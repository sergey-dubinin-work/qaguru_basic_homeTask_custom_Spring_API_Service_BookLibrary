package guru.qa.booklibrary.repository.memory;

import guru.qa.booklibrary.domain.entity.users.UserInfoEntity;
import guru.qa.booklibrary.domain.repository.UserRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Profile("dev")
public class InMemoryUserRepository implements UserRepository {

    private static final List<UserInfoEntity> USERS = new ArrayList<>();

    @Override
    public UserInfoEntity addUser(UserInfoEntity userInfoEntity){
        USERS.add(userInfoEntity);

        return userInfoEntity;
    }

}
