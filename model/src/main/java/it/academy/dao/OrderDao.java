package it.academy.dao;

import it.academy.model.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDao {

    List<Order> findAllOrders(int pageNumber, int pageSize);

    void createOrder(Order order);

    Order findOrderById(int id);

}
