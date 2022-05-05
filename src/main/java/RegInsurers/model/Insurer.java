package RegInsurers.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "INSURERS")
public class Insurer {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "code", nullable = false, unique = true)
//    private Integer code;

    @Id
    @NotNull
 //   @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reg_Num", nullable = false, unique = true)
    private String regNum;

    @NotEmpty
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Column(name = "inn", nullable = false)
    private Long inn;

    @NotNull
    @Column(name = "ogrn", nullable = false)
    private Long ogrn;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "kpr_code", nullable = false)
    private Kpr kpr;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "state_code", nullable = false)
    private StatementStr statement;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "kps_code", nullable = false)
    private Tof kps;

    public Insurer(String regNum, String name, Long inn, Long ogrn, Kpr kpr, StatementStr st, Tof kps) {
        this.regNum = kps.toString() + regNum;
        this.name = name;
        this.inn = inn;
        this.ogrn = ogrn;
        this.kpr = kpr;
        this.statement = st;
        this.kps = kps;
    }


//    @NotEmpty
//    @Column(name = "date_in")
//    private String dateIn;
//
//    @Column(name = "date_out")
//    private  String dateOut;

//    @OneToMany(mappedBy = "insurer", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<InsurerOkved> okveds;



}
