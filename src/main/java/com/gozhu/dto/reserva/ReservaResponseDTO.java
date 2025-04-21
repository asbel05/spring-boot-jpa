package com.gozhu.dto.reserva;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
public class ReservaResponseDTO {
    private Long id;
    private LocalDate fecha;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private Long idEquipo;
    private String nombre;
    private String tipoEquipo;
    private Long idUsuario;
    private String nombreCompleto;
}
