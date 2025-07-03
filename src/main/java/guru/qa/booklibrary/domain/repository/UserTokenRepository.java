package guru.qa.booklibrary.domain.repository;

import guru.qa.booklibrary.domain.entity.userTokens.UserTokenEntity;

public interface UserTokenRepository {
    UserTokenEntity addToken(UserTokenEntity userTokenEntity);
}
