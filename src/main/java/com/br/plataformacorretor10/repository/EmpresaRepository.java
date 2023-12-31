package com.br.plataformacorretor10.repository;

import com.br.plataformacorretor10.model.jpa.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * The Class EmpresaRepository
 *
 * @author Tiago Ferreira.
 * @since 10/11/2023
 */
@Repository
@Transactional
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
}