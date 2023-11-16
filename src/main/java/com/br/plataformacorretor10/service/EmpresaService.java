package com.br.plataformacorretor10.service;

import com.br.plataformacorretor10.repository.EmpresaRepository;
import com.br.plataformacorretor10.model.dto.EmpresaDTO;
import com.br.plataformacorretor10.model.jpa.Empresa;
import com.br.plataformacorretor10.model.jpa.Corretor;
import com.br.plataformacorretor10.repository.CorretorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * The Class EmpresaService
 *
 * @author Tiago Ferreira.
 * @since 10/11/2023
 */
@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private CorretorRepository corretorRepository;

    @Transactional(rollbackOn = Exception.class)
    public Empresa criar(final EmpresaDTO empresaDTO, final Long corretorId) throws Exception {
        try {
            Empresa empresa = new Empresa(empresaDTO);
            if(Objects.nonNull(empresa.getDocumento()) && empresa.getDocumento().length() < 14){
                throw new Exception("Tamanho do documento inserido inválido!");
            }
            empresa = this.empresaRepository.save(empresa);

            Corretor corretor = this.corretorRepository.findById(corretorId).orElseThrow(() -> new Exception("Corretor não localizado!"));
            corretor.setEmpresa(empresa);
            this.corretorRepository.save(corretor);

            return empresa;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}