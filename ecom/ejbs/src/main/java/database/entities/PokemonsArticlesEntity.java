package database.entities;

import database.enums.ArticlesStatesEnum;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "pokemons_articles", schema = "public", catalog = "pokemondb")
public class PokemonsArticlesEntity implements Serializable {
    private int id;
    private float price;
    private String name;
    private String description;
    private int userId;
    private Integer cartId;
    private int pokemonId;
    private int level;
    private Boolean shininess;
    private ArticlesStatesEnum state;

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "price", nullable = true)
    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Basic
    @Column(name = "description", nullable = true)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "user_id", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "cart_id", nullable = true)
    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    @Basic
    @Column(name = "name", nullable = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "level", nullable = true)
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Basic
    @Column(name = "pokemon_id", nullable = false)
    public int getPokemonId() {
        return pokemonId;
    }

    public void setPokemonId(int pokemonId) {
        this.pokemonId = pokemonId;
    }

    @Basic
    @Column(name = "shininess", nullable = true)
    public Boolean getShininess() {
        return shininess;
    }

    public void setShininess(Boolean shininess) {
        this.shininess = shininess;
    }

    @Basic
    @Column(name = "state", nullable = true)
    public String getState() {
        return state.name();
    }

    public void setState(String state) {
        this.state = ArticlesStatesEnum.valueOf(state);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PokemonsArticlesEntity that = (PokemonsArticlesEntity) o;

        if (id != that.id) return false;
        if (Float.compare(that.price, price) != 0) return false;
        if (userId != that.userId) return false;
        if (cartId != that.cartId) return false;
        if (pokemonId != that.pokemonId) return false;
        if (level != that.level) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (shininess != null ? !shininess.equals(that.shininess) : that.shininess != null) return false;
        return state == that.state;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (price != +0.0f ? Float.floatToIntBits(price) : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + userId;
        result = 31 * result + cartId;
        result = 31 * result + pokemonId;
        result = 31 * result + level;
        result = 31 * result + (shininess != null ? shininess.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        return result;
    }
}
