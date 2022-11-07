package com.example.auditoria.security.controller;

import com.example.auditoria.security.dto.NuevoUsuarioDto;
import com.example.auditoria.security.dto.RequestDto;
import com.example.auditoria.security.dto.TokenDto;
import com.example.auditoria.security.dto.UsuarioDto;
import com.example.auditoria.security.model.Usuario;
import com.example.auditoria.security.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/autenticacion")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @PostMapping("/login")
    public ResponseEntity<TokenDto> login(@RequestBody UsuarioDto dto){
        TokenDto tokenDto = usuarioService.login(dto);
        if(tokenDto == null)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(tokenDto);
    }

    @PostMapping("/validar")
    public ResponseEntity<TokenDto> validate(@RequestParam String token, @RequestBody RequestDto dto){
        TokenDto tokenDto = usuarioService.validate(token, dto);
        if(tokenDto == null)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(tokenDto);
    }

    @PostMapping("/crear")
    public ResponseEntity<Usuario> create(@RequestBody NuevoUsuarioDto dto){
        Usuario usuario = usuarioService.save(dto);
        if(usuario == null)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(usuario);
    }
}
