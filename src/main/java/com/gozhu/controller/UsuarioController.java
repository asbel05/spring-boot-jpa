package com.gozhu.controller;

import com.gozhu.dto.usuario.UsuarioRequestDTO;
import com.gozhu.dto.usuario.UsuarioResponseDTO;
import com.gozhu.entity.Usuario;
import com.gozhu.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {
    private final UsuarioService usuarioService;

    @GetMapping
    public List<UsuarioResponseDTO> listar() {
        return usuarioService.listar();
    }

    @PostMapping
    public UsuarioResponseDTO guardar(@RequestBody UsuarioRequestDTO requestDTO) {
        return usuarioService.guardar(requestDTO);
    }

    @GetMapping("/{id}")
    public UsuarioResponseDTO obtener(@PathVariable Long id) {
        return usuarioService.obtenerPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        usuarioService.eliminar(id);
    }
}
