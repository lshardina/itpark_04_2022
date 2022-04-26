package hw43.service;

import hw43.dto.BookDto;
import hw43.dto.BookPageDto;
import hw43.model.Book;
import org.springframework.data.domain.Pageable;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Optional;

public interface BookService {

    List<BookDto> findAll();

    BookPageDto getPage(Pageable pageable);

    Optional<BookDto> getById(@NotEmpty int bookId);

    BookDto save(@Valid BookDto book);

    void deleteById(@NotEmpty int bookId);

    void delete(@Valid Book book);
}
