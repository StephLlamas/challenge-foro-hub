<h1>💻💬 Foro Hub - API REST </h1>
<p align="center">
<img src="https://img.shields.io/badge/Java-21%2B-%23ED8B00?color=%23ED8B00">
<img src="https://img.shields.io/badge/Spring-4f4f4f?logo=spring&logoColor=%236DB33F">  
<img src="https://img.shields.io/badge/Spring%20Boot-4.0-%252388e339%3F%26color%3D%252388e339?logo=springboot&logoColor=%23f5f5f5&color=%236DB33F">
<img src="https://img.shields.io/badge/Insomnia-Testing-%2523FF6C37%3F?logo=insomnia&color=%234000BF">
<img src="https://img.shields.io/badge/Swagger-%234f4f4f?logo=swagger&logoColor=%2385EA2D">
<img src="https://img.shields.io/badge/License-MIT-0173b4">
</p>

<h3>📝 Descripción</h3>
<p>Aplicación backend desarrollada en Java con Spring Boot, diseñada para gestionar un foro en línea. El objetivo es implementar un sistema completo de autenticación, autorización y CRUD de tópicos, aplicando buenas prácticas de arquitectura y seguridad.

La aplicación permite a los usuarios:
<ul>
  <li>Registrarse e iniciar sesión mediante JWT.</li>
  <li>Crear, listar, actualizar y eliminar tópicos.</li>
  <li>Filtrar tópicos por estado (abierto/cerrado) y ordenados por fecha.</li>
  <li>Consultar detalles de cada tópico.</li>
  <li>Mantener la integridad y seguridad de los datos con Spring Security y validaciones.</li>
</ul>

Este proyecto forma parte de un challenge de backend orientado a reforzar conocimientos en:
<ul>
  <li>Arquitectura REST.</li>
  <li>Persistencia con Spring Data JPA.</li>
  <li>Migraciones de base de datos con Flyway.</li>
  <li>Buenas prácticas en DTOs, controladores y servicios.</li>
</ul>
</p>

<h3>🛠️ Tecnologías utilizadas</h3>
<ul>
  <li>Java 17</li>
  <li>Spring Boot</li>
  <li>Spring Security</li>
  <li>JWT (JSON Web Token)</li>
  <li>Spring Data JPA</li>
  <li>Flyway</li>
  <li>MySQL</li>
  <li>Maven</li>
</ul>
  
<h3>⚙️ Funcionalidades principales</h3>
<ul>
  <li>Autenticación y autorización con JWT.</li>
  <li>Gestión de usuarios: registro e inicio de sesión.</li>
  <li>Gestión de tópicos: creación, edición, eliminación y consulta.</li>
  <li>Validaciones en entradas.</li>
  <li>Migraciones automáticas de base de datos.</li>
  <li>Documentación de endpoints con Swagger/OpenAPI</li>
</ul>

<h3>🏗️ Arquitectura</h3>
<p>El código está organizado en capas para mantener claridad y escalabilidad:</p>
<ul>
    <li>Controllers → expone los endpoints REST.</li>
    <li>Services → contiene la lógica de negocio.</li>
    <li>Repositories → maneja la persistencia con JPA.</li>
    <li>DTOs → aseguran un intercambio de datos limpio y seguro.</li>
    <li>Entities → representan las tablas de la base de datos.</li>
  </ul>

  ### 🚀 Instalación y Uso
1. Clona el repositorio:
```bash
 git clone https://github.com/StephLlamas/challenge-foro-hub.git
```
2. Asegúrate de tener JDK 17 o superior instalado.
3. Se requiere Maven 3.5.x
4. Base de datos MySQL.
5. Abre el proyecto en IntelliJ IDEA.
6. Configura la base de datos en <code>application.properties</code> utilizando variables de entorno, para proteger la infraestructura y seguir las mejores prácticas de desarrollo:
```properties
  spring.datasource.url=jdbc:mysql://${FH_DB_HOST}/${FH_DB_NAME}
  spring.datasource.username=${FH_DB_USER}
  spring.datasource.password=${FH_DB_PASSWORD}
```
5. Ejecuta el proyecto en <code>Application.java</code> → <code>Run 'Application.main()'</code>.
6. Accede a los endpoints disponibles en tu localhost.
7. Ejemplos de endpoints en Swagger UI <code>(/swagger-ui/index.html)</code>:
   <ul>
     <li>Autenticación</li>
     <img width="1794" height="717" alt="image" src="https://github.com/user-attachments/assets/5c9f4ebc-d120-4bd0-ae15-b311e11718ff" />
     <li>Tópicos</li>
     Crea un nuevo tópico: </br>
     <img width="1798" height="694" alt="image" src="https://github.com/user-attachments/assets/019b627f-65e1-4a80-b4c4-1f1473ac2265" /> </br>
     Lista todos los tópicos: </br>
     <img width="1799" height="885" alt="image" src="https://github.com/user-attachments/assets/3c787492-2b5e-4a25-a624-387b6bbf384a" /> </br>
     Obtiene los detalles de un tópico específico mediante su id: </br>
     <img width="1611" height="856" alt="image" src="https://github.com/user-attachments/assets/0d06736e-a527-410b-84c5-50d6b46b79b1" /> </br>
     Actualiza la información de un tópico específico mediante su id: </br>
     <img width="1613" height="721" alt="image" src="https://github.com/user-attachments/assets/37be819c-ca2e-4b64-9621-da1ecfd05e83" /> </br>
     Elimina un tópico: </br>
     <img width="1611" height="490" alt="image" src="https://github.com/user-attachments/assets/620552ba-5f80-416f-a649-756349b5b6f5" /> </br>
   </ul>
<hr/>
<em>Desarrollado por <a href="https://github.com/StephLlamas">Estefanía Llamas</a> como parte del programa <strong>Oracle Next Education</strong> impartido por <a href="https://www.aluracursos.com">Alura Latam</a>.</em>
