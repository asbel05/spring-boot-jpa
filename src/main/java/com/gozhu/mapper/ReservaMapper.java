package com.gozhu.mapper;

import com.gozhu.dto.reserva.ReservaRequestDTO;
import com.gozhu.dto.reserva.ReservaResponseDTO;
import com.gozhu.entity.Equipo;
import com.gozhu.entity.Reserva;
import com.gozhu.entity.Usuario;
import org.springframework.stereotype.Component;

@Component
public class ReservaMapper {
    public ReservaResponseDTO toDTO(Reserva reserva) {
        return ReservaResponseDTO.builder()
                .id(reserva.getId())
                .fecha(reserva.getFecha())
                .horaInicio(reserva.getHoraInicio())
                .horaFin(reserva.getHoraFin())
                .idEquipo(reserva.getEquipo().getId())
                .nombre(reserva.getEquipo().getNombre())
                .tipoEquipo(reserva.getEquipo().getTipoEquipo())
                .idUsuario(reserva.getUsuario().getId())
                .nombreCompleto(reserva.getUsuario().getNombreCompleto())
                .build();
    }

    public Reserva toEntity(ReservaRequestDTO requestDTO, Equipo equipo, Usuario usuario) {
        return Reserva.builder()
                .fecha(requestDTO.getFecha())
                .horaInicio(requestDTO.getHoraInicio())
                .horaFin(requestDTO.getHoraFin())
                .equipo(equipo)
                .usuario(usuario)
                .build();
    }
}
