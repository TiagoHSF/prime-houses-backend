package com.br.plataformacorretor10.repository;

import com.br.plataformacorretor10.model.jpa.Corretor;
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