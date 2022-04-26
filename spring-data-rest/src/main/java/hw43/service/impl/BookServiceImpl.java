package hw43.service.impl;

import hw43.dto.BookDto;
import hw43.dto.BookPageDto;
import hw43.mapper.BookMapper;
import hw43.model.Book;
import hw43.repository.BookRepository;
import hw43.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Override
    @Transactional(readOnly = true)
    public List<BookDto> findAll() {
        return bookMapper.toDtos(bookRepository.findAll());
    }

    @Override
    public BookPageDto getPage(Pageable pageable) {
        Page<Book> currentPage = bookRepository.findAll(pageable);
        return new BookPageDto(bookMapper.toDtos(currentPage.getContent()),
                currentPage.getNumber(),
                currentPage.getTotalPages(),
                currentPage.hasNext(),
                currentPage.hasPrevious());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<BookDto> getById(@NotEmpty int bookId) {
        return bookMapper.toOptionalDto(bookRepository.findById(bookId));
    }

    @Override
    @Transactional
    public BookDto save(@Valid BookDto book) {
        return bookMapper.toDto(bookRepository
                .save(bookMapper.toEntity(book)));
    }

    @Override
    @Transactional
    public void deleteById(@NotEmpty int bookId) {
        bookRepository.deleteById(bookId);
    }

    @Override
    public void delete(@Valid Book book) {
        bookRepository.delete(book);
    }


}
