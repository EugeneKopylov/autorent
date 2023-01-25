package it.academy.controller.rest;

import it.academy.dtos.dto.car.BrandModelDto;
import it.academy.dtos.dto.car.OrderDto;
import it.academy.model.order.Order;
import it.academy.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order-rest")
public class OrderRestController {

    @Autowired
    OrderService orderService;

    @GetMapping("/order/{id}.view")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable int id) {
        Order order = orderService.getOrderById(id);
        OrderDto orderDto = new OrderDto();
        orderDto.setOrderDateFrom(order.getOrderDateFrom());
        orderDto.setOrderDateTo(order.getOrderDateTo());
        orderDto.setCost(order.getCost().toString());
        return new ResponseEntity<OrderDto>(orderDto, HttpStatus.OK);
    }
}
