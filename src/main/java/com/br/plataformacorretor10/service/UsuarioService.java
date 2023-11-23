package com.br.plataformacorretor10.service;

import com.br.plataformacorretor10.exception.ServiceException;
import com.br.plataformacorretor10.model.constants.TipoUsuario;
import com.br.plataformacorretor10.model.dto.UsuarioDTO;
import com.br.plataformacorretor10.model.jpa.Corretor;
import com.br.plataformacorretor10.model.jpa.Usuario;
import com.br.plataformacorretor10.model.util.RandomInteger;
import com.br.plataformacorretor10.repository.CorretorRepository;
import com.br.plataformacorretor10.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * The Class UsuarioService
 *
 * @author Tiago Ferreira.
 * @since 03/11/2023
 */
@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CorretorRepository corretorRepository;

    @Autowired
    private AuthService authService;

    @Transactional(rollbackOn = Exception.class)
    public Usuario criar(final UsuarioDTO usuarioDTO) throws ServiceException {
        try {
            Usuario usuario = new Usuario(usuarioDTO);
            usuario.setCodigoSeguranca(RandomInteger.randomInteger(100000, 999999));
            if(Objects.isNull(usuarioDTO.getCreci()) || usuarioDTO.getCreci().equals("")){
                usuario.setTipo(TipoUsuario.CLIENTE);
            } else {
                if(Objects.isNull(usuarioDTO.getCreci())){
                    throw new Exception("Creci não informado!");
                }
                usuario.setTipo(TipoUsuario.CORRETOR);
                Corretor corretor = new Corretor(usuario, usuarioDTO.getCreci());
                this.corretorRepository.save(corretor);
            }
            usuario = this.usuarioRepository.save(usuario);

//            LoginDTO loginDTO = new LoginDTO(usuario.getEmail(), usuarioDTO.getSenha());
//            usuario = this.authService.login(loginDTO);
            return usuario;
        } catch (Exception e){
            throw new ServiceException(e.getMessage());
        }
    }


}