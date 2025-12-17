package idat.pe.efinal_alexanderfr.config;

import idat.pe.efinal_alexanderfr.entity.*;
import idat.pe.efinal_alexanderfr.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InitData implements CommandLineRunner {

    private final UsuarioRepository usuarioRepo;
    private final AlumnoRepository alumnoRepo;
    private final DocenteRepository docenteRepo;
    private final AsignaturaRepository asignaturaRepo;
    private final PasswordEncoder encoder;

    @Override
    public void run(String... args) {

        Docente docente = docenteRepo.findAll().stream().findFirst().orElse(null);

        if (usuarioRepo.findByUsername("docente1").isEmpty()) {
            Usuario uDoc = Usuario.builder()
                    .username("docente1")
                    .password(encoder.encode("123456"))
                    .rol(Usuario.RolUsuario.DOCENTE)
                    .estado(Usuario.EstadoUsuario.ACTIVO)
                    .nombreCompleto("Junior")
                    .apellidos("Tello Trujillo")
                    .build();

            docente = Docente.builder()
                    .especialidad("Desarrollo de Servicios Web 2")
                    .usuario(uDoc)
                    .build();

            docente = docenteRepo.save(docente);
        }

        if (usuarioRepo.findByUsername("alumno1").isEmpty()) {
            Usuario uAl = Usuario.builder()
                    .username("alumno1")
                    .password(encoder.encode("123456"))
                    .rol(Usuario.RolUsuario.ALUMNO)
                    .estado(Usuario.EstadoUsuario.ACTIVO)
                    .nombreCompleto("Alexander")
                    .apellidos("Ferrua Rúa")
                    .build();

            Alumno alumno = Alumno.builder()
                    .ciclo(5)
                    .carrera("Desarrollo de Sistemas de Informacion")
                    .usuario(uAl)
                    .build();

            alumnoRepo.save(alumno);
        }


        if (asignaturaRepo.count() == 0 && docente != null) {

            Asignatura a1 = Asignatura.builder()
                    .nombre("Desarrollo de Sistemas de Informacion")
                    .creditos(4)
                    .docente(docente)
                    .build();

            Asignatura a2 = Asignatura.builder()
                    .nombre("Base de Datos")
                    .creditos(3)
                    .docente(docente)
                    .build();

            asignaturaRepo.save(a1);
            asignaturaRepo.save(a2);
        }

    }
}

