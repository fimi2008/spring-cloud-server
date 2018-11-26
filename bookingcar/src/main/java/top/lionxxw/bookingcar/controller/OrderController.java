package top.lionxxw.bookingcar.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import top.lionxxw.bookingcar.domain.entity.Entity;
import top.lionxxw.bookingcar.domain.entity.Order;
import top.lionxxw.bookingcar.domain.service.OrderService;

import java.util.Collection;

/**
 * Package top.lionxxw.bookingcar.controller
 * Project bookingcar
 *
 * Author lionxxw
 * Created on 2017/5/19 15:08
 * version 1.0.0
 */
@RestController
@RequestMapping("/v1/order")
@Slf4j
public class OrderController {

    @Autowired
    protected OrderService orderService;

    /**
     * 通过用户ID来获得订单.
     * http://.../v1/order?userid={userid}
     * @param userId
     * @return 订单集合
     */
    @GetMapping()
    public ResponseEntity<Collection<Order>> findByUserId(@RequestParam("userid") String userId) {
        log.info(String.format("订车管理微服务，通过用户ID查找订单：invoked by {%s}, userId {%s}",
                orderService.getClass().getName(), userId));
        userId = userId.trim();
        Collection<Order> orders;
        try {
            orders = orderService.findByUserId(userId);
        } catch (Exception ex) {
            log.error("异常:{0} ", ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return orders.size() > 0 ? new ResponseEntity<>(orders, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



    /**
     * 通过id获取订单信息
     * http://.../v1/order/{id}
     *
     *
     * @param id
     * @return 订单.
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<Entity> findById(@PathVariable("id") String id) {
        log.info(String.format("订车管理微服务，通过订单ID查找订单：invoked by {%s}, order id {%s} ",
                orderService.getClass().getName(), id));
        id = id.trim();
        Entity order;
        try {
            order = orderService.findById(id);
        } catch (Exception ex) {
            log.error("异常：{0} ", ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return order != null ? new ResponseEntity<>(order, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    /**
     * 数据服务
     * 通过Order ID来获得订单名称.
     * http://.../v1/order/name/{id}
     * @param id
     * @return 订单名称
     */
    @GetMapping(value = "/name/{id}")
    public String getOrderName(@PathVariable("id") String id) {
        id = id.trim();
        Entity order;
        try {
            order = orderService.findById(id);
        } catch (Exception ex) {
            return "Exception happened";
        }
        return order != null ? order.getName() : "No such order";
    }
}
