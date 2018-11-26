package top.lionxxw.bookingcar.domain.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.lionxxw.bookingcar.domain.entity.Entity;
import top.lionxxw.bookingcar.domain.entity.Order;
import top.lionxxw.bookingcar.domain.repository.OrderRepository;
import top.lionxxw.bookingcar.domain.service.BaseService;
import top.lionxxw.bookingcar.domain.service.OrderService;

import java.util.Collection;

/**
 * Package top.lionxxw.bookingcar.domain.service.impl
 * Project bookingcar
 *
 * Author lionxxw
 * Created on 2017/5/19 14:39
 * version 1.0.0
 */
@Service("orderService")
public class OrderServiceImpl extends BaseService<Order, String> implements OrderService {

    private OrderRepository<Order, String> orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository<Order, String> repository) {
        super(repository);
        this.orderRepository = repository;
    }

    public void add(Order order) throws Exception{
        if (orderRepository.containsName(order.getName())){
            throw new Exception(String.format("there is already a order withc name - %s", order.getName()));
        }

        if (order.getName() == null || "".equals(order.getName())){
            throw new Exception("order name cannot be null or empty string");
        }
        super.add(order);
    }

    @Override
    public void update(Order order) throws Exception {
        orderRepository.update(order);
    }

    @Override
    public void delete(String id) throws Exception {
        orderRepository.remove(id);
    }

    @Override
    public Collection<Order> findByUserId(String userId) throws Exception {
        return orderRepository.findByUserId(userId);
    }

    @Override
    public Entity findById(String id) throws Exception {
        return orderRepository.get(id);
    }

    @Override
    public boolean contains(String id) {
        return orderRepository.contains(id);
    }

    @Override
    public Entity get(String id) {
        return orderRepository.get(id);
    }
}
