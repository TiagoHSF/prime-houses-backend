package com.br.plataformacorretor10.core.repository;

import com.br.plataformacorretor10.core.model.jpa.Endereco;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The Class EnderecoRepository
 *
 * @author Tiago Ferreira.
 * @since 01/11/2023
 */@Repository
@Transactional

public interface EnderecoRepository extends  JpaRepository<Endereco, Long>{
}
