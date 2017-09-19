package database.entities;

import javax.persistence.*;

@Entity
@Table(name = "lots_articles", schema = "public", catalog = "pokemondb")
@IdClass(LotsArticlesEntityPK.class)
public class LotsArticlesEntity {
    private int lotId;
    private int itemArticleId;
    private int pokemonArticleId;

    @Id
    @Column(name = "lot_id", nullable = false)
    public int getLotId() {
        return lotId;
    }

    public void setLotId(int lotId) {
        this.lotId = lotId;
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
    @Column(name = "pokemon_article_id", nullable = false)
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

        LotsArticlesEntity that = (LotsArticlesEntity) o;

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
