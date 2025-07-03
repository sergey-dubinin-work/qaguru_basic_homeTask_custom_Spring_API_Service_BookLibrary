package guru.qa.booklibrary.repository;

import guru.qa.booklibrary.model.entity.bookShelf.BookShelfEntity;

public interface BookShelfRepository {

    BookShelfEntity addToBookShelf(BookShelfEntity bookShelfEntity);

}
