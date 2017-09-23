package database.dao;

import java.util.Collection;

public interface IGenericDao<T> {
    T create(T t);

    void delete(T t);

    T update(T t);

    Collection findWithNamedQuery(String queryName);

    Collection findWithNamedQuery(String queryName, int id);

    Collection findWithNamedQuery(String queryName, String name);

    Collection findWithNamedQuery(String queryName, int id, int lang);
}
