package com.gozhu.service.impl;

import com.gozhu.dto.equipo.EquipoRequestDTO;
import com.gozhu.dto.equipo.EquipoResponseDTO;
import com.gozhu.entity.Equipo;
import com.gozhu.mapper.EquipoMapper;
import com.gozhu.repository.EquipoRepository;
import com.gozhu.service.EquipoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EquipoServiceImpl implements EquipoService {
    private final EquipoRepository equipoRepository;
    private final EquipoMapper equipoMapper;

    public List<EquipoResponseDTO> listar() {
        return equipoRepository.findAll().stream().map(equipoMapper::toDTO).toList();
    }

    public EquipoResponseDTO guardar(EquipoRequestDTO requestDTO) {
        Equipo equipo = equipoMapper.toEntity(requestDTO);
        Equipo guardado = equipoRepository.save(equipo);
        return equipoMapper.toDTO(guardado);
    }

    public EquipoResponseDTO obtenerPorId(Long id) {
        return equipoRepository.findById(id).map(equipoMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Equipo no encontrado"));
    }

    public void eliminar(Long id) {
        if(!equipoRepository.existsById(id)) {
            throw new RuntimeException("No existe equipo con ID : " + id);
        }
        equipoRepository.deleteById(id);
    }

    public Equipo obtenerEntidadPorId(Long id) {
        return equipoRepository.findById(id).orElseThrow(() -> new RuntimeException("Equipo no encontrado"));
    }
}
