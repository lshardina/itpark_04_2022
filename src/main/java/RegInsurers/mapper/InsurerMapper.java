package RegInsurers.mapper;


import RegInsurers.dto.InsurerDto;
import RegInsurers.model.Insurer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Mapper
public interface InsurerMapper {

    @Mapping(target = "regNum", source = "entity.regNum")
    @Mapping(target = "inn", source = "entity.inn")
    @Mapping(target = "ogrn", source = "entity.ogrn")
    @Mapping(target = "name", source = "entity.name")
    @Mapping(target = "kpr", source = "entity.kpr.kprCode")
    @Mapping(target = "statement", source = "entity.statement.stateCode")
    @Mapping(target = "kps", source = "entity.kps.tofCode")
//    @Mapping(target = "dateIn", source = "entity.dateIn")
//    @Mapping(target = "dateOut", source = "entity.dateOut")
    InsurerDto toDto(Insurer entity);

    @Mapping(target = "regNum", source = "dto.regNum")
    @Mapping(target = "inn", source = "dto.inn")
    @Mapping(target = "ogrn", source = "dto.ogrn")
    @Mapping(target = "name", source = "dto.name")
    @Mapping(target = "kpr.kprCode", source = "dto.kpr")
    @Mapping(target = "statement.stateCode", source = "dto.statement")
    @Mapping(target = "kps.tofCode", source = "dto.kps")
//    @Mapping(target = "dateIn", source = "dto.dateIn")
//    @Mapping(target = "dateOut", source = "dto.dateOut")
    Insurer toEntity(InsurerDto dto);

    default List<InsurerDto> toDtos(List<Insurer> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }

    default Optional<InsurerDto> toOptionalDto(Optional<Insurer> entity) {
        return entity.map(this::toDto);
    }

}
