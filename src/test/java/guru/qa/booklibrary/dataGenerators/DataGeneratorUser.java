package guru.qa.booklibrary.dataGenerators;

import guru.qa.booklibrary.dto.users.UserRegistrationRequest;

public class DataGeneratorUser extends DataGeneratorBase{

    public static UserRegistrationRequest getUserRegistrationRequestWithOnlyRequiredParameters(){
        return UserRegistrationRequest.builder()
                .userName(faker.name().fullName())
                .password(faker.internet().password())
                .age(faker.random().nextInt())
                .build();
    }

}
