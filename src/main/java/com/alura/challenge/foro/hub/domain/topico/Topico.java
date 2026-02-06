package com.alura.challenge.foro.hub.domain.topico;

import com.alura.challenge.foro.hub.domain.usuario.Usuario;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false, length = 500)
    private String mensaje;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime fechaCreacion;

//    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Boolean status;

    // Relación con Usuario: autor_id es la FK
    @ManyToOne
    @JoinColumn(name = "autor_id", nullable = false)
    private Usuario autor;

    @Column(nullable = false)
    private String curso;

    @Column(nullable = false)
    @UpdateTimestamp
    private LocalDateTime fechaActualizacion;

    // Constructor de conveniencia para nuevos tópicos
    public Topico(String titulo, String mensaje, Usuario autor, String curso) {
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.status = true;
        this.autor = autor;
        this.curso = curso;
    }
    
    public void actualizarInfo(@Valid DatosActualizacionTopico datos) {
        if (datos.titulo() != null && !datos.titulo().isBlank()) {
            this.titulo = datos.titulo();
        }
        if (datos.mensaje() != null && !datos.mensaje().isBlank()) {
            this.mensaje = datos.mensaje();
        }
        if (datos.curso() != null && !datos.curso().isBlank()) {
            this.curso = datos.curso();
        }
        this.fechaActualizacion = LocalDateTime.now();
    }

    public void desactivar() {
        this.status = false;
    }
}
