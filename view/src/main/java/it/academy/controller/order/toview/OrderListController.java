package it.academy.controller.order.toview;

import it.academy.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Secured(value = {"ROLE_USER"})
@Controller
public class OrderListController {

    @Autowired
    OrderService orderService;

    @GetMapping("order-list.view")
    public ModelAndView showOrderListFirstPage() {
        String nickname = SecurityContextHolder.getContext().getAuthentication().getName();
        return new ModelAndView(
                "order_list",
                Map.of("orders", orderService.listOfUserOrders(nickname))
        );
    }

}
