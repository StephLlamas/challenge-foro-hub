ALTER TABLE topicos
    ADD CONSTRAINT fk_topicos_usuarios FOREIGN KEY (autor_id) REFERENCES usuarios(id);