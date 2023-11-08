package com.br.plataformacorretor10.core.corretor.gestao.dashboard;

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

    public @ResponseBody ResponseEntity<Map<String, Object>> dashboard(
        @RequestParam("corretorId") final Long corretorId
    ) throws Exception {
      try {
            final Map<String, Object> api = this.dashboardService.dashboard(corretorId);
            return ResponseEntity.ok(api);
      } catch (Exception e){
          throw new Exception(e.getMessage());
      }
    }

}