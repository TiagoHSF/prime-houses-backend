package com.br.plataformacorretor10.core.model.constants;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Enum tipo imóvel
 *
 * @author Tiago
 * @date 1 de nov de 2023
 * */
public enum TipoImovel {

    APARTAMENTO("APARTAMENTO"),
    CASA("CASA"),
    PONTO_COMERCIAL("PONTO COMERCIAL"),
    TERRENO("TERRENO"),
    COBERTURA("COBERTURA"),
    SOBRADO("SOBRADO"),
    KITNET("KITNET"),
    CHACARA_SITIO("CHACARA/SITIO"),
    LOFT("LOFT"),
    BARRACAO_INDUSTRIAL("BARRACAO INDUSTRIAL");

    /** The label. */
    private final String label;

    private TipoImovel(final String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public static Stream<TipoImovel> stream() {
        return Arrays.asList(TipoImovel.values()).stream();
    }
}
