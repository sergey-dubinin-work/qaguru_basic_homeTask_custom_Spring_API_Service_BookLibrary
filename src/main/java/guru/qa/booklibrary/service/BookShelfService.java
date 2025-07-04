package guru.qa.booklibrary.service;

import guru.qa.booklibrary.model.entity.bookShelf.BookShelfEntity;
import guru.qa.booklibrary.repository.BookShelfRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookShelfService {

    private final BookShelfRepository bookShelfRepository;

    public BookShelfService(BookShelfRepository bookShelfRepository){
        this.bookShelfRepository = bookShelfRepository;
    }

    public BookShelfEntity addBookToBookShelf(UUID bookId){
        BookShelfEntity bookShelfEntity = new BookShelfEntity(
                UUID.randomUUID(),
                bookId,
                null
        );
        return bookShelfRepository.addToBookShelf(bookShelfEntity);
    }
    public List<BookShelfEntity> getBookShelfState(){
        return bookShelfRepository.getBookShelfState();
    }

}
