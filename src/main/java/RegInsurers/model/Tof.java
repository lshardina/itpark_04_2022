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

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TOF")
@Data
public class Tof {

    @Id
    @NotNull
    @Column(name = "tof_code", unique = true)
    private Integer tofCode;

    @NotEmpty
    @Column(name = "tof_name")
    private String tofName;
}
