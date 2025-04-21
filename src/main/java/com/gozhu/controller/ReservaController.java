package com.gozhu.controller;

import com.gozhu.dto.reserva.ReservaRequestDTO;
import com.gozhu.dto.reserva.ReservaResponseDTO;
import com.gozhu.service.ReservaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservas")
@RequiredArgsConstructor
public class ReservaController {
    private final ReservaService reservaService;

    @GetMapping
    public List<ReservaResponseDTO> listar() {
        return reservaService.listar();
    }

    @PostMapping
    public ReservaResponseDTO guardar(@RequestBody ReservaRequestDTO requestDTO) {
        return reservaService.guardar(requestDTO);
    }

    @GetMapping("/{id}")
    public ReservaResponseDTO obtener(@PathVariable Long id) {
        return reservaService.obtenerPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        reservaService.eliminar(id);
    }
}
