package com.br.plataformacorretor10.corretor.imoveis;

import com.br.plataformacorretor10.corretor.imoveis.model.jpa.Imovel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImoveisRepository extends JpaRepository<Imovel, Long> {
}
