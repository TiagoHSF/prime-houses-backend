package com.br.plataformacorretor10.model.constants;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Enum formas pagamento
 *
 * @author Tiago
 * @date 1 de nov de 2023
 * */
public enum FormasPagamento {

    A_VISTA("À VISTA"),
    PARCELADO("PARCELADO"),
    FINANCIAMENTO("FINANCIAMENTO"),
    ALUGUEL("ALUGUEL"),
    PERMUTA("PERMUTA"), /*TROCA DE IMÓVEL 1TO1*/
    LEILAO("LEILÃO"),
    CONSORCIO_IMOBILIARIO("CONSÓRCIO IMOBILIÁRIO"),
    USUFRUTO("USUFRUTO"), /*COMPRADOR PAGA PELO DIREITO DE RESIDIR, PORÉM NÃO É DELE*/
    DOACAO("DOAÇÃO"),
    CONTRATO_GAVETA("CONTRATO DE GAVETA"); /* POSSE DO IMÓVEL SÓ APÓS TODO O PAGAMENTO*/

    /** The label. */
    private final String label;

    private FormasPagamento(final String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public static Stream<FormasPagamento> stream() {
        return Arrays.asList(FormasPagamento.values()).stream();
    }

}
