package com.gozhu.dto.usuario;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UsuarioRequestDTO {
    private String nombreCompleto;
    private String email;
    private String telefono;
}
