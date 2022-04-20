package lesson41.hw;

import com.github.cloudyrock.spring.v5.EnableMongock;
import lesson41.hw.model.Book;
import lesson41.hw.repository.BookRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@EnableMongock
@EnableMongoRepositories
@SpringBootApplication
public class WebFluxBookRunner {

    public static void main(String[] args) {
        SpringApplication.run(WebFluxBookRunner.class, args);
    }

    @Bean
    public RouterFunction<ServerResponse> composedRoutes(BookRepository bookRepository) {
        return route()
                .GET("/api/books", accept(APPLICATION_JSON),
                        request -> ok().contentType(APPLICATION_JSON).body(bookRepository.findAll(), Book.class)
                )
                .DELETE("/api/books/{id}",
                        request -> bookRepository.deleteById(request.pathVariable("id")).flatMap(v -> ok().build())
                ).build();

    }
}