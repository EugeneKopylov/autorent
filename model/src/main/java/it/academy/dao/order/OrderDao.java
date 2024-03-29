package it.academy.dao.order;

import it.academy.model.car.Car;
import it.academy.model.order.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDao {

    List<Order> findAllOrders(int pageNumber, int pageSize);

    void createOrder(Order order);

    Order findOrderById(int id);

    void deleteOrderById(int id);

    void deleteByCarId(int carId);
}
