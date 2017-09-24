package database.services;

import java.util.List;

public interface GenericDao<T> {
    T create(T t);

    void delete(T t);

    T update(T t);

    T find(int id);
}
