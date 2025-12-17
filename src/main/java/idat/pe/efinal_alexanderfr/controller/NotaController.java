package idat.pe.efinal_alexanderfr.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import idat.pe.efinal_alexanderfr.dto.request.RegistrarNotaRequest;
import idat.pe.efinal_alexanderfr.entity.Nota;
import idat.pe.efinal_alexanderfr.service.NotaService;

import java.util.List;

@RestController
@RequestMapping("/api/notas")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class NotaController {

    private final NotaService notaService;

    @PostMapping("/registrar")
    public ResponseEntity<Nota> registrar(@Valid @RequestBody RegistrarNotaRequest req) {
        return ResponseEntity.ok(notaService.registrar(req));
    }

    @GetMapping("/mis-notas")
    public ResponseEntity<List<Nota>> misNotas(Authentication auth) {
        return ResponseEntity.ok(notaService.misNotasPorUsername(auth.getName()));
    }
}

