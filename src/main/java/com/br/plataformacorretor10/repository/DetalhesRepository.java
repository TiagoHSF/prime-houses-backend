package com.br.plataformacorretor10.repository;

import com.br.plataformacorretor10.corretor.imoveis.model.jpa.DetalhesImovel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The Class DetalhesRepository
 *
 * @author Tiago Ferreira.
 * @since 01/11/2023
 */
@Repository
@Transactional
public interface DetalhesRepository extends JpaRepository<DetalhesImovel, Long> {
}