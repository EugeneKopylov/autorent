package it.academy.service.order;

import it.academy.dao.car.CarDao;
import it.academy.dao.order.OrderDao;
import it.academy.dao.user.ApplicationUserDao;
import it.academy.dao.user.UserDao;
import it.academy.model.car.Car;
import it.academy.model.order.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

    @Autowired
    UserDao userDao;

    @Transactional
    public void addNewOrder(Order order, String price, String brand, String model, String nickname) {
        order.setUser(applicationUserDao.findByNickname(nickname).getUser());
        order.setDate(LocalDateTime.now());
        order.setCar(carDao.findCarByBrandModelCost(Integer.valueOf(price), brand, model).get(0));
        order.setCost(
                Integer.parseInt(price) *
                        ((int) ChronoUnit.DAYS.between(
                        LocalDate.parse(order.getOrderDateFrom(), DateTimeFormatter.ofPattern("d/M/yyyy")),
                        LocalDate.parse(order.getOrderDateTo(), DateTimeFormatter.ofPattern("d/M/yyyy"))
                ) == 0 ? 1 : (int) ChronoUnit.DAYS.between(
                                LocalDate.parse(order.getOrderDateFrom(), DateTimeFormatter.ofPattern("d/M/yyyy")),
                                LocalDate.parse(order.getOrderDateTo(), DateTimeFormatter.ofPattern("d/M/yyyy"))
        )));
        orderDao.createOrder(order);
    }

    @Transactional
    public List listOfOrders(int pageNumber, int pageSize) {
        return orderDao.findAllOrders(pageNumber,pageSize);
    }

    @Transactional
    public List<Order> listOfUserOrders(String nickname) {
        return applicationUserDao.findByNickname(nickname).getUser().getOrderList();
    }

    @Transactional
    public String getBookingDateForCar(String brand, String model, String price){
        Car car = carDao.findCarByBrandModelCost(Integer.valueOf(price), brand, model).get(0);
        List<Order> orders = car.getOrders();
        StringBuilder date = new StringBuilder();
        for (Order order : orders) {
            LocalDate localDateFrom = null;
            localDateFrom = LocalDate.parse(order.getOrderDateFrom(), DateTimeFormatter.ofPattern("d/M/yyyy"));
            System.out.println(order.getOrderDateFrom());
            LocalDate localDateTo = LocalDate.parse(order.getOrderDateTo(), DateTimeFormatter.ofPattern("d/M/yyyy"));
            while(!localDateFrom.isEqual(localDateTo)){
                date.append("\"").append(localDateFrom.format(DateTimeFormatter.ofPattern("d/M/yyyy"))).append("\",");
                localDateFrom = localDateFrom.plusDays(1);
            }
            date.append("\"").append(localDateFrom.format(DateTimeFormatter.ofPattern("d/M/yyyy"))).append("\",");
        }

        return (date.length() == 0) ? "not ordered for yet" : date.deleteCharAt(date.length() - 1).toString();
    }

}
