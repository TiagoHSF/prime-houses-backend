package com.br.plataformacorretor10.core.usuario;

import com.br.plataformacorretor10.core.model.util.RandomInteger;
import com.br.plataformacorretor10.core.usuario.model.dto.UsuarioDTO;
import com.br.plataformacorretor10.core.usuario.model.jpa.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Usuario criar(final UsuarioDTO usuarioDTO) throws Exception {
        try {
            Usuario usuario = new Usuario(usuarioDTO);
            usuario.setCodigoSeguranca(RandomInteger.randomInteger(100000, 999999));
            usuario = this.usuarioRepository.save(usuario);
            return usuario;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }


}