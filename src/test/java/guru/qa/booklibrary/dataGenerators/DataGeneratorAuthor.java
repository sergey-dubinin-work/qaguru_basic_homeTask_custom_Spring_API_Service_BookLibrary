package guru.qa.booklibrary.dataGenerators;

import guru.qa.booklibrary.api.AuthorApi;
import guru.qa.booklibrary.model.dto.authors.AddAuthorRequest;
import guru.qa.booklibrary.model.dto.authors.AuthorResponse;

public class DataGeneratorAuthor extends DataGeneratorBase{

    public static AddAuthorRequest getAuthorRequestWithOnlyRequiredParameters(){
        return AddAuthorRequest.builder()
                .authorName(faker.name().fullName())
                .build();
    }

    public static AuthorResponse createAuthorWithOnlyRequiredParameters(){
        return AuthorApi.addAuthor(getAuthorRequestWithOnlyRequiredParameters())
                .as(AuthorResponse.class);

    }

}
