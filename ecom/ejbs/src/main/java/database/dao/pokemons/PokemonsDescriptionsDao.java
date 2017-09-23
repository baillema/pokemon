package database.dao.pokemons;

import database.entities.pokemons.PokemonsDescriptionsEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

@Stateless
public class PokemonsDescriptionsDao {
    @PersistenceContext
    private EntityManager em;

    public void create(PokemonsDescriptionsEntity description) {
        em.persist(description);
    }

    public Collection<PokemonsDescriptionsEntity> readAll() {
        return em.createQuery("SELECT c FROM PokemonsDescriptionsEntity c")
                 .getResultList();
    }

    public PokemonsDescriptionsEntity read(int id) {
        return em.find(PokemonsDescriptionsEntity.class, id);
    }

    public void update(PokemonsDescriptionsEntity description) {
        em.merge(description);
    }

    public void delete(PokemonsDescriptionsEntity description) {
        em.remove(description);
    }

    public void delete(int id) {
        em.createQuery("DELETE FROM PokemonsDescriptionsEntity WHERE id = :id")
          .setParameter("id", id)
          .executeUpdate();
    }
}
