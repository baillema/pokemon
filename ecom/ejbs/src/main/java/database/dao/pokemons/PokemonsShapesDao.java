package database.dao.pokemons;

import database.entities.pokemons.PokemonsShapesEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

public class PokemonsShapesDao {
    @PersistenceContext
    private EntityManager em;

    public void create(PokemonsShapesEntity shape) {
        em.persist(shape);
    }

    public Collection<PokemonsShapesEntity> readAll() {
        return em.createQuery("SELECT c FROM PokemonsShapesEntity c")
                 .getResultList();
    }

    public PokemonsShapesEntity read(int id) {
        return em.find(PokemonsShapesEntity.class, id);
    }

    public void update(PokemonsShapesEntity shape) {
        em.merge(shape);
    }

    public void delete(PokemonsShapesEntity shape) {
        em.remove(shape);
    }

    public void delete(int id) {
        em.createQuery("DELETE FROM PokemonsShapesEntity WHERE id = :id")
          .setParameter("id", id)
          .executeUpdate();
    }
}
