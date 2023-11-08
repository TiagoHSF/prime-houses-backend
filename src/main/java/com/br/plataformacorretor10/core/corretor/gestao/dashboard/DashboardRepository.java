package com.br.plataformacorretor10.core.corretor.gestao.dashboard;

import com.br.plataformacorretor10.core.corretor.imoveis.model.jpa.Imovel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * The Class DashboardRepository
 *
 * @author Tiago Ferreira.
 * @since 07/11/2023
 */
@Repository
@Transactional
public interface DashboardRepository extends JpaRepository<Imovel, Long> {

    @Query(value = "SELECT"
        + "(SELECT count(c) FROM Imovel c WHERE c.corretor.id = :corretorId AND c.status = 'DISPONIVEL') as imoveisAnunciados,"
        + "(SELECT count(c) FROM Imovel c WHERE c.corretor.id = :corretorId AND c.status = 'VENDIDO OU ALUGADO') as imoveisVendidos,"
        + "(SELECT count(c) FROM Imovel c WHERE c.corretor.id = :corretorId AND c.status = 'EM NEGOCIAÇÃO') as imoveisEmNegociacao,"
        + "(SELECT count(c) FROM Imovel c WHERE c.corretor.id = :corretorId AND c.status = 'AGUARDANDO APROVAÇÃO') as aguardandoAprovacao")
    Map<String, Object> dashboard(@Param("corretorId") Long corretorId);


}