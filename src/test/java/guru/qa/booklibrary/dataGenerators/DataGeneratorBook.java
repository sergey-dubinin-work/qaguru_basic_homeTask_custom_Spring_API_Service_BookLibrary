package guru.qa.booklibrary.dataGenerators;

import guru.qa.booklibrary.api.BookApi;
import guru.qa.booklibrary.model.dto.books.AddBookRequest;
import guru.qa.booklibrary.model.dto.books.BookResponse;

public class DataGeneratorBook extends DataGeneratorBase{

    public static AddBookRequest getBookRequestWithOnlyRequiredParameters(String token){
        return AddBookRequest.builder()
                .authorId(DataGeneratorAuthor.createAuthorWithOnlyRequiredParameters(token).getId())
                .bookName(faker.starWars().wookieWords())
                .build();
    }

    public static BookResponse createBookWithOnlyRequiredParameters(String token){
        return BookApi.addBook(token, getBookRequestWithOnlyRequiredParameters(token)).as(BookResponse.class);
    }
}
