package guru.qa.booklibrary.service;

import guru.qa.booklibrary.exception.NoAvailableBookException;
import guru.qa.booklibrary.exception.NotFoundException;
import guru.qa.booklibrary.model.entity.bookShelf.BookShelfEntity;
import guru.qa.booklibrary.repository.BookRepository;
import guru.qa.booklibrary.repository.BookShelfRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static java.util.Objects.isNull;

@Service
public class BookShelfService {

    private final BookRepository bookRepository;
    private final BookShelfRepository bookShelfRepository;

    public BookShelfService(BookRepository bookRepository, BookShelfRepository bookShelfRepository) {
        this.bookRepository = bookRepository;
        this.bookShelfRepository = bookShelfRepository;
    }

    public BookShelfEntity addBookToBookShelf(UUID bookId) {
        BookShelfEntity bookShelfEntity = new BookShelfEntity(
                UUID.randomUUID(),
                bookId,
                null
        );
        return bookShelfRepository.addToBookShelf(bookShelfEntity);
    }

    public BookShelfEntity rentABook(UUID userId, UUID bookId) {

        if (isNull(bookRepository.getBookById(bookId))){
            throw new NotFoundException();
        }

        BookShelfEntity shelfEntityToRent = bookShelfRepository.getFirstFreeBook(bookId);

        if (isNull(shelfEntityToRent)) {
            throw new NoAvailableBookException();
        }

        return bookShelfRepository.setRenterToBookShelfEntity(shelfEntityToRent.getId(), userId);
    }

    public BookShelfEntity returnABook(UUID userId, UUID bookId) {
        if (isNull(bookRepository.getBookById(bookId))){
            throw new NotFoundException();
        }

        BookShelfEntity shelfEntityToReturn = bookShelfRepository.getBookRentedByUser(bookId, userId);

        if (isNull(shelfEntityToReturn)){
            throw new NotFoundException();
        }

        return bookShelfRepository.setRenterToBookShelfEntity(shelfEntityToReturn.getId(), null);
    }

    public List<BookShelfEntity> getBookShelfState() {
        return bookShelfRepository.getBookShelfState();
    }

}
