package database.entities.pokemons;

import database.entities.pokemons.translations.PokemonsHabitatsTranslationsEntity;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "pokemons_habitats", schema = "public", catalog = "pokemondb")
public class PokemonsHabitatsEntity {
    private int id;
    private Set<PokemonsHabitatsTranslationsEntity> translations = new HashSet<>();

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "pokemon_habitat_id")
    public Set<PokemonsHabitatsTranslationsEntity> getTranslations() {
        return this.translations;
    }

    public void setTranslations(Set<PokemonsHabitatsTranslationsEntity> translations) {
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

        PokemonsHabitatsEntity entity = (PokemonsHabitatsEntity) o;

        if (id != entity.id) {
            return false;
        }

        return true;
    }
}
