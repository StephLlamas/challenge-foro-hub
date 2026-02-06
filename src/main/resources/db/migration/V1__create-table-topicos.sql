CREATE TABLE topicos(
    id BIGINT auto_increment PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    mensaje VARCHAR(500) NOT NULL,
    fecha_creacion DATETIME NOT NULL,
    status tinyint NOT NULL,
    autor VARCHAR(100) NOT NULL,
    curso VARCHAR(255) NOT NULL,
    fecha_actualizacion DATETIME NOT NULL,

    UNIQUE (titulo, mensaje)
);
