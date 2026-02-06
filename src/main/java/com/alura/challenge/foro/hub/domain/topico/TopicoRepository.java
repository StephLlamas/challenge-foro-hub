package com.alura.challenge.foro.hub.domain.topico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
    //Validar que no esté duplicado
    boolean existsByTituloAndMensaje(String titulo, String mensaje);

    //Listar tópicos activos
    Page<Topico> findAllByStatusTrue(Pageable pageable);
}
