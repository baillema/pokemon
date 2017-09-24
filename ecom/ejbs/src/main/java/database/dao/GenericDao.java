package database.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;
import java.util.List;

@Stateless
public class GenericDao<T> implements IGenericDao<T> {
    @PersistenceContext
    protected EntityManager em;

    private Class<T> type;

    public GenericDao() {}

    public GenericDao(Class clazz) {
        type = clazz;
    }

    @Override
    public T create(T t) {
        this.em.persist(t);
        return t;
    }

    @Override
    public void delete(final Object id) {
        this.em.remove(this.em.getReference(type, id));
    }

    @Override
    public T update(final T t) {
        return this.em.merge(t);
    }

    @Override
    public T find(final int id) {
        return this.em.find(type, id);
    }

    @Override
    public Collection<T> findWithNamedQuery(String queryName) {
        return (Collection<T>) this.em.createNamedQuery(queryName).getResultList();
    }

    @Override
    public Collection findWithNamedQuery(String queryName, int id) {
        return (Collection<T>) this.em.createNamedQuery(queryName).setParameter("id", id).getResultList();
    }

    @Override
    public Collection findWithNamedQuery(String queryName, String str) {
        return (Collection<T>) this.em.createNamedQuery(queryName).setParameter("str", str).getResultList();
    }

    @Override
    public Collection findWithNamedQuery(String queryName, int id, int lang) {
        return (Collection<T>) this.em.createNamedQuery(queryName).setParameter("id", id).setParameter("lang", lang).getResultList();
    }
}
