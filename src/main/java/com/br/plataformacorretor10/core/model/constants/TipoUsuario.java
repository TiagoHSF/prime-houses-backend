package com.br.plataformacorretor10.core.model.constants;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * The Class TipoUsuario
 *
 * @author Tiago Ferreira.
 * @since 03/11/2023
 */
public enum TipoUsuario {

    CLIENTE("CLIENTE"),
    CORRETOR("CORRETOR");

    private final String label;

    private TipoUsuario(final String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public static Stream<TipoUsuario> stream() {
        return Arrays.asList(TipoUsuario.values()).stream();
    }
}