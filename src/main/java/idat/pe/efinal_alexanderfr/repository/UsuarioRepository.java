package idat.pe.efinal_alexanderfr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import idat.pe.efinal_alexanderfr.entity.*;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByUsername(String username);
}
