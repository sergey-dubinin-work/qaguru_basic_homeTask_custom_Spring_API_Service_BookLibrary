package guru.qa.booklibrary.dataGenerators;

import guru.qa.booklibrary.api.BookApi;
import guru.qa.booklibrary.dto.books.AddBookRequest;
import guru.qa.booklibrary.dto.books.BookResponse;

public class DataGeneratorBook extends DataGeneratorBase{

    public static AddBookRequest getBookRequestWithOnlyRequiredParameters(){
        return AddBookRequest.builder()
                .authorId(DataGeneratorAuthor.createAuthorWithOnlyRequiredParameters().getId())
                .bookName(faker.starWars().wookieWords())
                .build();
    }

    public static BookResponse createBookWithOnlyRequiredParameters(){
        return BookApi.addBook(getBookRequestWithOnlyRequiredParameters()).as(BookResponse.class);
    }
}
