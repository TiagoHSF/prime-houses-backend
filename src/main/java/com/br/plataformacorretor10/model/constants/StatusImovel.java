package com.br.plataformacorretor10.model.constants;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * The Class StatusImovel
 *
 * @author Tiago Ferreira.
 * @since 07/11/2023
 */
public enum StatusImovel {

    DISPONIVEL("DISPONÍVEL"),
    EM_NEGOCIACAO("EM NEGOCIAÇÃO"),
    VENDIDO_ALUGADO("VENDIDO OU ALUGADO"),
    RESERVADO("RESERVADO"),
    EM_REFORMA("EM REFORMA"),
    CANCELADO("CANCELADO"),
    AGUARDANDO_APROVACAO("AGUARDANDO APROVAÇÃO"),
    EM_VISTORIA("EM VISTORIA");

    /** The label. */
    private final String label;

    private StatusImovel(final String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public static Stream<StatusImovel> stream() {
        return Arrays.asList(StatusImovel.values()).stream();
    }


}