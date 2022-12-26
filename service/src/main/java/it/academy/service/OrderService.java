package it.academy.service;

import it.academy.dao.OrderDao;
import it.academy.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderDao orderDao;

    @Transactional
    public void addNewOrder(Order order) {
        orderDao.createOrder(order);
    }

    @Transactional
    public List listOfOrders(int pageNumber, int pageSize) {
        return orderDao.findAllOrders(pageNumber,pageSize);
    }

}