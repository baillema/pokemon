package database.dao.pokemons;

import database.entities.pokemons.PokemonsSpeciesTranslationsEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

@Stateless
public class PokemonSpeciesTranslationsDao {
    @PersistenceContext
    private EntityManager em;

    public void create(PokemonsSpeciesTranslationsEntity pokemonsSpeciesTranslations) {
        em.persist(pokemonsSpeciesTranslations);
    }

    public Collection<PokemonsSpeciesTranslationsEntity> readAll() {
        return em.createQuery("SELECT l FROM PokemonsSpeciesTranslationsEntity l")
                 .getResultList();
    }

    public Collection<PokemonsSpeciesTranslationsEntity> read(int speciesId) {
        return em.createQuery("SELECT p FROM PokemonsSpeciesTranslationsEntity p WHERE p.pokemonSpecieId = :speciesId")
          .setParameter("speciesId", speciesId)
          .getResultList();
    }

    public void update(PokemonsSpeciesTranslationsEntity pokemonsSpeciesTranslations) {
        em.merge(pokemonsSpeciesTranslations);
    }

    public void delete(PokemonsSpeciesTranslationsEntity pokemonsSpeciesTranslations) {
        em.remove(pokemonsSpeciesTranslations);
    }

    public void delete(int speciesId) {
        em.createQuery("DELETE FROM PokemonsSpeciesTranslationsEntity WHERE pokemonSpecieId = :speciesId")
          .setParameter("speciesId", speciesId)
          .executeUpdate();
    }
}
