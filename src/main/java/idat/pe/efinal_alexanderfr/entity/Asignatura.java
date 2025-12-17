package idat.pe.efinal_alexanderfr.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "asignaturas")
@Data
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Asignatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 100)
    @Column(nullable = false, length = 100)
    private String nombre;

    @NotNull
    @Min(1)
    @Max(6)
    @Column(nullable = false)
    private Integer creditos;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "docente_id", foreignKey = @ForeignKey(name = "fk_asignatura_docente"))
    private Docente docente;
}
