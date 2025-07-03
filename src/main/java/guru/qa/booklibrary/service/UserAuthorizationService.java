package guru.qa.booklibrary.service;

import guru.qa.booklibrary.domain.entity.userTokens.UserTokenEntity;
import guru.qa.booklibrary.domain.entity.users.UserEntity;
import guru.qa.booklibrary.domain.repository.UserRepository;
import guru.qa.booklibrary.domain.repository.UserTokenRepository;
import guru.qa.booklibrary.exception.UserNotAuthorizedException;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static java.util.Objects.isNull;

@Service
public class UserAuthorizationService {

    private final UserRepository userRepository;
    private final UserTokenRepository userTokenRepository;

    public UserAuthorizationService(UserRepository userRepository, UserTokenRepository userTokenRepository){
        this.userRepository = userRepository;
        this.userTokenRepository = userTokenRepository;
    }

    public UserTokenEntity getToken(UserEntity userEntity){

        UserEntity authorizedUser = userRepository.getUserByUsernameAndPassword(userEntity);

        if (isNull(authorizedUser)){
            throw new UserNotAuthorizedException();
        } else {
            return userTokenRepository.addToken(new UserTokenEntity(
                    UUID.randomUUID(),
                    authorizedUser.getId(),
                    UUID.randomUUID().toString().replace("-", "")
                    )
            );
        }

    }

    public UserEntity getUserByBearerTokenHeader(String authHeader){

        if (authHeader != null && authHeader.startsWith("Bearer ")){
            String token = authHeader.substring(7);
            UserTokenEntity userTokenEntity = userTokenRepository.findByToken(token);
            return userRepository.getUserByUserId(userTokenEntity.getUserId());
        } else {
            throw new UserNotAuthorizedException();
        }

    }
}
