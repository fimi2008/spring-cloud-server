/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top.lionxxw.bookingcar.domain.repository;
import java.util.Collection;

/**
 *司机存储库
 * @author darren.shuxing.liu
 * @param <Driver>
 * @param <String>
 */
public interface DriverRepository<Driver, String> extends Repository<Driver, String> {

    /**
     *
     * @param name
     * @return
     */
    boolean containsName(String name);

    /**
     *
     * @param name
     * @return
     * @throws Exception
     */
    public Collection<Driver> findByName(String name) throws Exception;
}
