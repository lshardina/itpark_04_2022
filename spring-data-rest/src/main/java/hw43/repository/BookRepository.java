package hw43.repository;

import hw43.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "books")
public interface BookRepository extends JpaRepository <Book, Integer> {
}
