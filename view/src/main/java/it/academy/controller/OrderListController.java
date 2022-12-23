package it.academy.controller;

import it.academy.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class OrderListController {

    @Autowired
    OrderService orderService;

    private static final int PAGE_SIZE = 10;

    @GetMapping("/order-list/0.view")
    public ModelAndView showOrderListFirstPage() {
        return new ModelAndView(
                "order_list",
                Map.of("orders", orderService.listOfOrders(0,PAGE_SIZE))
        );
    }

    @GetMapping("/order-list/${offset}.view")
    public ModelAndView showOrderListPaginationPage(@PathVariable int offset) {
        return new ModelAndView(
                "order_list",
                Map.of("orders", orderService.listOfOrders(offset, PAGE_SIZE))
        );
    }
}
