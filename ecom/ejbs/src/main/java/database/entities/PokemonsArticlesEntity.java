package database.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "pokemons_articles", schema = "public", catalog = "pokemondb")
public class PokemonsArticlesEntity {
    private int id;
    private String name;
    private Float price;
    private String description;
    private Boolean shininess;
    private Integer level;
    private int pokemonId;
    private int state;
    private int userId;
    private Integer cartId;
    private Collection<FeedbackEntity> feedbacksById;
    private PokemonsEntity pokemonsByPokemonId;
    private ArticlesStatesEntity articlesStatesByState;
    private UsersEntity usersByUserId;
    private CartsEntity cartsByCartId;
    private Collection<SuggestionsEntity> suggestionsById;
    private Collection<SuggestionsEntity> suggestionsById_0;
    private Collection<TradesEntity> tradesById;
    private Collection<TradesEntity> tradesById_0;

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

    @Basic
    @Column(name = "price", nullable = true, precision = 0)
    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Basic
    @Column(name = "description", nullable = true, length = -1)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
    @Column(name = "level", nullable = true)
    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
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
    @Column(name = "state", nullable = false)
    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PokemonsArticlesEntity that = (PokemonsArticlesEntity) o;

        if (id != that.id) return false;
        if (pokemonId != that.pokemonId) return false;
        if (state != that.state) return false;
        if (userId != that.userId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (shininess != null ? !shininess.equals(that.shininess) : that.shininess != null) return false;
        if (level != null ? !level.equals(that.level) : that.level != null) return false;
        if (cartId != null ? !cartId.equals(that.cartId) : that.cartId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (shininess != null ? shininess.hashCode() : 0);
        result = 31 * result + (level != null ? level.hashCode() : 0);
        result = 31 * result + pokemonId;
        result = 31 * result + state;
        result = 31 * result + userId;
        result = 31 * result + (cartId != null ? cartId.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "pokemonsArticlesByPokemonId")
    public Collection<FeedbackEntity> getFeedbacksById() {
        return feedbacksById;
    }

    public void setFeedbacksById(Collection<FeedbackEntity> feedbacksById) {
        this.feedbacksById = feedbacksById;
    }

    @ManyToOne
    @JoinColumn(name = "pokemon_id", referencedColumnName = "id", nullable = false)
    public PokemonsEntity getPokemonsByPokemonId() {
        return pokemonsByPokemonId;
    }

    public void setPokemonsByPokemonId(PokemonsEntity pokemonsByPokemonId) {
        this.pokemonsByPokemonId = pokemonsByPokemonId;
    }

    @ManyToOne
    @JoinColumn(name = "state", referencedColumnName = "id", nullable = false)
    public ArticlesStatesEntity getArticlesStatesByState() {
        return articlesStatesByState;
    }

    public void setArticlesStatesByState(ArticlesStatesEntity articlesStatesByState) {
        this.articlesStatesByState = articlesStatesByState;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    public UsersEntity getUsersByUserId() {
        return usersByUserId;
    }

    public void setUsersByUserId(UsersEntity usersByUserId) {
        this.usersByUserId = usersByUserId;
    }

    @ManyToOne
    @JoinColumn(name = "cart_id", referencedColumnName = "id")
    public CartsEntity getCartsByCartId() {
        return cartsByCartId;
    }

    public void setCartsByCartId(CartsEntity cartsByCartId) {
        this.cartsByCartId = cartsByCartId;
    }

    @OneToMany(mappedBy = "pokemonsArticlesByPokemonArticleId")
    public Collection<SuggestionsEntity> getSuggestionsById() {
        return suggestionsById;
    }

    public void setSuggestionsById(Collection<SuggestionsEntity> suggestionsById) {
        this.suggestionsById = suggestionsById;
    }

    @OneToMany(mappedBy = "pokemonsArticlesByPokemonArticleCoupledId")
    public Collection<SuggestionsEntity> getSuggestionsById_0() {
        return suggestionsById_0;
    }

    public void setSuggestionsById_0(Collection<SuggestionsEntity> suggestionsById_0) {
        this.suggestionsById_0 = suggestionsById_0;
    }

    @OneToMany(mappedBy = "pokemonsArticlesByFirstPokemonId")
    public Collection<TradesEntity> getTradesById() {
        return tradesById;
    }

    public void setTradesById(Collection<TradesEntity> tradesById) {
        this.tradesById = tradesById;
    }

    @OneToMany(mappedBy = "pokemonsArticlesBySecondPokemonId")
    public Collection<TradesEntity> getTradesById_0() {
        return tradesById_0;
    }

    public void setTradesById_0(Collection<TradesEntity> tradesById_0) {
        this.tradesById_0 = tradesById_0;
    }
}
