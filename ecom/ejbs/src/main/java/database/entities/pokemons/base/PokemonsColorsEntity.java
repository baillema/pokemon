package database.entities.pokemons.base;

import database.consts.Requests;
import database.entities.pokemons.translations.PokemonsColorsTranslationsEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "pokemons_colors", schema = "public", catalog = "pokemondb")
@NamedQueries({
        @NamedQuery(name = Requests.POK_COL_ALL,
                    query = "SELECT x " +
                            "FROM PokemonsColorsEntity x"),
        @NamedQuery(name = Requests.POK_COL_FROM_ID,
                    query = "SELECT x " +
                            "FROM PokemonsColorsEntity x " +
                            "WHERE x.id = :id")
})
public class PokemonsColorsEntity {
    private int id;
    private Set<PokemonsColorsTranslationsEntity> translations = new HashSet<>();

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "pokemon_color_id")
    public Set<PokemonsColorsTranslationsEntity> getTranslations() {
        return this.translations;
    }

    public void setTranslations(Set<PokemonsColorsTranslationsEntity> translations) {
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

        PokemonsColorsEntity entity = (PokemonsColorsEntity) o;

        if (id != entity.id) {
            return false;
        }

        return true;
    }
}
