package top.lionxxw.bookingcar.domain.service;

import top.lionxxw.bookingcar.domain.repository.Repository;

import java.util.Collection;

/**
 * Package top.lionxxw.bookingcar.domain.service
 * Project bookingcar
 *
 * Author lionxxw
 * Created on 2017/5/19 14:35
 * version 1.0.0
 */
public abstract class BaseService<TE, T> extends ReadOnlyBaseService<TE, T> {
    private Repository<TE, T> _repository;
    public BaseService(Repository<TE, T> repository) {
        super(repository);
        _repository = repository;
    }

    public void add(TE entity) throws Exception{
        _repository.add(entity);
    }

    public Collection<TE> getAll(){
        return _repository.getAll();
    }
}
