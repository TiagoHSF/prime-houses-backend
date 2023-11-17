package com.br.plataformacorretor10.controller;

import com.br.plataformacorretor10.exception.ServiceException;
import com.br.plataformacorretor10.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * The Class DashboardController
 *
 * @author Tiago Ferreira.
 * @since 07/11/2023
 */
@Controller()
@RequestMapping("corretor/dashboard/")
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    public @ResponseBody ResponseEntity<?> dashboard(
        @RequestParam("empresaId") final Long empresaId
    ) throws ServiceException {
      try {
            final Map<String, Object> api = this.dashboardService.dashboard(empresaId);
            return ResponseEntity.ok(api);
      } catch (Exception e){
          throw new ServiceException(e.getMessage());
      }
    }

}