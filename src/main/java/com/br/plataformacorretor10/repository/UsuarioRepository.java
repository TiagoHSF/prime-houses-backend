package com.br.plataformacorretor10.repository;

import com.br.plataformacorretor10.model.jpa.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The Class UsuarioRepository
 *
 * @author Tiago Ferreira.
 * @since 03/11/2023
 */
@Repository
@Transactional
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    public Usuario findUsuarioByEmail(final String email);

    public Usuario findUsuarioByToken(final String token);
}