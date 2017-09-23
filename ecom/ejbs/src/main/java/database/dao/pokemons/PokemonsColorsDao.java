package database.dao.pokemons;

import database.entities.pokemons.PokemonsColorsEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

@Stateless
public class PokemonsColorsDao {
    @PersistenceContext
    private EntityManager em;

    public void create(PokemonsColorsEntity color) {
        em.persist(color);
    }

    public Collection<PokemonsColorsEntity> readAll() {
        return em.createQuery("SELECT c FROM PokemonsColorsEntity c")
                 .getResultList();
    }

    public PokemonsColorsEntity read(int id) {
        return em.find(PokemonsColorsEntity.class, id);
    }

    public void update(PokemonsColorsEntity color) {
        em.merge(color);
    }

    public void delete(PokemonsColorsEntity color) {
        em.remove(color);
    }

    public void delete(int id) {
        em.createQuery("DELETE FROM PokemonsColorsEntity WHERE id = :id")
          .setParameter("id", id)
          .executeUpdate();
    }
}
