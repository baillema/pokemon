package database.entities.pokemons.base;

import database.consts.Requests;
import database.entities.pokemons.translations.PokemonsHabitatsTranslationsEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "pokemons_habitats", schema = "public", catalog = "pokemondb")
@NamedQueries({
        @NamedQuery(name = Requests.POK_HAB_ALL,
                query = "SELECT x " +
                        "FROM PokemonsHabitatsEntity x"),
        @NamedQuery(name = Requests.POK_HAB_FROM_ID,
                query = "SELECT x " +
                        "FROM PokemonsHabitatsEntity x " +
                        "WHERE x.id = :id")
})
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
