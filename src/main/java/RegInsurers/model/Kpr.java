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
@Table (name = "KPR")
@NoArgsConstructor
@AllArgsConstructor
public class Kpr {

    @Id
    @NotNull
    @Column(name = "kpr_code", unique = true)
    private Integer kprCode;

    @NotEmpty
    @Column(name = "kpr_Name")
    private String kprName;
}
