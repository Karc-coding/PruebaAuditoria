package com.example.auditoria.security.service;

import com.example.auditoria.security.dao.IUsuarioDao;
import com.example.auditoria.security.dto.NuevoUsuarioDto;
import com.example.auditoria.security.dto.RequestDto;
import com.example.auditoria.security.dto.TokenDto;
import com.example.auditoria.security.dto.UsuarioDto;
import com.example.auditoria.security.model.Usuario;
import com.example.auditoria.security.security.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    IUsuarioDao usuarioDao;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtProvider jwtProvider;

    public Usuario save(NuevoUsuarioDto dto) {
        Optional<Usuario> usuario = usuarioDao.findByUsuario(dto.getUsuario());
        if(usuario.isPresent())
            return null;
        String password = passwordEncoder.encode(dto.getPassword());
        Usuario usuarioSave = Usuario.builder()
                .usuario(dto.getUsuario())
                .password(password)
                .rol(dto.getRol())
                .build();
        return usuarioDao.save(usuarioSave);
    }

    public TokenDto login(UsuarioDto dto) {
        Optional<Usuario> usuario = usuarioDao.findByUsuario(dto.getUsuario());
        if(!usuario.isPresent())
            return null;
        if(passwordEncoder.matches(dto.getPassword(), usuario.get().getPassword()))
            return new TokenDto(jwtProvider.createToken(usuario.get()));
        return null;
    }

    public TokenDto validate(String token, RequestDto dto) {
        if(!jwtProvider.validate(token, dto))
            return null;
        String usuario = jwtProvider.getUserNameFromToken(token);
        if(!usuarioDao.findByUsuario(usuario).isPresent())
            return null;
        return new TokenDto(token);
    }
}
