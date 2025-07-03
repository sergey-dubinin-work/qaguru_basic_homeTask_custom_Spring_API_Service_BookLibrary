package guru.qa.booklibrary.repository.memory;

import guru.qa.booklibrary.model.entity.userTokens.UserTokenEntity;
import guru.qa.booklibrary.repository.UserTokenRepository;
import guru.qa.booklibrary.exception.UserNotAuthorizedException;
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

    @Override
    public UserTokenEntity findByToken(String userToken) {
            return tokens.stream()
                    .filter(userTokenEntity -> userTokenEntity.getToken().equals(userToken))
                    .findFirst().orElseThrow(UserNotAuthorizedException::new);
    }

}
