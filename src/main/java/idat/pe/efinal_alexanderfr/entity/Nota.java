package idat.pe.efinal_alexanderfr.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(
        name = "notas",
        uniqueConstraints = @UniqueConstraint(
                name = "uk_nota_alumno_asignatura",
                columnNames = {"alumno_id", "asignatura_id"}
        )
)
@Data
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Nota {

    public enum EstadoNota { APROBADO, DESAPROBADO }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "alumno_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_nota_alumno"))
    private Alumno alumno;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "asignatura_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_nota_asignatura"))
    private Asignatura asignatura;

    @NotNull
    @DecimalMin("0.0")
    @DecimalMax("20.0")
    @Column(nullable = false)
    private Double nota;


    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 12)
    private EstadoNota estado;

    @NotNull
    @Column(nullable = false)
    private LocalDateTime fechaRegistro;


    @PrePersist
    public void prePersist() {
        if (fechaRegistro == null) fechaRegistro = LocalDateTime.now();

        if (estado == null) {
            estado = (nota != null && nota >= 11.0) ? EstadoNota.APROBADO : EstadoNota.DESAPROBADO;
        }
    }

}
