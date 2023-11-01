package com.br.plataformacorretor10.corretor.imoveis;

import com.br.plataformacorretor10.corretor.imoveis.model.jpa.Imovel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;

public interface ImoveisRepository extends JpaRepository<Imovel, Long> {

    @Query("UPDATE Imovel i SET i.dataDesativacao = :data WHERE i.id = :imovelId")
    int deleteByImovelId(@Param("imovelId") Long imovelId, @Param("data") LocalDateTime data);
}
