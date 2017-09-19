package database.entities;

import javax.persistence.*;

@Entity
@Table(name = "items_articles_carts", schema = "public", catalog = "pokemondb")
public class ItemsArticlesCartsEntity {
    private int id;
    private Integer quantity;
    private int idItemsArticles;
    private int idCart;
    private ItemsArticlesEntity itemsArticlesByIdItemsArticles;
    private CartsEntity cartsByIdCart;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "quantity", nullable = true)
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Basic
    @Column(name = "id_items_articles", nullable = false)
    public int getIdItemsArticles() {
        return idItemsArticles;
    }

    public void setIdItemsArticles(int idItemsArticles) {
        this.idItemsArticles = idItemsArticles;
    }

    @Basic
    @Column(name = "id_cart", nullable = false)
    public int getIdCart() {
        return idCart;
    }

    public void setIdCart(int idCart) {
        this.idCart = idCart;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ItemsArticlesCartsEntity that = (ItemsArticlesCartsEntity) o;

        if (id != that.id) return false;
        if (idItemsArticles != that.idItemsArticles) return false;
        if (idCart != that.idCart) return false;
        if (quantity != null ? !quantity.equals(that.quantity) : that.quantity != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        result = 31 * result + idItemsArticles;
        result = 31 * result + idCart;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_items_articles", referencedColumnName = "id", nullable = false)
    public ItemsArticlesEntity getItemsArticlesByIdItemsArticles() {
        return itemsArticlesByIdItemsArticles;
    }

    public void setItemsArticlesByIdItemsArticles(ItemsArticlesEntity itemsArticlesByIdItemsArticles) {
        this.itemsArticlesByIdItemsArticles = itemsArticlesByIdItemsArticles;
    }

    @ManyToOne
    @JoinColumn(name = "id_cart", referencedColumnName = "id", nullable = false)
    public CartsEntity getCartsByIdCart() {
        return cartsByIdCart;
    }

    public void setCartsByIdCart(CartsEntity cartsByIdCart) {
        this.cartsByIdCart = cartsByIdCart;
    }
}
