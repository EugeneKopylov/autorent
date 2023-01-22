package it.academy.controller.order.toaction;

import it.academy.model.order.Order;
import it.academy.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Secured(value = {"ROLE_USER"})
@Controller
public class AddOrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/add-order/{brand}/{model}/{price}.view")
    public ModelAndView addOrderPage(@PathVariable String brand,
                                     @PathVariable String model,
                                     @PathVariable String price,
                                     Model modelPage) {
        modelPage.addAttribute("brand", brand);
        modelPage.addAttribute("model", model);
        modelPage.addAttribute("price", price);
        return new ModelAndView("add_order");
    }

    @PostMapping("add-order/{brand}/{model}/{price}.action")
    public String addOrder(Order order,
                           @PathVariable String brand,
                           @PathVariable String model,
                           @PathVariable String price) {
        String nickname = SecurityContextHolder.getContext().getAuthentication().getName();
        orderService.addNewOrder(order, price, brand, model, nickname);
        return "redirect:/order-list.view";
    }
}
