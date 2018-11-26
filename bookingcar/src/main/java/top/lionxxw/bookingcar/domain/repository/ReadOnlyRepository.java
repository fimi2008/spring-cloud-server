package top.lionxxw.bookingcar.domain.repository;

import top.lionxxw.bookingcar.domain.entity.Entity;

import java.util.Collection;

/**
 * Package top.lionxxw.bookingcar.domain.repository
 * Project bookingcar
 *
 * Author lionxxw
 * Created on 2017/5/19 13:44
 * version 1.0.0
 */
public interface ReadOnlyRepository<TE, T> {
    boolean contains(T id);

    Entity get(T id);

    Collection<TE> getAll();
}
