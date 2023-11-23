package com.br.plataformacorretor10.controller;

import com.br.plataformacorretor10.exception.ServiceException;
import com.br.plataformacorretor10.service.EnumeratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * The Class ConstantesController
 *
 * @author Tiago Ferreira.
 * @since 22/11/2023
 */
@Controller()
@RequestMapping("constantes/")
public class ConstantesController {

    @Autowired
    private EnumeratorService enumeratorService;

    /**
     * Enumerators.
     *
     * @param enumerator the enumerator
     * @return the response entity
     */
    @GetMapping(path = "/enumerators")
    public @ResponseBody ResponseEntity<?> enumerators(@RequestParam("enumerator") final String enumerator) throws ServiceException {
        try {
            final Object[] api = this.enumeratorService.get(enumerator);
            return ResponseEntity.ok(api);
        } catch (final Exception e) {
            throw new ServiceException(e.getMessage());
        }
    }

}