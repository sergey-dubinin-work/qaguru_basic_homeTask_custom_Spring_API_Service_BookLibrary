package guru.qa.booklibrary.service;

import guru.qa.booklibrary.domain.entity.bookShelf.BookShelfEntity;
import guru.qa.booklibrary.domain.repository.BookShelfRepository;
import org.springframework.stereotype.Service;

@Service
public class BookShelfService {

    private final BookShelfRepository bookShelfRepository;

    public BookShelfService(BookShelfRepository bookShelfRepository){
        this.bookShelfRepository = bookShelfRepository;
    }

    public BookShelfEntity addBookToBookShelf(BookShelfEntity bookShelfEntity){
        return bookShelfRepository.addToBookShelf(bookShelfEntity);
    }
}
