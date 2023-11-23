package com.br.plataformacorretor10.service;

import com.br.plataformacorretor10.exception.ServiceException;
import com.br.plataformacorretor10.model.constants.*;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * The Class EnumeratorService
 *
 * @author Tiago Ferreira.
 * @since 22/11/2023
 */
@Service
public class EnumeratorService {

    public Object[] get(final String constante) throws ServiceException {
        try {
            Objects.requireNonNull(constante, "O nome da constante não foi informado");
            return switch (constante) {
                case "FormasPagamento" -> FormasPagamento.values();
                case "StatusEmpresa" -> StatusEmpresa.values();
                case "StatusImovel" -> StatusImovel.values();
                case "TipoImovel" -> TipoImovel.values();
                case "TipoUsuario" -> TipoUsuario.values();
                default -> null;
            };
        } catch (Exception e){
            throw new ServiceException(e.getMessage());
        }
    }

}