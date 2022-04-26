package hw43.mapper;

import hw43.dto.BookDto;
import hw43.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Mapper
public interface BookMapper {

    @Mapping(target = "id", source = "entity.id")
    @Mapping(target = "isbn", source = "entity.isbn")
    @Mapping(target = "name", source = "entity.name")
    @Mapping(target = "autor", source = "entity.autor")
    @Mapping(target = "market", source = "entity.market")
    @Mapping(target = "size", source = "entity.size")
    BookDto toDto(Book entity);

    @Mapping(target = "id", source = "dto.id")
    @Mapping(target = "isbn", source = "dto.isbn")
    @Mapping(target = "name", source = "dto.name")
    @Mapping(target = "autor", source = "dto.autor")
    @Mapping(target = "market", source = "dto.market")
    @Mapping(target = "size", source = "dto.size")
    Book toEntity(BookDto dto);

    default List<BookDto> toDtos(List<Book> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }

    default Optional<BookDto> toOptionalDto(Optional<Book> entity) {
        return entity.map(this::toDto);
    }

}
