package RegInsurers.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "STATEMENT_INS")
public class StatementStr {

    @Id
    @NotNull
    @Column(name = "state_code", unique = true)
    private Integer stateCode;

    @NotEmpty
    @Column(name = "state_name")
    private String stateName;
}
