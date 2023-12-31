package com.br.plataformacorretor10.repository;

import com.br.plataformacorretor10.model.jpa.Imovel;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
@Transactional
public interface ImoveisRepository extends JpaRepository<Imovel, Long> {

    @Modifying
    @Query("UPDATE Imovel i SET i.dataDesativacao = :data WHERE i.id = :imovelId")
    int desativarById(@Param("imovelId") Long imovelId, @Param("data") LocalDateTime data);

    @Query("SELECT i FROM Imovel i JOIN Corretor c on i.empresa.id = :empresaId WHERE i.dataDesativacao is null" +
        " AND i.status != 'AGUARDANDO APROVAÇÃO'")
    Page<Imovel> findImoveis(Pageable pageable, Long empresaId);
}
