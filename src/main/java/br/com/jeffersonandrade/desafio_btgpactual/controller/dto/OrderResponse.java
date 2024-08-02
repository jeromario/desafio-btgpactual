package br.com.jeffersonandrade.desafio_btgpactual.controller.dto;

import java.math.BigDecimal;

import br.com.jeffersonandrade.desafio_btgpactual.entity.OrderEntity;

public record OrderResponse(Long orderId, Long customerId, BigDecimal total) {

    public static OrderResponse fromEntity(OrderEntity entity){
        return new OrderResponse(entity.getOrderId(), entity.getCustomerId(), entity.getTotal());
    }

}
