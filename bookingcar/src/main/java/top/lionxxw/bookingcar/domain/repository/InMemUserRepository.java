/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top.lionxxw.bookingcar.domain.repository;

import org.springframework.stereotype.Repository;
import top.lionxxw.bookingcar.domain.entity.Entity;
import top.lionxxw.bookingcar.domain.entity.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author darren.shuxing.liu
 */
@Repository("userRepository")
public class InMemUserRepository implements UserRepository<User, String> {

    private Map<String, User> entities;

    /**
     * 实际中要从数据库里读取数据，这里使用演示数据
     */
    public InMemUserRepository() {
        entities = new HashMap();
        User user = new User("1", "User Name 1", "Address 1", "9999911111");
        entities.put("1", user);
        User user2 = new User("2", "User Name 2", "Address 2", "9999922222");
        entities.put("2", user2);
    }

    /**
     * Check if given user name already exist.
     *
     * @param name
     * @return true if already exist, else false
     */
    @Override
    public boolean containsName(String name) {
        try {
            return this.findByName(name).size() > 0;
        } catch (Exception ex) {
            //Exception Handler
        }
        return false;
    }

    /**
     *
     * @param entity
     */
    @Override
    public void add(User entity) {
        entities.put(entity.getId(), entity);
    }

    /**
     *
     * @param id
     */
    @Override
    public void remove(String id) {
        if (entities.containsKey(id)) {
            entities.remove(id);
        }
    }

    /**
     *
     * @param entity
     */
    @Override
    public void update(User entity) {
        if (entities.containsKey(entity.getId())) {
            entities.put(entity.getId(), entity);
        }
    }


    @Override
    public boolean contains(String id) {
        return entities.containsKey(id);
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Entity get(String id) {
        return entities.get(id);
    }

    /**
     *
     * @return
     */
    @Override
    public Collection<User> getAll() {
        return entities.values();
    }

    /**
     *
     * @param name
     * @return
     * @throws Exception
     */
    @Override
    public Collection<User> findByName(String name) throws Exception {
        Collection<User> users = new ArrayList();
        int noOfChars = name.length();
        entities.forEach((k, v) -> {
            if (v.getName().toLowerCase().contains(name.toLowerCase().subSequence(0, noOfChars))) {
                users.add(v);
            }
        });
        return users;
    }

}
