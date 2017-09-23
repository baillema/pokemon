package database.entities.pokemons;

import database.entities.pokemons.translations.PokemonsSpeciesTranslationsEntity;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "pokemons_species", schema = "public", catalog = "pokemondb")
public class PokemonsSpeciesEntity {
    private int id;
    private Set<PokemonsSpeciesTranslationsEntity> translations = new HashSet<>();

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "pokemon_specie_id")
    public Set<PokemonsSpeciesTranslationsEntity> getTranslations() {
        return this.translations;
    }

    public void setTranslations(Set<PokemonsSpeciesTranslationsEntity> translations) {
        this.translations = translations;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PokemonsSpeciesEntity entity = (PokemonsSpeciesEntity) o;

        if (id != entity.id) {
            return false;
        }

        return true;
    }
}
