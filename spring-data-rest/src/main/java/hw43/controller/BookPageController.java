package hw43.controller;

import hw43.dto.BookDto;
import hw43.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Validated
@Controller
@RequiredArgsConstructor
public class BookPageController {

    private final BookService bookService;

    @GetMapping("/books")
    public String index() {
        return "book/books";
    }

    @GetMapping("/book/add")
    public String newBook() {
        return "book/book";
    }

    @GetMapping("/book/edit")
    public String currentBook(@RequestParam("id") Integer bookId, Model model) {
        BookDto currentBook = bookService.getById(bookId)
                .orElseThrow(() -> new IllegalArgumentException("Non existed book"));
        model.addAttribute("book", currentBook);
        return "book/book";
    }

    @PostMapping("/book/save")
    public String saveBook(BookDto book) {
        bookService.save(book);
        return "redirect:/books";
    }
}
