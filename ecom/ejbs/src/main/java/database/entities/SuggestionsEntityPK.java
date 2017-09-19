package database.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class SuggestionsEntityPK implements Serializable {
    private int pokemonArticleId;
    private int itemArticleId;
    private int pokemonArticleCoupledId;
    private int itemArticleCoupledId;

    @Column(name = "pokemon_article_id", nullable = false)
    @Id
    public int getPokemonArticleId() {
        return pokemonArticleId;
    }

    public void setPokemonArticleId(int pokemonArticleId) {
        this.pokemonArticleId = pokemonArticleId;
    }

    @Column(name = "item_article_id", nullable = false)
    @Id
    public int getItemArticleId() {
        return itemArticleId;
    }

    public void setItemArticleId(int itemArticleId) {
        this.itemArticleId = itemArticleId;
    }

    @Column(name = "pokemon_article_coupled_id", nullable = false)
    @Id
    public int getPokemonArticleCoupledId() {
        return pokemonArticleCoupledId;
    }

    public void setPokemonArticleCoupledId(int pokemonArticleCoupledId) {
        this.pokemonArticleCoupledId = pokemonArticleCoupledId;
    }

    @Column(name = "item_article_coupled_id", nullable = false)
    @Id
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

        SuggestionsEntityPK that = (SuggestionsEntityPK) o;

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
}
