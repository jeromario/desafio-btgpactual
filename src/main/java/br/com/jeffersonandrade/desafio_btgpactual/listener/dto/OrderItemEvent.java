package br.com.jeffersonandrade.desafio_btgpactual.listener.dto;

import java.math.BigDecimal;

public record OrderItemEvent(
    String produto,
    Integer quantidade,
    BigDecimal preco
) {
}
