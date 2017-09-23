package database.dao.pokemons;

import database.entities.pokemons.PokemonsHabitatsEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

public class PokemonsHabitatsDao {
    @PersistenceContext
    private EntityManager em;

    public void create(PokemonsHabitatsEntity habitat) {
        em.persist(habitat);
    }

    public Collection<PokemonsHabitatsEntity> readAll() {
        return em.createQuery("SELECT c FROM PokemonsHabitatsEntity c")
                 .getResultList();
    }

    public PokemonsHabitatsEntity read(int id) {
        return em.find(PokemonsHabitatsEntity.class, id);
    }

    public void update(PokemonsHabitatsEntity habitat) {
        em.merge(habitat);
    }

    public void delete(PokemonsHabitatsEntity habitat) {
        em.remove(habitat);
    }

    public void delete(int id) {
        em.createQuery("DELETE FROM PokemonsHabitatsEntity WHERE id = :id")
          .setParameter("id", id)
          .executeUpdate();
    }
}
