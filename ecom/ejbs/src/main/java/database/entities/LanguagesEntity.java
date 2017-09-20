package database.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "languages", schema = "public", catalog = "pokemondb")
public class LanguagesEntity {
    private int id;
    private String name;
    //private Collection<PokemonsSpeciesTranslationsEntity> pokemonsSpeciesTranslationsById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        LanguagesEntity entity = (LanguagesEntity) o;

        if (id != entity.id) {
            return false;
        }
        if (name != null ? !name.equals(entity.name) : entity.name != null) {
            return false;
        }

        return true;
    }
    /*
    @OneToMany(mappedBy = "languagesByLanguageId")
    public Collection<PokemonsSpeciesTranslationsEntity> getPokemonsSpeciesTranslationsById() {
        return pokemonsSpeciesTranslationsById;
    }

    public void setPokemonsSpeciesTranslationsById(Collection<PokemonsSpeciesTranslationsEntity>
                                                           pokemonsSpeciesTranslationsById) {
        this.pokemonsSpeciesTranslationsById = pokemonsSpeciesTranslationsById;
    }*/
}
