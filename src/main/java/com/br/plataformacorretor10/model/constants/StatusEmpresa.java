package com.br.plataformacorretor10.model.constants;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * The Class StatusEmpresa
 *
 * @author Tiago Ferreira.
 * @since 10/11/2023
 */
public enum StatusEmpresa {

    FORMAL("FORMAL"),
    INFORMAL("INFORMAL");

    private final String label;

    private StatusEmpresa(final String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public static Stream<StatusEmpresa> stream() {
        return Arrays.asList(StatusEmpresa.values()).stream();
    }
}