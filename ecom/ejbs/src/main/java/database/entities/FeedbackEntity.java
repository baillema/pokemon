package database.entities;

import javax.persistence.*;

@Entity
@Table(name = "feedback", schema = "public", catalog = "pokemondb")
public class FeedbackEntity {
    private int id;
    private String text;
    private Integer mark;
    private Integer authorId;
    private Integer pokemonId;
    private Integer itemId;
    private Integer userId;
    private UsersEntity usersByAuthorId;
    private PokemonsArticlesEntity pokemonsArticlesByPokemonId;
    private ItemsArticlesEntity itemsArticlesByItemId;
    private UsersEntity usersByUserId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "text", nullable = true, length = -1)
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Basic
    @Column(name = "mark", nullable = true)
    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    @Basic
    @Column(name = "author_id", nullable = true)
    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    @Basic
    @Column(name = "pokemon_id", nullable = true)
    public Integer getPokemonId() {
        return pokemonId;
    }

    public void setPokemonId(Integer pokemonId) {
        this.pokemonId = pokemonId;
    }

    @Basic
    @Column(name = "item_id", nullable = true)
    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    @Basic
    @Column(name = "user_id", nullable = true)
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FeedbackEntity that = (FeedbackEntity) o;

        if (id != that.id) return false;
        if (text != null ? !text.equals(that.text) : that.text != null) return false;
        if (mark != null ? !mark.equals(that.mark) : that.mark != null) return false;
        if (authorId != null ? !authorId.equals(that.authorId) : that.authorId != null) return false;
        if (pokemonId != null ? !pokemonId.equals(that.pokemonId) : that.pokemonId != null) return false;
        if (itemId != null ? !itemId.equals(that.itemId) : that.itemId != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (mark != null ? mark.hashCode() : 0);
        result = 31 * result + (authorId != null ? authorId.hashCode() : 0);
        result = 31 * result + (pokemonId != null ? pokemonId.hashCode() : 0);
        result = 31 * result + (itemId != null ? itemId.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    public UsersEntity getUsersByAuthorId() {
        return usersByAuthorId;
    }

    public void setUsersByAuthorId(UsersEntity usersByAuthorId) {
        this.usersByAuthorId = usersByAuthorId;
    }

    @ManyToOne
    @JoinColumn(name = "pokemon_id", referencedColumnName = "id")
    public PokemonsArticlesEntity getPokemonsArticlesByPokemonId() {
        return pokemonsArticlesByPokemonId;
    }

    public void setPokemonsArticlesByPokemonId(PokemonsArticlesEntity pokemonsArticlesByPokemonId) {
        this.pokemonsArticlesByPokemonId = pokemonsArticlesByPokemonId;
    }

    @ManyToOne
    @JoinColumn(name = "item_id", referencedColumnName = "id")
    public ItemsArticlesEntity getItemsArticlesByItemId() {
        return itemsArticlesByItemId;
    }

    public void setItemsArticlesByItemId(ItemsArticlesEntity itemsArticlesByItemId) {
        this.itemsArticlesByItemId = itemsArticlesByItemId;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    public UsersEntity getUsersByUserId() {
        return usersByUserId;
    }

    public void setUsersByUserId(UsersEntity usersByUserId) {
        this.usersByUserId = usersByUserId;
    }
}
