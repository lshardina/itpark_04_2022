package RegInsurers.service;


import RegInsurers.dto.InsurerDto;
import RegInsurers.dto.InsurerPageDto;
import RegInsurers.model.Insurer;
import org.springframework.data.domain.Pageable;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Optional;

public interface InsurerService {

    List<InsurerDto> findAll();

    InsurerPageDto getPage(Pageable pageable);

    Optional<InsurerDto> getById(@NotEmpty Long regNum);

    InsurerDto save(@Valid InsurerDto insurer);

    void deleteById(@NotEmpty Long regNum);

    void delete(@Valid Insurer insurer);
}
