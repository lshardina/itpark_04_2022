package RegInsurers.service.impl;

import RegInsurers.dto.InsurerDto;
import RegInsurers.dto.InsurerPageDto;
import RegInsurers.mapper.InsurerMapper;
import RegInsurers.model.Insurer;
import RegInsurers.repository.InsurerRepository;
import RegInsurers.service.InsurerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InsurerServiceImpl implements InsurerService {

    private final InsurerRepository insurerRepository;
    private final InsurerMapper insurerMapper;

    @Override
    @Transactional(readOnly = true)
    public List<InsurerDto> findAll() {
        return insurerMapper.toDtos(insurerRepository.findAll());
    }

    @Override
    public InsurerPageDto getPage(Pageable pageable) {
        Page<Insurer> currentPage = insurerRepository.findAll(pageable);
        return new InsurerPageDto(insurerMapper.toDtos(currentPage.getContent()),
                currentPage.getNumber(),
                currentPage.getTotalPages(),
                currentPage.hasNext(),
                currentPage.hasPrevious());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<InsurerDto> getById(@NotEmpty Long regNum) {
        return insurerMapper.toOptionalDto(insurerRepository.findById(regNum));
    }

    @Override
    @Transactional
    public InsurerDto save(@Valid InsurerDto insurerDto) {
        return insurerMapper.toDto(insurerRepository
                .save(insurerMapper.toEntity(insurerDto)));
    }

    @Override
    @Transactional
    public void deleteById(@NotEmpty Long regNum) {
        insurerRepository.deleteById(regNum);
    }

    @Override
    public void delete(@Valid Insurer insurer) {
        insurerRepository.delete(insurer);
    }


}
