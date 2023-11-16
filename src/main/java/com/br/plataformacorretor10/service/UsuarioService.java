package com.br.plataformacorretor10.service;

import com.br.plataformacorretor10.model.constants.TipoUsuario;
import com.br.plataformacorretor10.model.jpa.Corretor;
import com.br.plataformacorretor10.model.util.RandomInteger;
import com.br.plataformacorretor10.repository.CorretorRepository;
import com.br.plataformacorretor10.repository.UsuarioRepository;
import com.br.plataformacorretor10.model.dto.UsuarioDTO;
import com.br.plataformacorretor10.model.jpa.Usuario;
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

    @Transactional(rollbackOn = Exception.class)
    public Usuario criar(final UsuarioDTO usuarioDTO) throws Exception {
        try {
            Usuario usuario = new Usuario(usuarioDTO);
            usuario.setCodigoSeguranca(RandomInteger.randomInteger(100000, 999999));
            if(usuarioDTO.getTipo().equals(TipoUsuario.CORRETOR)){
                if(Objects.isNull(usuarioDTO.getCreci())){
                    throw new Exception("Creci não informada!");
                }
                Corretor corretor = new Corretor(usuario, usuarioDTO.getCreci());
                this.corretorRepository.save(corretor);
            }
            usuario = this.usuarioRepository.save(usuario);
            return usuario;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }


}