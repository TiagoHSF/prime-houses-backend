package com.br.plataformacorretor10.configuration.security;

import com.br.plataformacorretor10.repository.UsuarioRepository;
import com.br.plataformacorretor10.model.jpa.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Objects;

/**
 * The Class CustomUserDetailService
 *
 * @author Tiago Ferreira.
 * @since 03/11/2023
 */
@Service
public class CustomUserDetailService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    public CustomUserDetailService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findUsuarioByEmail(email);
        if (Objects.isNull(usuario)) {
            throw new UsernameNotFoundException("User not found with username: " + email);
        }
        return new org.springframework.security.core.userdetails.User(
            usuario.getEmail(),
            usuario.getSenha(),
            Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"))
        );
    }

    @Transactional
    public UserDetails loadUserByToken(String token) throws UsernameNotFoundException {
        token = token.replace("Bearer ", "");
        Usuario usuario = usuarioRepository.findUsuarioByToken(token);
        if (Objects.isNull(usuario)) {
            throw new UsernameNotFoundException("User not found with username: " + token);
        }
        return new org.springframework.security.core.userdetails.User(
            usuario.getEmail(),
            usuario.getSenha(),
            Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"))
        );
    }

}