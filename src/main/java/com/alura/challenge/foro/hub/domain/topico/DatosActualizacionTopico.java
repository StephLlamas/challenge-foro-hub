package com.alura.challenge.foro.hub.domain.topico;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosActualizacionTopico(
        String titulo,
        String mensaje,
        String curso
) {
}
