package com.gozhu.mapper;

import com.gozhu.dto.equipo.EquipoRequestDTO;
import com.gozhu.dto.equipo.EquipoResponseDTO;
import com.gozhu.entity.Equipo;
import org.springframework.stereotype.Component;

@Component
public class EquipoMapper {
    public EquipoResponseDTO toDTO(Equipo equipo) {
        return EquipoResponseDTO.builder()
                .id(equipo.getId())
                .nombre(equipo.getNombre())
                .tipoEquipo(equipo.getTipoEquipo())
                .estado(equipo.getEstado())
                .build();
    }

    public Equipo toEntity(EquipoRequestDTO requestDTO) {
        return Equipo.builder()
                .nombre(requestDTO.getNombre())
                .tipoEquipo(requestDTO.getTipoEquipo())
                .estado(requestDTO.getEstado())
                .build();
    }
}
