package com.gozhu.service;

import com.gozhu.dto.reserva.ReservaRequestDTO;
import com.gozhu.dto.reserva.ReservaResponseDTO;

import java.util.List;

public interface ReservaService {
    List<ReservaResponseDTO> listar();
    ReservaResponseDTO guardar(ReservaRequestDTO requestDTO);
    ReservaResponseDTO obtenerPorId(Long id);
    void eliminar(Long id);
}
