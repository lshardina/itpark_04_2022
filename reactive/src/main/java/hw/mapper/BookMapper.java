package hw.mapper;

import hw.dto.BookDto;
import hw.model.Book;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Mapper
public interface BookMapper {

    BookDto toDto(Book entity);

    Book toEntity(BookDto dto);

    default List<BookDto> toDtos(List<Book> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }

    default Optional<BookDto> toOptionalDto(Optional<Book> entity) {
        return entity.map(this::toDto);
    }

}
