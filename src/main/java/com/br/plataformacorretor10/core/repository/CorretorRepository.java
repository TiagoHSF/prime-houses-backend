package com.br.plataformacorretor10.core.repository;

import com.br.plataformacorretor10.core.model.jpa.Corretor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * The Class CorretorRepository
 *
 * @author Tiago Ferreira.
 * @since 07/11/2023
 */
@Repository
@Transactional
public interface CorretorRepository extends JpaRepository<Corretor, Long> {
}