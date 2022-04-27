package org.billboard.repository;

import java.io.Serializable;
import java.util.List;

public interface CrudRepository<T extends Serializable> {

    void save(T entity);

    T findOne(int ID);

    List<T> findAll();

    boolean exists(int ID);

    void delete(int ID);
}
