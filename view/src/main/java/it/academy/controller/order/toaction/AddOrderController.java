package it.academy.controller.order.toaction;

import it.academy.model.car.Car;
import it.academy.model.order.Order;
import it.academy.service.car.CarService;
import it.academy.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AddOrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    CarService carService;

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
        Car car = carService.findCarByBrandModelCost(Integer.valueOf(price), brand, model);
        order.setCar(car);
        orderService.addNewOrder(order);
        return "redirect:/order-list/0.view";
    }
}
