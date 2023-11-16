package com.br.plataformacorretor10.repository;

import com.br.plataformacorretor10.model.jpa.Imovel;
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
        + "(SELECT sum(i.valor) FROM Imovel i WHERE i.empresa.id = :empresaId AND i.status = 'VENDIDO OU ALUGADO') as imoveisAnunciados,"
        + "(SELECT i.valor * (i.porcentagemComissao / 100) FROM Imovel i WHERE i.empresa.id = :empresaId AND i.status = 'VENDIDO OU ALUGADO') as imoveisVendidos,"
        + "(SELECT count(i) FROM Imovel i WHERE i.empresa.id = :empresaId AND i.status = 'EM NEGOCIAÇÃO') as imoveisEmNegociacao,"
        + "(SELECT count(i) FROM Imovel i WHERE i.empresa.id = :empresaId AND i.status = 'EM VISTORIA') as emVistoria")
    Map<String, Object> dashboard(@Param("empresaId") Long empresaId);


}