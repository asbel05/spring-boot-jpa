package com.gozhu.repository;

import com.gozhu.entity.Equipo;
import com.gozhu.entity.Reserva;
import com.gozhu.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    boolean existsByEquipoAndFechaAndHoraInicioLessThanAndHoraFinGreaterThan(
            Equipo equipo, LocalDate fecha, LocalTime horaFinal, LocalTime horaInicio);
}
