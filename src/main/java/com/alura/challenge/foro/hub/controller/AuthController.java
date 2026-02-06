package com.alura.challenge.foro.hub.controller;

import com.alura.challenge.foro.hub.domain.usuario.DatosAuth;
import com.alura.challenge.foro.hub.domain.usuario.Usuario;
import com.alura.challenge.foro.hub.infra.security.TokenService;
import com.alura.challenge.foro.hub.infra.security.DatosTokenJWT;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthController {
    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationManager manager;

    @PostMapping
    public ResponseEntity iniciarSesion(@RequestBody @Valid DatosAuth datos){
        var autenticaciontoken = new UsernamePasswordAuthenticationToken(datos.nombre(), datos.contrasenia());
        var autenticacion = manager.authenticate(autenticaciontoken);

        var tokenJWT = tokenService.generateToken((Usuario) autenticacion.getPrincipal());

        return ResponseEntity.ok(new DatosTokenJWT(tokenJWT));
    }
}
