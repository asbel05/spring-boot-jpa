package com.gozhu.dto.equipo;

import lombok.Data;

@Data
public class EquipoRequestDTO {
    private String nombre;
    private String tipoEquipo;
    private Boolean estado;
}
