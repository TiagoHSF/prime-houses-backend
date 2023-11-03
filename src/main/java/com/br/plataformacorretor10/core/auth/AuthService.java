package com.br.plataformacorretor10.core.auth;

import com.br.plataformacorretor10.configuration.security.CustomUserDetailService;
import com.br.plataformacorretor10.configuration.security.JwtTokenProvider;
import com.br.plataformacorretor10.configuration.security.SecurityConfig;
import com.br.plataformacorretor10.core.model.dto.LoginDTO;
import com.br.plataformacorretor10.core.usuario.UsuarioRepository;
import com.br.plataformacorretor10.core.usuario.model.jpa.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

/**
 * The Class AuthService
 *
 * @author Tiago Ferreira.
 * @since 03/11/2023
 */
@Service
public class AuthService {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private CustomUserDetailService customUserDetailService;

    private AuthenticationManager authenticationManager;

    @Autowired
    private SecurityConfig securityConfig;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public String login (final LoginDTO login) throws Exception {
        try {
            final UserDetails userDetails = this.customUserDetailService.loadUserByUsername(login.getEmail());

            if (!this.securityConfig.passwordEncoder().matches(login.getSenha(), userDetails.getPassword())) {
                throw new Exception("Senha incorreta");
            }

//            final UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
//            authenticationManager.authenticate(authenticationToken);

            String token = this.jwtTokenProvider.generateToken(userDetails);
            Usuario usuario = this.usuarioRepository.findUsuarioByEmail(login.getEmail());
            token = token.replace("Bearer ", "");
            usuario.setToken(token);
            this.usuarioRepository.save(usuario);
            return "Bearer " + token;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}