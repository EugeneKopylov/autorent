package it.academy.service.order;

import it.academy.dao.car.CarDao;
import it.academy.dao.order.OrderDao;
import it.academy.dao.user.ApplicationUserDao;
import it.academy.model.order.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderDao orderDao;

    @Autowired
    CarDao carDao;

    @Autowired
    ApplicationUserDao applicationUserDao;

    @Transactional
    public void addNewOrder(Order order, String price, String brand, String model, String nickname) {
        order.setUser(applicationUserDao.findByNickname(nickname).getUser());
        order.setDate(LocalDateTime.now());
        order.setCar(carDao.findCarByBrandModelCost(Integer.valueOf(price), brand, model).get(0));
        order.setCost(
                Integer.parseInt(price) *
                (int) ChronoUnit.DAYS.between(
                        LocalDate.parse(order.getOrderDateFrom()),
                        LocalDate.parse(order.getOrderDateTo())
                )
        );
        orderDao.createOrder(order);
    }

    @Transactional
    public List listOfOrders(int pageNumber, int pageSize) {
        return orderDao.findAllOrders(pageNumber,pageSize);
    }

}
