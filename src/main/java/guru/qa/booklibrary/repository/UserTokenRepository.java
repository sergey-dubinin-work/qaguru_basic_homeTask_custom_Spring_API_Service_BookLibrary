package guru.qa.booklibrary.repository;

import guru.qa.booklibrary.model.entity.userTokens.UserTokenEntity;

public interface UserTokenRepository {

    UserTokenEntity addToken(UserTokenEntity userTokenEntity);

    UserTokenEntity findByToken(String userToken);

}
