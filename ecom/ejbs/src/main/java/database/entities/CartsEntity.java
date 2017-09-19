package database.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "carts", schema = "public", catalog = "pokemondb")
public class CartsEntity {
    private int id;
    private Collection<ItemsArticlesCartsEntity> itemsArticlesCartsById;
    private Collection<PokemonsArticlesEntity> pokemonsArticlesById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CartsEntity that = (CartsEntity) o;

        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @OneToMany(mappedBy = "cartsByIdCart")
    public Collection<ItemsArticlesCartsEntity> getItemsArticlesCartsById() {
        return itemsArticlesCartsById;
    }

    public void setItemsArticlesCartsById(Collection<ItemsArticlesCartsEntity> itemsArticlesCartsById) {
        this.itemsArticlesCartsById = itemsArticlesCartsById;
    }

    @OneToMany(mappedBy = "cartsByCartId")
    public Collection<PokemonsArticlesEntity> getPokemonsArticlesById() {
        return pokemonsArticlesById;
    }

    public void setPokemonsArticlesById(Collection<PokemonsArticlesEntity> pokemonsArticlesById) {
        this.pokemonsArticlesById = pokemonsArticlesById;
    }
}
