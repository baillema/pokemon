package database.dao;

import database.entities.LanguagesEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

@Stateless
public class LanguagesDao {
    @PersistenceContext
    private EntityManager em;

    public void create(LanguagesEntity language) {
        em.persist(language);
    }

    public Collection<LanguagesEntity> readAll() {
        return em.createQuery("SELECT l FROM LanguagesEntity l")
                 .getResultList();
    }

    public LanguagesEntity read(int id) {
        return em.find(LanguagesEntity.class, id);
    }

    public void update(LanguagesEntity language) {
        em.merge(language);
    }

    public void delete(LanguagesEntity language) {
        em.remove(language);
    }

    public void delete(int id) {
        em.createQuery("DELETE FROM LanguagesEntity WHERE id = :id")
          .setParameter("id", id)
          .executeUpdate();
    }
}
