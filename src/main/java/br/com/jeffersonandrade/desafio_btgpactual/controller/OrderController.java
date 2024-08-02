package br.com.jeffersonandrade.desafio_btgpactual.controller;

import org.springframework.web.bind.annotation.RestController;

import br.com.jeffersonandrade.desafio_btgpactual.controller.dto.ApiResponse;
import br.com.jeffersonandrade.desafio_btgpactual.controller.dto.OrderResponse;
import br.com.jeffersonandrade.desafio_btgpactual.controller.dto.PaginationResponse;
import br.com.jeffersonandrade.desafio_btgpactual.service.OrderService;

import java.util.Map;

import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/customers/{customerId}/orders")
    public ResponseEntity<ApiResponse<OrderResponse>> listOrders(
                                            @RequestParam(name = "page", defaultValue = "0") Integer page,
                                            @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                                            @PathVariable("customerId") Long customerId) {
        
        var pageResponse = orderService.findByCustomer(customerId, PageRequest.of(page, pageSize));
        var totalOnOrders = orderService.getTotalOrdersByCustomerId(customerId);
        var apiResponse = new ApiResponse<>(
                            Map.of("totalOnOrders", totalOnOrders),
                            pageResponse.getContent(),
                            PaginationResponse.fromPage(pageResponse));

        return ResponseEntity.ok(apiResponse);
    }
    

    

}
