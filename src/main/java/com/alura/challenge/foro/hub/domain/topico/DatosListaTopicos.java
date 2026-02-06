package com.alura.challenge.foro.hub.domain.topico;

import com.alura.challenge.foro.hub.domain.usuario.Usuario;

import java.time.LocalDateTime;

public record DatosListaTopicos(
    Long id,
    String titulo,
    String mensaje,
    LocalDateTime fechaCreacion,
    Long autorId,
    String curso
) {
    public DatosListaTopicos(Topico topico) {
        this(topico.getId(),
             topico.getTitulo(),
             topico.getMensaje(),
             topico.getFechaCreacion(),
             topico.getAutor().getId(),
             topico.getCurso()
        );
    }
}
