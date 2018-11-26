/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top.lionxxw.bookingcar.domain.service;

import top.lionxxw.bookingcar.domain.entity.Entity;
import top.lionxxw.bookingcar.domain.entity.User;

import java.util.Collection;


/**
 *
 * @author darren.shuxing.liu
 */
public interface UserService {

    /**
     *
     * @param user
     * @throws Exception
     */
    public void add(User user) throws Exception;

    /**
     *
     * @param user
     * @throws Exception
     */
    public void update(User user) throws Exception;

    /**
     *
     * @param id
     * @throws Exception
     */
    public void delete(String id) throws Exception;

    /**
     *
     * @param id
     * @return
     * @throws Exception
     */
    public Entity findById(String id) throws Exception;

    /**
     *
     * @param name
     * @return
     * @throws Exception
     */
    public Collection<User> findByName(String name) throws Exception;    
}
