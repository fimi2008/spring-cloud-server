package top.lionxxw.bookingcar.domain.repository;

import top.lionxxw.bookingcar.domain.entity.Entity;
import top.lionxxw.bookingcar.domain.entity.Order;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Package top.lionxxw.bookingcar.domain.repository
 * Project bookingcar
 *
 * Author lionxxw
 * Created on 2017/5/19 14:06
 * version 1.0.0
 */
@org.springframework.stereotype.Repository("orderRepository")
public class InMemOrderRepository implements OrderRepository<Order, String> {

    private Map<String, Order> entities;

    public InMemOrderRepository() {
        entities = new HashMap();
        Order order = new Order("1", "订单1", "1", "5","从地狱到天堂", LocalDate.now(), LocalTime.now(),new BigDecimal("8888.00"));
        entities.put("1", order);
        Order order2 = new Order("2", "订单2", "1", "8","从北京到上海", LocalDate.now(), LocalTime.now(),new BigDecimal("888.00"));
        entities.put("2", order2);
        Order order3 = new Order("3", "订单3", "2", "8","从南山到福田", LocalDate.now(), LocalTime.now(),new BigDecimal("88.00"));
        entities.put("3", order3);
    }

    @Override
    public void add(Order entity) {
        entities.put(entity.getId(), entity);
    }

    @Override
    public void remove(String id) {
        if (entities.containsKey(id)) entities.remove(id);
    }

    @Override
    public boolean containsName(String name) {
        try {
            return this.findByName(name).size() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void update(Order entity) {
        if (entities.containsKey(entity.getId())) entities.put(entity.getId(), entity);
    }

    @Override
    public boolean contains(String id) {
        return entities.containsKey(id);
    }

    @Override
    public Entity get(String id) {
        return entities.get(id);
    }

    @Override
    public Collection<Order> findByName(String name) throws Exception {
        Collection<Order> orders = new ArrayList<>();
        entities.forEach((k, v) -> {
            if (v.getName().toLowerCase().contains(name.toLowerCase().substring(0, name.length()))){
                orders.add(v);
            }
        });
        return orders;
    }

    @Override
    public Collection<Order> findByUserId(String userId) throws Exception {
        Collection<Order> orders = new ArrayList<>();
        entities.forEach((k, v) -> {
            if (v.getUserId().equals(userId)){
                orders.add(v);
            }
        });
        return orders;
    }

    @Override
    public Order findById(String id) throws Exception {
        return entities.get(id);
    }

    @Override
    public Collection<Order> getAll() {
        return entities.values();
    }
}
