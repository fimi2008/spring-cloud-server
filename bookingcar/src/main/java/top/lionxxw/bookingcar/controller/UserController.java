package top.lionxxw.bookingcar.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import top.lionxxw.bookingcar.domain.entity.Entity;
import top.lionxxw.bookingcar.domain.entity.User;
import top.lionxxw.bookingcar.domain.service.UserService;

import java.util.Collection;

/**
 * Package top.lionxxw.bookingcar.controller
 * Project bookingcar
 *
 * Author lionxxw
 * Created on 2017/5/19 15:03
 * version 1.0.0
 */
@RestController
@RequestMapping("/v1/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 通过用户名称来获得用户.
     * http://.../v1/user?name={name}
     * @param name
     * @return 用户集合
     */
    @GetMapping
    public ResponseEntity<Collection<User>> findByName(@RequestParam("name") String name) {
        log.info(String.format("订车管理微服务，通过名字查找用户：invoked by {%s} , name = {%s} ",
                userService.getClass().getName(), name));
        name = name.trim().toLowerCase();
        Collection<User> users;
        try {
            users = userService.findByName(name);
        } catch (Exception ex) {
            log.error("异常 {0}", ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return users.size() > 0 ? new ResponseEntity<>(users, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * 通过id获取用户信息
     * http://.../v1/user/{id}
     *
     *
     * @param id
     * @return 用户.
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<Entity> findById(@PathVariable("id") String id) {
        log.info(String.format("订车管理微服务，通过id查找用户：invoked by {%s} , name = {%s} ",
                userService.getClass().getName(), id));
        id = id.trim();
        Entity user;
        try {
            user = userService.findById(id);
        } catch (Exception ex) {
            log.error("异常：通过ID查找用户 {0}", ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return user != null ? new ResponseEntity<>(user, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
