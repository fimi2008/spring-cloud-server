package top.lionxxw.bookingcar.domain.repository;

import java.util.Collection;

/**
 * Package top.lionxxw.bookingcar.domain.repository
 * Project bookingcar
 *
 * Author lionxxw
 * Created on 2017/5/19 14:01
 * version 1.0.0
 */
public interface OrderRepository<Order, String> extends Repository<Order, String> {

    boolean containsName(String name);

    Collection<Order> findByName(String name) throws Exception;

    Collection<Order> findByUserId(String userId) throws Exception;

    Order findById(String id) throws Exception;
}
