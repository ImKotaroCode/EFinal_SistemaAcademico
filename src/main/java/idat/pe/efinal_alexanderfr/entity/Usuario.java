package idat.pe.efinal_alexanderfr.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(
        name = "usuarios",
        uniqueConstraints = @UniqueConstraint(name = "uk_usuario_username", columnNames = "username")
)
@Data
@AllArgsConstructor @NoArgsConstructor
@Builder
public class Usuario {

    public enum EstadoUsuario { ACTIVO, INACTIVO, SUSPENDIDO }
    public enum RolUsuario { ALUMNO, DOCENTE }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 50)
    @Column(nullable = false, length = 50, unique = true)
    private String username;


    @NotBlank
    @Size(min = 60)
    @Column(nullable = false, length = 255)
    private String password;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 15)
    private EstadoUsuario estado;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private RolUsuario rol;

    @NotBlank
    @Size(max = 100)
    @Column(nullable = false, length = 100)
    private String nombreCompleto;

    @NotBlank
    @Size(max = 100)
    @Column(nullable = false, length = 100)
    private String apellidos;

    @NotNull
    @Column(nullable = false)
    private LocalDateTime feCreacion;

    @PrePersist
    public void prePersist() {
        if (feCreacion == null) feCreacion = LocalDateTime.now();
        if (estado == null) estado = EstadoUsuario.ACTIVO;
    }
}
