package database.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class LotsArticlesEntityPK implements Serializable {
    private int lotId;
    private int itemArticleId;
    private int pokemonArticleId;

    @Column(name = "lot_id", nullable = false)
    @Id
    public int getLotId() {
        return lotId;
    }

    public void setLotId(int lotId) {
        this.lotId = lotId;
    }

    @Column(name = "item_article_id", nullable = false)
    @Id
    public int getItemArticleId() {
        return itemArticleId;
    }

    public void setItemArticleId(int itemArticleId) {
        this.itemArticleId = itemArticleId;
    }

    @Column(name = "pokemon_article_id", nullable = false)
    @Id
    public int getPokemonArticleId() {
        return pokemonArticleId;
    }

    public void setPokemonArticleId(int pokemonArticleId) {
        this.pokemonArticleId = pokemonArticleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LotsArticlesEntityPK that = (LotsArticlesEntityPK) o;

        if (lotId != that.lotId) return false;
        if (itemArticleId != that.itemArticleId) return false;
        if (pokemonArticleId != that.pokemonArticleId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = lotId;
        result = 31 * result + itemArticleId;
        result = 31 * result + pokemonArticleId;
        return result;
    }
}
