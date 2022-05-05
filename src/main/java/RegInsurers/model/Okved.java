package RegInsurers.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "OKVED")
public class Okved {

    @Id
    @NotEmpty
    @Column(name = "okved_code", unique = true)
    private String okvedCode;

    @NotEmpty
    @Column(name = "okved_name")
    private String okvedName;

    @NotEmpty
    @Column(name = "okved_class")
    private Integer okvedClass;

    @NotEmpty
    @Column(name = "okved_tarif")
    private Double okvedTarif;

}
