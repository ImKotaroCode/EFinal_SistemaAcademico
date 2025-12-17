package idat.pe.efinal_alexanderfr.entity;

import idat.pe.efinal_alexanderfr.entity.Usuario;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "alumnos")
@Data
@AllArgsConstructor @NoArgsConstructor
@Builder
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Min(1)
    @Max(10)
    @Column(nullable = false)
    private Integer ciclo;

    @NotBlank
    @Size(max = 100)
    @Column(nullable = false, length = 100)
    private String carrera;


    @NotNull
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "usuario_id", nullable = false, unique = true,
            foreignKey = @ForeignKey(name = "fk_alumno_usuario"))
    private Usuario usuario;
}
