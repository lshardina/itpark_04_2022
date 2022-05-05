package RegInsurers.mapper;

import RegInsurers.dto.InsurerDto;
import RegInsurers.model.Insurer;
import RegInsurers.model.Kpr;
import RegInsurers.model.StatementStr;
import RegInsurers.model.Tof;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-05T15:15:27+0500",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class InsurerMapperImpl implements InsurerMapper {

    @Override
    public InsurerDto toDto(Insurer entity) {
        if ( entity == null ) {
            return null;
        }

        InsurerDto insurerDto = new InsurerDto();

        insurerDto.setRegNum( entity.getRegNum() );
        insurerDto.setInn( entity.getInn() );
        insurerDto.setOgrn( entity.getOgrn() );
        insurerDto.setName( entity.getName() );
        insurerDto.setKpr( entityKprKprCode( entity ) );
        Integer stateCode = entityStatementStateCode( entity );
        if ( stateCode != null ) {
            insurerDto.setStatement( String.valueOf( stateCode ) );
        }
        insurerDto.setKps( entityKpsTofCode( entity ) );

        return insurerDto;
    }

    @Override
    public Insurer toEntity(InsurerDto dto) {
        if ( dto == null ) {
            return null;
        }

        Insurer insurer = new Insurer();

        insurer.setKpr( insurerDtoToKpr( dto ) );
        insurer.setStatement( insurerDtoToStatementStr( dto ) );
        insurer.setKps( insurerDtoToTof( dto ) );
        insurer.setRegNum( dto.getRegNum() );
        insurer.setInn( dto.getInn() );
        insurer.setOgrn( dto.getOgrn() );
        insurer.setName( dto.getName() );

        return insurer;
    }

    private Integer entityKprKprCode(Insurer insurer) {
        if ( insurer == null ) {
            return null;
        }
        Kpr kpr = insurer.getKpr();
        if ( kpr == null ) {
            return null;
        }
        Integer kprCode = kpr.getKprCode();
        if ( kprCode == null ) {
            return null;
        }
        return kprCode;
    }

    private Integer entityStatementStateCode(Insurer insurer) {
        if ( insurer == null ) {
            return null;
        }
        StatementStr statement = insurer.getStatement();
        if ( statement == null ) {
            return null;
        }
        Integer stateCode = statement.getStateCode();
        if ( stateCode == null ) {
            return null;
        }
        return stateCode;
    }

    private Integer entityKpsTofCode(Insurer insurer) {
        if ( insurer == null ) {
            return null;
        }
        Tof kps = insurer.getKps();
        if ( kps == null ) {
            return null;
        }
        Integer tofCode = kps.getTofCode();
        if ( tofCode == null ) {
            return null;
        }
        return tofCode;
    }

    protected Kpr insurerDtoToKpr(InsurerDto insurerDto) {
        if ( insurerDto == null ) {
            return null;
        }

        Kpr kpr = new Kpr();

        kpr.setKprCode( insurerDto.getKpr() );

        return kpr;
    }

    protected StatementStr insurerDtoToStatementStr(InsurerDto insurerDto) {
        if ( insurerDto == null ) {
            return null;
        }

        StatementStr statementStr = new StatementStr();

        if ( insurerDto.getStatement() != null ) {
            statementStr.setStateCode( Integer.parseInt( insurerDto.getStatement() ) );
        }

        return statementStr;
    }

    protected Tof insurerDtoToTof(InsurerDto insurerDto) {
        if ( insurerDto == null ) {
            return null;
        }

        Tof tof = new Tof();

        tof.setTofCode( insurerDto.getKps() );

        return tof;
    }
}
