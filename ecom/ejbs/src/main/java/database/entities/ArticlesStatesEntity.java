package database.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "articles_states", schema = "public", catalog = "pokemondb")
public class ArticlesStatesEntity {
    private int id;
    private String name;
    private Collection<ItemsArticlesEntity> itemsArticlesById;
    private Collection<PokemonsArticlesEntity> pokemonsArticlesById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 12)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArticlesStatesEntity that = (ArticlesStatesEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "articlesStatesByState")
    public Collection<ItemsArticlesEntity> getItemsArticlesById() {
        return itemsArticlesById;
    }

    public void setItemsArticlesById(Collection<ItemsArticlesEntity> itemsArticlesById) {
        this.itemsArticlesById = itemsArticlesById;
    }

    @OneToMany(mappedBy = "articlesStatesByState")
    public Collection<PokemonsArticlesEntity> getPokemonsArticlesById() {
        return pokemonsArticlesById;
    }

    public void setPokemonsArticlesById(Collection<PokemonsArticlesEntity> pokemonsArticlesById) {
        this.pokemonsArticlesById = pokemonsArticlesById;
    }
}
