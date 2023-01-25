package it.academy.dao.order;

import it.academy.model.car.Car;
import it.academy.model.order.Order;
import it.academy.repository.order.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDaoImpl implements OrderDao {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public List<Order> findAllOrders(int pageNumber, int pageSize) {
        return orderRepository.findAll(PageRequest.of(pageNumber, pageSize)).getContent();
    }

    @Override
    public void createOrder(Order order) {
        orderRepository.save(order);
    }

    @Override
    public Order findOrderById(int id) {
        return orderRepository.findById(id).isPresent() ? orderRepository.findById(id).get() : null;
    }

    @Override
    public void deleteOrderById(int id) {
        orderRepository.deleteById(id);
    }

    @Override
    public void deleteByCarId(int carId) {
        orderRepository.deleteByCarId(carId);
    }


}
