package database.entities.pokemons;

import database.entities.pokemons.translations.PokemonsGendersTranslationsEntity;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "pokemons_genders", schema = "public", catalog = "pokemondb")
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
