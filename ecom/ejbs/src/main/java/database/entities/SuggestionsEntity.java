package database.entities;

import javax.persistence.*;

@Entity
@Table(name = "suggestions", schema = "public", catalog = "pokemondb")
@IdClass(SuggestionsEntityPK.class)
public class SuggestionsEntity {
    private int pokemonArticleId;
    private int itemArticleId;
    private int pokemonArticleCoupledId;
    private int itemArticleCoupledId;
    private PokemonsArticlesEntity pokemonsArticlesByPokemonArticleId;
    private ItemsArticlesEntity itemsArticlesByItemArticleId;
    private PokemonsArticlesEntity pokemonsArticlesByPokemonArticleCoupledId;
    private ItemsArticlesEntity itemsArticlesByItemArticleCoupledId;

    @Id
    @Column(name = "pokemon_article_id", nullable = false)
    public int getPokemonArticleId() {
        return pokemonArticleId;
    }

    public void setPokemonArticleId(int pokemonArticleId) {
        this.pokemonArticleId = pokemonArticleId;
    }

    @Id
    @Column(name = "item_article_id", nullable = false)
    public int getItemArticleId() {
        return itemArticleId;
    }

    public void setItemArticleId(int itemArticleId) {
        this.itemArticleId = itemArticleId;
    }

    @Id
    @Column(name = "pokemon_article_coupled_id", nullable = false)
    public int getPokemonArticleCoupledId() {
        return pokemonArticleCoupledId;
    }

    public void setPokemonArticleCoupledId(int pokemonArticleCoupledId) {
        this.pokemonArticleCoupledId = pokemonArticleCoupledId;
    }

    @Id
    @Column(name = "item_article_coupled_id", nullable = false)
    public int getItemArticleCoupledId() {
        return itemArticleCoupledId;
    }

    public void setItemArticleCoupledId(int itemArticleCoupledId) {
        this.itemArticleCoupledId = itemArticleCoupledId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SuggestionsEntity that = (SuggestionsEntity) o;

        if (pokemonArticleId != that.pokemonArticleId) return false;
        if (itemArticleId != that.itemArticleId) return false;
        if (pokemonArticleCoupledId != that.pokemonArticleCoupledId) return false;
        if (itemArticleCoupledId != that.itemArticleCoupledId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = pokemonArticleId;
        result = 31 * result + itemArticleId;
        result = 31 * result + pokemonArticleCoupledId;
        result = 31 * result + itemArticleCoupledId;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "pokemon_article_id", referencedColumnName = "id", nullable = false)
    public PokemonsArticlesEntity getPokemonsArticlesByPokemonArticleId() {
        return pokemonsArticlesByPokemonArticleId;
    }

    public void setPokemonsArticlesByPokemonArticleId(PokemonsArticlesEntity pokemonsArticlesByPokemonArticleId) {
        this.pokemonsArticlesByPokemonArticleId = pokemonsArticlesByPokemonArticleId;
    }

    @ManyToOne
    @JoinColumn(name = "item_article_id", referencedColumnName = "id", nullable = false)
    public ItemsArticlesEntity getItemsArticlesByItemArticleId() {
        return itemsArticlesByItemArticleId;
    }

    public void setItemsArticlesByItemArticleId(ItemsArticlesEntity itemsArticlesByItemArticleId) {
        this.itemsArticlesByItemArticleId = itemsArticlesByItemArticleId;
    }

    @ManyToOne
    @JoinColumn(name = "pokemon_article_coupled_id", referencedColumnName = "id", nullable = false)
    public PokemonsArticlesEntity getPokemonsArticlesByPokemonArticleCoupledId() {
        return pokemonsArticlesByPokemonArticleCoupledId;
    }

    public void setPokemonsArticlesByPokemonArticleCoupledId(PokemonsArticlesEntity pokemonsArticlesByPokemonArticleCoupledId) {
        this.pokemonsArticlesByPokemonArticleCoupledId = pokemonsArticlesByPokemonArticleCoupledId;
    }

    @ManyToOne
    @JoinColumn(name = "item_article_coupled_id", referencedColumnName = "id", nullable = false)
    public ItemsArticlesEntity getItemsArticlesByItemArticleCoupledId() {
        return itemsArticlesByItemArticleCoupledId;
    }

    public void setItemsArticlesByItemArticleCoupledId(ItemsArticlesEntity itemsArticlesByItemArticleCoupledId) {
        this.itemsArticlesByItemArticleCoupledId = itemsArticlesByItemArticleCoupledId;
    }
}
