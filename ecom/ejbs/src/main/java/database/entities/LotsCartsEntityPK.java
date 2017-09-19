package database.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class LotsCartsEntityPK implements Serializable {
    private int cartId;
    private int lotId;

    @Column(name = "cart_id", nullable = false)
    @Id
    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    @Column(name = "lot_id", nullable = false)
    @Id
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

        LotsCartsEntityPK that = (LotsCartsEntityPK) o;

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
