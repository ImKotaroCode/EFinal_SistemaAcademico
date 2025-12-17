package idat.pe.efinal_alexanderfr.repository;

import idat.pe.efinal_alexanderfr.entity.Nota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotaRepository extends JpaRepository<Nota, Long> {
    List<Nota> findByAlumno_Id(Long alumnoId);

}
