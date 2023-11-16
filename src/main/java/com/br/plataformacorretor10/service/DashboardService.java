package com.br.plataformacorretor10.service;

import com.br.plataformacorretor10.repository.DashboardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;

/**
 * The Class DashboardService
 *
 * @author Tiago Ferreira.
 * @since 07/11/2023
 */
@Service
public class DashboardService {

    @Autowired
    private DashboardRepository dashboardRepository;

    public Map<String, Object> dashboard(final Long empresaId) throws Exception {
        try {
            if(Objects.isNull(empresaId)){
                throw new Exception("Corretor não informado!");
            }
            Map<String, Object> dashboard = this.dashboardRepository.dashboard(empresaId);
            return dashboard;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}