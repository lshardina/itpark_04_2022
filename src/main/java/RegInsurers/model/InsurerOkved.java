package RegInsurers.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Table (name ="INSURER_OKVED")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class InsurerOkved {

    @Id
    @Column(name = "id")
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "okved_code", nullable = false)
    public Okved okvedCode;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "ins_reg_num", nullable = false)
    public Insurer insRegNum;


}


