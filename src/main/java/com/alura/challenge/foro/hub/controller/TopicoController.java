package com.alura.challenge.foro.hub.controller;

import com.alura.challenge.foro.hub.domain.topico.*;
import com.alura.challenge.foro.hub.domain.usuario.UsuarioRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@RestController
@RequestMapping("/topicos")
@SecurityRequirement(name = "bearer-key")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    @Transactional
    public ResponseEntity registrarTopico(@RequestBody @Valid DatosRegistroTopico datos, UriComponentsBuilder uriComponentsBuilder){
        // Buscar autor por id
        var autor = usuarioRepository.getReferenceById(datos.autorId());

        // Crear el tópico con el autor encontrado
        var topico = new Topico(datos.titulo(), datos.mensaje(), autor, datos.curso());
        topicoRepository.save(topico);

        var uri = uriComponentsBuilder.path("/topicos/{id}")
                                      .buildAndExpand(topico.getId())
                                      .toUri();

        return ResponseEntity.created(uri).body(new DatosDetalleTopico(topico));
    }

    @GetMapping
    public ResponseEntity<Page<DatosListaTopicos>> listarTopicos(@PageableDefault(size = 10, sort = {"fechaCreacion"}, direction = Sort.Direction.ASC) Pageable paginacion){
        return ResponseEntity.ok(topicoRepository.findAllByStatusTrue(paginacion)
                                                 .map(DatosListaTopicos::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosDetalleTopico> detallarTopico(@PathVariable Long id){
        var topico = topicoRepository.getReferenceById(id);

        return ResponseEntity.ok(new DatosDetalleTopico(topico));
    }

    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity actualizarTopico(@PathVariable Long id, @RequestBody @Valid DatosActualizacionTopico datos) {
        Optional<Topico> optionalTopico = topicoRepository.findById(id);

        if(optionalTopico.isPresent()){
            Topico topico = optionalTopico.get();
            topico.actualizarInfo(datos);
            return ResponseEntity.ok(new DatosDetalleTopico(topico));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity eliminarTopico(@PathVariable Long id){
        try{
            topicoRepository.deleteById(id);
            return ResponseEntity.noContent().build(); // 204 si se borró
        } catch (EmptyResultDataAccessException e){
            return ResponseEntity.notFound().build(); // 404 si no existía
        }
    }

    @Transactional
    @PutMapping("/{id}/desactivar")
    public ResponseEntity desactivarTopico(@PathVariable Long id){
        return topicoRepository.findById(id)
                .map(topico -> {
                    topico.desactivar();
                    return ResponseEntity.ok(new DatosDetalleTopico(topico));
                })
                .orElseGet(()->ResponseEntity.notFound().build());
    }
}
