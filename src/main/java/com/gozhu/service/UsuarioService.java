package com.gozhu.service;

import com.gozhu.dto.usuario.UsuarioRequestDTO;
import com.gozhu.dto.usuario.UsuarioResponseDTO;
import com.gozhu.entity.Usuario;

import java.util.List;

public interface UsuarioService {
    List<UsuarioResponseDTO> listar();
    UsuarioResponseDTO guardar(UsuarioRequestDTO requestDTO);
    UsuarioResponseDTO obtenerPorId(Long id);
    void eliminar(Long id);
    Usuario obtenerEntidadPorId(Long id);
}
