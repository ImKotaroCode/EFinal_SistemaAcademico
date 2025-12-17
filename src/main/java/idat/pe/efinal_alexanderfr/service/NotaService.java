package idat.pe.efinal_alexanderfr.service;

import org.springframework.stereotype.Service;


import lombok.RequiredArgsConstructor;
import idat.pe.efinal_alexanderfr.dto.request.RegistrarNotaRequest;
import idat.pe.efinal_alexanderfr.entity.Nota;
import idat.pe.efinal_alexanderfr.repository.*;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotaService {

    private final NotaRepository notaRepo;
    private final AlumnoRepository alumnoRepo;
    private final AsignaturaRepository asignaturaRepo;

    public Nota registrar(RegistrarNotaRequest req) {
        var alumno = alumnoRepo.findById(req.getAlumnoId())
                .orElseThrow(() -> new RuntimeException("Alumno no existe"));

        var asignatura = asignaturaRepo.findById(req.getAsignaturaId())
                .orElseThrow(() -> new RuntimeException("Asignatura no existe"));

        Nota n = Nota.builder()
                .alumno(alumno)
                .asignatura(asignatura)
                .nota(req.getNota())
                .build();

        return notaRepo.save(n);
    }

    public List<Nota> misNotasPorUsername(String username) {
        var alumno = alumnoRepo.findByUsuario_Username(username)
                .orElseThrow(() -> new RuntimeException("Alumno asociado no encontrado"));
        return notaRepo.findByAlumno_Id(alumno.getId());
    }
}
