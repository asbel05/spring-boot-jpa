package com.gozhu.service;

import com.gozhu.dto.equipo.EquipoRequestDTO;
import com.gozhu.dto.equipo.EquipoResponseDTO;
import com.gozhu.entity.Equipo;

import java.util.List;

public interface EquipoService {
    List<EquipoResponseDTO> listar();
    EquipoResponseDTO guardar(EquipoRequestDTO requestDTO);
    EquipoResponseDTO obtenerPorId(Long id);
    void eliminar(Long id);
    Equipo obtenerEntidadPorId(Long id);
}
