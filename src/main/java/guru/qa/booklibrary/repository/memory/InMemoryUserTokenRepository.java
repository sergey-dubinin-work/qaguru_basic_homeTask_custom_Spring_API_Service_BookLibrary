package guru.qa.booklibrary.repository.memory;

import guru.qa.booklibrary.domain.entity.userTokens.UserTokenEntity;
import guru.qa.booklibrary.domain.repository.UserTokenRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Profile("dev")
public class InMemoryUserTokenRepository implements UserTokenRepository {

    private final List<UserTokenEntity> tokens = new ArrayList<>();

    @Override
    public UserTokenEntity addToken(UserTokenEntity userTokenEntity) {
        tokens.add(userTokenEntity);
        return userTokenEntity;
    }

}
