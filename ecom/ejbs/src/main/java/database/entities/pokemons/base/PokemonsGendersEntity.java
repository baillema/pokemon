package database.entities.pokemons.base;

import database.consts.Requests;
import database.entities.pokemons.translations.PokemonsGendersTranslationsEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "pokemons_genders", schema = "public", catalog = "pokemondb")
@NamedQueries({
        @NamedQuery(name = Requests.POK_GEND_ALL,
                query = "SELECT x " +
                        "FROM PokemonsGendersEntity x"),
        @NamedQuery(name = Requests.POK_GEND_FROM_ID,
                query = "SELECT x " +
                        "FROM PokemonsGendersEntity x " +
                        "WHERE x.id = :id")
})
public class PokemonsGendersEntity {
    private int id;
    private Set<PokemonsGendersTranslationsEntity> translations = new HashSet<>();

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "gender_id")
    public Set<PokemonsGendersTranslationsEntity> getTranslations() {
        return this.translations;
    }

    public void setTranslations(Set<PokemonsGendersTranslationsEntity> translations) {
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

        PokemonsGendersEntity entity = (PokemonsGendersEntity) o;

        if (id != entity.id) {
            return false;
        }

        return true;
    }
}
