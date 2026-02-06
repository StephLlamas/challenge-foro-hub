CREATE TABLE usuarios(
    id BIGINT auto_increment PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL UNIQUE,
    contrasenia VARCHAR(255) NOT NULL
);