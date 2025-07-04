package guru.qa.booklibrary.repository;

import guru.qa.booklibrary.model.entity.bookShelf.BookShelfEntity;

import java.util.List;
public interface BookShelfRepository {

    BookShelfEntity addToBookShelf(BookShelfEntity bookShelfEntity);

    List<BookShelfEntity> getBookShelfState();

}
