package database.services;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class GenericDaoJpaImpl<T> implements GenericDao<T> {

    @PersistenceContext(name = "pokemonDB")
    protected EntityManager em;

    private Class<T> type;

    public GenericDaoJpaImpl() {
    }

    public GenericDaoJpaImpl(Class clazz) {
        type = clazz;
    }

    @Override
    public T create(final T t) {
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
}