package lesson41.hw.controller;

import lesson41.hw.dto.BookDto;
import lesson41.hw.mapper.BookMapper;
import lesson41.hw.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@Validated
@Controller
@RequiredArgsConstructor
public class BookPageController {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @GetMapping("/books")
    public String index() {
        return "book/books";
    }

    @GetMapping("/book/add")
    public String newBook() {
        return "book/book";
    }

    @GetMapping("/book/edit")
    public String currentBook(@RequestParam("id") String bookId, Model model) {
        model.addAttribute("book", bookRepository.findById(bookId));
        return "book/book";
    }

    @PostMapping("/book/save")
    public Mono<String> saveBook(@Valid BookDto book) {
        return bookRepository.save(bookMapper.toEntity(book)).map(g ->
                "redirect:/books"
        );
    }

}
