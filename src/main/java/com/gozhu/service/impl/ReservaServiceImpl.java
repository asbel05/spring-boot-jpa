package com.gozhu.service.impl;

import com.gozhu.dto.reserva.ReservaRequestDTO;
import com.gozhu.dto.reserva.ReservaResponseDTO;
import com.gozhu.entity.Equipo;
import com.gozhu.entity.Reserva;
import com.gozhu.entity.Usuario;
import com.gozhu.mapper.ReservaMapper;
import com.gozhu.repository.ReservaRepository;
import com.gozhu.service.EquipoService;
import com.gozhu.service.ReservaService;
import com.gozhu.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReservaServiceImpl implements ReservaService {
    private final ReservaRepository reservaRepository;
    private final UsuarioService usuarioService;
    private final EquipoService equipoService;
    private final ReservaMapper reservaMapper;

    public List<ReservaResponseDTO> listar() {
        return reservaRepository.findAll().stream().map(reservaMapper::toDTO).collect(Collectors.toList());
    }

    public ReservaResponseDTO guardar(ReservaRequestDTO requestDTO) {
        Equipo equipo = equipoService.obtenerEntidadPorId(requestDTO.getIdEquipo());
        Usuario usuario = usuarioService.obtenerEntidadPorId(requestDTO.getIdUsuario());

        boolean hayCruce = reservaRepository.existsByEquipoAndFechaAndHoraInicioLessThanAndHoraFinGreaterThan(
                equipo,
                requestDTO.getFecha(),
                requestDTO.getHoraFin(),
                requestDTO.getHoraInicio());
        if (hayCruce){
            throw new RuntimeException("El equipo ya está reservado en ese horario");
        }

        Reserva reserva = reservaMapper.toEntity(requestDTO, equipo, usuario);
        Reserva guardado = reservaRepository.save(reserva);
        return reservaMapper.toDTO(guardado);
    }

    public ReservaResponseDTO obtenerPorId(Long id) {
        return reservaRepository.findById(id).map(reservaMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Reserva no encontrada"));
    }

    public void eliminar(Long id) {
        if(!reservaRepository.existsById(id)) {
            throw new RuntimeException("No existe reserva con ID : " + id);
        }
        reservaRepository.deleteById(id);
    }
}
