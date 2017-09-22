package database.dao.pokemons;

import database.entities.pokemons.PokemonsSpeciesEntity;
import database.entities.pokemons.PokemonsSpeciesTranslationsEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

public class PokemonsSpeciesDao {
    @PersistenceContext
    private EntityManager em;

    public void create(PokemonsSpeciesEntity pokemonsSpecies) {
        em.persist(pokemonsSpecies);
    }

    public Collection<PokemonsSpeciesEntity> readAll() {
        return em.createQuery("SELECT p FROM PokemonsSpeciesTranslationsEntity p")
                 .getResultList();
    }

    public PokemonsSpeciesEntity read(int id) {
        return em.find(PokemonsSpeciesEntity.class, id);
    }

    public void update(PokemonsSpeciesEntity pokemonsSpecies) {
        em.merge(pokemonsSpecies);
    }

    public void delete(PokemonsSpeciesEntity pokemonsSpecies) {
        em.remove(pokemonsSpecies);
    }

    public void delete(int id) {
        em.createQuery("DELETE FROM PokemonsSpeciesEntity WHERE id = :id")
          .setParameter("id", id)
          .executeUpdate();
    }
}
