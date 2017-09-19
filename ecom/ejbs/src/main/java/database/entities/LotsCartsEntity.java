package database.entities;

import javax.persistence.*;

@Entity
@Table(name = "lots_carts", schema = "public", catalog = "pokemondb")
@IdClass(LotsCartsEntityPK.class)
public class LotsCartsEntity {
    private int cartId;
    private int lotId;

    @Id
    @Column(name = "cart_id", nullable = false)
    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    @Id
    @Column(name = "lot_id", nullable = false)
    public int getLotId() {
        return lotId;
    }

    public void setLotId(int lotId) {
        this.lotId = lotId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LotsCartsEntity that = (LotsCartsEntity) o;

        if (cartId != that.cartId) return false;
        if (lotId != that.lotId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cartId;
        result = 31 * result + lotId;
        return result;
    }
}
