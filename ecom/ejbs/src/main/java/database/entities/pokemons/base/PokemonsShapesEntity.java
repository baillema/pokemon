package database.entities.pokemons.base;

import database.consts.Requests;
import database.entities.pokemons.translations.PokemonsShapesTranslationsEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "pokemons_shapes", schema = "public", catalog = "pokemondb")
@NamedQueries({
        @NamedQuery(name = Requests.POK_SHAP_ALL,
                query = "SELECT x " +
                        "FROM PokemonsShapesEntity x"),
        @NamedQuery(name = Requests.POK_SHAP_FROM_ID,
                query = "SELECT x " +
                        "FROM PokemonsShapesEntity x " +
                        "WHERE x.id = :id")
})
public class PokemonsShapesEntity {
    private int id;
    private Set<PokemonsShapesTranslationsEntity> translations = new HashSet<>();

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "pokemon_shape_id")
    public Set<PokemonsShapesTranslationsEntity> getTranslations() {
        return this.translations;
    }

    public void setTranslations(Set<PokemonsShapesTranslationsEntity> translations) {
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

        PokemonsShapesEntity entity = (PokemonsShapesEntity) o;

        if (id != entity.id) {
            return false;
        }

        return true;
    }
}
