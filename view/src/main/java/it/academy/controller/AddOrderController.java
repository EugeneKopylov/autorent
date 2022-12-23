package it.academy.controller;

import it.academy.model.Order;
import it.academy.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AddOrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/add-order.view")
    public String addOrderPage() {
        return "add_order";
    }

    @PostMapping("/add-order.action")
    public String addOrder(Order order) {
        orderService.addNewOrder(order);
        return "redirect:/order-list/0.view";
    }
}
