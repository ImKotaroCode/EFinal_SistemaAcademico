package idat.pe.efinal_alexanderfr.dto.request;


import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RegistrarNotaRequest {

    @NotNull
    private Long alumnoId;

    @NotNull
    private Long asignaturaId;

    @NotNull
    @DecimalMin("0.0")
    @DecimalMax("20.0")
    private Double nota;
}