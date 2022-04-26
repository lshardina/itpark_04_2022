package hw43.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class BookDto {

    @NotNull
    @Size(min = 1, max = 5)
    private int id;

    private String isbn;

    @NotNull
    @Size(min = 1, max = 200)
    private String name;

    @NotNull
    @Size(min = 1, max = 100)
    private String autor;

    private String market;

    private int size;

    public String getIdStr() {
        return String.format("book_%d", id);
    }
}
