package com.gozhu.controller;

import com.gozhu.dto.equipo.EquipoRequestDTO;
import com.gozhu.dto.equipo.EquipoResponseDTO;
import com.gozhu.entity.Equipo;
import com.gozhu.service.EquipoService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipos")
@RequiredArgsConstructor
public class EquipoController {
    private final EquipoService equipoService;

    @GetMapping
    public List<EquipoResponseDTO> listar() {
        return equipoService.listar();
    }

    @PostMapping
    public EquipoResponseDTO guardar(@RequestBody EquipoRequestDTO requestDTO) {
        return equipoService.guardar(requestDTO);
    }

    @GetMapping("/{id}")
    public EquipoResponseDTO obtener(@PathVariable Long id) {
        return equipoService.obtenerPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        equipoService.eliminar(id);
    }
}
