/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top.lionxxw.bookingcar.domain.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.lionxxw.bookingcar.domain.entity.Entity;
import top.lionxxw.bookingcar.domain.entity.User;
import top.lionxxw.bookingcar.domain.repository.UserRepository;
import top.lionxxw.bookingcar.domain.service.BaseService;
import top.lionxxw.bookingcar.domain.service.UserService;

import java.util.Collection;

/**
 *
 * @author darren.shuxing.liu
 * 
 */
@Service("userService")
public class UserServiceImpl extends BaseService<User, String>
        implements UserService {

    private UserRepository<User, String> userRepository;

    /**
     *
     * @param userRepository
     */
    @Autowired
    public UserServiceImpl(UserRepository<User, String> userRepository) {
        super(userRepository);
        this.userRepository = userRepository;
    }

    @Override
    public void add(User user) throws Exception {
        if (userRepository.containsName(user.getName())) {
            throw new Exception(String.format("There is already a product with the name - %s", user.getName()));
        }

        if (user.getName() == null || "".equals(user.getName())) {
            throw new Exception("Booking name cannot be null or empty string.");
        }
        super.add(user);
    }

    /**
     *
     * @param name
     * @return
     * @throws Exception
     */
    @Override
    public Collection<User> findByName(String name) throws Exception {
        return userRepository.findByName(name);
    }

    /**
     *
     * @param user
     * @throws Exception
     */
    @Override
    public void update(User user) throws Exception {
        userRepository.update(user);
    }

    /**
     *
     * @param id
     * @throws Exception
     */
    @Override
    public void delete(String id) throws Exception {
        userRepository.remove(id);
    }

    /**
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public Entity findById(String id) throws Exception {
        return userRepository.get(id);
    }    
}
