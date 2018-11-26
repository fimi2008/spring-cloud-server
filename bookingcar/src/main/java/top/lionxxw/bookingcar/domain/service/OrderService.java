package top.lionxxw.bookingcar.domain.service;

import top.lionxxw.bookingcar.domain.entity.Entity;
import top.lionxxw.bookingcar.domain.entity.Order;
import top.lionxxw.bookingcar.domain.repository.ReadOnlyRepository;

import java.util.Collection;

/**
 * Package top.lionxxw.bookingcar.domain.service
 * Project bookingcar
 *
 * Author lionxxw
 * Created on 2017/5/19 14:41
 * version 1.0.0
 */
public interface OrderService extends ReadOnlyRepository<Order, String> {

    void add(Order order) throws Exception;

    void update(Order order) throws Exception;

    void delete(String id) throws Exception;

    Collection<Order> findByUserId(String userId) throws Exception;

    Entity findById(String id) throws Exception;
}
