package database.entities.pokemons.base;

import database.consts.Requests;
import database.entities.pokemons.translations.PokemonsDescriptionsTranslationsEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "pokemons_descriptions", schema = "public", catalog = "pokemondb")
@NamedQueries({
        @NamedQuery(name = Requests.POK_DESC_ALL,
                query = "SELECT x " +
                        "FROM PokemonsDescriptionsEntity x"),
        @NamedQuery(name = Requests.POK_DESC_FROM_ID,
                query = "SELECT x " +
                        "FROM PokemonsDescriptionsEntity x " +
                        "WHERE x.id = :id")
})
public class PokemonsDescriptionsEntity {
    private int id;
    private Set<PokemonsDescriptionsTranslationsEntity> translations = new HashSet<>();

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "pokemon_description_id")
    public Set<PokemonsDescriptionsTranslationsEntity> getTranslations() {
        return this.translations;
    }

    public void setTranslations(Set<PokemonsDescriptionsTranslationsEntity> translations) {
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

        PokemonsDescriptionsEntity entity = (PokemonsDescriptionsEntity) o;

        if (id != entity.id) {
            return false;
        }

        return true;
    }
}
