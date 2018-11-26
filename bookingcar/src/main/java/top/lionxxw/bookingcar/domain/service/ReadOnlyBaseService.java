package top.lionxxw.bookingcar.domain.service;

import top.lionxxw.bookingcar.domain.repository.Repository;

/**
 * Package top.lionxxw.bookingcar.domain.service
 * Project bookingcar
 *
 * Author lionxxw
 * Created on 2017/5/19 14:32
 * version 1.0.0
 */
public abstract class ReadOnlyBaseService<TE,T> {
    private Repository<TE, T> repository;

    public ReadOnlyBaseService(Repository<TE, T> repository) {
        this.repository = repository;
    }
}
