package top.lionxxw.bookingcar.domain.repository;

/**
 * Package top.lionxxw.bookingcar.domain.repository
 * Project bookingcar
 *
 * Author lionxxw
 * Created on 2017/5/19 13:58
 * version 1.0.0
 */
public interface Repository<TE, T> extends ReadOnlyRepository<TE, T> {

    void add(TE entity);

    void remove(T id);

    void update(TE entity);
}