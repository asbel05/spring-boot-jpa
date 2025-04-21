package com.gozhu.dto.equipo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EquipoResponseDTO {
    private Long id;
    private String nombre;
    private String tipoEquipo;
    private Boolean estado;
}
