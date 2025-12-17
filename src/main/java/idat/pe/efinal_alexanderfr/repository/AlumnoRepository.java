package idat.pe.efinal_alexanderfr.repository;

import idat.pe.efinal_alexanderfr.entity.Alumno;
import org.hibernate.boot.models.JpaAnnotations;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
    Optional<Alumno> findByUsuario_Username(String username);

}
