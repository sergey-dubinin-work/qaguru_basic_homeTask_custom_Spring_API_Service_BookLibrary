package guru.qa.booklibrary.domain.repository;

import guru.qa.booklibrary.domain.entity.bookShelf.BookShelfEntity;

public interface BookShelfRepository {

    BookShelfEntity addToBookShelf(BookShelfEntity bookShelfEntity);

}
