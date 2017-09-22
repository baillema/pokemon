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

    public PokemonsSpeciesTranslationsEntity read(int speciesId) {
        return em.find(PokemonsSpeciesTranslationsEntity.class, speciesId);
    }

    public void update(PokemonsSpeciesTranslationsEntity pokemonsSpeciesTranslations) {
        em.merge(pokemonsSpeciesTranslations);
    }

    public void delete(PokemonsSpeciesTranslationsEntity pokemonsSpeciesTranslations) {
        em.remove(pokemonsSpeciesTranslations);
    }

    public void delete(int speciesId) {
        em.createQuery("DELETE FROM PokemonsSpeciesTranslationsEntity WHERE  pokemonSpecieId = :speciesId")
          .setParameter("speciesId", speciesId)
          .executeUpdate();
    }
}
