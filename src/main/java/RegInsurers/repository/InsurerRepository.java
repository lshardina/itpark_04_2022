package RegInsurers.repository;

import RegInsurers.model.Insurer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "insurer")
public interface InsurerRepository extends JpaRepository <Insurer, Long> {
}
