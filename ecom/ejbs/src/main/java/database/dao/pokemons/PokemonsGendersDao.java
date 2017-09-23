package database.dao.pokemons;

import database.entities.pokemons.PokemonsGendersEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

@Stateless
public class PokemonsGendersDao {
    @PersistenceContext
    private EntityManager em;

    public void create(PokemonsGendersEntity gender) {
        em.persist(gender);
    }

    public Collection<PokemonsGendersEntity> readAll() {
        return em.createQuery("SELECT c FROM PokemonsGendersEntity c")
                 .getResultList();
    }

    public PokemonsGendersEntity read(int id) {
        return em.find(PokemonsGendersEntity.class, id);
    }

    public void update(PokemonsGendersEntity gender) {
        em.merge(gender);
    }

    public void delete(PokemonsGendersEntity gender) {
        em.remove(gender);
    }

    public void delete(int id) {
        em.createQuery("DELETE FROM PokemonsGendersEntity WHERE id = :id")
          .setParameter("id", id)
          .executeUpdate();
    }
}
