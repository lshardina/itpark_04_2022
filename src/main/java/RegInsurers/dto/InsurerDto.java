package RegInsurers.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@Getter
@Setter
public class InsurerDto {

    @NotNull
    @Size(min = 10, max = 10)
    private String regNum;


    @NotNull
    @Size(min = 10, max = 12)
    private Long inn;

    @NotNull
    @Size(min = 10, max = 10)
    private Long ogrn;

    @NotEmpty
    @Size(min = 1, max = 255)
    private String name;

    @NotNull
    @Size(min = 1, max = 1)
    private Integer kpr;

    @NotEmpty
    @Size(min = 1, max = 100)
    private String statement;

    @NotNull
    @Size(min = 4, max = 4)
    private Integer kps;

//    @NotEmpty
//    //@Size(min = 1, max = 10)
//    private String dateIn;
//
//    //@Size(min = 1, max = 10)
//    private String dateOut;

    public String getRegNumStr() {
        return String.format("insurer_%li", regNum);
    }
}
